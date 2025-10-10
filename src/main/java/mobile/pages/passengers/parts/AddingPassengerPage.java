package mobile.pages.passengers.parts;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AddingPassengerPage {
    //Общие элементы страницы
    private final SelenideAppiumElement
            titlePage = $(byText("Новый пассажир")),
            btnBack = $(AppiumBy.accessibilityId("Перейти назад")),
            formAutoFill = $(AppiumBy.id("ru.rzd.pass.debug:id/fill_from_profile_layout")),
            btnFillFromProfile = $(AppiumBy.id("ru.rzd.pass.debug:id/fill_from_profile")),
            btnHideFormAutoFill = $(AppiumBy.id("ru.rzd.pass.debug:id/hide_fill_from_profile")),
            btnSave = $(AppiumBy.id("ru.rzd.pass.debug:id/save_button"));

    private final SelenideAppiumElement
            patronymic = $(AppiumBy.id("ru.rzd.pass.debug:id/patronymic_edit")),
            name = $(AppiumBy.id("ru.rzd.pass.debug:id/name_edit")),
            surname = $(AppiumBy.id("ru.rzd.pass.debug:id/surname_edit")),
            patronymicEmptyCheck = $(AppiumBy.id("ru.rzd.pass.debug:id/patronymicEmptyCheck")),
    //Аллерт который появляется при активации чек-бокса без отчества
            alertTitle = $(AppiumBy.id("ru.rzd.pass.debug:id/alertTitle")),
            alertMessage = $(AppiumBy.id("android:id/message")),
            btnAlertNoPatronymic = $(AppiumBy.id("android:id/button1")),
            btnAlertThereArePatronymic = $(AppiumBy.id("android:id/button2")),
    //Документ
            documentView = $(AppiumBy.id("ru.rzd.pass.debug:id/document_view")),
            addNewDocument = $(AppiumBy.id("ru.rzd.pass.debug:id/empty")),


            fieldDateBirthday = $(AppiumBy.id("ru.rzd.pass.debug:id/etDateBirth")),
            listGender = $(AppiumBy.id("ru.rzd.pass.debug:id/gender"));

    @Step("Проверка начальных элементов страницы 'Новый пассажир'")
    public AddingPassengerPage checkInitElements(){
        titlePage.shouldBe(visible);
        btnBack.shouldBe(visible);
        formAutoFill.shouldBe(visible);
        btnSave.shouldBe(visible);
        return this;
    }

    @Step("Заполнить данные из профиля")
    public AddingPassengerPage fillDataFromProfile(){
        btnFillFromProfile
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Проверка полей ФИО после авто заполнения")
    public AddingPassengerPage checkingFullNameFields(){
        surname
                .shouldBe(visible)
                .shouldNotHave(value(""));
        name
                .shouldBe(visible)
                .shouldNotHave(value(""));

        // Проверяем состояние поля отчества и связанного чекбокса
        String patronymicValue = patronymic.getValue();

        if(patronymicValue == null || patronymicValue.isEmpty()){
            patronymicEmptyCheck.shouldHave(attribute("checked","true"));
            patronymic.shouldBe(disabled);
        }else {
            patronymic
                    .shouldBe(visible)
                    .shouldNotHave(value(""));
        }

        return this;
    }
}
