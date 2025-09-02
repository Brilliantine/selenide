package mobile.pages.onbording;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.alerts.AlertDialog;
import org.checkerframework.checker.units.qual.A;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AgreementPage {

    private final SelenideAppiumElement title =
            $(AppiumBy.id("ru.rzd.pass.debug:id/title_text_view"));
    private final SelenideAppiumElement acceptButton =
            $(AppiumBy.id("ru.rzd.pass.debug:id/accept_button"));
    private final SelenideAppiumElement declineButton =
            $(AppiumBy.id("ru.rzd.pass.debug:id/cancel_button"));

    @Step("Проверка элементов страницы лицензионного соглашения")
    public AgreementPage checkInitElements(){
        title.shouldBe(visible);
        acceptButton.shouldBe(visible);
        declineButton.shouldBe(visible);
        return this;
    }

    @Step("Отказ от лицензионного соглашения")
    public AlertDialog tapDeclineButton(){
        declineButton
                .click();
        return new AlertDialog();
    }

    @Step("Принятие лицензионного соглашения")
    public AgreementKasperskyPage tapAcceptButton(){
        acceptButton
                .click();
        return new AgreementKasperskyPage();
    }

}
