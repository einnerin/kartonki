package com.example.kartonki.ui.screen.pvp

import com.example.kartonki.domain.model.Word

/**
 * Quiz data produced by [PvpGameLogic.buildQuiz]. Shared between local and online PvP.
 */
data class PvpQuiz(
    val playedCard: Word,
    val question: String,
    val questionLabel: String,
    val options: List<String>,
    val correctAnswer: String,
)

/**
 * Pure, stateless game logic shared between local pass-and-play and online PvP.
 * All functions are side-effect-free and deterministic (except the random shuffles).
 */
object PvpGameLogic {

    const val HAND_SIZE = 10
    const val TIMER_DURATION = 30
    const val AFK_LIMIT = 3
    const val TIMER_TICK_MS = 1000L
    const val WRONG_ANSWER_DELAY_MS = 800L

    fun buildHand(cards: List<Word>): List<Word> =
        if (cards.size <= HAND_SIZE) cards.shuffled()
        else cards.shuffled().take(HAND_SIZE)

    fun streakToMultiplier(streak: Int): Int = when {
        streak >= 15 -> 4
        streak >= 10 -> 3
        streak >= 5  -> 2
        else         -> 1
    }

    /**
     * Returns distractor candidates ordered by semantic similarity:
     *  tier1 = same pos + same semanticGroup (best distractors)
     *  tier2 = same pos, different semanticGroup
     *  tier3 = different pos (fallback)
     */
    fun pickDistractors(word: Word, allWords: List<Word>): List<Word> {
        val candidates = allWords.filter { it.id != word.id && it.languagePair == word.languagePair }
        if (word.pos == null && word.semanticGroup == null) return candidates.shuffled()
        val tier1 = candidates.filter { it.pos == word.pos && it.semanticGroup == word.semanticGroup }.shuffled()
        val tier2 = candidates.filter { it.pos == word.pos && it.semanticGroup != word.semanticGroup }.shuffled()
        val tier3 = candidates.filter { it.pos != word.pos }.shuffled()
        return tier1 + tier2 + tier3
    }

    /**
     * Builds a quiz for [word] using [allWords] as the distractor pool.
     * Randomly picks from translation / definition / fill_blank based on available data.
     * Returns null if fewer than 3 distractors are available.
     */
    fun buildQuiz(word: Word, allWords: List<Word>): PvpQuiz? {
        val others = pickDistractors(word, allWords)
        if (others.size < 3) return null

        // Exclude translation if another word in the pool shares the same original —
        // that would produce two correct answers in a multiple-choice question.
        val hasAmbiguousOriginal = allWords.any { it.id != word.id && it.original.equals(word.original, ignoreCase = true) }
        val candidates = buildList {
            if (!hasAmbiguousOriginal) add("translation")
            if (word.definition != null && others.count { it.definition != null } >= 3) add("definition")
            if (word.example != null) add("fill_blank")
        }

        // If no unambiguous type is available, fall back to translation (best we can do).
        val chosenType = if (candidates.isEmpty()) "translation" else candidates.random()
        return when (chosenType) {
            "definition" -> {
                val wrongs = others.filter { it.definition != null }.take(3).map { it.definition!! }
                if (wrongs.size < 3) return translationQuiz(word, others)
                PvpQuiz(
                    playedCard = word,
                    question = word.original,
                    questionLabel = "Выберите определение:",
                    options = (wrongs + word.definition!!).shuffled(),
                    correctAnswer = word.definition!!,
                )
            }
            "fill_blank" -> {
                val sentence = word.example!!.replace(word.original, "_____", ignoreCase = true)
                val wrongs = others.take(3).map { it.original }
                PvpQuiz(
                    playedCard = word,
                    question = sentence,
                    questionLabel = "Выберите слово для пропуска:",
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original,
                )
            }
            else -> translationQuiz(word, others)
        }
    }

    fun translationQuiz(word: Word, others: List<Word>): PvpQuiz {
        val wrongs = others.filter { it.translation != word.translation }.take(3).map { it.translation }
        return PvpQuiz(
            playedCard = word,
            question = word.original,
            questionLabel = "Выберите перевод:",
            options = (wrongs + word.translation).shuffled(),
            correctAnswer = word.translation,
        )
    }
}
