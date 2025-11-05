package tests.debugging;

import mobile.helper.Onbording;
import mobile.pages.onbording.LanguageSelectionPage;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.enums.Contour.BRANCHES;
import static mobile.enums.Language.RUSSIAN;

public class DebugTest extends BaseTest {

    @Test
    public void debug(){
        //Onbording.completeOnboarding();
        LanguageSelectionPage languageSelectionPage = new LanguageSelectionPage();
        languageSelectionPage
                .checkInitElements()
                .languageSelection()
                .tapButtonNext()
                .checkInitElements()
                //.selectEnvironment(BRANCHES)
                //.selectIsolatedBranch("16501-adapter")
                .quickOnboarding()
                .checkInitElements()
                .tapAcceptButton()
                .checkInitElements()
                .tapAcceptButton()
                .checkInitElements()
                .swipeToEndTutorial()
                .tapButtonClose()
                .checkInitElements()
                .openCalendar()
                .checkInitElements();

    }
}
