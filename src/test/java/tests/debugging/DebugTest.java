package tests.debugging;

import io.qameta.allure.*;
import mobile.helper.Onbording;
import mobile.helper.badAuthorization.BadAuthorization;
import mobile.pages.basket.BasketPage;
import mobile.pages.dataPassenger.DataPassenger;
import mobile.pages.getReceipt.GetReceiptPage;
import mobile.pages.main.MainPage;
import mobile.pages.parts.Progressbar;
import mobile.pages.parts.modal.ModalAttention;
import mobile.pages.parts.modal.ModalInsurance;
import mobile.pages.passengers.parts.AddingPassengerPage;
import mobile.pages.pay.PayPage;
import mobile.pages.pay.paymentMethod.PaymentMethodPage;
import mobile.pages.schedule.SchedulePage;
import mobile.pages.searchTrains.ExtendedSearchPage;
import mobile.pages.train.TrainPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

@Epic("Клиент")
@Feature("Покупка билета ДС")
public class DebugTest extends BaseTest {

    @Test
    @Story("Покупка билета МСК - СПБ")
    @Description("Проверяем покупку билета")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("debug")
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
        extendedSearchPage
                .searchStationWhere()
                .setStation("САНКТ-ПЕТЕРБУРГ")
                .tapOnStation(0.5,0.21);
        extendedSearchPage
                .clickButtonSearchTrains();
        Progressbar.waitLoading();
        SchedulePage schedulePage = new SchedulePage()
                .closeCardList();
        Progressbar.waitLoading();
        schedulePage
                .checkInitElements()
                .selectTrain("016А");
        TrainPage trainPage = new TrainPage();
        trainPage
                .checkInitElements()
                .selectCarriage("01")
                .checkInitElements()
                .clickButtonContinue();
        DataPassenger dataPassenger = new DataPassenger();
        dataPassenger
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
        AddingPassengerPage addingPassengerPage = new AddingPassengerPage();
        addingPassengerPage
                .clickBtnSave();
        dataPassenger
                .selectFullTariffHelper()
                .clickButtonNext();
        GetReceiptPage getReceiptPage = new GetReceiptPage();
        getReceiptPage
                .checkInitElements()
                .clickBtnNext();
        Progressbar.waitLoading(120);
        BasketPage basketPage = new BasketPage();
        basketPage
                .clickButtonPay();
        ModalInsurance modalInsurance = new ModalInsurance();
        modalInsurance
                .skipModalInsurance();
        ModalAttention modalAttention = new ModalAttention();
        modalAttention
                .skipModalAttention();
        PaymentMethodPage paymentMethodPage = new PaymentMethodPage();
        paymentMethodPage
                .checkInitElements()
                .selectCard()
                .clickButtonPay();
        Progressbar.waitLoading();
        PayPage payPage = new PayPage();
        Progressbar.waitLoading();
        payPage
                .checkInitElements()
                .setNumberCard("4058889915002926")
                .setExpirationDate("1227")
                .setCVV("415")
                .clickButtonPay();
        basketPage
                .checkSuccessBought();



    }
}
