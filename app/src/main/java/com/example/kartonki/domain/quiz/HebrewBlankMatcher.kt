package com.example.kartonki.domain.quiz

/**
 * Hebrew-aware matcher for the FILL_IN_BLANK quiz.
 *
 * English example: original "cookie" must literally appear in example
 * "I baked a delicious cookie for my daughter's birthday." → strict replace works.
 *
 * Hebrew is morphologically richer: a noun in an example commonly carries an
 * attached prefix letter (definite article ה, prepositions ב/ל/מ/כ, conjunction
 * ו, relative ש). The bare original lacks the prefix; strict replace then
 * fails:
 *
 *   original = "בֵּית מִשְׁפָּט הַשָּׁלוֹם"
 *   example  = "הַתְּבִיעָה הֻגְּשָׁה לְבֵית מִשְׁפָּט הַשָּׁלוֹם בְּתֵל אָבִיב."
 *                                  ^^ prefix לְ
 *
 * Naive `example.replace(original, "_____")` finds nothing and falls back to
 * MULTIPLE_CHOICE_TRANSLATION. The workaround was to mark whole sets with
 * isFillInBlankSafe=false — 1014 he-ru words lost FILL_IN_BLANK that way.
 *
 * This matcher does:
 *   1) strict replace (handles fully aligned cases)
 *   2) nikud-insensitive search with single-letter Hebrew prefix tolerance
 *      (ה, ב, ל, מ, כ, ו, ש, plus common two-letter combinations)
 *   3) maps the match back to the original example to substitute "_____"
 *      preserving any attached prefix (so the blank reads naturally)
 *
 * What it does NOT handle (intentional — would produce wrong matches):
 *   - Inflectional changes inside the root (singular ↔ plural, mascular ↔ feminine)
 *   - Re-ordering of multi-word phrases
 *   - Mid-word affixes (suffixes like ־ָה, ־ִים)
 *
 * Returns null when no acceptable match found → caller falls back to
 * MULTIPLE_CHOICE_TRANSLATION.
 */
object HebrewBlankMatcher {

    private val NIKUD_RANGE = '֑'..'ׇ'

    /**
     * Common Hebrew prefix letters allowed before the root. Empty string in
     * the list = "no prefix"; the algorithm tries from no-prefix outward, so
     * exact match wins over prefixed match.
     *
     * Order matters: try longer prefixes after shorter, to prevent eating
     * a part of the root.
     */
    private val PREFIXES = listOf(
        "",
        "ה", "ב", "ל", "מ", "כ", "ו", "ש",
        "וה", "וב", "ול", "ומ", "וכ",
        "כש", "לש", "מש", "בש",
    )

    /**
     * Replace [original] with [blank] in [example] with Hebrew-aware tolerance.
     *
     * @return modified example with the blank inserted, or null if neither
     *         strict nor relaxed match succeeded.
     */
    fun replaceOriginalWithBlank(
        example: String,
        original: String,
        blank: String = "_____",
    ): String? {
        // 1) Strict path (cheap, handles all en-ru and well-aligned he-ru cases).
        val strict = example.replace(original, blank, ignoreCase = false)
        if (strict != example) return strict

        // 2) Nikud-insensitive search with prefix tolerance.
        if (original.isBlank()) return null
        val origStripped = stripNikud(original)
        if (origStripped.isBlank()) return null

        // Build a map from stripped-example index → original-example index.
        // This lets us find substring span in the stripped form and replace
        // the corresponding slice in the original (preserving nikud + prefix).
        val mapping = IntArray(example.length + 1)
        val strippedBuilder = StringBuilder(example.length)
        var stripIdx = 0
        for (i in example.indices) {
            val c = example[i]
            if (c in NIKUD_RANGE) continue
            mapping[stripIdx] = i
            strippedBuilder.append(c)
            stripIdx++
        }
        mapping[stripIdx] = example.length
        val exampleStripped = strippedBuilder.toString()

        // 2a) Single-token or leading-prefix-only multi-token (cheap path).
        // Word-bounded — both sides of the match must not be Hebrew letters,
        // otherwise we'd match singular inside plural (כלב ⊂ כלבים) or
        // root-inside-derived-form.
        for (prefix in PREFIXES) {
            val needle = prefix + origStripped
            val foundAt = findWordBounded(exampleStripped, needle)
            if (foundAt < 0) continue
            val startInOrig = mapping[foundAt]
            val endInOrig = mapping[foundAt + needle.length]
            return example.substring(0, startInOrig) + blank + example.substring(endInOrig)
        }

        // 2b) Multi-token compound: each token may carry its own prefix.
        // Handles `קַלְמָר עֲנָק` appearing as `הַקַּלְמָר הָעֲנָק` (article on
        // both noun and adjective). Original must contain whitespace.
        if (origStripped.contains(' ')) {
            val pat = buildMultiTokenRegex(origStripped)
            val m = Regex("(?<![א-ת])$pat(?![א-ת])").find(exampleStripped)
            if (m != null) {
                val startInOrig = mapping[m.range.first]
                val endInOrig = mapping[m.range.last + 1]
                return example.substring(0, startInOrig) + blank + example.substring(endInOrig)
            }
        }

        return null
    }

    private const val PREFIX_REGEX = "[הבלמכוש]*"

    /** Build a regex that matches the phrase allowing prefix letters before each
     * whitespace-separated token. */
    private fun buildMultiTokenRegex(origStripped: String): String =
        origStripped.split(' ').joinToString("\\s+") { PREFIX_REGEX + Regex.escape(it) }

    /** Find [needle] in [haystack] such that neither side touches a Hebrew letter. */
    private fun findWordBounded(haystack: String, needle: String): Int {
        var start = 0
        while (true) {
            val idx = haystack.indexOf(needle, start)
            if (idx < 0) return -1
            val beforeOk = idx == 0 || !isHebrewLetter(haystack[idx - 1])
            val end = idx + needle.length
            val afterOk = end == haystack.length || !isHebrewLetter(haystack[end])
            if (beforeOk && afterOk) return idx
            start = idx + 1
        }
    }

    private val HEBREW_LETTER_RANGE = 'א'..'ת'
    private fun isHebrewLetter(c: Char): Boolean = c in HEBREW_LETTER_RANGE

    /** Remove Hebrew nikud (vowel points) from a string. */
    private fun stripNikud(text: String): String {
        if (text.isEmpty()) return text
        val sb = StringBuilder(text.length)
        for (c in text) if (c !in NIKUD_RANGE) sb.append(c)
        return sb.toString()
    }
}
