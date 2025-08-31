package mobile.pages.alerts;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import mobile.pages.onbording.AgreementPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

//Диалоговое окно при отказе от лицензионного соглашения
public class AlertDialog {

    private final SelenideAppiumElement message =
            $(AppiumBy.id("android:id/message"));
    private final SelenideAppiumElement yes =
            $(AppiumBy.id("android:id/button1"));
    private final SelenideAppiumElement no =
            $(AppiumBy.id("android:id/button2"));

    //Получение текста диалогового окна
    public String getDialogMessageWithWait(){
        return message.shouldBe(visible).getText();
    }

    public void tapButtonYes(){
        yes
                .shouldBe(visible)
                .click();
    }

    public AgreementPage tapButtonNo(){
        no
                .shouldBe(visible)
                .click();
        return new AgreementPage();
    }
}
