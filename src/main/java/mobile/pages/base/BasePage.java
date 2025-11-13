package mobile.pages.base;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import mobile.utils.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class BasePage {
    protected WebDriverWait wait = new WebDriverWait(Initializer.getDriver(), Duration.ofSeconds(2));

    //Ждем элемент и возвращаем его
    public WebElement waitForVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Клик с ожиданием
    protected void waitAndClick(By locator){
        waitForVisible(locator).click();
    }
    //Скролл нужно дорабатывать
    protected void scrollToElement(String xpath){
        //Максимальное количество скроллов
        int maxScroll = 5;

        //Скролл и клик
        for (int i = 0; i < maxScroll; i++){
            //Получаем размеры экрана
            Dimension screenSize = Initializer.getDriver().manage().window().getSize();
            int screenWidth = screenSize.getWidth(); //Ширина
            int screenHeight = screenSize.getHeight(); //Высота

            try{
                SelenideAppiumElement elementXpath = $(AppiumBy.xpath(xpath));
                return;
            } catch (NoSuchElementException e) {
                //Параметры для скролла
                Map<String, Object> params = new HashMap<>();
                // X-кордината начала области скролла
                params.put("left", screenWidth/10);
                //Y-кордината начала области скролла
                params.put("top", screenHeight/4);
                //Ширина области, в которой будт скролл
                params.put("width", screenWidth*8/10);
                //Высота области, в которой будет скролл
                params.put("height", screenHeight/2);
                //Направления скролла
                params.put("direction","down");
                //Насколько длинным будет скролл (от 0.0 до 1.0)
                params.put("percent",0.7);

                Boolean canScroll = (Boolean) Initializer.getDriver().executeScript("mobile: scrollGesture",params);

                if(!canScroll){
                    throw new NoSuchElementException("Не удалось найти элемент после скролла");
                }
            }
        }
        throw new NoSuchElementException("Не удалось найти элемент после " +maxScroll+ " скроллов");
    }
}
