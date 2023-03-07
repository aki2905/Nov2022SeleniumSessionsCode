package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		//1. open the browser : chrome, ff, edge
		//ChromeDriver driver = new ChromeDriver();
		
		String browser = "chrome";
		WebDriver driver = null;
		
		//cross browser logic
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equals("safari")) {
			driver = new SafariDriver();
		}
		else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("plz pass the right browser...." + browser);
		}
		
	
		
		
		
		//2. enter the URL:
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//div[text()='Accept all']")).click();
		
		
		//3. get the title:
		String actTitle = driver.getTitle();
		System.out.println("page title is : "+ actTitle );
		
		//validation point or checkpoint:
		if(actTitle.equals("Google")) {
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Automation steps + validation/assertions = Automation testing
		
		
		//close the browser:
		driver.quit(); 
		
		
		
		
		

	}

}
