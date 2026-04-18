package mobile.pages.parts.modal;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import mobile.pages.base.BasePage;
import mobile.utils.AppConfig;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ModalInsurance extends BasePage {
    private final SelenideAppiumElement
            modalInsurance = $(AppiumBy.id("android:id/message")),
            btnNoInsurance = $(AppiumBy.id("android:id/button1")),
            btnYesInsurance = $(AppiumBy.id("android:id/button2"));

    //Проверка отображения модального окна с предложением оформить страховку
    public boolean isModalInsurancePresent()
    {
        //return modalInsurance.isDisplayed();
        return modalInsurance.is(visible, Duration.ofSeconds(5));
    }

    public void clickYesButton()
    {
        btnYesInsurance
                .shouldBe(visible)
                .click();
    }

    public void clickNoButton(){
        btnNoInsurance
                .shouldBe(visible)
                .click();
    }

    public void skipModalInsurance()
    {
        if(isModalInsurancePresent())
        {
            clickNoButton();
            System.out.println("Скипнули страховку");
        }else {
            System.out.println("Не скипнули страховку");
        }
    }
}
