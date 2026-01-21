package mobile.pages.parts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.utils.AppConfig;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class Progressbar {

    private static final SelenideAppiumElement progressBar = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/progress_bar"));

    @Step("Ожидание появления и исчезновения загрузки")
    public static void waitLoading() {
        if ($(AppiumBy.xpath("//android.widget.ProgressBar"))
                .is(visible, Duration.ofSeconds(15))) {
            progressBar.shouldBe(Condition.hidden, Duration.ofSeconds(15));
        }
    }

    public static boolean isLoadingDisplayed(){
        return progressBar.is(visible);
    }
}
