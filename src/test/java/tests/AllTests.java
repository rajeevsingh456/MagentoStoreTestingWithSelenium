package tests;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.Logout;
import pages.Paymentd;
import pages.SighUp;

public class AllTests {
	
	WebDriver driver;
    LoginPage loginPage;
    CartPage  cartpage;
    CheckoutPage checkoutpage;
    HomePage homePage;
    Paymentd  paymentpage;
    SighUp signupPage;
    Logout logout;

    
    @BeforeClass
public void setup() {
    	
	driver = new ChromeDriver();
	driver.get("https://magento.softwaretestingboard.com/#contentarea");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	loginPage = new LoginPage(driver);
	cartpage = new CartPage(driver);
	checkoutpage = new CheckoutPage(driver);
	homePage = new HomePage(driver);
	paymentpage = new Paymentd(driver);
	signupPage = new SighUp(driver);
	logout = new Logout(driver);
}
    @Test(priority = 0)
    public void verifyCurrencyAndLanguageSelectors() throws InterruptedException {
    	  homePage.validateCurrencyAndLanguageSelectors();
    	    homePage.validateEmptySearchBar();
    }
    @Test(priority = 1)
    public void testSignUpNegativeScenarios() throws InterruptedException {
		
		signupPage.CreateNewAcc("Rajeev", "Singh", "wrong-email", "Pass1234", "Pass1234");
		Assert.assertEquals(driver.findElement(By.id("email_address-error")).getText(),
				"Please enter a valid email address (Ex: johndoe@domain.com).");
		Thread.sleep(3000);

		
		signupPage.CreateNewAcc("Rajeev", "Singh", "sachinsingh63927478852@gmail.com", "@Devil1234", "@Devil1234");
		Thread.sleep(3000);
	}

    @Test(priority = 2)
public void testLogin() throws InterruptedException {
    	loginPage.validatePhoneLoginOption();
    	loginPage.login("invaliduser@example.com", "wrongpassword");
        String actualMessage = loginPage.getLoginErrorMessage();
        System.out.println("Login Error Message: " + actualMessage);
        Assert.assertEquals(actualMessage, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
        Thread.sleep(3000);
	    loginPage.login("Sachinsingh6392747885@gmail.com","@Devil1234");
	    loginPage.validateHeaderStructureAfterLogin();
	     Thread.sleep(4000);
	
}
    
    
    @Test(priority = 3)
    public void addcart() throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	cartpage.cart();
    	Thread.sleep(4000);
    }
    @Test(priority = 4)
    public void update_Cart() throws InterruptedException {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	 checkoutpage.checkout();
    	 Thread.sleep(4000);
    }
    
    @Test(priority = 5)
    public void  Payment_page() throws InterruptedException {
    	paymentpage.verifyMissingPaymentMethods();
    }
    @Test(priority = 6)
    public void logoutPage() throws InterruptedException {
    	logout.performLogout();
    }
    
@AfterClass
public void teardawon() {
	driver.quit();
}
}
