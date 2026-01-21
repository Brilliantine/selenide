package mobile.pages.train;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class TrainPage {
    private final SelenideAppiumElement
            toolbar = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/toolbar")),
            btnBack = $(AppiumBy.accessibilityId("Перейти назад")),
            btnBasket = $(AppiumBy.accessibilityId("Корзина")),
            tvStation0 = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/tvStation0")),
            tvStation1 = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/tvStation1")),
            btnFilterWagon = $(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)"));

    public TrainPage checkInitElements(){
        toolbar.shouldBe(visible);
        btnBack.shouldBe(visible);
        btnBasket.shouldBe(visible);
        tvStation0.shouldBe(visible);
        tvStation1.shouldBe(visible);
        btnFilterWagon.shouldBe(visible);
        return this;
    }
}
