package mobile.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Contour {
    PROD("EKMP"),
    PREPROD("EKMP-PREPROD"),
    MASTER("master"),
    COMMON("common"),
    BRANCHES("branches"),
    PROXY("proxy");

    private final String contour;
}
