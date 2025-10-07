package mobile.pages.onbording;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.enums.BranchesCommon;
import mobile.enums.Contour;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class EnvironmentSelectionPage {
    private final static SelenideAppiumElement title = $(AppiumBy.id("ru.rzd.pass.debug:id/title"));
    private final SelenideAppiumElement changeContour = $(AppiumBy.id("ru.rzd.pass.debug:id/apply_host"));
    private final SelenideAppiumElement buttonNext = $(AppiumBy.id("ru.rzd.pass.debug:id/continue_button"));

    @Step("Проверка элементов страницы выбора контура")
    public EnvironmentSelectionPage checkInitElements(){
        title.shouldBe(visible);
        //changeContour.shouldBe(visible);
        //buttonNext.shouldBe(visible);
        return this;
    }

    @Step("Выбор контура")
    public EnvironmentSelectionPage selectEnvironment(Contour contour){
        $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/tvGroupName\" and @text='" + contour.getContour() + "']"))
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Выбор ветки")
    public EnvironmentSelectionPage selectBranch(BranchesCommon branch){
        $(AppiumBy.xpath("//android.widget.RadioButton[@text='"+ branch.getBranch() +"']"))
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Скролим и нажимаем кноопку ПОМЕНЯТЬ КОНТУР")
    public EnvironmentSelectionPage tapChangeContour(){
        changeContour
                .scrollTo()
                .click();
        return this;
    }
    @Step("Нажимаем на кнопку ПРОДОЛЖИТЬ и переходим к пользовательскому соглашению")
    public AgreementPage tapButtonNext(){
        buttonNext
                .shouldBe(visible)
                .click();
        return new AgreementPage();
    }

    public static String getTextTitle(){
        title.shouldBe(visible);
        return title.getText();
    }

}
