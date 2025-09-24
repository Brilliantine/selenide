package mobile.pages.schedule;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import mobile.pages.parts.Progressbar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

@Slf4j
public class SchedulePage {

    //Всплывающее окно со списком ДП
    private final SelenideAppiumElement
            progressCardListTitle = $(AppiumBy.id("ru.rzd.pass.debug:id/progress_card_list_title")),
            btnDisagreeEcard = $(AppiumBy.id("ru.rzd.pass.debug:id/progress_disagree_ecard"));

    private final SelenideAppiumElement
            toolBar = $(AppiumBy.id("ru.rzd.pass.debug:id/toolbar")),
            btnBack = $(AppiumBy.accessibilityId("Перейти вверх")),
            stationFrom = $(AppiumBy.id("ru.rzd.pass.debug:id/station_from")),
            stationTo = $(AppiumBy.id("ru.rzd.pass.debug:id/station_to")),
            btnFavourites = $(AppiumBy.id("ru.rzd.pass.debug:id/add_to_favorites")),
            btnBasket = $(AppiumBy.id("ru.rzd.pass.debug:id/cart")),
            btnSettings = $(AppiumBy.id("ru.rzd.pass.debug:id/timetable_filter"));

    @Step("Проверка начальных элементов страницы")
    public SchedulePage checkInitElements(){
        toolBar.shouldBe(visible);
        btnBack.shouldBe(visible);
        stationFrom.shouldBe(visible);
        stationTo.shouldBe(visible);
        btnFavourites.shouldBe(visible);
        btnBasket.shouldBe(visible);
        btnSettings.shouldBe(visible);
        return this;
    }

    @Step("Закрыть всплывающее окно со списком ДП")
    public SchedulePage closeCardList(){

        if(progressCardListTitle.is(visible)){
            btnSettings.shouldBe(visible).click();
        }
        else {
            log.info("Всплывающее окно со списком ДП не появилось");
        }
        Progressbar.waitLoading();
        return this;
    }

}
