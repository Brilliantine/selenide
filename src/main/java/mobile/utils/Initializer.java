package mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.options.UiAutomator2Options;
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

    //Подход устарел. Библиотеку MobileCapabilityType удалили
    /*
    private static DesiredCapabilities getDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", config.getProperty("deviceName"));
        capabilities.setCapability("platformName", config.getProperty("platformName"));
        capabilities.setCapability("automationName", config.getProperty("automationName"));
        capabilities.setCapability("appPackage", config.getProperty("appPackage"));
        capabilities.setCapability("appActivity", config.getProperty("appActivity"));
        return capabilities;
    }*/

    private static UiAutomator2Options getOPtoins(){
        return new UiAutomator2Options()
                .setDeviceName(config.getProperty("deviceName"))
                .setPlatformName(config.getProperty("platformName"))
                .setAutomationName(config.getProperty("automationName"))
                .setAppPackage(config.getProperty("appPackage"))
                .setAppActivity(config.getProperty("appActivity"));
    }

    public static void initDriver(){
        try {
            URI appiumServerURI = new URI(config.getProperty("appiumServerURL"));
            URL appiumServerURL = appiumServerURI.toURL();
            //DesiredCapabilities capabilities = getDesiredCapabilities(); //Устаревший подход. Можно удалять строку
            UiAutomator2Options options = getOPtoins();
            driver =new AndroidDriver(appiumServerURL,options);
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
