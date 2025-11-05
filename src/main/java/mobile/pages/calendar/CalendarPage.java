package mobile.pages.calendar;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.schedule.SchedulePage;
import mobile.pages.searchTrains.SearchStationPage;
import mobile.utils.AppConfig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static java.time.format.DateTimeFormatter.ofPattern;

public class CalendarPage {

    DateTimeFormatter formatter =ofPattern("d MMMM",new Locale("ru"));

    private final SelenideAppiumElement
            toolbar = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/toolbar")),
            buttonNext = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/continueButton")),
            oneWayPicker = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/one_way_button")),
            bothWayPicker = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/both_way_button"));

    @Step("Проверка начальных элементов страницы")
    public CalendarPage checkInitElements(){
        toolbar.shouldBe(visible);
        buttonNext.shouldBe(visible);
        oneWayPicker.shouldBe(visible);
        bothWayPicker.shouldBe(visible);
        return this;
    }

    public void clickOneDate(LocalDate date){
        $(AppiumBy.xpath("//android.view.View[contains(@content-desc, '" +date.format(formatter)+"')]"))
                .shouldBe(visible)
                .click();
    }

    @Step("Выбор даты: {date}")
    public CalendarPage selectDate(LocalDate date){
        clickOneDate(date);
        return this;
    }

    @Step("Нажать на кнопку ПРОДОЛЖИТЬ")
    public SchedulePage clickContinue(){
        buttonNext.click();
        return new SchedulePage();
    }
}
