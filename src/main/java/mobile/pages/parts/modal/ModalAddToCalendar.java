package mobile.pages.parts.modal;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ModalAddToCalendar {
    private final String MODAL_ADD_TO_CALENDAR = "Добавлять билеты в календарь после оплаты?";
    private final SelenideAppiumElement
            modalAddToCalendar = $(AppiumBy.xpath("//android.widget.TextView[@text='" + MODAL_ADD_TO_CALENDAR + "']")),
            btnYes = $(AppiumBy.id("android:id/button1")),
            btnNo = $(AppiumBy.id("android:id/button2")),
            btnNotSuggest = $(AppiumBy.id("android:id/button3"));

    //Проверка отображения модального окна по заголовку
    public boolean isModalAddToCalendarPresent() {
        return modalAddToCalendar.is(visible, Duration.ofSeconds(5));
    }
    //Нажать "ДА"
    public void clickBtnYes() {
        btnYes
                .shouldBe(visible)
                .click();
    }
    //Нажать "НЕТ"
    public void clickBtnNo() {
        btnNo
                .shouldBe(visible)
                .click();
    }
    //Нажать "НЕ ПРЕДЛАГАТЬ"
    public void clickBtnNotSuggest() {
        btnNotSuggest
                .shouldBe(visible)
                .click();
    }
    //Скип модалки
    public void skipModalAddToCalendar() {
        if(isModalAddToCalendarPresent()){
            clickBtnNo();
        }
    }

}
