package mobile.pages.searchTrains;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.main.MainPage;
import mobile.utils.AppConfig;
import org.openqa.selenium.By;

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

    //Вывод времени добавлял для отладки. При тесте данный метод занимает 2-3 минуты
    @Step("Выбрать станцию")
    public MainPage clickOnStation(String value){
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
        return new MainPage();
    }
}
