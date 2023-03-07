package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefExceptionConcept {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");//DOM v1
		
		WebElement email = driver.findElement(By.id("input-email"));//v1
		email.sendKeys("naveen@gmail.com");//v1
		
		driver.navigate().refresh();//DOM v2
		Thread.sleep(5000);
		
		email.sendKeys("gurjit@gmail.com"); //StaleElementReferenceException
		
		//It is important to create the web element once again for and then use Send keys as below:
		email = driver.findElement(By.id("input-email"));
		email.sendKeys("gurjit@gmail.com");
	}

}
