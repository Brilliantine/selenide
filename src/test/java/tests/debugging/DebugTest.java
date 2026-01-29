package tests.debugging;

import mobile.helper.LoginHelper;
import mobile.helper.Onbording;
import mobile.pages.main.MainPage;
import mobile.pages.parts.Progressbar;
import mobile.pages.schedule.SchedulePage;
import mobile.pages.searchTrains.ExtendedSearchPage;
import mobile.pages.train.TrainPage;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class DebugTest extends BaseTest {

    @Test
    public void debug(){
        Onbording.completeOnboarding();
        LoginHelper.authorization();
        MainPage mainPage = new MainPage();
        mainPage.isPageDisplayed();
        mainPage
                .clickButtonExtendedSearch()
                .checkInitElements()
                .clickFromDate()
                .checkInitElements()
                .selectDateFromToday(3)
                .clickContinue();
        ExtendedSearchPage extendedSearchPage = new ExtendedSearchPage();
        extendedSearchPage
                .searchStationFrom()
                .setStation("МОСКВА")
                .tapOnStation(0.5,0.25);
        new ExtendedSearchPage()
                .searchStationWhere()
                .setStation("САНКТ")
                .tapOnStation(0.5,0.25);
        new ExtendedSearchPage()
                .clickButtonSearchTrains();
        Progressbar.waitLoading();
        SchedulePage schedulePage = new SchedulePage()
                .closeCardList();
        Progressbar.waitLoading();
        schedulePage
                .checkInitElements()
                .selectTrain("016А");
        new TrainPage()
                .checkInitElements()
                .selectCarriage("05")
                .checkInitElements();



    }
}
