package mobile.pages.searchTrains;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.main.MainPage;
import mobile.utils.AppConfig;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class SearchStationPage {

    private final SelenideAppiumElement
            inputSearch = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/search_src_text")),
            tabCitiesAndStation = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/first_type_view")),
            tapRoutes = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/second_type_view"));

    @Step("Проверка начальных элементов страницы")
    public SearchStationPage checkInitElements(){
        inputSearch.shouldBe(visible);
        tapRoutes.shouldBe(visible);
        tabCitiesAndStation.shouldBe(visible);
        return this;
    }

    @Step("Заполнить поле поиска: {value}")
    public SearchStationPage setStation(String value){
        inputSearch.setValue(value);
        return this;
    }

    @Step("Выбрать станцию: {value}")
    public MainPage clickOnElement (String value){
        if($(AppiumBy.xpath("//android.widget.TextView[contains(@resource-id,'id/tvTitle') and @text='" + value + "']")).is(visible)){
            $(AppiumBy.xpath("//android.widget.TextView[contains(@resource-id,'id/tvTitle') and @text='" + value + "']")).click();
        }
        else{
            $(AppiumBy.xpath("//android.widget.TextView[contains(@resource-id,'id/tvTitle') and @text='" + value + "']"))
                    .scrollTo()
                    .shouldBe(visible)
                    .click();
        }
        inputSearch.shouldNotBe(visible);
        return new MainPage();
    }
}
