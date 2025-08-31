package mobile.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Language {
    RUSSIAN("Русский"),
    ENGLISH("English"),
    CHINA("简体中文");

    private final String languageMobile;
}
