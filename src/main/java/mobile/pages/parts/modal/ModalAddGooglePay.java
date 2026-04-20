package mobile.pages.parts.modal;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ModalAddGooglePay {
    private final String MODAL_ADD_GOOGL_PAY = "Автоматически добавлять в Google Pay все билеты?";
    private final SelenideAppiumElement
            modalAddGooglePay = $(AppiumBy.xpath("//android.widget.TextView[@text='" + MODAL_ADD_GOOGL_PAY + "']")),
            btnYes = $(AppiumBy.id("android:id/button1")),
            btnNo = $(AppiumBy.id("android:id/button2")),
            btnNotSuggest =  $(AppiumBy.id("android:id/button3"));

    //Проверка отображения модального окна с предложением добавить билет в Google Pay
    public  boolean isModalAddGooglePayPresent(){
        return modalAddGooglePay.is(visible, Duration.ofSeconds(5));
    }
    public void clickBtnYes(){
        btnYes
                .shouldBe(visible)
                .click();
    }
    public void clickBtnNo(){
        btnNo
                .shouldBe(visible)
                .click();
    }
    public void clickBtnNotSuggest(){
        btnNotSuggest
                .shouldBe(visible)
                .click();
    }
    public void skipModalAddGooglePay(){
        if(isModalAddGooglePayPresent()){
            clickBtnNo();
        }
    }
}
