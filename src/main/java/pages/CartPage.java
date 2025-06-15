package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;

	By SearchBar = By.id("search");
	 By product = By.xpath("//span[@class='qs-option-name' and contains(text(),'Radiant Tee')]");

	 By firstProductContainer = By.cssSelector("li.product-item:first-child");
	    By addToCartButtonOnHover = By.cssSelector("li.product-item:first-child button[title='Add to Cart']");
         By productSize = By.id("option-label-size-143-item-167");
         By productColor = By.id("option-label-color-93-item-50");
         By ProductQTY = By.id("qty");
         By AddTOCART = By.id("product-addtocart-button");
	public CartPage(WebDriver driver) {
		this.driver = driver;
	
	}
	
	
	public void cart() throws InterruptedException {
		 driver.get("https://magento.softwaretestingboard.com/");
		    Thread.sleep(2000);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Actions actions = new Actions(driver);

	   
	    wait.until(ExpectedConditions.elementToBeClickable(SearchBar)).click();
	    driver.findElement(SearchBar).sendKeys("Radiant Tee");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(product)).click();

	    
	    WebElement productContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductContainer));
	    actions.moveToElement(productContainer).perform();
	    Thread.sleep(1000); 

	  
	    WebElement hoverAddButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonOnHover));
	    hoverAddButton.click();
	    Thread.sleep(2000);

	   
	    WebElement size = wait.until(ExpectedConditions.elementToBeClickable(productSize));
	    size.click();

	   
	    WebElement color = wait.until(ExpectedConditions.elementToBeClickable(productColor));
	    color.click();

	   
	    WebElement qty = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductQTY));
	    qty.clear();
	    qty.sendKeys("2");

	 
	    WebElement finalAddToCart = wait.until(ExpectedConditions.elementToBeClickable(AddTOCART));
	    finalAddToCart.click();

	    Thread.sleep(3000); 

	    System.out.println("Product added to cart successfully.");
	}



}
