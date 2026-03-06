package mobile.pages.onbording;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.enums.Branches;
import mobile.enums.Contour;
import mobile.pages.base.BasePage;
import mobile.utils.AppConfig;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class EnvironmentSelectionPage extends BasePage {
    /*private final static SelenideAppiumElement title = $(AppiumBy.id("ru.rzd.pass.debug:id/title"));
    private final SelenideAppiumElement changeContour = $(AppiumBy.id("ru.rzd.pass.debug:id/apply_host"));
    private final SelenideAppiumElement buttonNext = $(AppiumBy.id("ru.rzd.pass.debug:id/continue_button"));*/
    private final static SelenideAppiumElement
            title = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/title")),
            changeContour = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/apply_host")),
            buttonNext = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/continue_button"));

    @Step("Проверка элементов страницы выбора контура")
    public EnvironmentSelectionPage checkInitElements(){
        title.shouldBe(visible);
        //changeContour.shouldBe(visible);
        //buttonNext.shouldBe(visible);
        return this;
    }

    @Step("Выбор контура")
    public EnvironmentSelectionPage selectEnvironment(Contour contour){
        //$(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/tvGroupName\" and @text='" + contour.getContour() + "']"))
        $(AppiumBy.xpath("//android.widget.TextView[@text='" + contour.getContour() + "']"))
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Выбор ветки")
    public EnvironmentSelectionPage selectBranch(Branches branch){
        $(AppiumBy.xpath("//android.widget.RadioButton[@text='"+ branch.getBranch() +"']"))
                .scrollTo()
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Выбор изолированной ветки")
    public EnvironmentSelectionPage selectIsolatedBranch(String branch){
        $(byText(branch))
                .scrollTo()
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Автоматический выбор окружения")
    public EnvironmentSelectionPage selectAutoEnvironment(){
        AppConfig config = AppConfig.getInstance();

        //Автоматически получаем контур и ветку для текущей сборки
        Contour autoContour = config.getAutoContour();
        Branches autoBranch = config.getAutoBranch();

        if(autoContour != null){
            selectEnvironment(autoContour);
        }

        if(autoBranch != null){
            selectBranch(autoBranch);
        }

        return this;
    }

    @Step("Скролим и нажимаем кноопку ПОМЕНЯТЬ КОНТУР")
    public EnvironmentSelectionPage tapChangeContour(){
        changeContour
                .scrollTo();
        //shortScroll();
        changeContour.click();
        return this;
    }
    @Step("Нажимаем на кнопку ПРОДОЛЖИТЬ и переходим к пользовательскому соглашению")
    public AgreementPage tapButtonNext(){
        buttonNext
                .shouldBe(visible)
                .click();
        return new AgreementPage();
    }

    @Step("Быстрое прохождение онбординга")
    public AgreementPage quickOnboarding(){
        selectAutoEnvironment();
        tapChangeContour();
        tapButtonNext();
        return new AgreementPage();
    }

    @Step("Проверяем что открыт экран выбора контура")
    public boolean isPageDisplayed(){
        return title.is(visible,Duration.ofSeconds(2));
    }

    public static String getTextTitle(){
        title.shouldBe(visible);
        return title.getText();
    }

}
