package mobile.pages.main;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.login.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class MainPage {

    private final SelenideAppiumElement
            buttonSideMenu = $(AppiumBy.accessibilityId("Левое боковое меню")),
            buttonLogin = $(AppiumBy.id("ru.rzd.pass.debug:id/sign_in_text_view")),
            buttonBasket = $(AppiumBy.id("ru.rzd.pass.debug:id/cart")),
            buttonExtendedSearch = $(AppiumBy.id("ru.rzd.pass.debug:id/extended_search")),
            fieldFrom = $(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"ru.rzd.pass.debug:id/text_view_station\"])[1]")),
            fieldWhere = $(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"ru.rzd.pass.debug:id/text_view_station\"])[2]")),
            buttonSearchTrains = $(AppiumBy.id("ru.rzd.pass.debug:id/search_button")),
            thereDateHeader =$(AppiumBy.id("ru.rzd.pass.debug:id/there_date_header"));

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
}
