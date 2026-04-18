package com.example.kartonki.quiz

import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.StudyQuizType
import com.example.kartonki.domain.model.Word
import com.example.kartonki.domain.quiz.QuizBuilder
import org.junit.Assert.*
import org.junit.Test

class QuizBuilderTest {

    // ── Test-word factory ──────────────────────────────────────────────────────

    private fun makeWord(
        id: Long,
        original: String = "word$id",
        translation: String = "перевод$id",
        pos: String? = "noun",
        semanticGroup: String? = "groupA",
        definition: String? = "A word$id is a thing.",
        definitionNative: String? = "Это определение word$id.",
        example: String? = "I see a word$id here.",
        exampleNative: String? = "Я вижу word$id здесь.",
    ) = Word(
        id = id, original = original, translation = translation, rarity = Rarity.COMMON,
        pos = pos, semanticGroup = semanticGroup, definition = definition,
        definitionNative = definitionNative, example = example, exampleNative = exampleNative,
    )

    /** 20 fully-populated words — enough for all quiz types. */
    private val fullWords: List<Word> = (1L..20L).map { makeWord(it) }

    // ── Invariant: correct answer always in options ────────────────────────────

    @Test fun `correct answer always present in options - MULTIPLE_CHOICE_TRANSLATION`() {
        fullWords.forEach { word ->
            val step = QuizBuilder.buildQuizStep(word, StudyQuizType.MULTIPLE_CHOICE_TRANSLATION, fullWords)
            assertTrue("Correct answer '${step.correctAnswer}' not in options ${step.options}",
                step.options.any { it.equals(step.correctAnswer, ignoreCase = true) })
        }
    }

    @Test fun `correct answer always present in options - MULTIPLE_CHOICE_DEFINITION`() {
        fullWords.forEach { word ->
            val step = QuizBuilder.buildQuizStep(word, StudyQuizType.MULTIPLE_CHOICE_DEFINITION, fullWords)
            assertTrue("Correct answer '${step.correctAnswer}' not in options",
                step.options.any { it.equals(step.correctAnswer, ignoreCase = true) })
        }
    }

    @Test fun `correct answer always present in options - MULTIPLE_CHOICE_DEFINITION_NATIVE`() {
        fullWords.forEach { word ->
            val step = QuizBuilder.buildQuizStep(word, StudyQuizType.MULTIPLE_CHOICE_DEFINITION_NATIVE, fullWords)
            assertTrue("Correct answer '${step.correctAnswer}' not in options",
                step.options.any { it.equals(step.correctAnswer, ignoreCase = true) })
        }
    }

    @Test fun `correct answer always present in options - MULTIPLE_CHOICE_WORD_FROM_DEF`() {
        fullWords.forEach { word ->
            val step = QuizBuilder.buildQuizStep(word, StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF, fullWords)
            assertTrue("Correct answer '${step.correctAnswer}' not in options",
                step.options.any { it.equals(step.correctAnswer, ignoreCase = true) })
        }
    }

    @Test fun `correct answer always present in options - MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE`() {
        fullWords.forEach { word ->
            val step = QuizBuilder.buildQuizStep(word, StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE, fullWords)
            assertTrue("Correct answer '${step.correctAnswer}' not in options",
                step.options.any { it.equals(step.correctAnswer, ignoreCase = true) })
        }
    }

    @Test fun `correct answer always present in options - FILL_IN_BLANK`() {
        fullWords.forEach { word ->
            val step = QuizBuilder.buildQuizStep(word, StudyQuizType.FILL_IN_BLANK, fullWords)
            assertTrue("Correct answer '${step.correctAnswer}' not in options",
                step.options.any { it.equals(step.correctAnswer, ignoreCase = true) })
        }
    }

    // ── Invariant: exactly 4 options ──────────────────────────────────────────

    @Test fun `options always have exactly 4 items for all quiz types`() {
        StudyQuizType.values().forEach { type ->
            fullWords.forEach { word ->
                val step = QuizBuilder.buildQuizStep(word, type, fullWords)
                assertEquals("Type $type word '${word.original}': expected 4 options, got ${step.options.size}",
                    4, step.options.size)
            }
        }
    }

    // ── Invariant: fill-in-blank produces a blank ──────────────────────────────

    @Test fun `FILL_IN_BLANK question contains blank marker`() {
        val step = QuizBuilder.buildQuizStep(fullWords[0], StudyQuizType.FILL_IN_BLANK, fullWords)
        if (step.type == StudyQuizType.FILL_IN_BLANK) {
            assertTrue("FILL_IN_BLANK question has no blank: '${step.question}'",
                step.question.contains("_____"))
        }
    }

    @Test fun `FILL_IN_BLANK sentence differs from original example`() {
        val word = makeWord(99, original = "apple", example = "I ate an apple today.")
        val allWords = listOf(word) + (1L..6L).map { makeWord(it) }
        val step = QuizBuilder.buildQuizStep(word, StudyQuizType.FILL_IN_BLANK, allWords)
        if (step.type == StudyQuizType.FILL_IN_BLANK) {
            assertNotEquals("Sentence should have a blank inserted", word.example, step.question)
        }
    }

    @Test fun `word absent from sentence triggers fallback to translation quiz`() {
        val word = makeWord(99, original = "apple", example = "I ate the fruit.")  // "apple" not in sentence
        val allWords = listOf(word) + (1L..6L).map { makeWord(it) }
        val step = QuizBuilder.buildQuizStep(word, StudyQuizType.FILL_IN_BLANK, allWords)
        assertEquals("Expected fallback to MULTIPLE_CHOICE_TRANSLATION when word absent from sentence",
            StudyQuizType.MULTIPLE_CHOICE_TRANSLATION, step.type)
    }

    // ── Correct content for each quiz type ────────────────────────────────────

    @Test fun `MULTIPLE_CHOICE_TRANSLATION correct answer is translation`() {
        val word = fullWords[0]
        val step = QuizBuilder.buildQuizStep(word, StudyQuizType.MULTIPLE_CHOICE_TRANSLATION, fullWords)
        assertEquals(word.translation, step.correctAnswer)
    }

    @Test fun `MULTIPLE_CHOICE_DEFINITION correct answer is definition`() {
        val word = fullWords[0]
        val step = QuizBuilder.buildQuizStep(word, StudyQuizType.MULTIPLE_CHOICE_DEFINITION, fullWords)
        assertEquals(word.definition, step.correctAnswer)
    }

    @Test fun `MULTIPLE_CHOICE_DEFINITION_NATIVE correct answer is definitionNative`() {
        val word = fullWords[0]
        val step = QuizBuilder.buildQuizStep(word, StudyQuizType.MULTIPLE_CHOICE_DEFINITION_NATIVE, fullWords)
        assertEquals(word.definitionNative, step.correctAnswer)
    }

    @Test fun `MULTIPLE_CHOICE_WORD_FROM_DEF correct answer is original word`() {
        val word = fullWords[0]
        val step = QuizBuilder.buildQuizStep(word, StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF, fullWords)
        assertEquals(word.original, step.correctAnswer)
    }

    @Test fun `FILL_IN_BLANK correct answer is original word`() {
        val word = fullWords[0]
        val step = QuizBuilder.buildQuizStep(word, StudyQuizType.FILL_IN_BLANK, fullWords)
        if (step.type == StudyQuizType.FILL_IN_BLANK) assertEquals(word.original, step.correctAnswer)
    }

    // ── Distractor quality ─────────────────────────────────────────────────────

    @Test fun `distractors never include the target word itself`() {
        fullWords.forEach { word ->
            val distractors = QuizBuilder.pickDistractors(word, fullWords)
            assertFalse("Distractor list for '${word.original}' includes itself",
                distractors.any { it.id == word.id })
        }
    }

    @Test fun `distractors rank same-pos-and-group words first (tier 1)`() {
        val target = makeWord(1, pos = "noun", semanticGroup = "animals")
        val tier1  = (2L..5L).map { makeWord(it, pos = "noun", semanticGroup = "animals") }
        val tier2  = (6L..8L).map { makeWord(it, pos = "noun", semanticGroup = "food") }
        val tier3  = (9L..11L).map { makeWord(it, pos = "verb", semanticGroup = "actions") }
        val all    = listOf(target) + tier1 + tier2 + tier3

        val distractors = QuizBuilder.pickDistractors(target, all)
        val firstFour   = distractors.take(4).map { it.id }.toSet()
        val tier1Ids    = tier1.map { it.id }.toSet()
        assertEquals("First 4 distractors should all be tier-1 (same pos+group)",
            tier1Ids, firstFour)
    }

    @Test fun `distractors for word without pos or semanticGroup are just shuffled`() {
        val noPosWord = makeWord(1, pos = null, semanticGroup = null)
        val others    = (2L..6L).map { makeWord(it, pos = null, semanticGroup = null) }
        val all       = listOf(noPosWord) + others
        val distractors = QuizBuilder.pickDistractors(noPosWord, all)
        assertEquals("Should have all other words as distractors", others.size, distractors.size)
        assertTrue("Should not include the word itself", distractors.none { it.id == noPosWord.id })
    }

    // ── Quiz type selection ────────────────────────────────────────────────────

    @Test fun `all 7 quiz types can be selected for a word with all fields`() {
        val word = fullWords.first()
        val selectedTypes = (1..2000).map {
            QuizBuilder.pickQuizType(word, fullWords)
        }.toSet()
        val allTypes = StudyQuizType.values().toSet()
        assertEquals("All 7 quiz types should be selectable for a fully-populated word",
            allTypes, selectedTypes)
    }

    @Test fun `only translation type selected when all context types are disabled`() {
        val word = fullWords.first()
        repeat(100) {
            val type = QuizBuilder.pickQuizType(word, fullWords, enabledTypes = setOf("translation"))
            assertEquals(StudyQuizType.MULTIPLE_CHOICE_TRANSLATION, type)
        }
    }

    @Test fun `definition mode foreign excludes native definition types`() {
        val word = fullWords.first()
        val types = (1..500).map {
            QuizBuilder.pickQuizType(word, fullWords, definitionMode = "foreign")
        }.toSet()
        assertFalse(StudyQuizType.MULTIPLE_CHOICE_DEFINITION_NATIVE in types)
        assertFalse(StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE in types)
    }

    @Test fun `definition mode native excludes foreign definition types`() {
        val word = fullWords.first()
        val types = (1..500).map {
            QuizBuilder.pickQuizType(word, fullWords, definitionMode = "native")
        }.toSet()
        assertFalse(StudyQuizType.MULTIPLE_CHOICE_DEFINITION in types)
        assertFalse(StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF in types)
    }

    @Test fun `word with no definition cannot get definition quiz types`() {
        val noDefWord = makeWord(1, definition = null, definitionNative = null)
        val allWords  = listOf(noDefWord) + (2L..20L).map { makeWord(it) }
        val types = (1..500).map { QuizBuilder.pickQuizType(noDefWord, allWords) }.toSet()
        assertFalse(StudyQuizType.MULTIPLE_CHOICE_DEFINITION in types)
        assertFalse(StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF in types)
        assertFalse(StudyQuizType.MULTIPLE_CHOICE_DEFINITION_NATIVE in types)
        assertFalse(StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE in types)
    }

    @Test fun `word with no example cannot get fill-in-blank quiz types`() {
        val noExWord = makeWord(1, example = null, exampleNative = null)
        val allWords = listOf(noExWord) + (2L..20L).map { makeWord(it) }
        val types = (1..500).map { QuizBuilder.pickQuizType(noExWord, allWords) }.toSet()
        assertFalse(StudyQuizType.FILL_IN_BLANK in types)
    }

    // ── Fallback behaviour ────────────────────────────────────────────────────

    @Test fun `fallbackTranslation always produces valid step with correct answer in options`() {
        (1..20).forEach { n ->
            val word = makeWord(99)
            val context = (1L..n.toLong()).map { makeWord(it) }
            val step = QuizBuilder.fallbackTranslation(word, context + word)
            assertTrue("Fallback: correct answer must be in options",
                step.options.contains(step.correctAnswer))
            assertEquals(StudyQuizType.MULTIPLE_CHOICE_TRANSLATION, step.type)
        }
    }

    // ── Hebrew / RTL words ────────────────────────────────────────────────────

    @Test fun `hebrew words produce valid quiz steps`() {
        val hebrewWords = (1L..20L).map { id ->
            Word(id = id, original = "מילה$id", translation = "перевод$id", rarity = Rarity.COMMON,
                languagePair = "he-ru", pos = "noun", semanticGroup = "hardware",
                definition = "מילה $id היא.", definitionNative = "Это слово $id.",
                example = "אני רואה מילה$id כאן.", exampleNative = "Я вижу מילה$id здесь.",
                transliteration = "mila$id")
        }
        StudyQuizType.values().forEach { type ->
            val step = QuizBuilder.buildQuizStep(hebrewWords[0], type, hebrewWords)
            assertEquals("Hebrew $type: expected 4 options", 4, step.options.size)
            assertTrue("Hebrew $type: correct answer must be in options",
                step.options.any { it.equals(step.correctAnswer, ignoreCase = true) })
        }
    }
}
