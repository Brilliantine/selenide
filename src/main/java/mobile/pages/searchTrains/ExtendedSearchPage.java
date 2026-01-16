package mobile.pages.searchTrains;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.calendar.CalendarPage;
import mobile.pages.schedule.SchedulePage;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;

public class ExtendedSearchPage extends BasePage {
    private final SelenideAppiumElement
            toolbar = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/toolbar")),
            btnBack = $(AppiumBy.accessibilityId("Перейти назад")),
            titlePage = $(byText("Расширенный поиск")),
            btnStationSwap = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/swap")),
            fieldFrom = $(AppiumBy.accessibilityId("ОТКУДА")),
            fieldWhere = $(AppiumBy.accessibilityId("КУДА")),
            fromDate = $(AppiumBy.xpath("//*[contains(@content-desc, 'Туда')]")),
            toDate = $(AppiumBy.xpath("//*[contains(@content-desc, 'Обратно')]")),
            btnSearchTrains = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+ ":id/apply")),
    //Филтры
            btnClear = $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"" + AppConfig.getInstance().getPathToElement() + ":id/clear\"]")),
            сbTrains = $(AppiumBy.accessibilityId("Фильтр поездов")),
            сbSuburbanTrain = $(AppiumBy.accessibilityId("Фильтр электричек")),
            cbTicketsOnly = $(AppiumBy.accessibilityId("Фильтр с билетами")),
            cbConnection = $(AppiumBy.accessibilityId("Фильтр с пересадками")),
            cbUsePoints = $(AppiumBy.accessibilityId("Можно купить за\\nбонусные баллы")),
            cbBusinessPass = $(AppiumBy.accessibilityId("Можно оплатить деловым проездным")),
            selectCarrier = $(AppiumBy.xpath("(//android.widget.RelativeLayout[@resource-id=\"" + AppConfig.getInstance().getPathToElement() + ":id/header\"])[1]")),
            selectTrainBrand = $(AppiumBy.xpath("(//android.widget.RelativeLayout[@resource-id=\"" + AppConfig.getInstance().getPathToElement() + ":id/header\"])[2]")),
            selectCarType = $(AppiumBy.xpath("(//android.widget.RelativeLayout[@resource-id=\""+ AppConfig.getInstance().getPathToElement() + ":id/header\"])[3]")),
            selectServices = $(AppiumBy.xpath("(//android.widget.RelativeLayout[@resource-id=\""+ AppConfig.getInstance().getPathToElement() + ":id/header\"])[4]")),
            btnSaveFilter = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/save_filter_button")),
            btnListFilters = $(AppiumBy.id(AppConfig.getInstance().getPathToElement() + ":id/list_filters_button"));

    @Step("Проверка начальных элементов страницы расширенного поиска")
    public ExtendedSearchPage checkInitElements(){
        titlePage.shouldBe(visible);
        fieldFrom.shouldBe(visible);
        fieldWhere.shouldBe(visible);
        fromDate.shouldBe(visible);
        toDate.shouldBe(visible);
        btnSearchTrains.shouldBe(visible);
        return this;
    }

    @Step("Нажать на поле ОТКУДА")
    public SearchStationPage searchStationFrom(){
        fieldFrom
                .shouldBe(visible)
                .click();
        return new SearchStationPage();
    }

    @Step("Нажать на поле КУДА")
    public SearchStationPage searchStationWhere(){
        fieldWhere
                .shouldBe(visible)
                .click();
        return new SearchStationPage();
    }

    @Step("Нажать на дату ТУДА")
    public CalendarPage clickFromDate(){
        fromDate
                .shouldBe(visible)
                .click();
        return new CalendarPage();
    }

    @Step("Нажать на дату ОБРАТНО")
    public CalendarPage clickToDate(){
        toDate
                .shouldBe(visible)
                .click();
        return new CalendarPage();
    }

    @Step("Нажать на кнопку НАЙТИ ПОЕЗД")
    public SchedulePage clickButtonSearchTrains(){
        btnSearchTrains
                .shouldBe(visible)
                .click();
        return new SchedulePage();
    }

    @Step("Активировать чек-бокс 'Только с билетами'")
    public ExtendedSearchPage selectTicketsOnly(){
        isElementSafeToClick(cbTicketsOnly);
        verifyCheckboxIsChecked(cbTicketsOnly);
        return this;
    }

    @Step("Активировать чек-бокс 'С пересадками'")
    public ExtendedSearchPage selectConnection(){
        isElementSafeToClick(cbConnection);
        verifyCheckboxIsChecked(cbConnection);
        return this;
    }

    @Step("Выбрать услугу: {service}")
    public ExtendedSearchPage selectService(String service){
        SelenideAppiumElement elementService = $(byText(service));
        isElementSafeToClick(selectServices);
        isElementSafeToClick(elementService);
        verifyCheckboxIsChecked(elementService);

        return this;
    }
    @Step("Проверить, что чек-бокс активирован")
    public void verifyCheckboxIsChecked(SelenideAppiumElement checkbox){
        checkbox
                .shouldHave(attribute("checked", "true"));
    }

    @Step("Нажать на поле 'Перевозчик'")
    public void clickFieldCarrier(){
        isElementSafeToClick(selectCarrier);
    }

    @Step("Выбрать перевозчика '{carrier}'")
    public void clickCarrier(String carrier){
        SelenideAppiumElement carrierElement = $(AppiumBy.accessibilityId(carrier));
        isElementSafeToClick(carrierElement);
        verifyCheckboxIsChecked(carrierElement);
    }

    public ExtendedSearchPage selectCarrier(String carrier){
        clickFieldCarrier();
        clickCarrier(carrier);
        return this;
    }

    @Step("Нажать на поле 'Бренд плезда'")
    public void clickFieldTrainBrand(){
        isElementSafeToClick(selectTrainBrand);
    }

    @Step("Выбрать бренд поезда 'trainBrand'")
    public void clickTrainBrand(String brand){
        SelenideAppiumElement brandElement = $(AppiumBy.accessibilityId(brand));
        isElementSafeToClick(brandElement);
        verifyCheckboxIsChecked(brandElement);
    }

    public ExtendedSearchPage selectTrainBrand(String brand){
        clickFieldTrainBrand();
        clickTrainBrand(brand);
        return this;
    }
    //Метод для обхода кнопки поиска поезда и безопасного клика по нужному элементу
    public void isElementSafeToClick(SelenideAppiumElement element){
        if(!element.is(visible)){
            element
                    .scrollTo();
        }
        element.shouldBe(visible);
        shortScroll();
        element.click();
    }
}
