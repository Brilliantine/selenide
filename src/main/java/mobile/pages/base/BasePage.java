package mobile.pages.base;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import mobile.utils.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
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

    //Клик по координатам
    protected void tapByCoordinates(double width, double height){
        Dimension sizeWindow = Initializer.getDriver().manage().window().getSize();
        int widthWindow = (int)(sizeWindow.width * width);
        int highWindow = (int)(sizeWindow.height * height);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),widthWindow,highWindow));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Initializer.getDriver().perform(Collections.singletonList(tap));
    }

    // Простой скролл вниз
    public void shortScroll() {
        Dimension screenSize = Initializer.getDriver().manage().window().getSize();
        int screenWidth = screenSize.getWidth(); //Ширина
        int screenHeight = screenSize.getHeight(); //Высота
        Map<String, Object> params = Map.of(
                "left", screenWidth/10,
                "top", screenHeight/4,
                "width",screenWidth*8/10,
                "height",screenHeight/2,
                "direction", "down",
                "percent", 0.2
        );
        Initializer.getDriver().executeScript("mobile: scrollGesture", params);
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
