package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement search = $(AppiumBy.accessibilityId("Search Wikipedia"));

    @Step("Нажимаем кнопку поиска")
    public MainPage clickSearch() {
        search.click();
        return this;
    }
}
