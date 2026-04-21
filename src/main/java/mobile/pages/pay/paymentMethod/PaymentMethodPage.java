package mobile.pages.pay.paymentMethod;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class PaymentMethodPage extends BasePage {
    private final SelenideAppiumElement
            title = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"Способ оплаты\")")),
            card = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"Банковская карта\")")),
            sbp = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"Система быстрых платежей\")")),
            mirPay = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"MirPay\")")),
            btnPay = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/btnContinue"));

    @Step("Проверка начальных элементов экрана 'Способ оплаты'")
    public PaymentMethodPage checkInitElements(){
        title.shouldBe(visible);
        btnPay.shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку 'Оплатить'")
    public void clickButtonPay(){
        btnPay
                .shouldBe(visible)
                .click();
    }

    @Step("Выбрать способ оплаты: банковской картой")
    public PaymentMethodPage selectCard(){
        card
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Выбрать способ оплаты: СБП")
    public PaymentMethodPage selectSBP(){
        sbp
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Выбрать способ оплаты: МирПэй")
    public PaymentMethodPage selectMirPay(){
        mirPay
                .shouldBe(visible)
                .click();
        return this;
    }
}
