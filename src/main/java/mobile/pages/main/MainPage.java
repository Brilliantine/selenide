package mobile.pages.main;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.calendar.CalendarPage;
import mobile.pages.login.LoginPage;
import mobile.pages.searchTrains.SearchStationPage;
import mobile.utils.AppConfig;

public class MainPage extends BasePage {

    private final SelenideAppiumElement
            buttonSideMenu = $(AppiumBy.accessibilityId("Левое боковое меню")),
            //buttonLogin = $(AppiumBy.id("ru.rzd.pass.debug:id/sign_in_text_view")),
            buttonLogin = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/sign_in_text_view")),
            buttonBasket = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/cart")),
            buttonExtendedSearch = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/extended_search")),
            //fieldFrom = $(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"ru.rzd.pass.debug:id/text_view_station\"])[1]")),
            //fieldWhere = $(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"ru.rzd.pass.debug:id/text_view_station\"])[2]")),
            fieldFrom = $(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"" + AppConfig.getInstance().getPathToElement() + ":id/text_view_station\"])[1]")),
            fieldWhere = $(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"" + AppConfig.getInstance().getPathToElement() + ":id/text_view_station\"])[2]")),
            buttonSearchTrains = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/search_button")),
            thereDateHeader =$(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/there_date_header")),
            //selectDate = $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/day\"]"));
            selectDate = $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"" + AppConfig.getInstance().getPathToElement() + ":id/day\"]"));

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
    public MainPage tapButtonSideMenu(){
        buttonSideMenu.click();
        return this;
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

    @Step("Проверка успешной авторизации")
    public MainPage checkUserIsLoggedIn(){
        buttonLogin.shouldNotBe(visible);
        return this;
    }
}
