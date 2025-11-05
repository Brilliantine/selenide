package mobile.pages.parts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.utils.AppConfig;

import java.time.Duration;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class Progressbar {

    private static final SelenideAppiumElement progressBar = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/progress_bar"));

    @Step("Ожидание появления и исчезновения загрузки")
    public static void waitLoading() {
        if ($(AppiumBy.xpath("//android.widget.ProgressBar"))
                .is(Condition.visible, Duration.ofSeconds(15))) {
            progressBar.shouldBe(Condition.hidden, Duration.ofSeconds(15));
        }
    }
}
