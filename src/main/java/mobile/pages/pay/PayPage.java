package mobile.pages.pay;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class PayPage extends BasePage {
    private final SelenideAppiumElement
            title = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"Оплата\")")),
            btnPay = $(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"OK\")")),
            fieldNumberCard = $(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"cp-pan-decor\")")),
            fieldExpirationDate = $(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"cc-exp-month\")")),
            fieldCVV = $(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"cvv2\")")),
            btnBack = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"← Вернуться в магазин\")"));

    @Step("Проверка начальных элементов экрана 'Оплата'")
    public PayPage checkInitElements(){
        title.shouldBe(visible);
        btnPay.shouldBe(visible);
        fieldNumberCard.shouldBe(visible);
        fieldExpirationDate.shouldBe(visible);
        fieldCVV.shouldBe(visible);
        return this;
    }

    @Step("Нажать кнопку 'Оплатить'")
    public void clickButtonPay(){
        btnPay.click();
    }
}
