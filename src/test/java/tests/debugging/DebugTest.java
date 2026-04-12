package tests.debugging;

import mobile.helper.LoginHelper;
import mobile.helper.Onbording;
import mobile.helper.badAuthorization.BadAuthorization;
import mobile.pages.dataPassenger.DataPassenger;
import mobile.pages.documentsPassenger.ChooseDocumentPage;
import mobile.pages.getReceipt.GetReceiptPage;
import mobile.pages.main.MainPage;
import mobile.pages.parts.Progressbar;
import mobile.pages.passengers.parts.AddingPassengerPage;
import mobile.pages.schedule.SchedulePage;
import mobile.pages.searchTrains.ExtendedSearchPage;
import mobile.pages.train.TrainPage;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class DebugTest extends BaseTest {

    @Test
    public void debug(){
        Onbording.completeOnboarding();
        //LoginHelper.authorization();

        BadAuthorization badAuthorization = new BadAuthorization();
        badAuthorization.authorizationBad();
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
                .tapOnStation(0.5,0.21);
        new ExtendedSearchPage()
                .searchStationWhere()
                .setStation("САНКТ-ПЕТЕРБУРГ")
                .tapOnStation(0.5,0.21);
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
                .selectCarriage("02")
                .checkInitElements()
                .clickButtonContinue();
        new DataPassenger()
                .checkInitElements()
                .clickButtonAddPassenger()
                .checkInitElements()
                .clickBtnAddNewPassenger()
                .checkInitElements()
                .fillDataFromProfile()
                .setBirthday("08071996")
                .selectGender("Мужской")
                .addDocument()
                .checkInitElements()
                .setNumberDocument("8816999999")
                .clickBtnSave();
        new AddingPassengerPage()
                .clickBtnSave();
        new DataPassenger()
                .clickButtonNext();
        new GetReceiptPage()
                .checkInitElements()
                .clickBtnNext();
        Progressbar.waitLoading();



    }
}
