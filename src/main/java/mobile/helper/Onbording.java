package mobile.helper;

import lombok.extern.slf4j.Slf4j;
import mobile.enums.Language;
import mobile.pages.main.MainPage;
import mobile.pages.onbording.*;

@Slf4j
public class Onbording {

    public static void completeOnboarding(){
        LanguageSelectionPage languageSelectionPage = new LanguageSelectionPage();
        languageSelectionPage
                .checkInitElements()
                .languageSelection(Language.RUSSIAN)
                .tapButtonNext();
        /*if(languageSelectionPage.isPageDisplayed()){
            languageSelectionPage
                    .checkInitElements()
                    .languageSelection(Language.RUSSIAN)
                    .tapButtonNext();
        }*/

        EnvironmentSelectionPage environmentSelectionPage = new EnvironmentSelectionPage();
        if(environmentSelectionPage.isPageDisplayed()){
            environmentSelectionPage
                    .quickOnboarding();
            //По сути вызов цепочки ниже уже не нужен
                    /*.checkInitElements()
                    .selectEnvironment(Contour.COMMON)
                    .selectBranch(BranchesCommon.TEST)
                    .tapChangeContour()
                    .tapButtonNext();*/
        }

        AgreementPage agreementPage = new AgreementPage();
        agreementPage
                .checkInitElements()
                .tapAcceptButton();
        /*if(agreementPage.isPageDisplayed()){
            agreementPage
                    .checkInitElements()
                    .tapAcceptButton();
        }*/

        AgreementKasperskyPage agreementKasperskyPage = new AgreementKasperskyPage();
        agreementKasperskyPage
                .checkInitElements()
                .clickAcceptButton();
        /*if(agreementKasperskyPage.isPageDisplayed()){
            agreementKasperskyPage
                    .checkInitElements()
                    .clickAcceptButton();
        }*/

        TutorialPage tutorialPage = new TutorialPage();
        tutorialPage
                .checkInitElements()
                .tapButtonClose();
        /*if(tutorialPage.isPageDisplayed()){
            tutorialPage
                    .checkInitElements()
                    .tapButtonClose();
        }*/

        MainPage mainPage = new MainPage();
        mainPage.isPageDisplayed();
    }
}
