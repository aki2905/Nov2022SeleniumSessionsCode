package seleniumsessionstwo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CostcoTest {
	static WebDriver driver;

	// 2. multi level menu items

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://www.costco.com/");
		By shopByCat = By.id("navigation-dropdown");
		multiLevelMenuHandling(shopByCat, "Baby", "Baby Care & Safety", "Baby Monitors");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void multiLevelMenuHandling(By parentMenu, String l1, String l2, String l3)
			throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).click().build().perform();

		WebElement l2Ele = driver.findElement(By.xpath("//a[text()='Baby']/parent::li"));
		Action action = act.moveToElement(l2Ele).moveToElement(l2Ele).build();
		action.perform();

		Thread.sleep(1500);

		Action action1 = act.moveToElement(driver.findElement(By.xpath("//a[text()='Baby Care & Safety']/parent::li")))
				.build();
		action1.perform();

		Thread.sleep(1500);

		driver.findElement(By.linkText(l3)).click();
	}

}