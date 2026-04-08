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


    public static void authorization(){
            navigateToMainPage();
            performLogin();
            Progressbar.waitLoading();
            skipProtectedPage();
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
        if(isOnMainPage()){
            if(needsAuthorization()){
                new MainPage()
                        .tapButtonLogin();
            }else {
                log.info("Вы уже авторизованы");
            }
        }else {
            log.info("Вы находитесь не на главном экране");
        }
    }

    //Пропускаем экран защиты приложения
    public static void skipProtectedPage(){
        ProtectedPage protectedPage = new ProtectedPage();
        if(protectedPage.isPageDisplayed()) {
            protectedPage.proceedToMainPage();
        }else {
            System.out.println("Открыт не экран защиты входа");
            throw new RuntimeException("Открыт не экран защиты входа");
        }
    }

    //Проверка успешной авторизации
    public static boolean verifySuccessfulLogin(){
        MainPage mainPage = new MainPage();
        return mainPage.isPageDisplayed() && !mainPage.isButtonLoginDisplayed();
    }
}
