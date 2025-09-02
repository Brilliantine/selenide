package mobile.pages.onbording;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.main.MainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static java.lang.Thread.sleep;

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

    @Step("Нажимаем на кнопку Закрыть")
    public MainPage tapButtonClose(){
        buttonClose.click();
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
    public void swipeToEndTutorial(){
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

    }

}
