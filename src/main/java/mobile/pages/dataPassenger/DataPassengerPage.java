package mobile.pages.dataPassenger;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.passengers.PassengersPage;
import mobile.utils.AppConfig;

import java.time.Duration;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class DataPassengerPage extends BasePage {
    private final SelenideAppiumElement
            trainInfo = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/trainInfo")),
            direction = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/direction")),
            btnAddPassenger = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/fab")),
            btnNext = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/bookOrder")),
            btnEditTariff = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/edit_button")),
            fieldTariff = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"Тариф:\")")),
            noSelectTariff = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"Не выбран\")")),
            dropDownTariffs = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/spinner_layout")),
            btnSaveTariff = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/save_button")),
            tariffProgressLayout = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/layoutTariffProgress"));

    @Step("Проверка начальных элементов экрана 'Данные пассажиры'")
    public DataPassengerPage checkInitElements(){
        trainInfo.shouldBe(visible);
        direction.shouldBe(visible);
        btnAddPassenger.shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку 'Добавить пассажира'")
    public PassengersPage clickButtonAddPassenger(){
        btnAddPassenger
                .shouldBe(visible)
                .click();
        return new PassengersPage();
    }

    @Step("Нажать на кнопку 'Продолжить'")
    public void clickButtonNext(){
        btnNext
                .shouldBe(visible)
                .click();
    }

    @Step("Нажать на кнопку 'Изменить' у блока с тарифом")
    public DataPassengerPage clickButtonEditTariff(){
        btnEditTariff
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Проверка выбран ли тариф по умолчанию")
    public boolean checkNoSelectedTariff(){
        return noSelectTariff.is(visible);
    }

    @Step("Раскрыть список тарифов")
    public DataPassengerPage clickDropDownTariffs(){
        dropDownTariffs
                .shouldBe(visible)
                .click();
        return this;
    }

    //Раскрыть список тарифов
    public DataPassengerPage expandTariffList(){
        clickButtonEditTariff();
        clickDropDownTariffs();
        return this;
    }

    @Step("Выбрать тариф 'Полный'")
    public DataPassengerPage selectFullTariff(){
        $(AppiumBy.androidUIAutomator("new UiSelector().text(\"Полный\")"))
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Выбрать тариф '{tariffName}'")
    public DataPassengerPage selectTariff(String tariffName){
        $(AppiumBy.androidUIAutomator("new UiSelector().text(\""+tariffName+"\")"))
                .shouldBe(visible)
                .click();
        return this;
    }

    public DataPassengerPage selectFullTariffHelper(){
        if(checkNoSelectedTariff()){
            waitForTariffLoading();
            expandTariffList();
            //selectFullTariff();
        }
        try {
            selectFullTariff();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this;
    }

    public DataPassengerPage selectTariffHelper(String tariffName){
        waitForTariffLoading();
        expandTariffList();
        selectTariff(tariffName);
        return this;
    }

    @Step("Ожидаем загрузку тарифов")
    public void waitForTariffLoading(){
        if (tariffProgressLayout.is(visible, Duration.ofSeconds(10))){
            tariffProgressLayout.shouldBe(hidden, Duration.ofSeconds(30));
        }

    }
}
