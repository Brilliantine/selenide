package mobile.pages.searchTrains;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.main.MainPage;
import mobile.utils.AppConfig;

import java.time.Duration;
import java.util.Date;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class SearchStationPage extends BasePage {

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
        inputSearch.clear();
        inputSearch.setValue(value);
        return this;
    }

    @Step("Выбрать станцию")
    public MainPage clickOnStation(String value){
        //Configuration.timeout = 10000;
        //Configuration.pollingInterval = 100;

        long startTime = System.currentTimeMillis();

        System.out.println("=== НАЧАЛО ПОИСКА СТАНЦИИ ===");
        System.out.println("Время: " + new Date());

        SelenideAppiumElement stationElement = $(byText(value));
        System.out.println("Элемент создан: " + (System.currentTimeMillis() - startTime) + "ms");

        boolean isVisible = stationElement.is(visible, Duration.ofSeconds(15));
        System.out.println("Проверка видимости завершена: " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("Элемент видим: " + isVisible);

        if(isVisible){
            System.out.println("Станция найдена, начинаем клик: " + (System.currentTimeMillis() - startTime) + "ms");
            stationElement.click();
            System.out.println("Клик выполнен: " + (System.currentTimeMillis() - startTime) + "ms");
        } else {
            System.out.println("Станция не найдена: " + (System.currentTimeMillis() - startTime) + "ms");
        }

        /*SelenideAppiumElement stationElement = $(byText(value));
        if(stationElement.is(visible, Duration.ofSeconds(5))){
            System.out.println("Станция найдена");
            stationElement.click();
        }else {
            System.out.println("Станция не найдена");
        }

        SelenideAppiumElement
                firstStation = $(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(8)")),
                exactMatch = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + value + "\")"));
                //exactMatch = $(AppiumBy.xpath("//android.widget.TextView[@resource-id='" +AppConfig.getInstance().getPathToElement() + ":id/tvTitle' and @text='" + value + "']"));
        firstStation
                .shouldBe(visible, Duration.ofSeconds(10));
        exactMatch
                .shouldBe(visible)
                .click();*/
        return new MainPage();
    }
}
