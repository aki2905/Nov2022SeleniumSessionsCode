package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefExceptionWithFEs {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		Thread.sleep(5000);
		
		
	List<WebElement> linksFreshWorksList =	driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a")); //v1
	int linksize= linksFreshWorksList.size();
	System.out.println(linksize);
	
	
	
	for(int i=0; i< linksFreshWorksList.size();i++) {
	     linksFreshWorksList.get(i).click();//v1 //StaleElementReferenceException
	     String url= driver.getCurrentUrl();
	     System.out.println(url);
	     //v2 dom
	     //v3 dom
	     //v4 dom
	     linksFreshWorksList =	driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));//v2 v3 v4
	}
		
		

	}

}
