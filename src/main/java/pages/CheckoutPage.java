package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
public class CheckoutPage {
	WebDriver driver;
	
	By Cart_Button = By.xpath("//div[@class=\"minicart-wrapper\"]");
	By Edit_Cart  = By.xpath("//span[contains(text(), 'View and Edit Cart')]");
	By  QTY_Change = By.cssSelector("input.input-text.qty");
	By Update_cart = By.xpath("//button[@class=\"action update\"]");
	By prCheckout = By.xpath("//button[@class=\"action primary checkout\"]");
	By New_add = By.xpath("//button[@class=\"action action-show-popup\"]");
    By First_Name = By.xpath("//input[@name='firstname']");
    By Last_Name = By.xpath("//input[@name='lastname']");
    By Company_Name = By.xpath("//input[@name='company']");
    By City_Name = By.xpath("//input[@name='city']");
    By Street_Name = By.xpath("//input[@name='street[0]']");
    By State_Name =  By.name("region_id");
    By Post_Code = By.xpath("//input[@name='postcode']");
    By Country = By.cssSelector("select.select[name='country_id']");
    
    By Phone_No = By.xpath("//input[@name='telephone']");
    By Save_add = By.id("shipping-save-in-address-book");
    By ShipHere = By.xpath("//button[@class=\"action primary action-save-address\"]");
   
    
	public CheckoutPage(WebDriver driver ) {
		this.driver=driver;
	}
 public void checkout () throws InterruptedException {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 
	 driver.findElement(Cart_Button).click();
	 driver.findElement(Edit_Cart).click();
	 driver.findElement(QTY_Change).clear();
	 driver.findElement(QTY_Change).sendKeys("5");
	 driver.findElement(Update_cart).click();
	 Thread.sleep(3000);
	 driver.findElement(prCheckout).click();
	 Thread.sleep(3000);
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));
	    WebElement newAddressButton = driver.findElement(New_add);
	    newAddressButton.click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(First_Name)).sendKeys("Sachin");;
	    WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Last_Name));
	    lastNameInput.sendKeys("Singh");

	    driver.findElement(Company_Name).sendKeys("Masai");
	    driver.findElement(Street_Name).sendKeys("Govindpuru gali no 5");
	    WebElement CountryDropdown = wait.until(ExpectedConditions.elementToBeClickable(Country));
	    Select selectC = new Select(CountryDropdown);
	    selectC.selectByVisibleText("India");
	    driver.findElement(City_Name).sendKeys("Noida");
	    WebElement stateDropdown = wait.until(ExpectedConditions.elementToBeClickable(State_Name));
	 
	    Select select = new Select(stateDropdown);
	    select.selectByVisibleText("Goa");
	    Thread.sleep(5000);
	    driver.findElement(Post_Code).sendKeys("110019");
	    driver.findElement(Phone_No).sendKeys("868686868");
	    WebElement checkbox = driver.findElement(Save_add);
	    if (!checkbox.isSelected()) {
	        checkbox.click();
	    }
	    
	    WebElement shipHereBtn = driver.findElement(ShipHere);
	    if (shipHereBtn.isDisplayed() && shipHereBtn.isEnabled()) {
	        System.out.println("Ship Here is visible and clickable. Attempting click...");
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", shipHereBtn);
	    } else {
	        System.out.println("Ship Here is not clickable or visible.");
	    }

	    try {
	    
	    	wait.until(ExpectedConditions.invisibilityOfElementLocated(New_add));
	        System.out.println("New Address' popup closed");
	    } catch (Exception e) {
	        System.out.println("Address popup did not close after clicking Ship Here");
	    }

	    Thread.sleep(3000);
	    
	    
 }
 
}
