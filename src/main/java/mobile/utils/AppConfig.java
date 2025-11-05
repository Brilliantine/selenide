package mobile.utils;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import mobile.enums.BranchesCommon;
import mobile.enums.Contour;
import org.openqa.selenium.By;
import mobile.enums.ServerType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static AppConfig instance;
    private final Properties config = new Properties();
    private ServerType serverType = ServerType.DEBUG; // default
    /**
     * Приватный конструктор (Singleton pattern).
     * При создании экземпляра автоматически загружает конфигурацию.
     * Нельзя создать через new AppConfig() - только через getInstance().
     */
    private AppConfig() {
        loadConfig();
    }
    /**
     * Возвращает единственный экземпляр AppConfig (Singleton).
     *
     * Особенности:
     * - synchronized - потокобезопасность при многопоточном доступе
     * - Ленивая инициализация - создается только при первом вызове
     * - Всегда возвращает один и тот же экземпляр
     *
     * Использование:
     * AppConfig config = AppConfig.getInstance();
     * config.getAppPackage();
     */
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    //Загружает конфигурацию и определяет тип сервера.
    private void loadConfig() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) {
                throw new RuntimeException("config.properties not found in resources");
            }
            config.load(is);

            // определяем приоритет: System property -> ENV -> config.properties -> debug
            String serverName = System.getProperty("server",
                    System.getenv("SERVER") != null ? System.getenv("SERVER")
                            : config.getProperty("buildType", "debug"));

            try {
                serverType = ServerType.valueOf(serverName.trim().toUpperCase());
            } catch (Exception e) {
                serverType = ServerType.DEBUG;
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    //Получаем пакет приложения в виде строки
    public String getAppPackage() {
        switch (serverType) {
            case ADAPTER:
                return config.getProperty("appPackageAdapter");
            case PROD:
                return config.getProperty("appPackageProd");
            default:
                return config.getProperty("appPackage");
        }
        //Временный код для отладки:
        /*String pkg;
        switch (serverType){
            case ADAPTER:
                pkg = config.getProperty("appPackageAdapter");
                break;
            case PROD:
                pkg = config.getProperty("appPackageProd");
                break;
            default:
                pkg = config.getProperty("appPackage");
        }
        System.out.println("📦 Используется пакет: " + pkg);
        return pkg;*/
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }

    public ServerType getServerType() {
        return serverType;
    }

    //Отдаем пакет в виде строки: ru.rzd.pass.adapter.debug и тд
    public String getPathToElement(){
        return getAppPackage();
    }

    //Получаем контур
    public Contour getAutoContour() {
        return serverType.getAutoContour();
    }

    //Получаем ветку
    public BranchesCommon getAutoBranch() {
        return serverType.getAutoBranch();
    }
}