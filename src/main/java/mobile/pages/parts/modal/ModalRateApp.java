package mobile.pages.parts.modal;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ModalRateApp {
    private final String MODAL_RATE_APP = "Оцените приложение";
    private final SelenideAppiumElement
            modalRateApp = $(AppiumBy.xpath("//android.widget.TextView[@text='" + MODAL_RATE_APP + "']")),
            btnRate = $(AppiumBy.id("ru.rzd.pass.adapter.debug:id/positive_btn")),
            btnCancel = $(AppiumBy.id("ru.rzd.pass.adapter.debug:id/negative_btn"));

    //Проверка отображения модального окна с оценкой
    public  boolean isModalRateAppPresent(){
        return modalRateApp.is(visible, Duration.ofSeconds(5));
    }
    public void clickBtnRate(){
        btnRate
                .shouldBe(visible)
                .click();
    }
    public void clickBtnCancel(){
        btnCancel
                .shouldBe(visible)
                .click();
    }
    public void skipModalRateApp(){
        if(isModalRateAppPresent()){
            clickBtnCancel();
        }
    }
}
