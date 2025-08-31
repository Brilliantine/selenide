package tests;

import mobile.enums.BranchesCommon;
import mobile.enums.Contour;
import mobile.enums.Language;
import mobile.pages.onbording.LanguageSelectionPage;
import org.junit.jupiter.api.Test;

public class Login extends BaseTest{

    @Test
    public void login(){
        LanguageSelectionPage languageSelectionPage = new LanguageSelectionPage();
        languageSelectionPage
                .checkInitElements()
                .languageSelection(Language.RUSSIAN)
                .tapButtonNext()
                .checkInitElements()
                .selectEnvironment(Contour.COMMON)
                .selectBranch(BranchesCommon.TEST)
                .tapChangeContour()
                .tapButtonNext();
    }
}
