package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcepts {

	static WebDriver driver;

	public static void main(String[] args) {

		// create a webelement + perform action (click, sendKeys, gettext,
		// isDisplayed....)

		// create a webelement: need a locator

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// 1. id
		// 1st type
//		driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("naveen@123");

		// 2nd type
//		WebElement emailID = driver.findElement(By.id("input-email"));
//  	WebElement password = driver.findElement(By.id("input-password"));

//		emailID.sendKeys("naveen@gmail.com");
//	    password.sendKeys("naveen@123");

		// 3rd type: By locator
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement eId = driver.findElement(email);
//		WebElement pwd = driver.findElement(password);
//		
//		eId.sendKeys("naveen@gmail.com");
//		pwd.sendKeys("naveen@123");
//		

		// 4th type: By locator + creating a generic method
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(emailId).sendKeys("naveen@gmail.com");
//		getElement(password).sendKeys("naveen@123");
		
		
		//5th type: By locator + generic methods for Webelements and actions
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(emailId, "naveen@gmail.com");
//		doSendKeys(password, "naveen@123");
		
		//6th type: By locator + generic methods for Webelements and actions in ElementUtil class
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailId, "naveen@gmail.com");
		eleUtil.doSendKeys(password, "naveen@123");
		
	}}

//	public static WebElement getElement(By locator) {
//		return driver.findElement(locator);
//
//	}
//
//	public static void doSendKeys(By locator, String value) {
//		getElement(locator).sendKeys(value);
//	}
//}
