package mobile.pages.getReceipt;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.dataPassenger.DataPassenger;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class GetReceiptPage extends BasePage {
    private final SelenideAppiumElement
            toolbar = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/toolbar")),
            emailField = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/emailEditText")),
            phoneField = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/phoneEditText")),
            btnNext = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/continueButton")),
            radioBtnEmail = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/emailCheckImage")),
            radioBtnPhone = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/phoneCheckImage"));

    @Step("Проверка начальных элементов экрана 'Получение чека'")
    public GetReceiptPage checkInitElements(){
        emailField.shouldBe(visible);
        phoneField.shouldBe(visible);
        btnNext.shouldBe(visible);
        return this;
    }

    @Step("Проверяем что находимся на 'Получение чека'")
    public boolean isPageDisplayed(){
        return emailField.is(visible) && phoneField.is(visible);
    }

    @Step("Нажать на кнопку Продолжить")
    public void clickBtnNext(){
        btnNext
                .shouldBe(visible)
                .click();
    }

    @Step("Выбрать почту")
    public GetReceiptPage selectEmail(){
        radioBtnEmail
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Выбрать СМС")
    public GetReceiptPage selectSMS(){
        radioBtnPhone
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Изменить почту")
    public GetReceiptPage changeEmail(String email){
        emailField
                .shouldBe(visible)
                .click();
        emailField.clear();
        emailField.setValue(email);
        return this;
    }

    @Step("Изменить номер телефона")
    public GetReceiptPage changeNumberPhone(String phone){
        phoneField
                .shouldBe(visible)
                .click();
        phoneField.clear();
        phoneField.setValue(phone);
        return this;
    }


}
