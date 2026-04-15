"""
Third pass: manual IPA for words the library couldn't handle.
"""

import re
import sys

FILES = [
    r"C:\Users\Einerin\AndroidStudioProjects\Kartonki\app\src\main\java\com\example\kartonki\data\WordDataEnglish.kt",
    r"C:\Users\Einerin\AndroidStudioProjects\Kartonki\app\src\main\java\com\example\kartonki\data\WordDataEnglishExpanded.kt",
]

MISSING_PATTERN = re.compile(
    r'(original = "([^"]+)",)(?=\s+translation)'
)

MANUAL: dict[str, str] = {
    # ── Common modern vocab ────────────────────────────────────────────────
    "biofuel":          "[ˈbaɪoʊfjuːəl]",
    "influencer":       "[ˈɪnfluənsər]",
    "paywall":          "[ˈpeɪwɔːl]",
    "mindfulness":      "[ˈmaɪndfəlnəs]",
    "marginalised":     "[ˈmɑːrdʒɪnəlaɪzd]",
    "immersive":        "[ɪˈmɜːrsɪv]",
    "recalibrate":      "[riˈkælɪbreɪt]",
    "verbose":          "[vɜːrˈboʊs]",
    "iterate":          "[ˈɪtəreɪt]",
    "liaise":           "[liˈeɪz]",
    "reproducible":     "[ˌriːprəˈduːsɪbəl]",
    "taxonomy":         "[tækˈsɒnəmi]",
    "counterintuitive": "[ˌkaʊntərɪnˈtuːɪtɪv]",
    "equanimous":       "[ɪˈkwænɪməs]",
    "reductive":        "[rɪˈdʌktɪv]",
    "liminal":          "[ˈlɪmɪnəl]",
    "transmute":        "[trænsˈmjuːt]",
    "catalyse":         "[ˈkætəlaɪz]",
    # ── Rhetoric / linguistics ─────────────────────────────────────────────
    "circumlocution":   "[ˌsɜːrkəmloʊˈkjuːʃən]",
    "litotes":          "[ˈlaɪtətiːz]",
    "tautology":        "[tɔːˈtɒlədʒi]",
    "tautological":     "[ˌtɔːtəˈlɒdʒɪkəl]",
    "ellipsis":         "[ɪˈlɪpsɪs]",
    "pragmatics":       "[præɡˈmætɪks]",
    "metonymy":         "[mɪˈtɒnɪmi]",
    "synecdoche":       "[sɪˈnɛkdəki]",
    "solecism":         "[ˈsɒlɪsɪzəm]",
    "intertextuality":  "[ˌɪntərtɛkstʃuˈælɪti]",
    "prolepsis":        "[proʊˈlɛpsɪs]",
    "bathos":           "[ˈbeɪθɒs]",
    "mimesis":          "[mɪˈmiːsɪs]",
    "picaresque":       "[ˌpɪkəˈrɛsk]",
    "ekphrasis":        "[ˈɛkfrəsɪs]",
    "diegesis":         "[ˌdaɪəˈdʒiːsɪs]",
    "metafiction":      "[ˈmɛtəfɪkʃən]",
    # ── Philosophy / rhetoric ──────────────────────────────────────────────
    "solipsism":        "[ˈsɒlɪpsɪzəm]",
    "solipsistic":      "[ˌsɒlɪpˈsɪstɪk]",
    "axiological":      "[ˌæksiəˈlɒdʒɪkəl]",
    "apodeictic":       "[ˌæpəˈdaɪktɪk]",
    "vitiate":          "[ˈvɪʃieɪt]",
    "abjure":           "[æbˈdʒʊər]",
    # ── Literary terms ─────────────────────────────────────────────────────
    "lacuna":           "[ləˈkjuːnə]",
    "desideratum":      "[dɪˌzɪdəˈreɪtəm]",
    "palimpsest":       "[ˈpælɪmpsɛst]",
    # ── Advanced adjectives / rare words ──────────────────────────────────
    "perfidious":       "[pərˈfɪdiəs]",
    "limpid":           "[ˈlɪmpɪd]",
    "meretricious":     "[ˌmɛrɪˈtrɪʃəs]",
    "pellucid":         "[pɛˈluːsɪd]",
    "platitudinous":    "[ˌplætɪˈtjuːdɪnəs]",
    "stentorian":       "[stɛnˈtɔːriən]",
    "mellifluous":      "[mɛˈlɪfluəs]",
    "ineffaceable":     "[ˌɪnɪˈfeɪsəbəl]",
    "sempiternal":      "[ˌsɛmpɪˈtɜːrnəl]",
    "sagacious":        "[səˈɡeɪʃəs]",
    "diffident":        "[ˈdɪfɪdənt]",
    "sanguinary":       "[ˈsæŋɡwɪnɛri]",
    "sycophant":        "[ˈsɪkəfænt]",
    "magniloquent":     "[mæɡˈnɪləkwənt]",
    "attrite":          "[əˈtraɪt]",
    "reify":            "[ˈriːɪfaɪ]",
    "fecund":           "[ˈfɛkənd]",
    "efflorescence":    "[ˌɛfləˈrɛsəns]",
    "fructify":         "[ˈfrʌktɪfaɪ]",
    # ── Culinary (Expanded) ────────────────────────────────────────────────
    "sommelier":        "[ˌsɒməˈljeɪ]",
    "sauté":            "[soʊˈteɪ]",
    "emulsify":         "[ɪˈmʌlsɪfaɪ]",
    "julienne":         "[ˌdʒuːliˈɛn]",
    "deglaze":          "[diːˈɡleɪz]",
    "coulis":           "[ˈkuːli]",
    "veloute":          "[vəˈluːteɪ]",
    "vinaigrette":      "[ˌvɪnɪˈɡrɛt]",
    "charcuterie":      "[ʃɑːrˈkuːtəri]",
    "tartare":          "[tɑːrˈtɑːr]",
    "crudites":         "[ˈkruːdɪteɪ]",
    "umami":            "[uːˈmɑːmi]",
    "brunoise":         "[bruːnˈwɑːz]",
    "confit":           "[ˈkɒnfi]",
    "mirepoix":         "[mɪrˈpwɑː]",
    "beurre blanc":     "[bɜːr ˈblɑːŋk]",
    "chiffonade":       "[ˌʃɪfəˈnɑːd]",
    "lacto-ferment":    "[ˈlæktoʊ fɜːrmɛnt]",
    "cardamom":         "[ˈkɑːrdəməm]",
    "turmeric":         "[ˈtɜːrmərɪk]",
    # ── Tech / computing (Expanded) ───────────────────────────────────────
    "username":         "[ˈjuːzərneɪm]",
    "tethering":        "[ˈtɛðərɪŋ]",
    "emoji":            "[ɪˈmoʊdʒi]",
    "captcha":          "[ˈkæptʃə]",
    "permalink":        "[ˈpɜːrməlɪŋk]",
    "ransomware":       "[ˈrænsəmwɛr]",
    "metadata":         "[ˈmɛtədeɪtə]",
    "keylogger":        "[ˈkiːlɒɡər]",
    "refactor":         "[riːˈfæktər]",
    "transpile":        "[trænsˈpaɪl]",
    "botnet":           "[ˈbɒtnɛt]",
    "firmware":         "[ˈfɜːrmwɛr]",
    "cryptography":     "[krɪpˈtɒɡrəfi]",
    "virtualization":   "[ˌvɜːrtʃuəlaɪˈzeɪʃən]",
    "recursion":        "[rɪˈkɜːrʒən]",
    "blockchain":       "[ˈblɒktʃeɪn]",
    "steganography":    "[ˌstɛɡəˈnɒɡrəfi]",
    "containerization": "[kənˌteɪnərɪˈzeɪʃən]",
    "containerisation": "[kənˌteɪnərɪˈzeɪʃən]",
    "microservices":    "[ˈmaɪkroʊsɜːrvɪsɪz]",
    "trackpad":         "[ˈtræk pæd]",
    "dongle":           "[ˈdɒŋɡəl]",
    "USB":              "[ˌjuː ɛs ˈbiː]",
    "VPN":              "[ˌviː piː ˈɛn]",
    "API":              "[ˌeɪ piː ˈaɪ]",
    "adware":           "[ˈædwɛr]",
    "touchscreen":      "[ˈtʌtʃskriːn]",
    "screenshot":       "[ˈskriːnʃɒt]",
    "barcode":          "[ˈbɑːrkoʊd]",
    "honeypot":         "[ˈhʌnipɒt]",
    "jitter":           "[ˈdʒɪtər]",
    # ── Gaming (Expanded) ─────────────────────────────────────────────────
    "minimap":          "[ˈmɪnimæp]",
    "NPC":              "[ˌɛn piː ˈsiː]",
    "respawn":          "[riˈspɔːn]",
    "cooldown":         "[ˈkuːldaʊn]",
    "roguelike":        "[ˈroʊɡlaɪk]",
    "permadeath":       "[ˈpɜːrmədɛθ]",
    "speedrun":         "[ˈspiːdrʌn]",
    # ── Biology / ecology (Expanded) ──────────────────────────────────────
    "bioluminescence":  "[ˌbaɪoʊˌluːmɪˈnɛsəns]",
    "ecotone":          "[ˈiːkətoʊn]",
    "decomposer":       "[ˌdiːkəmˈpoʊzər]",
    "xerophyte":        "[ˈzɪərəfaɪt]",
    "palynology":       "[ˌpælɪˈnɒlədʒi]",
    "diapause":         "[ˈdaɪəpɔːz]",
    "commensalism":     "[kəˈmɛnsəlɪzəm]",
    "mycorrhiza":       "[ˌmaɪkəˈraɪzə]",
    "allelopathy":      "[ˌæliˈɒpəθi]",
    "phytoremediation": "[ˌfaɪtoʊrɪˌmiːdiˈeɪʃən]",
    "transpiration":    "[ˌtrænspaɪˈreɪʃən]",
    "anthropocene":     "[ˌænθrəpoʊˈsiːn]",
    "rewilding":        "[riːˈwaɪldɪŋ]",
    "permafrost":       "[ˈpɜːrməfrɒst]",
    "eutrophication":   "[juːˌtrɒfɪˈkeɪʃən]",
    "leachate":         "[ˈliːtʃeɪt]",
    "microplastic":     "[ˈmaɪkroʊplæstɪk]",
    "monoculture":      "[ˈmɒnəkʌltʃər]",
    # ── Chemistry / physics (Expanded) ────────────────────────────────────
    "titrant":          "[ˈtaɪtrənt]",
    "thermolysis":      "[θɜːrˈmɒlɪsɪs]",
    "solute":           "[ˈsɒljuːt]",
    "anion":            "[ˈænaɪən]",
    "centrifugation":   "[ˌsɛntrɪfjuːˈɡeɪʃən]",
    "titration":        "[taɪˈtreɪʃən]",
    "sublimation":      "[ˌsʌblɪˈmeɪʃən]",
    "molarity":         "[moʊˈlærɪti]",
    "solubility":       "[ˌsɒljuˈbɪlɪti]",
    "enthalpy":         "[ˈɛnθælpi]",
    "electronegativity":"[ɪˌlɛktrəˌnɛɡəˈtɪvɪti]",
    "thermodynamics":   "[ˌθɜːrmoʊdaɪˈnæmɪks]",
    "stoichiometry":    "[ˌstɔɪkiˈɒmɪtri]",
    "hypotenuse":       "[haɪˈpɒtɪnjuːs]",
    "factorial":        "[fækˈtɔːriəl]",
    "trigonometry":     "[ˌtrɪɡəˈnɒmɪtri]",
    "quadratic":        "[kwɒˈdrætɪk]",
    "numerator":        "[ˈnjuːmərɪtər]",
    # ── Law (Expanded) ────────────────────────────────────────────────────
    "misdemeanour":     "[ˌmɪsdɪˈmiːnər]",
    "amicus curiae":    "[əˌmaɪkəs ˈkjʊərieɪ]",
    "nolo contendere":  "[ˌnoʊloʊ kənˈtɛndəri]",
    # ── Politics / society (Expanded) ─────────────────────────────────────
    "technocracy":      "[tɛkˈnɒkrəsi]",
    "prorogation":      "[ˌprɒrəˈɡeɪʃən]",
    "plutocracy":       "[pluːˈtɒkrəsi]",
    "secessionism":     "[sɪˈsɛʃənɪzəm]",
    "kakistocracy":     "[ˌkækɪˈstɒkrəsi]",
    # ── Art (Expanded) ────────────────────────────────────────────────────
    "woodcut":          "[ˈwʊdkʌt]",
    "diorama":          "[ˌdaɪəˈrɑːmə]",
    "gouache":          "[ɡuˈɑːʃ]",
    "foreshortening":   "[fɔːrˈʃɔːrtənɪŋ]",
    "contrapposto":     "[ˌkɒntrəˈpɒstoʊ]",
    "tenebrism":        "[ˈtɛnɪbrɪzəm]",
    "grisaille":        "[ɡrɪˈzaɪ]",
    "chiaroscuro":      "[kiˌɑːrəˈskjʊəroʊ]",
    "sfumato":          "[sfuːˈmɑːtoʊ]",
    "impasto":          "[ɪmˈpæstoʊ]",
    "encaustic":        "[ɛnˈkɔːstɪk]",
    "trompe-l'oeil":    "[ˌtrɒmp ˈlɔɪ]",
    "sgraffito":        "[ˌsɡrəˈfiːtoʊ]",
    "imprimatura":      "[ˌɪmprɪməˈtjʊərə]",
    "capriccio":        "[kəˈprɪtʃioʊ]",
    # ── Literature (Expanded) ─────────────────────────────────────────────
    "couplet":          "[ˈkʌplɪt]",
    "epigraph":         "[ˈɛpɪɡrɑːf]",
    "chiasmus":         "[kaɪˈæzməs]",
    "caesura":          "[sɪˈzjʊərə]",
    "assonance":        "[ˈæsənəns]",
    "zeugma":           "[ˈzjuːɡmə]",
    "hamartia":         "[ˌhæmɑːrˈtiːə]",
    "peripeteia":       "[ˌpɛrɪpɪˈtiːə]",
    "bildungsroman":    "[ˈbɪldʊŋsroʊˌmɑːn]",
    "sibilance":        "[ˈsɪbɪləns]",
    "enjambment":       "[ɛnˈdʒæmmənt]",
    "blazon":           "[ˈbleɪzən]",
    "deus ex machina":  "[ˌdeɪəs ɛks ˈmækɪnə]",
    "in medias res":    "[ɪn ˈmiːdiəs ˈreɪs]",
    "fabula":           "[ˈfæbjʊlə]",
    "panegyric":        "[ˌpænɪˈdʒɪrɪk]",
    "didascalia":       "[ˌdɪdæˈskeɪliə]",
    "mise-en-scene":    "[ˌmiːz ɒn ˈsɛn]",
    "auteur":           "[oʊˈtɜːr]",
    "cinematheque":     "[ˌsɪnəməˈtɛk]",
    "diegetic":         "[ˌdaɪəˈdʒɛtɪk]",
    # ── Weather (Expanded) ────────────────────────────────────────────────
    "sirocco":          "[sɪˈrɒkoʊ]",
    "waterspout":       "[ˈwɔːtərspаʊt]",
    "radiosonde":       "[ˈreɪdioʊsɒnd]",
    "isotherm":         "[ˈaɪsəθɜːrm]",
    "troposphere":      "[ˈtrɒpəsfɪər]",
    "isobar":           "[ˈaɪsəbɑːr]",
    "microburst":       "[ˈmaɪkroʊbɜːrst]",
    "derecho":          "[dɪˈreɪtʃoʊ]",
    "thermocline":      "[ˈθɜːrməklaɪn]",
    "haboob":           "[həˈbuːb]",
    "cyclogenesis":     "[ˌsaɪkloʊˈdʒɛnɪsɪs]",
    "cumulus":          "[ˈkjuːmjʊləs]",
    # ── Transport / logistics (Expanded) ──────────────────────────────────
    "haulage":          "[ˈhɔːlɪdʒ]",
    "rickshaw":         "[ˈrɪkʃɔː]",
    "motorway":         "[ˈmoʊtərweɪ]",
    "drayage":          "[ˈdreɪɪdʒ]",
    "flyover":          "[ˈflaɪoʊvər]",
    "gangway":          "[ˈɡæŋweɪ]",
    "transshipment":    "[trænsˈʃɪpmənt]",
    "transhipment":     "[trænsˈʃɪpmənt]",
    "containerization": "[kənˌteɪnərɪˈzeɪʃən]",
    "waypoint":         "[ˈweɪpɔɪnt]",
    "multimodal":       "[ˌmʌltiˈmoʊdəl]",
    "waybill":          "[ˈweɪbɪl]",
    "deadfreight":      "[ˈdɛdfreɪt]",
    # ── Fashion (Expanded) ────────────────────────────────────────────────
    "hoodie":           "[ˈhʊdi]",
    "ruching":          "[ˈruːʃɪŋ]",
    "decolletage":      "[ˌdeɪkɒlɪˈtɑːʒ]",
    "bespoke":          "[bɪˈspoʊk]",
    "atelier":          "[ˌætəˈljeɪ]",
    "jacquard":         "[ˈdʒækɑːrd]",
    "peplum":           "[ˈpɛpləm]",
    "passementerie":    "[ˌpæsməntˈriː]",
    "grosgrain":        "[ˈɡroʊɡreɪn]",
    "smocking":         "[ˈsmɒkɪŋ]",
    # ── Misc (Expanded) ───────────────────────────────────────────────────
    "planogram":        "[ˈplænoʊɡræm]",
    "cashback":         "[ˈkæʃbæk]",
    "fascia":           "[ˈfeɪʃə]",
    "fascia board":     "[ˈfeɪʃə bɔːrd]",
    "gaffer":           "[ˈɡæfər]",
    "offside":          "[ˌɒfˈsaɪd]",
    "doping":           "[ˈdoʊpɪŋ]",
    "physiotherapy":    "[ˌfɪzioʊˈθɛrəpi]",
    "biomechanics":     "[ˌbaɪoʊmɪˈkænɪks]",
    "cornice":          "[ˈkɔːrnɪs]",
    "pediment":         "[ˈpɛdɪmənt]",
    "haemorrhage":      "[ˈhɛmərɪdʒ]",
    "habituation":      "[həˌbɪtʃuˈeɪʃən]",
    "introversion":     "[ˌɪntrəˈvɜːrʒən]",
    "neuroticism":      "[njʊˈrɒtɪsɪzəm]",
    "extraversion":     "[ˌɛkstrəˈvɜːrʒən]",
    "individuation":    "[ˌɪndɪˌvɪdʒuˈeɪʃən]",
    "abreaction":       "[ˌæbriˈækʃən]",
    "placation":        "[pləˈkeɪʃən]",
    "redshift":         "[ˈrɛdʃɪft]",
    "perihelion":       "[ˌpɛrɪˈhiːliən]",
    "aphelion":         "[əˈfiːliən]",
    "magnetosphere":    "[mæɡˈniːtəsfɪər]",
    "artefact":         "[ˈɑːrtɪfækt]",
    "IPO":              "[ˌaɪ piː ˈoʊ]",
    "QR code":          "[ˌkjuː ˈɑːr koʊd]",
    "windowsill":       "[ˈwɪndoʊsɪl]",
    "worktop":          "[ˈwɜːrktɒp]",
    "sparkler":         "[ˈspɑːrklər]",
    "physiotherapist":  "[ˌfɪzioʊˈθɛrəpɪst]",
    "dibber":           "[ˈdɪbər]",
    "cultivator":       "[ˈkʌltɪveɪtər]",
    "vlog":             "[vlɒɡ]",
    "filtrate":         "[ˈfɪltreɪt]",
    "stocktaking":      "[ˈstɒkteɪkɪŋ]",
    "RFQ":              "[ˌɑːr ɛf ˈkjuː]",
    "spokeshave":       "[ˈspoʊkʃeɪv]",
    "osteopath":        "[ˈɒstioʊpæθ]",
    "metallurgist":     "[mɪˈtælərdʒɪst]",
    "geophysicist":     "[ˌdʒiːoʊˈfɪzɪsɪst]",
    "cryptographer":    "[krɪpˈtɒɡrəfər]",
    "biostatistician":  "[ˌbaɪoʊˌstætɪˈstɪʃən]",
    "palaeontologist":  "[ˌpeɪliɒnˈtɒlədʒɪst]",
    "downpipe":         "[ˈdaʊnpaɪp]",
    "coving":           "[ˈkoʊvɪŋ]",
    "fenestration":     "[ˌfɛnɪˈstreɪʃən]",
    "wainscoting":      "[ˈweɪnskɒtɪŋ]",
    "vermiculite":      "[vɜːrˈmɪkjʊlaɪt]",
    "covalent bond":    "[koʊˈveɪlənt bɒnd]",
    "taiga":            "[ˈtaɪɡə]",
    "copse":            "[kɒps]",
}


def process_file(path: str) -> None:
    with open(path, encoding="utf-8") as f:
        content = f.read()

    replaced = 0
    still_missing = []

    def replacer(m: re.Match) -> str:
        nonlocal replaced
        full_match = m.group(1)
        word = m.group(2)
        ipa_str = MANUAL.get(word, "")
        replaced += 1
        if not ipa_str:
            still_missing.append(word)
            return full_match
        return f'{full_match} transliteration = "{ipa_str}",'

    new_content = MISSING_PATTERN.sub(replacer, content)

    with open(path, "w", encoding="utf-8") as f:
        f.write(new_content)

    filled = replaced - len(still_missing)
    sys.stdout.buffer.write(
        (f"\n{path}\n"
         f"  Candidates : {replaced}\n"
         f"  Filled     : {filled}\n"
         f"  Remaining  : {len(still_missing)}\n").encode("utf-8")
    )
    if still_missing:
        sys.stdout.buffer.write(
            ("  Still missing: " + ", ".join(still_missing) + "\n").encode("utf-8")
        )


for file_path in FILES:
    process_file(file_path)

sys.stdout.buffer.write(b"\nDone.\n")
