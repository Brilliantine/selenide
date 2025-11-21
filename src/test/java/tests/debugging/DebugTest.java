package tests.debugging;

import mobile.helper.LoginHelper;
import mobile.helper.Onbording;
import mobile.pages.main.MainPage;
import mobile.pages.parts.Progressbar;
import mobile.pages.schedule.SchedulePage;
import mobile.pages.searchTrains.ExtendedSearchPage;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class DebugTest extends BaseTest {

    @Test
    public void debug(){
        Onbording.completeOnboarding();
        MainPage mainPage = new MainPage();
        mainPage.isPageDisplayed();
        /*mainPage
                .clickButtonExtendedSearch()
                .checkInitElements()
                .selectConnection()
                .selectCarrier("ДОСС")
                .selectTrainBrand("Фирменный");*/
        mainPage
                .clickButtonExtendedSearch()
                .checkInitElements()
                .searchStationFrom()
                .setStation("МОС")
                .clickOnStationExtendedSearchPage("МОСКВА")
                .searchStationWhere()
                .setStation("САНКТ")
                .clickOnStationExtendedSearchPage("САНКТ-ПЕТЕРБУРГ")
                .clickFromDate()
                .checkInitElements()
                .selectDateFromToday(3)
                .clickContinue();
        new ExtendedSearchPage()
                .selectTicketsOnly()
                .selectCarrier("ДОСС")
                .selectTrainBrand("Сапсан")
                .clickButtonSearchTrains();
        Progressbar.waitLoading();
        new SchedulePage()
                .checkInitElements();
        //LoginHelper.authorization();
        /*mainPage
                .searchStationFromPage()
                .checkInitElements()
                .setStation("КАЗАНЬ")
                .castomClickOnStation("КАЗАНЬ")
                .searchStationWherePage()
                .setStation("МОСКВА")
                .castomClickOnStation("МОСКВА")
                .tapButtonSearchTrains();*/
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
