package mobile.helper;

import lombok.extern.slf4j.Slf4j;
import mobile.enums.BranchesCommon;
import mobile.enums.Contour;
import mobile.enums.Language;
import mobile.pages.onbording.EnvironmentSelectionPage;
import mobile.pages.onbording.LanguageSelectionPage;

@Slf4j
public class Onbording {
    private final String titleTextLanguageSelectionPage = LanguageSelectionPage.getTextTitle();
    private final String titleEnvironmentSelectionPage = EnvironmentSelectionPage.getTextTitle();

    public void completeIfPresents(){
        LanguageSelectionPage languageSelectionPage = new LanguageSelectionPage();
        if(titleTextLanguageSelectionPage.equals("Выберите язык приложения")){
            languageSelectionPage
                    .checkInitElements()
                    .languageSelection(Language.RUSSIAN)
                    .tapButtonNext();
        }

        EnvironmentSelectionPage environmentSelectionPage = new EnvironmentSelectionPage();
        if(titleEnvironmentSelectionPage.equals("Debug")){
            environmentSelectionPage
                    .checkInitElements()
                    .selectEnvironment(Contour.COMMON)
                    .selectBranch(BranchesCommon.TEST)
                    .tapChangeContour()
                    .tapButtonNext();
        }
    }
}
