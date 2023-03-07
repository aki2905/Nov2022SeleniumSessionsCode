package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTagDropdowHandle {
	
	static WebDriver driver;
	
    public static void main(String[] args) throws InterruptedException {
    	
    	driver = new ChromeDriver();
    	driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");

    		
    	
    	//dropdown --htmltag ==> <select>
    	//use Select class in Selenium
    	
//    	WebElement country_ele = driver.findElement(country);
//    	Select select = new Select(country_ele);
    	
    	//Select options we have below as: 
    	//select.selectByIndex(5);
    	//select.selectByValue("India"); //value=attribute
    	//select.selectByVisibleText("Belgium"); //text of the option
    	
    	By country = By.id("Form_getForm_Country");
    	doSelectDropdownByIndex(country,10);
    	Thread.sleep(2000);
    	doSelectDropdownByValue(country, "India");
    	Thread.sleep(2000);
    	doSelectDropdownByVisibleText(country, "Belgium");
    	
	}

    
    public static WebElement  getElement(By locator) {
    	return driver.findElement(locator);
    }
    
    public static void doSelectDropdownByIndex(By locator, int index) {
    	Select select = new Select(getElement(locator));
    	select.selectByIndex(index); 
    }
    public static void doSelectDropdownByValue(By locator, String value) {
    	Select select = new Select(getElement(locator));
    	select.selectByValue(value); 
    }
    
    public static void doSelectDropdownByVisibleText(By locator, String text) {
    	Select select = new Select(getElement(locator));
    	select.selectByValue(text); 
    }
    
}
