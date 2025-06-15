package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	By sighnbutton = By.xpath("//a[contains(text(), 'Sign In')]");
	By user_name = By.id("email");
	By password = By.id("pass");
	By  Loginbutton = By.id("send2");
	 By topHeader = By.cssSelector(".panel.header");
	    By welcomeUser = By.xpath("//div[contains(@class, 'panel header')]//span[contains(text(),'Welcome')]");
	    By logo = By.cssSelector(".logo");
	    By cartIcon = By.cssSelector("a.action.showcart");
	    By loginErrorMsg = By.cssSelector("div.message-error div");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void  login (String username,String Pass) {
		driver.findElement(sighnbutton).click();
		driver.findElement(user_name).sendKeys(username);
		driver.findElement(password).sendKeys(Pass);
		driver.findElement(Loginbutton).click();
	}
	public void validatePhoneLoginOption() {
        List<WebElement> phoneFields = driver.findElements(By.xpath("//input[contains(@type, 'tel') or contains(@name, 'phone')]"));
        if (phoneFields.isEmpty()) {
            System.out.println("Phone number login option is missing.");
        } else {
            System.out.println("Phone number login option is available.");
        }
    }
	public void validateHeaderStructureAfterLogin() {
       
        if (driver.findElements(topHeader).isEmpty() || driver.findElements(welcomeUser).isEmpty()) {
            System.out.println("Top header or 'Welcome User' text is missing.");
        } else {
            System.out.println("Top header and 'Welcome' message are present.");
        }

        
        if (driver.findElements(logo).isEmpty()) {
            System.out.println("Logo is missing in header.");
        } else {
            System.out.println("Logo is present in header.");
        }

        
        if (driver.findElements(cartIcon).isEmpty()) {
            System.out.println("Cart icon is missing in header.");
        } else {
            System.out.println("Cart icon is present in header.");
        }
    }
	public String getLoginErrorMessage() {
		try {
			WebElement errorMsg = driver.findElement(loginErrorMsg);
			return errorMsg.getText().trim();
		} catch (Exception e) {
			return "No error message displayed.";
		}
	}
}
