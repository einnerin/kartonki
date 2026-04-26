package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Single source of truth for all seed word/set/deck data.
 *
 * HOW TO ADD A NEW LANGUAGE:
 * 1. Create WordData<Language>.kt (and split files if needed, e.g. WordData<Language>Expanded.kt).
 * 2. Add the new object's sets and words to [allSets] and [allWords] below.
 * 3. Add the new language's preset decks property to [allPrebuiltDecks].
 * 4. Add the new language ID block to [languageIdBlocks].
 * 5. Bump [WordDataVersion.CURRENT] and [PresetDecksVersion.CURRENT].
 *
 * That's the only file you need to touch outside the new WordData file itself.
 */
object WordRegistry {

    /**
     * When true, [allSets] and [allWords] filter out sets with ≥1 skeleton word
     * (missing definition / definitionNative / example / exampleNative). This
     * keeps the first Play Store release limited to fully-filled sets. Skeleton
     * sets stay in the source code and will re-enter the app once their text
     * fields are filled in a future update.
     *
     * Set to false to expose every set to the app (useful during development).
     */
    private const val EXCLUDE_SKELETON_SETS_FROM_RELEASE = true

    /** Set of setIds containing at least one skeleton (missing-fields) word. */
    private val skeletonSetIds: Set<Long> by lazy {
        if (!EXCLUDE_SKELETON_SETS_FROM_RELEASE) return@lazy emptySet()
        _allWordsRaw.asSequence()
            .filter { w ->
                w.setId != 0L &&  // setId=0 reserved for achievement-only words
                (w.definition.isNullOrBlank() || w.definitionNative.isNullOrBlank() ||
                 w.example.isNullOrBlank() || w.exampleNative.isNullOrBlank())
            }
            .map { it.setId }
            .toSet()
    }

    val allSets: List<WordSetEntity> by lazy {
        _allSetsRaw.filter { it.id !in skeletonSetIds }
    }

    val allWords: List<WordEntity> by lazy {
        _allWordsRaw.filter { it.setId !in skeletonSetIds || it.setId == 0L }
    }

    private val _allSetsRaw: List<WordSetEntity> by lazy {
        WordDataEnglish.sets + WordDataEnglishExpanded.sets +
                WordDataEnglishBatch3.sets +
                WordDataEnglishBatch4.sets +
                WordDataEnglishBatch5.sets +
                WordDataEnglishBatch6.sets +
                WordDataEnglishBatch7.sets +
                WordDataEnglishBatch8.sets +
                WordDataEnglishBatch9.sets +
                WordDataEnglishBatch10.sets +
                WordDataEnglishBatch11.sets +
                WordDataEnglishBatch12.sets +
                WordDataEnglishBatch13.sets +
                WordDataEnglishBatch14.sets +
                WordDataEnglishBatch15.sets +
                WordDataEnglishBatch16.sets +
                WordDataEnglishBatch17.sets +
                WordDataEnglishBatch18.sets +
                WordDataEnglishJournalism2.sets +
                WordDataEnglishJournalismL4.sets +
                WordDataEnglishJournalismL5.sets +
                WordDataEnglishHistory2.sets +
                WordDataEnglishHistoryL4.sets +
                WordDataEnglishHistoryL5.sets +
                WordDataEnglishClothing2.sets +
                WordDataEnglishClothingL5.sets +
                WordDataEnglishSports2.sets +
                WordDataEnglishSportsL4.sets +
                WordDataEnglishSportsL5.sets +
                WordDataEnglishTransport2.sets +
                WordDataEnglishTransportL5.sets +
                WordDataEnglishHomeL5.sets +
                WordDataEnglishFoodL4.sets +
                WordDataEnglishFoodL5.sets +
                WordDataEnglishCultureL1.sets +
                WordDataEnglishMedicineL4.sets +
                WordDataEnglishMedicineL5.sets +
                WordDataEnglishScienceL1.sets +
                WordDataEnglishScienceL5.sets +
                WordDataEnglishEducationL5.sets +
                WordDataEnglishEverydayL3.sets +
                WordDataEnglishEverydayL4.sets +
                WordDataEnglishEverydayL5.sets +
                WordDataEnglishPoliticsL1.sets +
                WordDataEnglishPoliticsL5.sets +
                WordDataEnglishNatureL4.sets +
                WordDataEnglishNatureL5.sets +
                WordDataEnglishPsychologyL1.sets +
                WordDataEnglishTravelL3.sets +
                WordDataEnglishTravelL4.sets +
                WordDataEnglishTravelL5.sets +
                WordDataEnglishWorkL3.sets +
                WordDataEnglishWorkL5.sets +
                WordDataEnglishTechL5.sets +
                WordDataEnglishPhilosophyL1.sets +
                WordDataEnglishPhilosophyL2.sets +
                WordDataEnglishFinanceL1.sets +
                WordDataEnglishFinanceL5.sets +
                WordDataEnglishHealthFitnessL1L2L3.sets +
                WordDataEnglishShoppingL1L2L3.sets +
                WordDataEnglishEntertainmentL1L2L3.sets +
                WordDataHebrewHealthFitnessL1L2L3.sets +
                WordDataHebrewShoppingL1L2L3.sets +
                WordDataHebrewEntertainmentL1L2L3.sets +
                WordDataHebrewBarberL1L2L3.sets +
                WordDataHebrewBaristaL1L2L3.sets +
                WordDataHebrewPlumberL1L2L3.sets +
                WordDataHebrew.sets + WordDataHebrewEveryday.sets +
                WordDataHebrewMore.sets + WordDataHebrewAdvanced.sets +
                WordDataHebrewImmigrant.sets +
                WordDataHebrewImmigrant2.sets +
                WordDataHebrewImmigrant3.sets +
                WordDataHebrewImmigrant4.sets +
                WordDataHebrewImmigrant5.sets +
                WordDataHebrewImmigrant6.sets +
                WordDataHebrewBatch5.sets +
                WordDataHebrewBatch6.sets +
                WordDataHebrewBatch7.sets +
                WordDataHebrewBatch8.sets +
                WordDataHebrewBatch9.sets +
                WordDataHebrewBatch10.sets +
                WordDataHebrewBatch11.sets +
                WordDataHebrewBatch13.sets +
                WordDataHebrewBatch15.sets +
                WordDataHebrewBatch16.sets +
                WordDataHebrewBatch18.sets +
                WordDataHebrewBatch20.sets +
                WordDataHebrewBatch21.sets +
                WordDataHebrewBatch22.sets +
                WordDataHebrewBatch23.sets +
                WordDataHebrewBatch24.sets +
                WordDataHebrewBatch25.sets +
                WordDataHebrewBatch27.sets +
                WordDataHebrewBatch33.sets +
                WordDataHebrewBatch39.sets +
                WordDataHebrewImmigrant9.sets +
                WordDataHebrewImmigrant10.sets +
                WordDataHebrewImmigrant11.sets +
                WordDataHebrewImmigrant12.sets +
                WordDataHebrewImmigrant13.sets +
                WordDataHebrewImmigrant15.sets +
                WordDataHebrewImmigrant16.sets +
                WordDataHebrewBatch40.sets +
                WordDataHebrewBatch42.sets +
                WordDataHebrewBatch43.sets +
                WordDataHebrewBatch44.sets +
                WordDataHebrewBatch45.sets +
                WordDataHebrewBatch46.sets +
                WordDataHebrewBatch47.sets +
                WordDataHebrewBatch48.sets +
                WordDataHebrewBatch49.sets +
                WordDataHebrewBatch50.sets +
                WordDataHebrewBatch51.sets +
                WordDataHebrewBatch52.sets +
                WordDataHebrewBatch53.sets +
                WordDataHebrewBatch54.sets +
                WordDataHebrewBatch55.sets +
                WordDataHebrewBatch56.sets +
                WordDataHebrewBatch57.sets +
                WordDataHebrewBatch58.sets +
                WordDataHebrewBatch59.sets +
                WordDataHebrewBatch60.sets +
                WordDataHebrewBatch61.sets +
                WordDataHebrewBatch62.sets +
                WordDataHebrewBatch63.sets +
                WordDataHebrewBatch64.sets +
                WordDataHebrewBatch65.sets +
                WordDataHebrewBatch66.sets +
                WordDataHebrewBatch67.sets +
                WordDataHebrewBatch68.sets +
                WordDataHebrewBatch69.sets +
                WordDataHebrewBatch70.sets +
                WordDataHebrewBatch71.sets +
                WordDataHebrewBatch72.sets +
                WordDataHebrewBatch73.sets +
                WordDataHebrewBatch74.sets +
                WordDataHebrewBatch75.sets +
                WordDataHebrewBatch77.sets +
                WordDataHebrewBatch79.sets +
                WordDataHebrewBatch80.sets +
                WordDataHebrewBatch81.sets +
                WordDataHebrewBatch82.sets +
                WordDataHebrewBatch83.sets +
                WordDataHebrewBatch87.sets +
                WordDataHebrewBatch89.sets +
                WordDataHebrewBatch91.sets +
                WordDataHebrewBatch92.sets +
                WordDataHebrewBatch93.sets +
                WordDataHebrewTransportV2.sets +
                WordDataHebrewWorkV2.sets +
                WordDataHebrewAliyaV2.sets +
                WordDataHebrewFinanceV2.sets +
                WordDataHebrewMedicineV2.sets +
                WordDataHebrewArchL4.sets +
                WordDataHebrewArmyL1.sets +
                WordDataHebrewCultureL1.sets +
                WordDataHebrewHomeL1.sets +
                WordDataHebrewReligionL1.sets +
                WordDataHebrewRelHolidaysL1.sets +
                WordDataHebrewRelHolidaysL5.sets +
                WordDataHebrewLawL1.sets +
                WordDataHebrewCityL1.sets +
                WordDataHebrewScienceL1.sets +
                WordDataHebrewPoliticsL1.sets +
                WordDataHebrewGreetingsL4.sets +
                WordDataHebrewAutomobilePartial.sets +
                WordDataHebrewAccountingL2.sets +
                WordDataHebrewDriverL4.sets +
                WordDataHebrewCleaningL4.sets +
                WordDataHebrewCourierL3.sets +
                WordDataHebrewLogisticsL3.sets +
                WordDataHebrewNurseL1.sets +
                WordDataHebrewWaiterL4.sets +
                WordDataHebrewSecurityL4.sets +
                WordDataHebrewCookL4.sets +
                WordDataHebrewRetailL4.sets +
                WordDataHebrewConstructionL2.sets +
                WordDataHebrewCareL3.sets +
                WordDataHebrewElectricianL1.sets +
                WordDataHebrewHightechL1.sets +
                WordDataHebrewHightechL2.sets +
                WordDataHebrewHightechL3.sets +
                WordDataHebrewHightechL4.sets +
                WordDataHebrewHightechL5.sets +
                WordDataHebrewInterview.sets
    }

    private val _allWordsRaw: List<WordEntity> by lazy {
        WordDataEnglish.words + WordDataEnglishExpanded.words +
                WordDataEnglishExpanded.achievementRewardWords() +
                WordDataHebrewAchievementRewards.achievementRewardWords() +
                WordDataEnglishBatch3.words +
                WordDataEnglishBatch4.words +
                WordDataEnglishBatch5.words +
                WordDataEnglishBatch6.words +
                WordDataEnglishBatch7.words +
                WordDataEnglishBatch8.words +
                WordDataEnglishBatch9.words +
                WordDataEnglishBatch10.words +
                WordDataEnglishBatch11.words +
                WordDataEnglishBatch12.words +
                WordDataEnglishBatch13.words +
                WordDataEnglishBatch14.words +
                WordDataEnglishBatch15.words +
                WordDataEnglishBatch16.words +
                WordDataEnglishBatch17.words +
                WordDataEnglishBatch18.words +
                WordDataEnglishJournalism2.words +
                WordDataEnglishJournalismL4.words +
                WordDataEnglishJournalismL5.words +
                WordDataEnglishHistory2.words +
                WordDataEnglishHistoryL4.words +
                WordDataEnglishHistoryL5.words +
                WordDataEnglishClothing2.words +
                WordDataEnglishClothingL5.words +
                WordDataEnglishSports2.words +
                WordDataEnglishSportsL4.words +
                WordDataEnglishSportsL5.words +
                WordDataEnglishTransport2.words +
                WordDataEnglishTransportL5.words +
                WordDataEnglishHomeL5.words +
                WordDataEnglishFoodL4.words +
                WordDataEnglishFoodL5.words +
                WordDataEnglishCultureL1.words +
                WordDataEnglishMedicineL4.words +
                WordDataEnglishMedicineL5.words +
                WordDataEnglishScienceL1.words +
                WordDataEnglishScienceL5.words +
                WordDataEnglishEducationL5.words +
                WordDataEnglishEverydayL3.words +
                WordDataEnglishEverydayL4.words +
                WordDataEnglishEverydayL5.words +
                WordDataEnglishPoliticsL1.words +
                WordDataEnglishPoliticsL5.words +
                WordDataEnglishNatureL4.words +
                WordDataEnglishNatureL5.words +
                WordDataEnglishPsychologyL1.words +
                WordDataEnglishTravelL3.words +
                WordDataEnglishTravelL4.words +
                WordDataEnglishTravelL5.words +
                WordDataEnglishWorkL3.words +
                WordDataEnglishWorkL5.words +
                WordDataEnglishTechL5.words +
                WordDataEnglishPhilosophyL1.words +
                WordDataEnglishPhilosophyL2.words +
                WordDataEnglishFinanceL1.words +
                WordDataEnglishFinanceL5.words +
                WordDataEnglishHealthFitnessL1L2L3.words +
                WordDataEnglishShoppingL1L2L3.words +
                WordDataEnglishEntertainmentL1L2L3.words +
                WordDataHebrewHealthFitnessL1L2L3.words +
                WordDataHebrewShoppingL1L2L3.words +
                WordDataHebrewEntertainmentL1L2L3.words +
                WordDataHebrewBarberL1L2L3.words +
                WordDataHebrewBaristaL1L2L3.words +
                WordDataHebrewPlumberL1L2L3.words +
                WordDataHebrew.words + WordDataHebrewEveryday.words +
                WordDataHebrewMore.words + WordDataHebrewAdvanced.words +
                WordDataHebrewImmigrant.words +
                WordDataHebrewImmigrant2.words +
                WordDataHebrewImmigrant3.words +
                WordDataHebrewImmigrant4.words +
                WordDataHebrewImmigrant5.words +
                WordDataHebrewImmigrant6.words +
                WordDataHebrewImmigrantExtra.words +
                WordDataHebrewBatch5.words +
                WordDataHebrewBatch6.words +
                WordDataHebrewBatch7.words +
                WordDataHebrewBatch8.words +
                WordDataHebrewBatch9.words +
                WordDataHebrewBatch10.words +
                WordDataHebrewBatch11.words +
                WordDataHebrewBatch13.words +
                WordDataHebrewBatch15.words +
                WordDataHebrewBatch16.words +
                WordDataHebrewBatch18.words +
                WordDataHebrewBatch20.words +
                WordDataHebrewBatch21.words +
                WordDataHebrewBatch22.words +
                WordDataHebrewBatch23.words +
                WordDataHebrewBatch24.words +
                WordDataHebrewBatch25.words +
                WordDataHebrewBatch27.words +
                WordDataHebrewBatch33.words +
                WordDataHebrewBatch39.words +
                WordDataHebrewImmigrant9.words +
                WordDataHebrewImmigrant10.words +
                WordDataHebrewImmigrant11.words +
                WordDataHebrewImmigrant12.words +
                WordDataHebrewImmigrant13.words +
                WordDataHebrewImmigrant15.words +
                WordDataHebrewImmigrant16.words +
                WordDataHebrewBatch40.words +
                WordDataHebrewBatch42.words +
                WordDataHebrewBatch43.words +
                WordDataHebrewBatch44.words +
                WordDataHebrewBatch45.words +
                WordDataHebrewBatch46.words +
                WordDataHebrewBatch47.words +
                WordDataHebrewBatch48.words +
                WordDataHebrewBatch49.words +
                WordDataHebrewBatch50.words +
                WordDataHebrewBatch51.words +
                WordDataHebrewBatch52.words +
                WordDataHebrewBatch53.words +
                WordDataHebrewBatch54.words +
                WordDataHebrewBatch55.words +
                WordDataHebrewBatch56.words +
                WordDataHebrewBatch57.words +
                WordDataHebrewBatch58.words +
                WordDataHebrewBatch59.words +
                WordDataHebrewBatch60.words +
                WordDataHebrewBatch61.words +
                WordDataHebrewBatch62.words +
                WordDataHebrewBatch63.words +
                WordDataHebrewBatch64.words +
                WordDataHebrewBatch65.words +
                WordDataHebrewBatch66.words +
                WordDataHebrewBatch67.words +
                WordDataHebrewBatch68.words +
                WordDataHebrewBatch69.words +
                WordDataHebrewBatch70.words +
                WordDataHebrewBatch71.words +
                WordDataHebrewBatch72.words +
                WordDataHebrewBatch73.words +
                WordDataHebrewBatch74.words +
                WordDataHebrewBatch75.words +
                WordDataHebrewBatch77.words +
                WordDataHebrewBatch79.words +
                WordDataHebrewBatch80.words +
                WordDataHebrewBatch81.words +
                WordDataHebrewBatch82.words +
                WordDataHebrewBatch83.words +
                WordDataHebrewBatch87.words +
                WordDataHebrewBatch89.words +
                WordDataHebrewBatch91.words +
                WordDataHebrewBatch92.words +
                WordDataHebrewBatch93.words +
                WordDataHebrewTransportV2.words +
                WordDataHebrewWorkV2.words +
                WordDataHebrewAliyaV2.words +
                WordDataHebrewFinanceV2.words +
                WordDataHebrewMedicineV2.words +
                WordDataHebrewArchL4.words +
                WordDataHebrewArmyL1.words +
                WordDataHebrewCultureL1.words +
                WordDataHebrewHomeL1.words +
                WordDataHebrewReligionL1.words +
                WordDataHebrewRelHolidaysL1.words +
                WordDataHebrewRelHolidaysL5.words +
                WordDataHebrewLawL1.words +
                WordDataHebrewCityL1.words +
                WordDataHebrewScienceL1.words +
                WordDataHebrewPoliticsL1.words +
                WordDataHebrewGreetingsL4.words +
                WordDataHebrewAutomobilePartial.words +
                WordDataHebrewAccountingL2.words +
                WordDataHebrewDriverL4.words +
                WordDataHebrewCleaningL4.words +
                WordDataHebrewCourierL3.words +
                WordDataHebrewLogisticsL3.words +
                WordDataHebrewNurseL1.words +
                WordDataHebrewWaiterL4.words +
                WordDataHebrewSecurityL4.words +
                WordDataHebrewCookL4.words +
                WordDataHebrewRetailL4.words +
                WordDataHebrewConstructionL2.words +
                WordDataHebrewCareL3.words +
                WordDataHebrewElectricianL1.words +
                WordDataHebrewHightechL1.words +
                WordDataHebrewHightechL2.words +
                WordDataHebrewHightechL3.words +
                WordDataHebrewHightechL4.words +
                WordDataHebrewHightechL5.words +
                WordDataHebrewInterview.words
    }

    val allPrebuiltDecks: List<DeckSeed> by lazy {
        WordDataEnglish.prebuiltDecks + WordDataHebrew.prebuiltDecks
    }

    /**
     * Valid set-ID ranges per language pair.
     * Word IDs follow the formula: setId × 100 + position (1–99).
     *
     * Add a new entry here when a new language pair is introduced.
     * Convention: allocate blocks of 1000 (e.g. fr-ru → 2001..2999).
     */
    val languageIdBlocks: Map<String, IntRange> = mapOf(
        "en-ru" to 1..999,
        "he-ru" to 1001..1999,
    )
}
