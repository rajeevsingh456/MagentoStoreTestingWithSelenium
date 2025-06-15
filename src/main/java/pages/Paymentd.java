package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Paymentd {
	
	
	WebDriver driver;
	
	By PlaceOrder = By.xpath("//button[@class=\"action primary checkout\"]");
	public Paymentd(WebDriver driver) {
	    this.driver = driver;
	}
	public void verifyMissingPaymentMethods() throws InterruptedException {
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    Thread.sleep(3000); 
	    
	    try {
	        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-role='opc-continue']")));
	        nextButton.click();
	    } catch (Exception e) {
	        System.out.println("Nextbutton not found or already clicked.");
	    }

	    
	    Thread.sleep(3000);

	 
	    By paymentSection = By.xpath("//div[@id='checkout-payment-method-load']");
	    By codOption = By.xpath("//*[contains(text(),'Cash on Delivery')]");
	    By placeOrderButton = By.xpath("//button[@title='Place Order']");

	    boolean isPaymentSectionVisible = driver.findElements(paymentSection).size() > 0;
	    boolean isCODVisible = driver.findElements(codOption).size() > 0;
	    boolean isPlaceOrderVisible = driver.findElements(placeOrderButton).size() > 0;

	
	    System.out.println("Payment Section Visible: " + isPaymentSectionVisible);
	    System.out.println("COD Option Visible: " + isCODVisible);
	    System.out.println("Place Order Button Visible: " + isPlaceOrderVisible);

	   
	    if (!isPaymentSectionVisible && !isCODVisible && isPlaceOrderVisible) {
	        System.out.println("Payment methods are missing, but 'Place Order' button is visible.");
	    } else {
	        System.out.println("Payment methods are shown not show .");
	    }
	    driver.findElement(PlaceOrder).click();

	
	 Thread.sleep(3000); 



	    try {
	        // Only log the main confirmation message, ignore order number
	        WebElement confirmationMessage = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".checkout-success p:nth-of-type(1)"))
	        );
	        System.out.println("Thank you for your purchase!");
	        System.out.println("✅ " + confirmationMessage.getText());
	        
	    } catch (Exception e) {
	        System.out.println("❌ Order confirmation message not found.");
	    }
	}
	

}
