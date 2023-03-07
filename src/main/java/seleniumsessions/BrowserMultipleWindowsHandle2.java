package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMultipleWindowsHandle2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(3000);

		WebElement twEle = driver.findElement(By.xpath("//a[contains(@href,'twitter')]"));
		WebElement fbEle = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
		WebElement ytEle = driver.findElement(By.xpath("//a[contains(@href,'youtube')]"));
		WebElement liEle = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));

		// Clicking on Twitter link:
		twEle.click();

		// get the window ids for parent window
		Set<String> handles1 = driver.getWindowHandles();

		Iterator<String> it1 = handles1.iterator();

		String parentWindowId1 = it1.next();
		System.out.println("parent window id : " + parentWindowId1);

		// get the window ids for child Twitter window
		String childWindowIdTwit = it1.next();
		System.out.println("Twitter child window id : " + childWindowIdTwit);

		// switching to Childwindow:
		driver.switchTo().window(childWindowIdTwit);
		System.out.println("Twitter child window url : " + driver.getCurrentUrl());

		Thread.sleep(3000);

		driver.close();// close the child window

		driver.switchTo().window(parentWindowId1);
		System.out.println("parent window url : " + driver.getCurrentUrl());

		// ======================================================================================

		// Clicking on Facebook link:
		fbEle.click();

		// get the window ids for parent window
		Set<String> handles2 = driver.getWindowHandles();

		Iterator<String> it2 = handles2.iterator();

		String parentWindowId2 = it2.next();
		System.out.println("parent window id : " + parentWindowId2);

		// get the window ids for child Twitter window
		String childWindowIdFb = it2.next();
		System.out.println("Facebook child window id : " + childWindowIdFb);

		// switching to window:
		driver.switchTo().window(childWindowIdFb);
		System.out.println("Facebook child window url : " + driver.getCurrentUrl());

		Thread.sleep(3000);

		driver.close();// close the child window

		driver.switchTo().window(parentWindowId2);
		System.out.println("parent window url : " + driver.getCurrentUrl());

		// ======================================================================================

		// Clicking on Youtube link:
		ytEle.click();

		// get the window ids for parent window
		Set<String> handles3 = driver.getWindowHandles();

		Iterator<String> it3 = handles3.iterator();

		String parentWindowId3 = it3.next();
		System.out.println("parent window id : " + parentWindowId3);

		// get the window ids for child Twitter window
		String childWindowIdYt = it3.next();
		System.out.println("YouTube child window id : " + childWindowIdYt);

		// switching to window:
		driver.switchTo().window(childWindowIdYt);
		System.out.println("YouTube child window url : " + driver.getCurrentUrl());

		Thread.sleep(3000);

		driver.close();// close the child window

		driver.switchTo().window(parentWindowId3);
		System.out.println("parent window url : " + driver.getCurrentUrl());

		// ======================================================================================

		// Clicking on LinkedIn link:
		liEle.click();

		// get the window ids for parent window
		Set<String> handles4 = driver.getWindowHandles();

		Iterator<String> it4 = handles4.iterator();

		String parentWindowId4 = it4.next();
		System.out.println("parent window id : " + parentWindowId4);

		// get the window ids for child Twitter window
		String childWindowIdLIn = it4.next();
		System.out.println("LinkedIn child window id : " + childWindowIdLIn);

		// switching to window:
		driver.switchTo().window(childWindowIdLIn);
		System.out.println("LinkedIn child window url : " + driver.getCurrentUrl());

		Thread.sleep(3000);

		driver.close();// close the child window

		driver.switchTo().window(parentWindowId4);
		System.out.println("parent window url : " + driver.getCurrentUrl());
		
		//Finally quitting the main browser (OrangeHRM)
		driver.quit();

	}
}
