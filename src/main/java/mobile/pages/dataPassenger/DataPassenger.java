package mobile.pages.dataPassenger;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.passengers.PassengersPage;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class DataPassenger extends BasePage {
    private final SelenideAppiumElement
            trainInfo = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/train_info")),
            direction = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/direction")),
            btnAddPassenger = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/fab"));

    @Step("Проверка начальных элементов страницы 'Данные пассажиры'")
    public DataPassenger checkInitElements(){
        trainInfo.shouldBe(visible);
        direction.shouldBe(visible);
        btnAddPassenger.shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку 'Добавить пассажира'")
    public PassengersPage clickButtonAddPassenger(){
        btnAddPassenger
                .shouldBe(visible)
                .click();
        return new PassengersPage();
    }
}
