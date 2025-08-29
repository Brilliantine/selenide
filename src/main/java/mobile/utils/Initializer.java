package mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

@Slf4j
public class Initializer {
    private static AppiumDriver driver;
    static Properties config = new Properties();

    static{
        try (InputStream inputStream = Initializer.class.getClassLoader()
                .getResourceAsStream("config.properties")){
            if(inputStream == null){
                log.error("Файл config.properties не найден");
            }
            config.load(inputStream);
        }catch (Exception exception){
            log.error(exception.getMessage());
            throw new ExceptionInInitializerError();
        }
    }

    private static DesiredCapabilities getDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getProperty("deviceName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, config.getProperty("platformName"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, config.getProperty("automationName"));
        capabilities.setCapability("appPackage", config.getProperty("appPackage"));
        capabilities.setCapability("appActivity", config.getProperty("appActivity"));
        return capabilities;
    }

    public static void initDriver(){
        try {
            URI appiumServerURI = new URI(config.getProperty("appiumServerURL"));
            URL appiumServerURL = appiumServerURI.toURL();
            DesiredCapabilities capabilities = getDesiredCapabilities();
            driver =new AndroidDriver(appiumServerURL,capabilities);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static AppiumDriver getDriver(){
        if(driver == null){
            initDriver();
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
