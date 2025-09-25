package mobile.pages.login;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.dto.AddUserData;
import mobile.pages.main.MainPage;
import mobile.pages.protect.ProtectedPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class LoginPage {

    private SelenideAppiumElement
            inputLogin = $(AppiumBy.id("ru.rzd.pass.debug:id/login")),
            inputPassword = $(AppiumBy.id("ru.rzd.pass.debug:id/password")),
            buttonLogin = $(AppiumBy.id("ru.rzd.pass.debug:id/avatar")),
            checkboxSaveAuth = $(AppiumBy.id("ru.rzd.pass.debug:id/agreementLoginSaveAuth")),
            buttonOfferta = $(AppiumBy.id("ru.rzd.pass.debug:id/offerta")),
            buttonRecoveryPassword = $(AppiumBy.id("ru.rzd.pass.debug:id/recovery_login_btn")),
            buttonRegistration = $(AppiumBy.id("ru.rzd.pass.debug:id/recovery_login_btn"));

    @Step("Проверка начальных элементов страницы авторизации")
    public LoginPage checkInitElements(){
        inputLogin.shouldBe(visible);
        inputPassword.shouldBe(visible);
        checkboxSaveAuth.shouldBe(visible);
        buttonLogin.shouldBe(visible);
        return this;
    }

    @Step("Вводим логин и пароль")
    public LoginPage setLoginAndPassword(AddUserData userData){
        inputLogin.setValue(userData.getLogin());
        inputPassword.setValue(userData.getUserPassword());
        return this;
    }

    @Step("Логинимся первый раз")
    public ProtectedPage tapBattonLoginAndProceedToProtectedPage(){
        buttonLogin.shouldBe(visible).click();
        return new ProtectedPage();
    }

    @Step("Логинимся второй или более раз")
    public MainPage tapButtonLoginAndProceedToMainPage(){
        buttonLogin.shouldBe(visible).click();
        return new MainPage();
    }
}
