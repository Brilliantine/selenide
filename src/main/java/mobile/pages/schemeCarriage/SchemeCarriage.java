package mobile.pages.schemeCarriage;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class SchemeCarriage extends BasePage {
    private final SelenideAppiumElement
            toolbar = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/toolbar")),
            btnContinue = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/btnContinue")),
            btnZoom = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/zoom_button")),
            btnBack = $(AppiumBy.accessibilityId("Перейти назад"));

    @Step("Проверка начальных элементов страницы 'Схема вагона'")
    public SchemeCarriage checkInitElements(){
        btnContinue.shouldBe(visible);
        btnZoom.shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку 'ПРОДОЛЖИТЬ'")
    public void clickButtonContinue(){
        btnContinue
                .shouldBe(visible)
                .click();
    }
}
