package mobile.helper.badAuthorization;

import mobile.helper.LoginHelper;
import mobile.pages.base.BasePage;

//Класс нужен для обхода бага с подвисанием экрана авторизации
public class BadAuthorization extends BasePage {

    public void authorizationBad(){
        try {
            LoginHelper.authorization();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("authorization() упал по таймауту");
            pressBack();

        }
    }
}
