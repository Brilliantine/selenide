package mobile.pages.parts.modal;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ModalAttention {
    private final String
            MODAL_ATTENTION = "Внимание!",
            BUTTON_CONTINUE_TEXT = "ВСЁ РАВНО ПРОДОЛЖИТЬ",
            BUTTON_VIEW_TICKETS_TEXT = "ПОСМОТРЕТЬ БИЛЕТЫ",
            BUTTON_CANCEL_TEXT = "ОТМЕНА";
    private final SelenideAppiumElement
            modalAttention = $(AppiumBy.xpath("//android.widget.TextView[@text='" + MODAL_ATTENTION + "']")),
            btnContinue = $(AppiumBy.id("android:id/button1")),
            btnViewTickets = $(AppiumBy.id("android:id/button2")),
            btnCancel = $(AppiumBy.id("android:id/button3"));

    //Проверка отображения модального окна по заголовку
    public boolean isModalAttentionPresent() {
        return modalAttention.is(visible, Duration.ofSeconds(5));
    }
    // Нажать "ВСЁ РАВНО ПРОДОЛЖИТЬ"
    public void clickContinue() {
        btnContinue.shouldBe(visible).click();
    }
    // Нажать "ПОСМОТРЕТЬ БИЛЕТЫ"
    public void clickViewTickets() {
        btnViewTickets.shouldBe(visible).click();
    }
    // Нажать "ОТМЕНА"
    public void clickCancel() {
        btnCancel.shouldBe(visible).click();
    }
    //Пропускаем все модалки
    public void skipModalAttention() {
        while (isModalAttentionPresent()) {
            clickContinue();
        }
    }
}
