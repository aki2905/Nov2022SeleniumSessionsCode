package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest {

	public static void main(String[] args) {
		
		
		String browserName ="chrome";
		
		BrowserUtil brUtil = new BrowserUtil();
		
		WebDriver mydriver = brUtil.initDriver(browserName);
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		//by locators : Object Respository
		By firstName= By.id("input-firstname");
		By lastName= By.id("input-lastname");
		By email= By.id("input-email");
		By telephone= By.id("input-telephone");
		By password= By.id("input-password");
		By confirmPassword= By.id("input-confirm");
		
		
		ElementUtil eleUtil = new ElementUtil(mydriver);
		eleUtil.doSendKeys(firstName, "Amrita");
		eleUtil.doSendKeys(lastName, "Arora");
		eleUtil.doSendKeys(email, "amrita@gmail.com");
		eleUtil.doSendKeys(telephone, "986127889");
		eleUtil.doSendKeys(password, "Amrita@123");
		eleUtil.doSendKeys(confirmPassword, "Amrita@123");
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
