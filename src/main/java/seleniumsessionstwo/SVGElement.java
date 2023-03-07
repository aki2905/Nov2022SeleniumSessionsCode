package seleniumsessionstwo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map");

		String state = "Florida";

//		California
//		Florida
//		New York
//		Maryland		

		Thread.sleep(4000);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));

		String svgXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='path']";

		List<WebElement> statesList = driver.findElements(By.xpath(svgXpath));

		System.out.println(statesList.size());
		Actions act = new Actions(driver);

		for (WebElement e : statesList) {

			String stateName = e.getAttribute("name");
			System.out.println(stateName);

			if (stateName.equals(state)) {
				Thread.sleep(2000);

				if (state.equals("Florida")) {
					int x = e.getSize().getWidth();
					int y = e.getSize().getHeight();
					// System.out.println(x + " : " + y);
					act.moveToElement(e, (x / 2) - 40, 0).click().build().perform();
				} else {
					e.click();
				}
				break;

			}

		}

	}

}