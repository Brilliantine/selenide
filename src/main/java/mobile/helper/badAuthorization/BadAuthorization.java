package mobile.helper.badAuthorization;

import mobile.helper.LoginHelper;
import mobile.pages.base.BasePage;

import static com.codeborne.selenide.Selenide.sleep;

//Класс нужен для обхода бага с подвисанием экрана авторизации
public class BadAuthorization extends BasePage {

    public void authorizationBad(){
        try {
            LoginHelper.authorization();
        }catch (Exception e){
            pressBack();
            System.out.println("Прожали кнопку Назад");
            LoginHelper.verifySuccessfulLogin();
        }
    }
}
