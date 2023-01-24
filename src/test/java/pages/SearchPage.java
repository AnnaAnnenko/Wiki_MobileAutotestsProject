package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    public SelenideElement searchInput = $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"));
    public ElementsCollection titleResultsList = $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"));
    public SelenideElement titleResult = $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"));
    public SelenideElement buttonSearchLanguage = $(AppiumBy.id("org.wikipedia.alpha:id/search_lang_button"));
    public ElementsCollection languagesList = $$(AppiumBy.id("org.wikipedia.alpha:id/localized_language_name"));

    @Step("Вводим в строке поиска {searchItem}")
    public SearchPage setSearchInput(String searchItem) {
        searchInput.sendKeys(searchItem);
        return this;
    }

    @Step("Результатов поиска больше чем 1")
    public void checkSearchResults() {
        titleResultsList.shouldHave(CollectionCondition.sizeGreaterThan(1));
    }

    @Step("Результат поиска содержит значение {testData}")
    public void checkItem(String testData) {
        titleResult.shouldHave(text(testData));
    }

    @Step("Меняем язык на {testData}")
    public void changeLanguage(String testData) {
        buttonSearchLanguage.click();
        languagesList.findBy(text(testData)).click();
    }
}