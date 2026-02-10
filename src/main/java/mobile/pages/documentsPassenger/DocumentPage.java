package mobile.pages.documentsPassenger;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import mobile.pages.base.BasePage;
import mobile.pages.documentsPassenger.parts.SearchCountryPage;
import mobile.utils.AppConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class DocumentPage extends BasePage {
    private final SelenideAppiumElement
            docType = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/doc_type")),
            docNumberEdit = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/doc_number_edit")),
            etCountryName = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/etCountryName")),
            btnDropDownList = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/text_input_end_icon")),
            checkBoxDefaultDoc = $(AppiumBy.id(AppConfig.getInstance().getPathToElement()+":id/default_doc"));

    @Step("Проверка начальных элементов экрана 'Документ'")
    public DocumentPage checkInitElements(){
        docType.shouldBe(visible);
        docNumberEdit.shouldBe(visible);
        etCountryName.shouldBe(visible);
        btnDropDownList.shouldBe(visible);
        return this;
    }

    @Step("Проверка значения в поле 'Тип документа'")
    public boolean checkValueDocType(String value){
        return value.equals(docType.getText());
    }

    @Step("Ввести номер документа: {number}")
    public DocumentPage setNumberDocument(int number){
        docNumberEdit.click();
        docNumberEdit.setValue(String.valueOf(number));
        return this;
    }

    @Step("Раскрыть выпадающий список c типами документов")
    public DocumentPage openDropDownList(){
        btnDropDownList
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Выбрать тип документа: {docType}")
    public DocumentPage selectDocumentType(String docType){
        hideKeyboard();
        $(AppiumBy.xpath(
                "//android.widget.TextView[@resource-id='" + AppConfig.getInstance().getPathToElement() +
                        ":id/item_text_view' and @text='" + docType + "']"))
                .scrollTo()     //Сомнительно использовать такой скролл. Слишком большой мах
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Нажать на поле 'Гражданство'")
    public SearchCountryPage clickSearchCountry(){
        etCountryName.click();
        return new SearchCountryPage();
    }

    @Step("Проверка значения в поле 'Гражданство'")
    public boolean checkValueCountryName(String value){
        return value.equals(etCountryName.getText());
    }
}
