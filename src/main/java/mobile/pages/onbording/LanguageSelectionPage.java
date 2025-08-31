package mobile.pages.onbording;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.enums.Language;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
public class LanguageSelectionPage {

    private final SelenideAppiumElement title = $(AppiumBy.id("ru.rzd.pass.debug:id/title"));
    private final SelenideAppiumElement buttonNext = $(AppiumBy.id("ru.rzd.pass.debug:id/continue_button"));

    @Step("Проверка элементов страницы выбора языка")
    public LanguageSelectionPage checkInitElements(){
        title.shouldBe(visible);
        buttonNext.shouldBe(visible);
        return this;
    }

    @Step("Выбираем язык приложения")
    public LanguageSelectionPage languageSelection(Language language){
        $(AppiumBy.xpath("//android.widget.TextView[@resource-id='ru.rzd.pass.debug:id/name' and @text='"+ language.getLanguageMobile() + "']"))
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Нажимаем на кнопку ПРОДОЛЖИТЬ")
    public EnvironmentSelectionPage tapButtonNext(){
        buttonNext
                .shouldBe(visible)
                .click();
        return new EnvironmentSelectionPage();
    }
}
