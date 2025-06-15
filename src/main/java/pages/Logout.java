package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Logout {

    WebDriver driver;

    // Locators
    By accountDropdown = By.cssSelector(".customer-welcome");
    By signOutLink = By.xpath("//a[contains(text(),'Sign Out') or contains(text(),'Log Out')]");
    By logoutMessage = By.cssSelector(".message-success.success.message");

    public Logout(WebDriver driver) {
        this.driver = driver;
    }

    public void performLogout() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(accountDropdown));
        dropdown.click();
        WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable(signOutLink));
        signOut.click();
 System.out.println( "You have signed out and will go to our homepage in 5 seconds.");
    }

}


