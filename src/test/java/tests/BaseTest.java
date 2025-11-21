package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import mobile.utils.Initializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeEach
    @Step("Инициализация драйвера")
    public void setUp(){
        driver = Initializer.getDriver();
        WebDriverRunner.setWebDriver(driver); // <- связка с Selenide

        configureSelenideForAppium();
    }

    public void configureSelenideForAppium(){
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 20000;
        Configuration.pollingInterval = 200;
        Configuration.browserSize = null;
        Configuration.remoteReadTimeout = 20000;
    }

    @AfterEach
    @Step("Закрытие драйвера")
    public void tearDown(){
        Initializer.quitDriver();
    }
}
