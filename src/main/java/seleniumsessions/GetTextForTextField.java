package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextForTextField {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement fn = driver.findElement(By.id("input-firstname"));
		fn.sendKeys("naveen automation labs");
		
		String fname = fn.getAttribute("value"); //getting the value entered by the user
		System.out.println(fname);
		
		WebElement ln = driver.findElement(By.id("input-lastname"));
		String lname = ln.getAttribute("placeholder"); //getting the place holder value
		System.out.println(lname);
		
		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys(null);// will throw IllegalArgumentException -- Keys to send should be a not null CharSequence

	}

}
