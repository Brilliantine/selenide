package mobile.pages.basket;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.parts.Progressbar;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class BasketPage {
    private final SelenideAppiumElement
            title = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"Корзина\")")),
            btnTickets = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/tickets")),
            blankText = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/textView4")),
            btnPay = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/pay_button")),
            btnRetry = $(AppiumBy.id(AppConfig.getInstance().getAppPackage()+":id/retry_button"));

    @Step("Проверка начальных элементов экрана 'Корзина'")
    public BasketPage checkInitElements(){
        title.shouldBe(visible);
        btnTickets.shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку 'Купить'")
    public void clickButtonPay(){
        btnPay
                .shouldBe(visible)
                .click();
    }

    @Step("Проверка успешной покупки билета")
    public BasketPage checkSuccessBought(){
        Progressbar.waitLoading(120);
        String MODAL_ADD_TO_CALENDAR = "Добавлять билеты в календарь после оплаты?";
        $(AppiumBy.xpath("//android.widget.TextView[@text='" + MODAL_ADD_TO_CALENDAR + "']"))
                .shouldBe(visible);
        return this;
    }
}
