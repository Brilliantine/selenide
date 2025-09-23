package mobile.pages.main;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.calendar.CalendarPage;
import mobile.pages.login.LoginPage;
import mobile.pages.searchTrains.SearchStationPage;

public class MainPage {

    private final SelenideAppiumElement
            buttonSideMenu = $(AppiumBy.accessibilityId("Левое боковое меню")),
            buttonLogin = $(AppiumBy.id("ru.rzd.pass.debug:id/sign_in_text_view")),
            buttonBasket = $(AppiumBy.id("ru.rzd.pass.debug:id/cart")),
            buttonExtendedSearch = $(AppiumBy.id("ru.rzd.pass.debug:id/extended_search")),
            fieldFrom = $(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"ru.rzd.pass.debug:id/text_view_station\"])[1]")),
            fieldWhere = $(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"ru.rzd.pass.debug:id/text_view_station\"])[2]")),
            buttonSearchTrains = $(AppiumBy.id("ru.rzd.pass.debug:id/search_button")),
            thereDateHeader =$(AppiumBy.id("ru.rzd.pass.debug:id/there_date_header")),
            selectDate = $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/day\"]"));

    @Step("Проверка начальных элементов главной страницы")
    public MainPage checkInitElements(){
        buttonSideMenu.shouldBe(visible);
        buttonBasket.shouldBe(visible);
        buttonExtendedSearch.shouldBe(visible);
        fieldFrom.shouldBe(visible);
        fieldWhere.shouldBe(visible);
        buttonSearchTrains.shouldBe(visible);
        return this;
    }
    @Step("Открыть левое боковое меню")
    public SideMenuPage tapButtonSideMenu(){
        buttonSideMenu.click();
        return new SideMenuPage();
    }

    @Step("Нажать на кнопку Войти")
    public LoginPage tapButtonLogin(){
        buttonLogin.shouldBe(visible).click();
        return new LoginPage();
    }

    @Step("Перейти в календарь")
    public CalendarPage openCalendar(){
        selectDate.shouldBe(visible).click();
        return new CalendarPage();
    }

    @Step("Перейти к поиску станции отправления")
    public SearchStationPage searchStationFromPage(){
        fieldFrom.click();
        return new SearchStationPage();
    }

    @Step("Перейти к поиску станции назначения")
    public SearchStationPage searchStationWherePage(){
        fieldWhere.click();
        return new SearchStationPage();
    }
}
