package tests.utils;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import mobile.utils.Initializer;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Класс для автоматического снятия скрина при падении теста
@Slf4j
public class ScreenshotOnFailureExtension implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        try {
            AppiumDriver driver = Initializer.getDriver();
            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                String testName = context.getDisplayName();
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

                Allure.addAttachment(
                        "FAILED - " + testName + " [" + timestamp + "]",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        "png"
                );

                log.info("Скриншот при падении теста сохранён: {}", testName);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }

        throw throwable;
    }
}
