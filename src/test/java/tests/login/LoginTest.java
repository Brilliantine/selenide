package tests.login;

import mobile.dto.AddUserData;
import mobile.enums.BranchesCommon;
import mobile.enums.Contour;
import mobile.enums.Language;
import mobile.pages.onbording.LanguageSelectionPage;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.utils.Constans.LOGIN;
import static mobile.utils.Constans.PASSWORD;

public class LoginTest extends BaseTest {

    private final AddUserData addUserData = AddUserData.builder()
            .login(LOGIN)
            .userPassword(PASSWORD)
            .build();

    @Test
    public void login(){
        LanguageSelectionPage languageSelectionPage = new LanguageSelectionPage();
        languageSelectionPage
                .checkInitElements()
                .languageSelection(Language.RUSSIAN)
                .tapButtonNext()
                .checkInitElements()
                .selectEnvironment(Contour.COMMON)
                .selectBranch(BranchesCommon.TEST)
                .tapChangeContour()
                .tapButtonNext()
                .checkInitElements()
                .tapAcceptButton()
                .checkInitElements()
                .clickAcceptButton()
                .checkInitElements()
                .swipeToEndTutorial()
                .tapButtonClose()
                .checkInitElements()
                .tapButtonLogin()
                .checkInitElements()
                .setLoginAndPassword(addUserData)
                .tapBattonLoginAndProceedToProtectedPage()
                .checkInitElements()
                .proceedToMainPage()
                .checkUserIsLoggedIn();
    }
}
