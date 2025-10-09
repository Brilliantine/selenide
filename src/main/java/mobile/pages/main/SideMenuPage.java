package mobile.pages.main;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;
import mobile.pages.base.BasePage;
import mobile.pages.passengers.PassengersPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class SideMenuPage extends BasePage {

    private final SelenideAppiumElement sideMenu =
            $(AppiumBy.id("ru.rzd.pass.debug:id/list"));
    private final SelenideAppiumElement buttonLogin =
            $(AppiumBy.id("ru.rzd.pass.debug:id/sign_in_out_button"));

    @AllArgsConstructor
    public enum MenuItem{
        BUY_TICKETS("Купить билет"),
        TICKETS("Мои билеты"),
        PASSENGERS("Пассажиры"),
        ONLINE("Онлайн-табло"),
        PASSENGERS_WITH_LIMITED_MOBILITY("Маломобильным пассажирам"),
        TRAIN_STATIONS("Навигация по вокзалам"),
        TRAVEL_WITH_RZD("Путешествуй с РЖД"),
        CARDS("Карты"),
        PROMOTIONS("Акции и спецпредложения"),
        ACTUAL_MOVEMENT("Фактическое движение"),
        FAVOURITES("Избранное"),
        ALERTS("Оповещения"),
        FREQUENT_QUESTIONS("Частые вопросы"),
        NEWS("Новости и пресса"),
        OPENINGS_RZD("Вакансии РЖД"),
        SUPPORT("Служба поддержки"),
        SETTINGS("Настройки"),
        DEBUG("Debug"),
        UI_SANDBOX("UI Sandbox");

        @Getter
        private final String value;
    }

    //Универсальный метод
    @Step("Нажать на пункт 'option.value' в боковом меню")
    public void clickMenuItem(MenuItem option){
        $(byText(option.getValue()))
                .shouldBe(visible)
                .click();
    }

    //Методы для цепочки вызовов без прерываний
    @Step("Нажать на пункт 'Пассажиры'")
    public PassengersPage openPassengers(){
        $(byText(MenuItem.PASSENGERS.getValue()))
                .shouldBe(visible)
                .click();
        return new PassengersPage();
    }

    @Step("Нажать на пункт 'Купить билет'")
    public MainPage openMainPage(){
        $(byText(MenuItem.BUY_TICKETS.getValue()))
                .shouldBe(visible)
                .click();
        return new MainPage();
    }

}
