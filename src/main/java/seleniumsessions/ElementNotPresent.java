package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementNotPresent {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By logoImage = By.className("img-responsive11");
		By search = By.name("search");
		
		//create webElement + perform action
		boolean flagImg= driver.findElement(logoImage).isDisplayed();//NoSuchElementException
		System.out.println(flagImg);
		
		//FindElement: throw NoSuchElementException
		
		
		
		
	}
	

}
