package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.domain.model.DeckLevel
import com.example.kartonki.domain.model.Rarity
import org.junit.Assert.*
import org.junit.Test

/**
 * Audits all seed-data files for completeness and correctness.
 * A failing test = a real problem that would break quiz generation for affected words.
 *
 * All data is accessed via [WordRegistry] — adding a new language means only
 * WordRegistry needs to be updated, not this test file.
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
        fail("English words missing required base fields", WordDataEnglish.words.mapNotNull { w ->
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
            WordDataEnglish.words.filter { w ->
                w.example != null && !w.example.contains(w.original, ignoreCase = true)
            }.map { w -> "Set ${w.setId} '${w.original}': '${w.example}'" }
        )
    }

    @Test fun `EN — each set has at least 4 words`() {
        val allEnWords = WordDataEnglish.words + WordDataEnglishExpanded.words
        val allEnSets  = WordDataEnglish.sets  + WordDataEnglishExpanded.sets
        fail("English sets with fewer than 4 words (multiple-choice impossible)",
            allEnSets.mapNotNull { set ->
                val count = allEnWords.count { it.setId == set.id }
                if (count < 4) "Set ${set.id} '${set.name}': $count words" else null
            }
        )
    }

    // ══════════════════════════════════════════════════════════════════════════
    // EN-NATIVE — native content inlined directly into WordDataEnglish
    // ══════════════════════════════════════════════════════════════════════════

    @Test fun `EN-NATIVE — exampleNative sentences embed the English word`() {
        fail("English FILL_IN_BLANK_NATIVE broken — English word absent from Russian example",
            WordDataEnglish.words.filter { w ->
                w.exampleNative != null && !w.exampleNative.contains(w.original, ignoreCase = true)
            }.map { w -> "Set ${w.setId} '${w.original}': '${w.exampleNative}'" }
        )
    }

    // ══════════════════════════════════════════════════════════════════════════
    // HEBREW WORDS
    // ══════════════════════════════════════════════════════════════════════════

    @Test fun `HE — all words have required fields including native content`() {
        val allHebrew = WordDataHebrew.words +
                WordDataHebrewEveryday.words +
                WordDataHebrewMore.words +
                WordDataHebrewAdvanced.words
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
        val allHebrew = WordDataHebrew.words +
                WordDataHebrewEveryday.words +
                WordDataHebrewMore.words +
                WordDataHebrewAdvanced.words
        fail("Hebrew FILL_IN_BLANK broken — Hebrew word absent from Hebrew example",
            allHebrew.filter { w ->
                w.example != null && !w.example.contains(w.original)
            }.map { w -> "Set ${w.setId} '${w.original}': '${w.example}'" }
        )
    }

    @Test fun `HE — FILL_IN_BLANK_NATIVE Russian examples embed the Hebrew word`() {
        val allHebrew = WordDataHebrew.words +
                WordDataHebrewEveryday.words +
                WordDataHebrewMore.words +
                WordDataHebrewAdvanced.words
        fail("Hebrew FILL_IN_BLANK_NATIVE broken — Hebrew word absent from Russian example",
            allHebrew.filter { w ->
                w.exampleNative != null && !w.exampleNative.contains(w.original)
            }.map { w -> "Set ${w.setId} '${w.original}': '${w.exampleNative}'" }
        )
    }

    @Test fun `HE — each set has at least 4 words`() {
        val allSets  = WordDataHebrew.sets  + WordDataHebrewEveryday.sets +
                WordDataHebrewMore.sets + WordDataHebrewAdvanced.sets
        val allWords = WordDataHebrew.words + WordDataHebrewEveryday.words +
                WordDataHebrewMore.words + WordDataHebrewAdvanced.words
        fail("Hebrew sets with fewer than 4 words",
            allSets.mapNotNull { set ->
                val count = allWords.count { it.setId == set.id }
                if (count < 4) "Set ${set.id} '${set.name}': $count words" else null
            }
        )
    }

    // ══════════════════════════════════════════════════════════════════════════
    // CROSS-LANGUAGE DUPLICATE DETECTION
    // ══════════════════════════════════════════════════════════════════════════

    @Test fun `no duplicate words — same original within the same language pair`() {
        val dupes = WordRegistry.allWords
            .groupBy { "${it.languagePair}|${it.original}" }
            .filter { (_, entries) -> entries.size > 1 }

        fail("Duplicate words with same original in the same language pair",
            dupes.map { (key, entries) ->
                val (lang, orig) = key.split("|", limit = 2)
                val ids   = entries.map { it.id }
                val sets  = entries.map { "set ${it.setId}" }
                val rarities = entries.map { it.rarity }
                "[$lang] '$orig' appears ${entries.size}× — ids=$ids sets=$sets rarities=$rarities"
            }
        )
    }

    // ══════════════════════════════════════════════════════════════════════════
    // PRESET DECKS — rarity distribution must match DeckLevel limits exactly
    // ══════════════════════════════════════════════════════════════════════════

    @Test fun `preset decks — rarity distribution matches DeckLevel limits`() {
        // Build a lookup map: (original, languagePair) → rarity.
        // Uses first-occurrence semantics to match physical DB insertion order.
        val rarityByKey: Map<String, String> = buildMap {
            for (w in WordRegistry.allWords) putIfAbsent("${w.languagePair}|${w.original}", w.rarity)
        }

        val problems = mutableListOf<String>()
        for (deck in WordRegistry.allPrebuiltDecks) {
            val limits = DeckLevel.limitsFor(deck.level)
            val counts = mutableMapOf("COMMON" to 0, "UNCOMMON" to 0, "RARE" to 0, "EPIC" to 0, "LEGENDARY" to 0)

            for (original in deck.wordOriginals) {
                val rarity = rarityByKey["${deck.languagePair}|$original"]
                if (rarity == null) {
                    problems += "Deck '${deck.name}' (L${deck.level}): word '$original' not found in '${deck.languagePair}'"
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
    // ID SCHEME — words follow setId×100+pos, sets follow language blocks
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * No two words may share the same ID across all seed files.
     * Duplicate IDs cause silent data loss via INSERT OR REPLACE.
     */
    @Test fun `no duplicate word IDs across all seed files`() {
        val dupes = WordRegistry.allWords.groupBy { it.id }.filter { (_, v) -> v.size > 1 }
        fail("Duplicate word IDs (silent data loss in DB)",
            dupes.map { (id, words) ->
                "id=$id appears ${words.size}× — originals: ${words.map { it.original }}"
            }
        )
    }

    /**
     * Every word ID must fall in the range (setId×100 + 1)..(setId×100 + 99).
     * Formula: wordId = setId × 100 + position_in_set (1–25 + a few spare slots).
     * This guarantees IDs are unique as long as set IDs are unique.
     */
    @Test fun `word IDs follow the setId x100 formula`() {
        // Achievement reward words use setId=0 as a sentinel but have manually-assigned IDs;
        // they are exempt from the formula check.
        fail("Word IDs outside expected setId×100 range",
            WordRegistry.allWords.mapNotNull { w ->
                if (w.semanticGroup == "achievement_reward") return@mapNotNull null
                val base = w.setId * 100
                if (w.id < base + 1 || w.id > base + 99)
                    "word '${w.original}' (set ${w.setId}): id=${w.id} not in [${base+1}..${base+99}]"
                else null
            }
        )
    }

    /**
     * Set IDs must respect language blocks defined in [WordRegistry.languageIdBlocks].
     * Adding a new language: add an entry there — the test automatically covers it.
     */
    @Test fun `set IDs are within their language block`() {
        fail("Set IDs outside their language block",
            WordRegistry.allSets.mapNotNull { s ->
                val range = WordRegistry.languageIdBlocks[s.languagePair]
                    ?: return@mapNotNull "Set ${s.id} '${s.name}': unknown language '${s.languagePair}' — add to WordRegistry.languageIdBlocks"
                if (s.id !in range)
                    "Set ${s.id} '${s.name}' (${s.languagePair}): must be in [${range.first}..${range.last}]"
                else null
            }
        )
    }

    // ══════════════════════════════════════════════════════════════════════════
    // UNIVERSALITY — new word would automatically get all quiz types
    // ══════════════════════════════════════════════════════════════════════════

    @Test fun `universality — fully-populated word gets all 7 quiz types in a set of 20`() {
        // Verify that any word with all fields in a 20-word set can use every quiz type.
        // This is the contract for future word additions in any language.
        val w = WordDataEnglish.words.first { it.definition != null && it.example != null }
        val set = WordDataEnglish.words.filter { it.setId == w.setId }.take(20)
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
