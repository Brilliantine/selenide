package mobile.pages.documentsPassenger;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ChooseDocumentPage extends BasePage {
    private final SelenideAppiumElement
            btnAddDoc = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/add_document_button"));

    @Step("Проверка начальных элементов экрана 'Выберите документ'")
    public ChooseDocumentPage checkInitElements(){
        btnAddDoc.shouldBe(visible);
        return this;
    }
}
