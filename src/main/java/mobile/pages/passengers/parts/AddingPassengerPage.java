package mobile.pages.passengers.parts;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AddingPassengerPage {
    private final SelenideAppiumElement
            titlePage = $(byText("Новый пассажир")),
            btnBack = $(AppiumBy.accessibilityId("Перейти назад")),
            formAutoFill = $(AppiumBy.id("ru.rzd.pass.debug:id/fill_from_profile_layout")),
            btnSave = $(AppiumBy.id("ru.rzd.pass.debug:id/save_button"));
}
