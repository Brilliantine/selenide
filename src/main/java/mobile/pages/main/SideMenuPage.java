package mobile.pages.main;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class SideMenuPage {

    private final SelenideAppiumElement sideMenu =
            $(AppiumBy.id("ru.rzd.pass.debug:id/list"));
    private final SelenideAppiumElement buttonLogin =
            $(AppiumBy.id("ru.rzd.pass.debug:id/sign_in_out_button"));

}
