package mobile.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Branches {
    TEST_RELEASE("TEST-RELEASE"),
    PASS_COMMON("PASS-COMMON"),
    TEST_COMMON("TEST-COMMON"),
    GAMMA_COMMON("TEST-COMMON"),
    CHI_COMMON("CHI-COMMON"),
    PSI_COMMON("PSI-COMMON"),
    ALPHA_COMMON("ALPHA-COMMON"),
    BETA_COMMON("BETA-COMMON"),
    ADAPTER("16501-adapter");

    private final String branch;
}
