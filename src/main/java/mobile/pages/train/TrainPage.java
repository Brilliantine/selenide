package mobile.pages.train;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.schemeCarriage.SchemeCarriage;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class TrainPage extends BasePage {
    private final SelenideAppiumElement
            toolbar = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/toolbar")),
            btnBack = $(AppiumBy.accessibilityId("Перейти назад")),
            btnBasket = $(AppiumBy.accessibilityId("Корзина")),
            tvStation0 = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/tvStation0")),
            tvStation1 = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/tvStation1")),
            btnFilterCarriage = $(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)")),
            scrollView = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/date")); //фильтр вагонов

    @Step("Проверка начальных элементов страницы 'Поезд'")
    public TrainPage checkInitElements(){
        toolbar.shouldBe(visible);
        btnBack.shouldBe(visible);
        btnBasket.shouldBe(visible);
        tvStation0.shouldBe(visible);
        tvStation1.shouldBe(visible);
        btnFilterCarriage.shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку фильтра вагонов")
    public TrainPage clickButtonFilterCarriage(){
        btnBack
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Нажать на вагон № {carriageNumber}")
    public SchemeCarriage selectCarriage(String carriageNumber){
        $(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Вагон №"+carriageNumber+"\")"))
                .scrollTo()
                .shouldBe(visible)
                .click();
        return new SchemeCarriage();
    }
}
