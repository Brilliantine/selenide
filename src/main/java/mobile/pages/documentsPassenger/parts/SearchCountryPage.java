package mobile.pages.documentsPassenger.parts;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class SearchCountryPage extends BasePage {
    private final SelenideAppiumElement
            fieldSearchCountry = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/search_src_text"));

    @Step("Проверка начальных элементов экрана поиска страны")
    public SearchCountryPage checkInitElements(){
        fieldSearchCountry.shouldBe(visible);
        return this;
    }
    @Step("Очистить поле ввода страны")
    public SearchCountryPage clearSearchCountry(){
        fieldSearchCountry.clear();
        return this;
    }
    @Step("Ввести в поле ввода страну: {country}")
    public SearchCountryPage setCountry(String country){
        fieldSearchCountry.setValue(country);
        return this;
    }
}
