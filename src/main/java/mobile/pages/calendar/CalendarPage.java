package mobile.pages.calendar;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.schedule.SchedulePage;
import mobile.pages.searchTrains.SearchStationPage;
import mobile.utils.AppConfig;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static java.time.format.DateTimeFormatter.ofPattern;

public class CalendarPage {

    DateTimeFormatter formatter =ofPattern("dd MMMM",new Locale("ru"));
    LocalDate today = LocalDate.now();

    private final SelenideAppiumElement
            toolbar = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/toolbar")),
            buttonNext = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/continueButton")),
            oneWayPicker = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/one_way_button")),
            bothWayPicker = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/both_way_button")),
            swapElement = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+ ":id/swap"));

    @Step("Проверка начальных элементов страницы")
    public CalendarPage checkInitElements(){
        toolbar.shouldBe(visible);
        buttonNext.shouldBe(visible);
        oneWayPicker.shouldBe(visible);
        bothWayPicker.shouldBe(visible);
        return this;
    }

    //Получить отформатированную дату для локатора
    public String getFormattedDate(LocalDate date){
        return date.format(formatter);
    }

    //Клик по дате
    public void clickDate(LocalDate date){
        //$(AppiumBy.xpath("//android.view.View[contains(@content-desc, '" +date.format(formatter)+"')]");

        String formatedDate = getFormattedDate(date);
        SelenideAppiumElement dateElement = $(AppiumBy.accessibilityId(formatedDate));

        System.out.println(date.format(formatter));

        if(!dateElement.is(visible)){
            dateElement.scrollTo();
        }
        dateElement
                .shouldBe(visible)
                .click();

    }

    //Поиск даты в одну сторону
    public void clickOneDate(LocalDate date){

        if (!swapElement.is(visible)){
            System.out.println("иконки свайпа нет на экране");
            clickDate(date);
        }else {
            oneWayPicker.click();
            clickDate(date);
        }

    }

    @Step("Выбор одной даты: {date}")
    public CalendarPage selectDate(LocalDate date){
        clickOneDate(date);
        return this;
    }

    @Step("Выбор одной даты через {days} дней от текущей")
    public CalendarPage selectDateFromToday(int days){
        clickOneDate(today.plusDays(days));
        return this;
    }


    @Step("Нажать на кнопку ПРОДОЛЖИТЬ")
    public void clickContinue(){
        buttonNext.click();
    }
}
