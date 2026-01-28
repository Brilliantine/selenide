package mobile.pages.searchTrains;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.main.MainPage;
import mobile.utils.AppConfig;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

public class SearchStationPage extends BasePage {

    private final SelenideAppiumElement
            inputSearch = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/search_src_text")),
            tabCitiesAndStation = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/first_type_view")),
            tapRoutes = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/second_type_view")),
            //stationList = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/list_switcher")),;
            stationList = $(AppiumBy.id("android:id/list")),
            progressBar = $(AppiumBy.className("android.widget.ProgressBar"));

    @Step("Проверка начальных элементов страницы")
    public SearchStationPage checkInitElements(){
        inputSearch.shouldBe(visible);
        tapRoutes.shouldBe(visible);
        tabCitiesAndStation.shouldBe(visible);
        return this;
    }

    @Step("Заполнить поле поиска: {value}")
    public SearchStationPage setStation(String value){
        inputSearch.clear();
        inputSearch.setValue(value);
        return this;
    }

    public boolean isPageDisplayed(){
        return tabCitiesAndStation.is(visible);
    }

    //Метод быстрый, НО требует подгонки по координатам
    @Step("Нажать на первую станцию в списке")
    public void tapOnStation(double width, double height){
        if (progressBar.exists()){
            progressBar.shouldNotBe(visible);
        }
        tapByCoordinates(width,height);
    }

    @Step("Нажать на станцию: {value}")
    public void clickOnStation (String value){
        By station = By.xpath("//android.widget.TextView[@resource-id='" +
                AppConfig.getInstance().getPathToElement() +
                ":id/tvTitle' and @text='" + value + "']");
        waitAndClick(station);
    }

    @Step("Нажимаем на первую станцию в списке")
    public void clickFirstStation(){
        SelenideAppiumElement station =
                $$(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/tvTitle"))
                        .shouldHave(sizeGreaterThan(0))
                        .first();
        station.tap();
    }

    //Методы clickOnStationMainPage и clickOnStationExtendedSearchPage долгие и уже не актуальны
    //Данный метод при тесте занимает около 1 минуты
    @Step("Нажать на станцию: {value}")
    public MainPage clickOnStationMainPage(String value){
        By station = By.xpath("//android.widget.TextView[@resource-id='" +
                AppConfig.getInstance().getPathToElement() +
                ":id/tvTitle' and @text='" + value + "']");
        waitAndClick(station);
        return new MainPage();
    }

    @Step("Нажать на станцию: {value}")
    public ExtendedSearchPage clickOnStationExtendedSearchPage(String value){
        By station = By.xpath("//android.widget.TextView[@resource-id='" +
                AppConfig.getInstance().getPathToElement() +
                ":id/tvTitle' and @text='" + value + "']");
        waitAndClick(station);
        return new ExtendedSearchPage();
    }
}
