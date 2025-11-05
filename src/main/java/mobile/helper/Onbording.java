package mobile.helper;

import lombok.extern.slf4j.Slf4j;
import mobile.enums.BranchesCommon;
import mobile.enums.Contour;
import mobile.enums.Language;
import mobile.pages.onbording.*;

@Slf4j
public class Onbording {

    public static void completeOnboarding(){
        LanguageSelectionPage languageSelectionPage = new LanguageSelectionPage();
        if(languageSelectionPage.isPageDisplayed()){
            languageSelectionPage
                    .checkInitElements()
                    .languageSelection(Language.RUSSIAN)
                    .tapButtonNext();
        }

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
        if(agreementPage.isPageDisplayed()){
            agreementPage
                    .checkInitElements()
                    .tapAcceptButton();
        }

        AgreementKasperskyPage agreementKasperskyPage = new AgreementKasperskyPage();
        if(agreementKasperskyPage.isPageDisplayed()){
            agreementKasperskyPage
                    .checkInitElements()
                    .tapAcceptButton();
        }

        TutorialPage tutorialPage = new TutorialPage();
        if(tutorialPage.isPageDisplayed()){
            tutorialPage
                    .checkInitElements()
                    .tapButtonClose();
        }
    }
}
