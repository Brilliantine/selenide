package mobile.pages.protect;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.main.MainPage;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ProtectedPage {

    private final SelenideAppiumElement
            //checkboxUsePinCode = $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/name\" and @text=\"Не защищать вход в приложение\"]")),
            //checkboxDontUsePinCode = $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/name\" and @text=\"Не защищать вход в приложение\"]")),
            checkboxUsePinCode = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Не защищать вход в приложение\"]")),
            checkboxDontUsePinCode = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Не защищать вход в приложение\"]")),
            butonNext = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/continue_button"));

    @Step("Проверка начальных элементов страницы защиты входа")
    public ProtectedPage checkInitElements(){
        checkboxUsePinCode.shouldBe(visible);
        checkboxDontUsePinCode.shouldBe(visible);
        butonNext.shouldBe(visible);
        return this;
    }

    @Step("Защищаем вход в приложение")
    public ProtectedPage selectProtectLoginOption(){
        checkboxUsePinCode.shouldBe(visible).click();
        return this;
    }

    @Step("Не защищаем вход в приложение")
    public ProtectedPage selectDoNotProtectLoginOption(){
        checkboxDontUsePinCode.shouldBe(visible).click();
        return this;
    }

    @Step("Нажимаем на кнопку ПРОДОЛЖИТЬ и переходим к главному экрану")
    public MainPage proceedToMainPage(){
        butonNext.shouldBe(visible).click();
        return new MainPage();
    }

    @Step("Нажимаем на кнопку ПРОДОЛЖИТЬ и переходим к экрану ввода пин-кода")
    public PinCodePage proceedToProtectionSetup(){
        butonNext.shouldBe(visible).click();
        return new PinCodePage();
    }
}
