package mobile.pages.passengers;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.passengers.parts.AddingPassengerPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class PassengersPage extends BasePage {
    private final SelenideAppiumElement
            titlePage = $(byText("Пассажиры")),
            btnAddPassenger = $(AppiumBy.id("ru.rzd.pass.debug:id/add_passenger_button")),
            recentPicker = $(AppiumBy.id("ru.rzd.pass.debug:id/first_type_view")),
            allPicker = $(AppiumBy.id("ru.rzd.pass.debug:id/second_type_view")),
            btnSearch = $(AppiumBy.id("ru.rzd.pass.debug:id/action_search")),
            btnBack = $(AppiumBy.accessibilityId("Перейти назад"));

    @Step("Проверка начальных элементов страницы Пассажиры")
    public PassengersPage checkInitElements(){
        titlePage.shouldBe(visible);
        btnAddPassenger.shouldBe(visible);
        recentPicker.shouldBe(visible);
        allPicker.shouldBe(visible);
        btnSearch.shouldBe(visible);
        btnBack.shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку 'Добавить нового пассажира'")
    public AddingPassengerPage addNewPassenger(){
        btnAddPassenger
                .shouldBe(visible)
                .click();
        return new AddingPassengerPage();
    }
}
