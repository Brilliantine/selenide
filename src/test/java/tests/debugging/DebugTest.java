package tests.debugging;

import mobile.helper.LoginHelper;
import mobile.helper.Onbording;
import mobile.pages.main.MainPage;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class DebugTest extends BaseTest {

    @Test
    public void debug(){
        Onbording.completeOnboarding();
        MainPage mainPage = new MainPage();
        mainPage.isPageDisplayed();
        LoginHelper.authorization();
        mainPage
                .searchStationFromPage()
                .checkInitElements()
                .setStation("КАЗАНЬ")
                .castomClickOnStation("КАЗАНЬ")
                .searchStationWherePage()
                .setStation("МОСКВА")
                .castomClickOnStation("МОСКВА")
                .tapButtonSearchTrains();
        /*LanguageSelectionPage languageSelectionPage = new LanguageSelectionPage();
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
                .checkInitElements()
                //.selectDate(LocalDate.now().plusDays(5)),
                .selectDateFromToday(72)
                .clickContinue();*/

    }
}
