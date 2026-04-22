package com.example.kartonki.domain.quiz

import com.example.kartonki.domain.model.StudyQuizType
import com.example.kartonki.domain.model.StudyStep
import com.example.kartonki.domain.model.Word

/**
 * Pure, stateless quiz-generation logic.
 * Extracted from StudySessionViewModel so it can be unit-tested without Android dependencies.
 *
 * Rules for every quiz step:
 *  - Exactly 4 options
 *  - correctAnswer is always present in options
 *  - FILL_IN_BLANK* falls back to MULTIPLE_CHOICE_TRANSLATION when the word is absent from the sentence
 */
object QuizBuilder {

    fun buildSteps(
        words: List<Word>,
        distractorPool: List<Word> = emptyList(),
        definitionMode: String = "both",
        fillBlankMode: String = "both",
        enabledTypes: Set<String> = setOf("translation", "definition", "fill_blank"),
    ): List<StudyStep.Quiz> {
        // Merge session words with extra distractor words (deduplicated). The extras are never
        // shown as quiz questions — they only appear as wrong-answer options.
        val fullPool = (words + distractorPool).distinctBy { it.id }
        return words.shuffled().map { word ->
            buildQuizStep(word, pickQuizType(word, words, definitionMode, fillBlankMode, enabledTypes), words, fullPool)
        }
    }

    // internal = accessible from the test source-set (same module) but not from outside the module
    internal fun pickQuizType(
        word: Word,
        allWords: List<Word>,
        definitionMode: String = "both",
        fillBlankMode: String = "both",
        enabledTypes: Set<String> = setOf("translation", "definition", "fill_blank"),
    ): StudyQuizType {
        val available = mutableListOf<StudyQuizType>()

        if ("translation" in enabledTypes && allWords.size >= 4)
            available.add(StudyQuizType.MULTIPLE_CHOICE_TRANSLATION)

        if ("definition" in enabledTypes) {
            val defForeign = definitionMode == "foreign" || definitionMode == "both"
            val defNative  = definitionMode == "native"  || definitionMode == "both"
            val foreignDefCount = allWords.count { it.definition != null }
            val nativeDefCount  = allWords.count { it.definitionNative != null }
            if (defForeign && word.definition != null && foreignDefCount >= 4) {
                available.add(StudyQuizType.MULTIPLE_CHOICE_DEFINITION)
                available.add(StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF)
            }
            if (defNative && word.definitionNative != null && nativeDefCount >= 4) {
                available.add(StudyQuizType.MULTIPLE_CHOICE_DEFINITION_NATIVE)
                available.add(StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE)
            }
        }

        if ("fill_blank" in enabledTypes) {
            // isFillInBlankSafe=false marks words whose example produces ambiguous or
            // broken blanks (form mismatch → "___s", siblings in same semanticGroup
            // fit equally well). We skip FILL_IN_BLANK for these — pickQuizType
            // simply picks another type. See docs/claude/quality_standards_examples.md.
            if (word.example != null && word.isFillInBlankSafe && allWords.size >= 4)
                available.add(StudyQuizType.FILL_IN_BLANK)
        }

        return if (available.isEmpty()) StudyQuizType.MULTIPLE_CHOICE_TRANSLATION else available.random()
    }

    internal fun buildQuizStep(
        word: Word,
        type: StudyQuizType,
        allWords: List<Word>,
        distractorPool: List<Word> = allWords,
    ): StudyStep.Quiz {
        val others = pickDistractors(word, distractorPool)
        return when (type) {
            StudyQuizType.MULTIPLE_CHOICE_TRANSLATION -> {
                val wrongs = others.take(3).map { it.translation }
                if (wrongs.size < 3) return fallbackTranslation(word, distractorPool)
                StudyStep.Quiz(word = word, type = type, question = word.original,
                    options = (wrongs + word.translation).shuffled(),
                    correctAnswer = word.translation)
            }
            StudyQuizType.MULTIPLE_CHOICE_DEFINITION -> {
                val wrongs = others.filter { it.definition != null }.take(3).map { it.definition!! }
                if (wrongs.size < 3) return fallbackTranslation(word, distractorPool)
                StudyStep.Quiz(word = word, type = type, question = word.original,
                    options = (wrongs + word.definition!!).shuffled(),
                    correctAnswer = word.definition!!)
            }
            StudyQuizType.MULTIPLE_CHOICE_DEFINITION_NATIVE -> {
                val wrongs = others.filter { it.definitionNative != null }.take(3).map { it.definitionNative!! }
                if (wrongs.size < 3) return fallbackTranslation(word, distractorPool)
                StudyStep.Quiz(word = word, type = type, question = word.original,
                    options = (wrongs + word.definitionNative!!).shuffled(),
                    correctAnswer = word.definitionNative!!)
            }
            StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF -> {
                val wrongs = others.filter { it.definition != null }.take(3).map { it.original }
                if (wrongs.size < 3) return fallbackTranslation(word, distractorPool)
                StudyStep.Quiz(word = word, type = type, question = word.definition!!,
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original)
            }
            StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE -> {
                val wrongs = others.filter { it.definitionNative != null }.take(3).map { it.original }
                if (wrongs.size < 3) return fallbackTranslation(word, distractorPool)
                StudyStep.Quiz(word = word, type = type, question = word.definitionNative!!,
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original)
            }
            StudyQuizType.FILL_IN_BLANK -> {
                val raw = word.example!!
                val sentence = raw.replace(word.original, "_____", ignoreCase = true)
                // If the word doesn't appear in the sentence, the blank cannot be created → fallback
                if (sentence == raw) return fallbackTranslation(word, distractorPool)
                val fillBlankDistractors = pickDistractors(word, distractorPool, forFillInBlank = true)
                val wrongs = fillBlankDistractors.take(3).map { it.original }
                if (wrongs.size < 3) return fallbackTranslation(word, distractorPool)
                StudyStep.Quiz(word = word, type = type, question = sentence,
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original)
            }
        }
    }

    /**
     * Returns distractor words ranked by semantic proximity.
     *
     * Default order (TRANSLATION, DEFINITION): closest first — makes the quiz harder.
     *  Tier 1 — same pos AND semanticGroup (closest, trickiest distractors)
     *  Tier 2 — same pos only
     *  Tier 3 — everything else
     *
     * When [forFillInBlank] is true, tiers 1 and 2 swap: far distractors come first.
     * This avoids picking distractors that would also grammatically and semantically
     * fit the blank in the example sentence. Additionally, any word whose id is in
     * `word.fillInBlankExclusions` is removed upfront — these are words the LLM
     * labeling pass identified as able to fit this word's example.
     */
    internal fun pickDistractors(
        word: Word,
        allWords: List<Word>,
        forFillInBlank: Boolean = false,
    ): List<Word> {
        val excludedIds = if (forFillInBlank) word.fillInBlankExclusions.toSet() else emptySet()
        val candidates = allWords.filter {
            it.id != word.id &&
                it.languagePair == word.languagePair &&
                it.id !in excludedIds
        }
        if (word.pos == null && word.semanticGroup == null) return candidates.shuffled()
        val sameSem = candidates.filter { it.pos == word.pos && it.semanticGroup == word.semanticGroup }.shuffled()
        val diffSem = candidates.filter { it.pos == word.pos && it.semanticGroup != word.semanticGroup }.shuffled()
        val diffPos = candidates.filter { it.pos != word.pos }.shuffled()
        return if (forFillInBlank) diffSem + sameSem + diffPos else sameSem + diffSem + diffPos
    }

    internal fun fallbackTranslation(word: Word, allWords: List<Word>): StudyStep.Quiz {
        val candidates = allWords.filter { it.id != word.id && it.languagePair == word.languagePair }.shuffled()
        val wrongs = candidates.take(3).map { it.translation }
        // Pad with numbered placeholders if the pool is too small (< 3 distractors).
        val paddedWrongs = wrongs + List(maxOf(0, 3 - wrongs.size)) { i -> "—${i + 1}" }
        return StudyStep.Quiz(
            word = word, type = StudyQuizType.MULTIPLE_CHOICE_TRANSLATION,
            question = word.original,
            options = (paddedWrongs + word.translation).shuffled(),
            correctAnswer = word.translation,
        )
    }
}
