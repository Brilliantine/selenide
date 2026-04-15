package mobile.pages.dataPassenger;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.passengers.PassengersPage;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class DataPassenger extends BasePage {
    private final SelenideAppiumElement
            trainInfo = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/train_info")),
            direction = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/direction")),
            btnAddPassenger = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/fab")),
            btnNext = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/bookOrder")),
            btnEditTariff = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/edit_button")),
            fieldTariff = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"Тариф:\")")),
            noSelectTariff = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"Не выбран\")")),
            dropDownTariffs = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/spinner_layout")),
            btnSaveTariff = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/save_button"));

    @Step("Проверка начальных элементов страницы 'Данные пассажиры'")
    public DataPassenger checkInitElements(){
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
    public DataPassenger clickButtonEditTariff(){
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
    public DataPassenger clickDropDownTariffs(){
        dropDownTariffs
                .shouldBe(visible)
                .click();
        return this;
    }

    //Раскрыть список тарифов
    public DataPassenger expandTariffList(){
        clickButtonEditTariff();
        clickDropDownTariffs();
        return this;
    }

    @Step("Выбрать тариф 'Полный'")
    public DataPassenger selectFullTariff(){
        $(AppiumBy.androidUIAutomator("new UiSelector().text(\"Полный\")"))
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Выбрать тариф '{tariffName}'")
    public DataPassenger selectTariff(String tariffName){
        $(AppiumBy.androidUIAutomator("new UiSelector().text(\""+tariffName+"\")"))
                .shouldBe(visible)
                .click();
        return this;
    }

    public DataPassenger selectFullTariffHelper(){
        if(checkNoSelectedTariff()){
            expandTariffList();
            selectFullTariff();
        }
        return this;
    }

    public DataPassenger selectTariffHelper(String tariffName){
        expandTariffList();
        selectTariff(tariffName);
        return this;
    }
}
