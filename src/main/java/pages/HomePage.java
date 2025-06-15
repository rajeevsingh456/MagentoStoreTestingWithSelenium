package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By currencyElements = By.xpath("//select[contains(@id,'currency') or contains(@class,'currency')]");
    By languageElements = By.xpath("//select[contains(@id,'language') or contains(@class,'language')]");
    By searchBar = By.id("search");

    public void validateCurrencyAndLanguageSelectors() {
        boolean isCurrencyPresent = !driver.findElements(currencyElements).isEmpty();
        boolean isLanguagePresent = !driver.findElements(languageElements).isEmpty();

        if (!isCurrencyPresent && !isLanguagePresent) {
            System.out.println("No Currency or Language switcher found. This may confuse non-US users.");
        } else {
            System.out.println("Currency or Language switcher is present.");
        }
    }

    public void validateEmptySearchBar() throws InterruptedException {
        WebElement searchBox = driver.findElement(searchBar);
        searchBox.clear();
        searchBox.submit();
        Thread.sleep(2000);

        String bodyText = driver.findElement(By.tagName("body")).getText().toLowerCase();

        if (bodyText.contains("enter") || bodyText.contains("required") || bodyText.contains("please")) {
            System.out.println("Search input validation is working correctly.");
        } else {
            System.out.println("No validation message shown for empty search input.");
        }
    }
}



