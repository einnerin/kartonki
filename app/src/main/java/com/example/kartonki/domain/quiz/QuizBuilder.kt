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
        definitionMode: String = "both",
        fillBlankMode: String = "both",
        enabledTypes: Set<String> = setOf("translation", "definition", "fill_blank"),
    ): List<StudyStep.Quiz> =
        words.shuffled().map { word ->
            buildQuizStep(word, pickQuizType(word, words, definitionMode, fillBlankMode, enabledTypes), words)
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
            val fbForeign = fillBlankMode == "foreign" || fillBlankMode == "both"
            val fbNative  = fillBlankMode == "native"  || fillBlankMode == "both"
            if (fbForeign && word.example != null && allWords.size >= 4)
                available.add(StudyQuizType.FILL_IN_BLANK)
            if (fbNative && word.exampleNative != null && allWords.size >= 4)
                available.add(StudyQuizType.FILL_IN_BLANK_NATIVE)
        }

        return if (available.isEmpty()) StudyQuizType.MULTIPLE_CHOICE_TRANSLATION else available.random()
    }

    internal fun buildQuizStep(word: Word, type: StudyQuizType, allWords: List<Word>): StudyStep.Quiz {
        val others = pickDistractors(word, allWords)
        return when (type) {
            StudyQuizType.MULTIPLE_CHOICE_TRANSLATION -> {
                val wrongs = others.take(3).map { it.translation }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(word = word, type = type, question = word.original,
                    options = (wrongs + word.translation).shuffled(),
                    correctAnswer = word.translation)
            }
            StudyQuizType.MULTIPLE_CHOICE_DEFINITION -> {
                val wrongs = others.filter { it.definition != null }.take(3).map { it.definition!! }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(word = word, type = type, question = word.original,
                    options = (wrongs + word.definition!!).shuffled(),
                    correctAnswer = word.definition!!)
            }
            StudyQuizType.MULTIPLE_CHOICE_DEFINITION_NATIVE -> {
                val wrongs = others.filter { it.definitionNative != null }.take(3).map { it.definitionNative!! }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(word = word, type = type, question = word.original,
                    options = (wrongs + word.definitionNative!!).shuffled(),
                    correctAnswer = word.definitionNative!!)
            }
            StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF -> {
                val wrongs = others.filter { it.definition != null }.take(3).map { it.original }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(word = word, type = type, question = word.definition!!,
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original)
            }
            StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE -> {
                val wrongs = others.filter { it.definitionNative != null }.take(3).map { it.original }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(word = word, type = type, question = word.definitionNative!!,
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original)
            }
            StudyQuizType.FILL_IN_BLANK -> {
                val raw = word.example!!
                val sentence = raw.replace(word.original, "_____", ignoreCase = true)
                // If the word doesn't appear in the sentence, the blank cannot be created → fallback
                if (sentence == raw) return fallbackTranslation(word, allWords)
                val wrongs = others.take(3).map { it.original }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(word = word, type = type, question = sentence,
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original)
            }
            StudyQuizType.FILL_IN_BLANK_NATIVE -> {
                val raw = word.exampleNative!!
                val sentence = raw.replace(word.original, "_____", ignoreCase = true)
                // Design: native examples embed the foreign word directly (e.g. "Я вижу dog здесь.")
                // If the word is absent, fall back gracefully
                if (sentence == raw) return fallbackTranslation(word, allWords)
                val wrongs = others.take(3).map { it.original }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(word = word, type = type, question = sentence,
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original)
            }
        }
    }

    /**
     * Returns distractor words ranked by semantic proximity:
     *  Tier 1 — same pos AND semanticGroup (closest)
     *  Tier 2 — same pos only
     *  Tier 3 — everything else
     */
    internal fun pickDistractors(word: Word, allWords: List<Word>): List<Word> {
        val candidates = allWords.filter { it.id != word.id }
        if (word.pos == null && word.semanticGroup == null) return candidates.shuffled()
        val tier1 = candidates.filter { it.pos == word.pos && it.semanticGroup == word.semanticGroup }.shuffled()
        val tier2 = candidates.filter { it.pos == word.pos && it.semanticGroup != word.semanticGroup }.shuffled()
        val tier3 = candidates.filter { it.pos != word.pos }.shuffled()
        return tier1 + tier2 + tier3
    }

    internal fun fallbackTranslation(word: Word, allWords: List<Word>): StudyStep.Quiz {
        val wrongs = allWords.filter { it.id != word.id }.shuffled().take(3).map { it.translation }
        return StudyStep.Quiz(
            word = word, type = StudyQuizType.MULTIPLE_CHOICE_TRANSLATION,
            question = word.original,
            options = (wrongs + word.translation).shuffled(),
            correctAnswer = word.translation,
        )
    }
}
