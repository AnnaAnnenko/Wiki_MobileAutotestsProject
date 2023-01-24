package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.SearchPage;

public class SearchTests extends TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Test
    public void checkResultsHasItems() {
        mainPage.clickSearch();
        searchPage.setSearchInput("Java");
        searchPage.checkSearchResults();
    }

    @ValueSource(strings = {"Java", "Jira"})
    @ParameterizedTest(name = "Проверка для значения {0}")
    public void mainSearch(String testData) {
        mainPage.clickSearch();
        searchPage.setSearchInput(testData);
        searchPage.checkItem(testData);
    }

    @Test
    public void changeLanguageAndCheckResults() {
        mainPage.clickSearch();
        searchPage.setSearchInput("Slovakia").changeLanguage("Svenska");
        searchPage.checkItem("Slovakien");
    }
}