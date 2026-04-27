package tests.utils;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import mobile.utils.Initializer;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Класс для ручных скриншотов
@Slf4j
public class AllureScreenshot {

    //Скриншот с именем
    public static void takeScreenshot(String name) {
        try {
            AppiumDriver driver = Initializer.getDriver();
            if(driver != null) {
                log.info("Драйвер не инициализирован — скриншот '{}' не сделан", name);
                return;
            }

            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            Allure.addAttachment(
                    name + "["+timestamp+"]",
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    "png"
            );
            log.info("Скриншот '{}' добавлен в отчёт", name);
        }catch (Exception e) {
            log.error("Ошибка при создании скриншота '{}': {}", name, e.getMessage());
        }
    }
    //Скриншот без имени
    public static void takeScreenshot(){
        takeScreenshot("Screenshot");
    }
}
