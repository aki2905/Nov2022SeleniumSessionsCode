package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		Thread.sleep(4000);

		driver.findElement(By.name("username")).sendKeys("newautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(4000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();

		Thread.sleep(4000);

		selectUser("deepti gupta");
		selectUser("Ali khan");

		String cName = getUserCompanyName("Ali khan");
		System.out.println(cName);

		cName = getUserCompanyName("deepti gupta");
		System.out.println(cName);

		cName = getUserCompanyName("Romi singh");
		System.out.println(cName);
		
		String phNumber = getUserPhoneNumber ("Ali khan");
		System.out.println(phNumber);
		
		String phNumber2 = getUserPhoneNumber ("Romi singh");
		System.out.println(phNumber2);
		
		String homePhNum1 = getUserHomePhoneNumber("deepti gupta");
		System.out.println(homePhNum1);
		
		String homePhNum2 = getUserHomePhoneNumber("Romi singh");
		System.out.println(homePhNum2);
		
		String mobile1 = getUserMobile("Ali khan");
		System.out.println(mobile1);
		
		String mobile2 = getUserMobile("Romi singh");
		System.out.println(mobile2);

	}

	//// a[text()='deepti
	//// gupta']/parent::td/preceding-sibling::td/input[@type='checkbox']
	public static void selectUser(String userName) {
		driver.findElement(By.xpath("//a[text()='" + userName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();

	}

	// a[text()='Ali khan']/parent::td/following-sibling::td/a[@context='company']
	public static String getUserCompanyName(String userName) {
		return driver.findElement(By.xpath("//a[text()='" + userName + "']/parent::td/following-sibling::td/a[@context='company']"))
				.getText();
	}

	
// 	(//a[text()='Ali khan']/parent::td/following-sibling::td/span[@context='phone'])[position()=1]
	public static String getUserPhoneNumber(String userName) {
		return driver.findElement(By.xpath("(//a[text()='"+ userName +"']/parent::td/following-sibling::td/span[@context='phone'])[position()=1]"))
				.getText();
	}	
	
//	(//a[text()='Ali khan']/parent::td/following-sibling::td/span[@context='phone'])[position()=2]
	public static String getUserHomePhoneNumber(String userName) {
		return driver.findElement(By.xpath("(//a[text()='"+ userName +"']/parent::td/following-sibling::td/span[@context='phone'])[position()=2]"))
				.getText();
	}	
	
//	(//a[text()='Ali khan']/parent::td/following-sibling::td/span[@context='phone'])[position()=3]
	public static String getUserMobile(String userName) {
		return driver.findElement(By.xpath("(//a[text()='"+ userName +"']/parent::td/following-sibling::td/span[@context='phone'])[position()=3]"))
				.getText();
	}	
	
}
