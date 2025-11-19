package mobile.pages.onbording;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.utils.AppConfig;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AgreementKasperskyPage {

    /*private final SelenideAppiumElement title =
            $(AppiumBy.id("ru.rzd.pass.debug:id/title_text_view"));
    private final SelenideAppiumElement acceptButton =
            $(AppiumBy.id("ru.rzd.pass.debug:id/accept_button"));
    private final SelenideAppiumElement declineButton =
            $(AppiumBy.id("ru.rzd.pass.debug:id/cancel_button"));*/
    private final SelenideAppiumElement
            title = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/title_text_view")),
            acceptButton = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/accept_button")),
            declineButton = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/cancel_button"));

    @Step("Проверка элементов экрана касперского")
    public AgreementKasperskyPage checkInitElements(){
        acceptButton.shouldBe(visible);
        declineButton.shouldBe(visible);
        return this;
    }

    @Step("Приниммаем соглашение касперского и переходим к туториалу")
    public TutorialPage clickAcceptButton(){
        acceptButton
                .shouldBe(visible)
                .click();
        return new TutorialPage();
    }

    @Step("Не принимаем соглашение касперского")
    public TutorialPage clickDeclineButton(){
        declineButton
                .shouldBe(visible)
                .click();
        return new TutorialPage();
    }

    @Step("Проверяем что находимся на экране касперского")
    public boolean isPageDisplayed(){
        return acceptButton.is(visible, Duration.ofSeconds(2));
    }
}
