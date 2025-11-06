package mobile.helper;

import lombok.extern.slf4j.Slf4j;
import mobile.dto.AddUserData;
import mobile.pages.login.LoginPage;
import mobile.pages.main.MainPage;
import mobile.pages.parts.Progressbar;
import mobile.pages.protect.ProtectedPage;

import static mobile.utils.Constans.LOGIN;
import static mobile.utils.Constans.PASSWORD;

@Slf4j
public class LoginHelper {


    public static boolean authorization(){
        try {
            if(isOnMainPage()){
                navigateToMainPage();
                performLogin();
                Progressbar.waitLoading();
                handleProtectionIfNeeded();
            }else {
                log.info("Открыт не главный экран");
            }
            return verifySuccessfulLogin();
        }catch (Exception e){
            log.error("Ошибка авторизации: {}", e.getMessage());
            return false;
        }
    }

    //Проверка открыт ли главный экран
    public static boolean isOnMainPage (){
        MainPage mainPage = new MainPage();
        return mainPage.isPageDisplayed();
    }

    //Проверка нужна ли авторизация
    public static boolean needsAuthorization(){
        MainPage mainPage = new MainPage();
        return mainPage.isButtonLoginDisplayed();
    }

    //Ввод логина, пароля и нажатие кнопки Войти
    public static void performLogin(){
        AddUserData userData = AddUserData.builder()
                .login(LOGIN)
                .userPassword(PASSWORD)
                .build();
        new LoginPage()
                .checkInitElements()
                .setLoginAndPassword(userData)
                .tapButtonLogin();
        log.info("Ввод учетных данных выполнен");
    }

    //Навигация на главном экране
    public static void navigateToMainPage(){
        new MainPage()
                .tapButtonLogin();
    }
    //Проверка открыт экран зашиты входа или главный экран
    public static void handleProtectionIfNeeded() {
        ProtectedPage protectedPage = new ProtectedPage();
        MainPage mainPage = new MainPage();

        if (protectedPage.isPageDisplayed()) {
            protectedPage
                    .proceedToMainPage()
                    .checkUserIsLoggedIn();
        } else {
            mainPage.checkUserIsLoggedIn();
        }
    }

    //Проверка успешной авторизации
    public static boolean verifySuccessfulLogin(){
        MainPage mainPage = new MainPage();
        return mainPage.isPageDisplayed() && !mainPage.isButtonLoginDisplayed();
    }
}
