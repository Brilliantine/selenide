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
            btnNext = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/continueButton"));

    @Step("Проверка начальных элементов экрана 'Получение чека'")
    public GetReceiptPage checkInitElements(){
        emailField.shouldBe(visible);
        phoneField.shouldBe(visible);
        btnNext.shouldBe(visible);
        return this;
    }
}
