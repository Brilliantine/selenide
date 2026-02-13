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
            btnEditDataTrip = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/edit_button")),
            tariffField = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/tariff_spinner")),
            btnNext = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/bookOrder")),
            insurancePopup = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/parentPanel")),
            btnInsuranceYes = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/button1")),
            btnInsuranceNo = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/button2"));

    @Step("Проверка начальных элементов экрана 'Данные пассажиров'")
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

    @Step("Нажать на кнопку 'Изменить' у блока с выбором тарифа")
    public DataPassenger clickBtnEditDataTrip(){
        btnEditDataTrip
                .scrollTo()
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Проверяем что тариф не выбран")
    public boolean checkTariffIsEmpty(){
        String tariff =  tariffField.getText();
        return tariff.equals("Тариф: не выбран");
    }

    @Step("Нажать на поле 'Тариф'")
    public DataPassenger clickTariff(){
        tariffField
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Выбрать тариф '{value}'")
    public DataPassenger chooseTariff(String value){
        $(AppiumBy.accessibilityId(value))
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Выбрать тариф 'Полный'")
    public DataPassenger chooseFullTariff(){
        $(AppiumBy.accessibilityId("Полный"))
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Нажать на кнопку 'Сохранить' в блоке выбора тарифа")
    public DataPassenger clickBtnSave(){
        $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/add_layout"))
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Нажать на кнопку 'Продолжить'")
    public void clickBtnNext(){
        btnNext
                .shouldBe(visible)
                .click();
    }

    @Step("Проверяем что всплывающее окно со страховкой появилось")
    public boolean isInsurancePopupDisplayed(){
        try {
            return  insurancePopup.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }

    @Step("Оформить страховой полис: {needInsurance}")
    public void chooseInsurance(boolean needInsurance){
        if(!isInsurancePopupDisplayed()){
            return;
        }
        if(needInsurance){
            btnInsuranceYes
                    .shouldBe(visible)
                    .click();
        }
        else {
            btnInsuranceNo
                    .shouldBe(visible)
                    .click();
        }
    }
}
