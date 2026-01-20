package mobile.pages.schedule;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import mobile.pages.base.BasePage;
import mobile.pages.parts.Progressbar;
import mobile.utils.AppConfig;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

@Slf4j
public class SchedulePage extends BasePage {

    //Всплывающее окно со списком ДП
    private final SelenideAppiumElement
            progressCardListTitle = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/progress_card_list_title")),
            btnDisagreeEcard = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/progress_disagree_ecard"));

    private final SelenideAppiumElement
            toolBar = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/toolbar")),
            btnBack = $(AppiumBy.accessibilityId("Перейти вверх")),
            stationFrom = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/station_from")),
            stationTo = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/station_to")),
            btnFavourites = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/add_to_favorites")),
            btnBasket = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/cart")),
            btnSettings = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/timetable_filter"));

    @Step("Проверка начальных элементов страницы Расписания")
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
            btnDisagreeEcard.shouldBe(visible).click();
        }
        else {
            log.info("Всплывающее окно со списком ДП не появилось");
            System.out.println("Всплывающее окно со списком ДП не появилось");
        }
        //Progressbar.waitLoading();
        return this;
    }

    @Step("Выбрать бренд поезда: '{brand}'")
    public SchedulePage selectTrainBrand(String brand){
        SelenideAppiumElement xpath =
        $(AppiumBy.xpath(
                "//android.widget.CheckBox[@resource-id=\"" +
                        AppConfig.getInstance().getPathToElement() +
                        ":id/filterCheckBox\" and @text=\"" +
                        brand +
                        "\"]"
        ));

        xpath
                .shouldBe(visible)
                .click();
     return this;
    }

    @Step("Проверить что выбранный бренд поезда успешно выбран")
    public SchedulePage checkSelectedBrandTrain(String brand){
        SelenideAppiumElement xpath =
                $(AppiumBy.xpath(
                        "//android.widget.CheckBox[@resource-id=\"" +
                                AppConfig.getInstance().getPathToElement() +
                                ":id/filterCheckBox\" and @text=\"" +
                                brand +
                                "\"]"
                ));
        xpath.shouldHave(attribute("checked", "true"));
        return this;
    }

}
