
package seleniumassesment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EcommercePageFunctionality extends AssesmentEcommerce {
	static WebDriver driver;

	public void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
	}

	public void launchURLtest() {
		String ActualURL = driver.getCurrentUrl();
		String ExpectedURL = "https://www.amazon.com/";
		System.out.println("User is able to launch the URL and it is:" + ActualURL);
		Assert.assertEquals(ActualURL, ExpectedURL);
	}

	public void clickSearchBar() throws InterruptedException {
		WebElement SearchBar = driver.findElement(By.xpath("//input[@type='text']"));
		SearchBar.sendKeys("Iphone");
		Thread.sleep(3000);
		System.out.println("User is able to click on Search Bar");
	}

	public void searchProdouct() throws InterruptedException {
		WebElement SubmitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		SubmitBtn.click();
		Thread.sleep(3000);
		System.out.println("User is able to search the Product");
	}

	public void shopByCategory() throws InterruptedException {
		List<WebElement> shopByCatProd = driver.findElements(By.xpath("//div[@class='a-row a-color-base']//a"));
		System.out.println("The size is " + shopByCatProd.size());

		for (WebElement e : shopByCatProd) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("slider")) {
				e.click();
				break;
			}
			Thread.sleep(3000);
		}
		System.out.println("User is able to click");
	}

	public void searchProdouctByBrand() throws InterruptedException {
		List<WebElement> PrdBrandList = driver.findElements(By.xpath(
				"//span[text()='Brands']/parent::div/following-sibling::ul//a/div//label//input[@type='checkbox']"));
		for (WebElement e : PrdBrandList) {
			String text = e.getText();
			System.out.println(text);
		}
		// Thread.sleep(3000);
		/*
		 * if (text.equals("slider")) { e.click(); break; }
		 */
	}

	
	public void tearDown() {
		// driver.quit();
	}
}