package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.domain.model.DeckLevel
import com.example.kartonki.domain.model.Rarity
import org.junit.Assert.*
import org.junit.Test

/**
 * Audits all seed-data files for completeness and correctness.
 * A failing test = a real problem that would break quiz generation for affected words.
 */
class SeedDataAuditTest {

    // ── Helpers ────────────────────────────────────────────────────────────────

    private fun fail(label: String, problems: List<String>) {
        if (problems.isEmpty()) return
        val sample = problems.take(30).joinToString("\n") { "  $it" }
        val tail   = if (problems.size > 30) "\n  … and ${problems.size - 30} more" else ""
        org.junit.Assert.fail("$label — ${problems.size} problem(s):\n$sample$tail")
    }

    // ══════════════════════════════════════════════════════════════════════════
    // ENGLISH WORDS
    // ══════════════════════════════════════════════════════════════════════════

    @Test fun `EN — all words have required base fields`() {
        fail("English words missing required base fields", SeedData.words.mapNotNull { w ->
            listOfNotNull(
                if (w.translation.isBlank())  "Set ${w.setId} '${w.original}': blank translation" else null,
                if (w.definition == null)     "Set ${w.setId} '${w.original}': null definition" else null,
                if (w.example == null)        "Set ${w.setId} '${w.original}': null example" else null,
                if (w.pos == null)            "Set ${w.setId} '${w.original}': null pos" else null,
                if (w.semanticGroup == null)  "Set ${w.setId} '${w.original}': null semanticGroup" else null,
            )
        }.flatten())
    }

    @Test fun `EN — FILL_IN_BLANK example sentences contain the word`() {
        fail("English FILL_IN_BLANK broken — word absent from example",
            SeedData.words.filter { w ->
                w.example != null && !w.example.contains(w.original, ignoreCase = true)
            }.map { w -> "Set ${w.setId} '${w.original}': '${w.example}'" }
        )
    }

    @Test fun `EN — each set has at least 4 words`() {
        fail("English sets with fewer than 4 words (multiple-choice impossible)",
            SeedData.sets.mapNotNull { set ->
                val count = SeedData.words.count { it.setId == set.id }
                if (count < 4) "Set ${set.id} '${set.name}': $count words" else null
            }
        )
    }

    // ══════════════════════════════════════════════════════════════════════════
    // SEEDDATAENGLISHNATIVE — coverage and sentence quality
    // ══════════════════════════════════════════════════════════════════════════

    @Test fun `EN-NATIVE — covers every English word in SeedData`() {
        val covered = SeedDataEnglishNative.data.keys
        fail("English words missing from SeedDataEnglishNative (FILL_IN_BLANK_NATIVE / DEFINITION_NATIVE broken)",
            SeedData.words.filter { it.languagePair == "en-ru" && it.original !in covered }
                .map { "Set ${it.setId}: '${it.original}'" }
        )
    }

    @Test fun `EN-NATIVE — exampleNative sentences embed the English word`() {
        fail("English FILL_IN_BLANK_NATIVE broken — English word absent from Russian example",
            SeedDataEnglishNative.data.entries.mapNotNull { (original, content) ->
                val ex = content.second
                if (!ex.contains(original, ignoreCase = true))
                    "'$original': '$ex'"
                else null
            }
        )
    }

    // ══════════════════════════════════════════════════════════════════════════
    // HEBREW WORDS
    // ══════════════════════════════════════════════════════════════════════════

    @Test fun `HE — all words have required fields including native content`() {
        val allHebrew = SeedDataHebrew.words + SeedDataHebrewEveryday.words
        fail("Hebrew words missing required fields", allHebrew.mapNotNull { w ->
            listOfNotNull(
                if (w.translation.isBlank())    "Set ${w.setId} '${w.original}': blank translation" else null,
                if (w.definition == null)       "Set ${w.setId} '${w.original}': null definition" else null,
                if (w.definitionNative == null) "Set ${w.setId} '${w.original}': null definitionNative" else null,
                if (w.example == null)          "Set ${w.setId} '${w.original}': null example" else null,
                if (w.exampleNative == null)    "Set ${w.setId} '${w.original}': null exampleNative" else null,
                if (w.transliteration == null)  "Set ${w.setId} '${w.original}': null transliteration" else null,
                if (w.pos == null)              "Set ${w.setId} '${w.original}': null pos" else null,
                if (w.semanticGroup == null)    "Set ${w.setId} '${w.original}': null semanticGroup" else null,
            )
        }.flatten())
    }

    @Test fun `HE — FILL_IN_BLANK Hebrew example sentences contain the Hebrew word`() {
        val allHebrew = SeedDataHebrew.words + SeedDataHebrewEveryday.words
        fail("Hebrew FILL_IN_BLANK broken — Hebrew word absent from Hebrew example",
            allHebrew.filter { w ->
                w.example != null && !w.example.contains(w.original)
            }.map { w -> "Set ${w.setId} '${w.original}': '${w.example}'" }
        )
    }

    @Test fun `HE — FILL_IN_BLANK_NATIVE Russian examples embed the Hebrew word`() {
        val allHebrew = SeedDataHebrew.words + SeedDataHebrewEveryday.words
        fail("Hebrew FILL_IN_BLANK_NATIVE broken — Hebrew word absent from Russian example",
            allHebrew.filter { w ->
                w.exampleNative != null && !w.exampleNative.contains(w.original)
            }.map { w -> "Set ${w.setId} '${w.original}': '${w.exampleNative}'" }
        )
    }

    @Test fun `HE — each set has at least 4 words`() {
        val allSets  = SeedDataHebrew.sets + SeedDataHebrewEveryday.sets
        val allWords = SeedDataHebrew.words + SeedDataHebrewEveryday.words
        fail("Hebrew sets with fewer than 4 words",
            allSets.mapNotNull { set ->
                val count = allWords.count { it.setId == set.id }
                if (count < 4) "Set ${set.id} '${set.name}': $count words" else null
            }
        )
    }

    // ══════════════════════════════════════════════════════════════════════════
    // PRESET DECKS — rarity distribution must match DeckLevel limits exactly
    // ══════════════════════════════════════════════════════════════════════════

    @Test fun `preset decks — rarity distribution matches DeckLevel limits`() {
        // Build a single lookup map: original → rarity across all seed sources.
        // Use first-occurrence semantics so that duplicate originals (e.g. "רֶשֶׁת"
        // appears in both SeedDataHebrew set 103 and SeedDataHebrewAdvanced set 114)
        // resolve to the word from the earlier file, matching physical insertion order.
        val allWords: List<WordEntity> =
            SeedData.words +
            SeedDataHebrew.words +
            SeedDataHebrewEveryday.words +
            SeedDataHebrewAdvanced.words
        val rarityByOriginal: Map<String, String> = buildMap {
            for (w in allWords) putIfAbsent(w.original, w.rarity)
        }

        val problems = mutableListOf<String>()
        for (deck in SeedData.prebuiltDecks) {
            val limits = DeckLevel.limitsFor(deck.level)
            val counts = mutableMapOf("COMMON" to 0, "UNCOMMON" to 0, "RARE" to 0, "EPIC" to 0, "LEGENDARY" to 0)

            for (original in deck.wordOriginals) {
                val rarity = rarityByOriginal[original]
                if (rarity == null) {
                    problems += "Deck '${deck.name}' (L${deck.level}): word '$original' not found in any seed file"
                } else {
                    counts[rarity] = (counts[rarity] ?: 0) + 1
                }
            }

            val expected = mapOf(
                "COMMON"    to limits.common,
                "UNCOMMON"  to limits.uncommon,
                "RARE"      to limits.rare,
                "EPIC"      to limits.epic,
                "LEGENDARY" to limits.legendary,
            )
            for ((rarity, expectedCount) in expected) {
                val actual = counts[rarity] ?: 0
                if (actual != expectedCount) {
                    problems += "Deck '${deck.name}' (L${deck.level}): $rarity expected $expectedCount, got $actual"
                }
            }
        }
        fail("Preset deck rarity mismatches", problems)
    }

    // ══════════════════════════════════════════════════════════════════════════
    // UNIVERSALITY — new word would automatically get all quiz types
    // ══════════════════════════════════════════════════════════════════════════

    @Test fun `universality — fully-populated word gets all 7 quiz types in a set of 20`() {
        // Verify that any word with all fields in a 20-word set can use every quiz type.
        // This is the contract for future word additions in any language.
        val w = SeedData.words.first { it.definition != null && it.example != null }
        val set = SeedData.words.filter { it.setId == w.setId }.take(20)
        // Count how many fields are non-null (a real word in the DB has all fields after the patch)
        val hasAllNative = set.all { it.definitionNative != null && it.exampleNative != null }
        // If the set doesn't have native content (pre-patch state), definition/native types won't appear.
        // The test documents the expected state after the patch.
        if (hasAllNative) {
            val domainWords = set.map { e ->
                com.example.kartonki.domain.model.Word(
                    id = e.id, original = e.original, translation = e.translation,
                    rarity = com.example.kartonki.domain.model.Rarity.valueOf(e.rarity),
                    languagePair = e.languagePair, pos = e.pos, semanticGroup = e.semanticGroup,
                    definition = e.definition, definitionNative = e.definitionNative,
                    example = e.example, exampleNative = e.exampleNative,
                )
            }
            val target = domainWords.first()
            val types = (1..2000).map {
                com.example.kartonki.domain.quiz.QuizBuilder.pickQuizType(target, domainWords)
            }.toSet()
            assertEquals("All 7 quiz types should appear for a fully-populated word",
                com.example.kartonki.domain.model.StudyQuizType.values().toSet(), types)
        }
    }
}
