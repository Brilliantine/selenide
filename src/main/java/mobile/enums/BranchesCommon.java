package mobile.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BranchesCommon {
    PASS("PASS-COMMON"),
    TEST("TEST-COMMON"),
    GAMMA("TEST-COMMON"),
    CHI("CHI-COMMON"),
    PSI("PSI-COMMON"),
    ALPHA("ALPHA-COMMON"),
    BETA("BETA-COMMON"),
    ADAPTER("16501-adapter");

    private final String branch;
}
