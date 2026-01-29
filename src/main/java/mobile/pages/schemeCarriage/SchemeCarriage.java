package mobile.pages.schemeCarriage;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class SchemeCarriage {
    private final SelenideAppiumElement
            toolbar = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/toolbar")),
            btnContinue = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/btnContinue")),
            btnZoom = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/zoom_button"));
}
