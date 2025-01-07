package co.com.literalura.model;

import co.com.literalura.utility.ConstantsUtil;

public enum LanguageCode {
    SPANISH("es"),
    ENGLISH("en"),
    FRENCH("fr"),
    GERMAN("de"),
    ITALIAN("it"),
    PORTUGUESE("pt"),
    DUTCH("nl"),
    RUSSIAN("ru"),
    JAPANESE("ja"),
    CHINESE("zh"),
    KOREAN("ko"),
    ARABIC("ar"),
    HINDI("hi"),
    SWEDISH("sv"),
    NORWEGIAN("no"),
    DANISH("da"),
    FINNISH("fi"),
    GREEK("el"),
    TURKISH("tr");

    private final String code;

    LanguageCode(String code) {
        this.code = code;
    }

    public static LanguageCode fromString(String text) {
        for (LanguageCode languageCode: LanguageCode.values()) {
            if (languageCode.code.equalsIgnoreCase(text)) {
                return languageCode;
            }
        }

        throw new IllegalArgumentException(ConstantsUtil.NO_LANGUAGE_CODE_FOUND_MESSAGE.concat(text));
    }
}
