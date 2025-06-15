package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SighUp {
	
	WebDriver driver;
	By sighnbutton = By.xpath("//a[contains(text(), 'Sign In')]");
By createAcc = By.xpath("//a[@class=\"action create primary\"]");
   By first_Name = By.id("firstname");
   By  Last_Name = By.id("lastname");
   By  Emailadd = By.id("email_address");
   By PPassword = By.id("password");
   By confirmPasword = By.id("password-confirmation");
   By accountcrt = By.xpath("//button[@class=\"action submit primary\"]");
   
   public SighUp(WebDriver driver) {
	    this.driver = driver;
	}

   
   public void CreateNewAcc(String Fname ,String Lname,String email,String passw,String Cpassword) throws InterruptedException {
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.findElement(sighnbutton).click();
	   driver.findElement(createAcc).click();
	   driver.findElement(first_Name).sendKeys(Fname);
	   driver.findElement(Last_Name).sendKeys(Lname);
	   driver.findElement(Emailadd).sendKeys(email);
	   driver.findElement(PPassword).sendKeys(passw);
	   driver.findElement(confirmPasword).sendKeys(Cpassword);
	   Thread.sleep(3000);
	   driver.findElement(accountcrt).click();
	   Thread.sleep(2000); 
	   if (driver.findElements(By.xpath("//div[contains(text(), 'There is already an account with this email address')]")).size() > 0) {
	       String msg = driver.findElement(By.xpath("//div[contains(text(), 'There is already an account with this email address')]")).getText();
	       System.out.println(msg);  // ✅ This prints the full message in your console
	   }
	   
	   if (driver.findElements(By.id("email_address-error")).size() > 0) {
		    String emailError = driver.findElement(By.id("email_address-error")).getText();
		    System.out.println("Email Error: " + emailError);
		}
   }
	   
   }
	   
   
