package mobile.pages.onbording;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.main.MainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.Selenide.sleep;

public class TutorialPage {

    private final SelenideAppiumElement buttonClose =
            $(AppiumBy.id("ru.rzd.pass.debug:id/pass_button"));
    private final SelenideAppiumElement tutorialImage =
            $(AppiumBy.id("ru.rzd.pass.debug:id/tutorial_image"));
    private final SelenideAppiumElement buttonForward =
            $(AppiumBy.id("ru.rzd.pass.debug:id/button_forward"));
    private final SelenideAppiumElement buttonBackward =
            $(AppiumBy.id("ru.rzd.pass.debug:id/button_backward"));
    private final SelenideAppiumElement slideCounter =
            $(AppiumBy.id("ru.rzd.pass.debug:id/text_counter"));

    @Step("Проверяем начальные элементы на странице туториола")
    public TutorialPage checkInitElements (){
        buttonClose.shouldBe(visible);
        tutorialImage.shouldBe(visible);
        buttonForward.shouldBe(visible);
        return this;
    }

    @Step("Закрываем туториал и переходим к главному экрану")
    public MainPage tapButtonClose(){
        buttonClose.shouldBe(visible).click();
        return new MainPage();
    }

    @Step("Перелистываем к следующему слайду туториола")
    public TutorialPage tapButtonForward (){
        buttonForward.click();
        return this;
    }

    @Step("Перелистываем к предыдущему слайду туториола")
    public TutorialPage tapButtonBackward(){
        buttonBackward.click();
        return this;
    }

    @Step("Пролистываем туториал до конца")
    //Новый более простой метод
    public TutorialPage swipeToEndTutorial(){
        while (buttonForward.is(visible)){
            buttonForward.click();
            sleep(500);
        }
        return this;
    }
    //Старый метод нуждается в доработке. После того как все туториалы пролистаны, пропадает кнопка "вперед" из-за этого тест падает
    /*public TutorialPage swipeToEndTutorial(){
       String counterText = slideCounter.getText();
       String totalSlidesStr = counterText.split(" ")[2];

       try {
           Integer totalSlide = Integer.parseInt(totalSlidesStr);
           for (int i = 0; i < totalSlide; i++){
               buttonForward.click();
               sleep(500);
           }
       }catch (Exception e){
           throw new RuntimeException("Не удалось распарсить счетчик слайдов "+e.getMessage());
       }

       return this;

    }*/

}
