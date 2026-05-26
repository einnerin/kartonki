package com.example.kartonki.quiz

import com.example.kartonki.domain.quiz.HebrewBlankMatcher
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class HebrewBlankMatcherTest {

    @Test
    fun `strict match — original verbatim in example`() {
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "אֲנִי אוֹהֵב כֶּלֶב.",
            original = "כֶּלֶב",
        )
        assertEquals("אֲנִי אוֹהֵב _____.", result)
    }

    @Test
    fun `prefix lamed — לְ attached to root`() {
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "הַתְּבִיעָה הֻגְּשָׁה לְבֵית מִשְׁפָּט הַשָּׁלוֹם בְּתֵל אָבִיב.",
            original = "בֵּית מִשְׁפָּט הַשָּׁלוֹם",
        )
        // Blank replaces "לְבֵית מִשְׁפָּט הַשָּׁלוֹם" — keeping prefix as part of the gap.
        assertEquals("הַתְּבִיעָה הֻגְּשָׁה _____ בְּתֵל אָבִיב.", result)
    }

    @Test
    fun `prefix definite article ה`() {
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "הַכֶּלֶב נָבַח כָּל הַלַּיְלָה.",
            original = "כֶּלֶב",
        )
        assertEquals("_____ נָבַח כָּל הַלַּיְלָה.", result)
    }

    @Test
    fun `prefix ב — preposition in`() {
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "הָאֵם פָּנְתָה לְבֵית מִשְׁפָּט לְעִנְיְנֵי מִשְׁפָּחָה.",
            original = "בֵּית מִשְׁפָּט לְעִנְיְנֵי מִשְׁפָּחָה",
        )
        assertEquals("הָאֵם פָּנְתָה _____.", result)
    }

    @Test
    fun `nikud-insensitive — example has stronger nikud than original`() {
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "הַכֶּלֶב נָבַח.",
            original = "כלב",  // no nikud at all
        )
        assertEquals("_____ נָבַח.", result)
    }

    @Test
    fun `no match — original simply not in example`() {
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "הַחָתוּל יָשַׁן עַל הַסַּפָּה.",
            original = "כֶּלֶב",
        )
        assertNull(result)
    }

    @Test
    fun `no match — inflectional change inside root`() {
        // Plural masculine: כְּלָבִים vs singular כֶּלֶב — different root chars
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "הַכְּלָבִים נָבְחוּ.",
            original = "כֶּלֶב",
        )
        // We don't handle inflection — return null so the caller falls back.
        assertNull(result)
    }

    @Test
    fun `english-style — fallback to identity behaviour for non-Hebrew works`() {
        // The matcher is only invoked for he-ru in QuizBuilder; here we
        // double-check that strict mode also works for ASCII.
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "I love my dog.",
            original = "dog",
        )
        assertEquals("I love my _____.", result)
    }

    @Test
    fun `combined prefix וה — and the`() {
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "הָלַכְתִּי לַחֲנוּת וְהַכֶּלֶב חִכָּה בַּחוּץ.",
            original = "כֶּלֶב",
        )
        // וְהַכֶּלֶב = "and the dog" — prefix ו+ה
        assertEquals("הָלַכְתִּי לַחֲנוּת _____ חִכָּה בַּחוּץ.", result)
    }

    @Test
    fun `blank parameter is configurable`() {
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "אֲנִי אוֹהֵב כֶּלֶב.",
            original = "כֶּלֶב",
            blank = "___",
        )
        assertEquals("אֲנִי אוֹהֵב ___.", result)
    }

    @Test fun `original appearing twice in example produces single blank not two`() {
        // Real-world case: «לֹא, אֲנִי לֹא עָיֵף עַכְשָׁיו.» — "No, I'm not tired".
        // Naive replace-all would create two blanks. We want exactly one.
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "לֹא, אֲנִי לֹא עָיֵף עַכְשָׁיו.",
            original = "לֹא",
        )
        assertEquals("_____, אֲנִי לֹא עָיֵף עַכְשָׁיו.", result)
    }

    @Test fun `english-style example with original twice produces single blank`() {
        val result = HebrewBlankMatcher.replaceOriginalWithBlank(
            example = "I run and run again.",
            original = "run",
        )
        assertEquals("I _____ and run again.", result)
    }
}
