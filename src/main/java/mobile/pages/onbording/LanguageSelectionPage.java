package mobile.pages.onbording;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.enums.Language;
import mobile.utils.AppConfig;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static mobile.enums.Language.RUSSIAN;

public class LanguageSelectionPage {

    private final static SelenideAppiumElement
            title = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/continue_button")),
            buttonNext = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/continue_button"));

    @Step("Проверка элементов страницы выбора языка")
    public LanguageSelectionPage checkInitElements(){
        title.shouldBe(visible);
        buttonNext.shouldBe(visible);
        return this;
    }

    @Step("Выбор языка приложения")
    public LanguageSelectionPage languageSelection(Language language){
        $(AppiumBy.xpath("//android.widget.TextView[@text='"+ language.getLanguageMobile() + "']"))
                .shouldBe(visible)
                .click();
        return this;
    }
    @Step("Выбор русского языка")
    public LanguageSelectionPage languageSelection(){
        $(AppiumBy.xpath("//android.widget.TextView[@text='"+ RUSSIAN.getLanguageMobile() + "']"))
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Нажимаем на кнопку ПРОДОЛЖИТЬ и переходим к выбору контура")
    public EnvironmentSelectionPage tapButtonNext(){
        buttonNext
                .shouldBe(visible)
                .click();
        return new EnvironmentSelectionPage();
    }

    @Step("Проверяем что открыт экран выбора языка")
    public boolean isPageDisplayed(){
        return title.is(visible, Duration.ofSeconds(2));
    }

    public static String getTextTitle(){
        title.shouldBe(visible);
        return title.getText();
    }
}
