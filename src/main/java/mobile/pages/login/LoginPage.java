package mobile.pages.login;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.main.MainPage;

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
    @Step("Вводим логин: {login}")
    public LoginPage setLogin(String login ){
        inputLogin.shouldBe(visible).setValue(login);
        return this;
    }

    @Step("Вводим пароль: {password}")
    public LoginPage setPassword(String password){
        inputPassword.shouldBe(visible).setValue(password);
        return this;
    }

    @Step("Логинимся второй или более раз")
    public MainPage tapButtonLogin(){
        buttonLogin.shouldBe(visible).click();
        return new MainPage();
    }

    @Step("Логинимся первый раз")
    public ProtectedPage tapBattonLogin(){
        buttonLogin.shouldBe(visible).click();
        return new ProtectedPage();
    }
}
