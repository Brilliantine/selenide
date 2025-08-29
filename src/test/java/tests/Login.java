package tests;

import mobile.pages.onbording.LanguageSelectionPage;
import org.junit.jupiter.api.Test;

public class Login extends BaseTest{

    @Test
    public void login(){
        LanguageSelectionPage languageSelectionPage = new LanguageSelectionPage();
        languageSelectionPage
                .checkInitElements()
                .languageSelection("Русский")
                .tapButtonNext()
                .checkInitElements()
                .selectEnvironment("common")
                .selectBranch("TEST-COMMON")
                .tapChangeContour()
                .tapButtonNext();
    }
}
