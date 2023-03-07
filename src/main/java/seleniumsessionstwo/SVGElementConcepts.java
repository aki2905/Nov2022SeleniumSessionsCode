package seleniumsessionstwo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElementConcepts {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map");
		driver.manage().window().maximize();

		Thread.sleep(4000);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));

		String svgXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='path']";

		List<WebElement> statesList = driver.findElements(By.xpath(svgXpath));

		System.out.println(statesList.size());

		for (WebElement e : statesList) {

			String stateName = e.getAttribute("name");
			System.out.println(stateName);

			if (stateName.equals("Texas")) {
				e.click();
				break;
			}

//				String svgXpath1 = "//*[local-name()='svg'  and @id='map-svg']//*[name()='g' and @id='texas']//*[name()='g' and @class='subregion']//*[name()='path']";
//				
//				List<WebElement> statesList2 = driver.findElements(By.xpath(svgXpath1));
//				
//				//System.out.println(statesList2.size());
//				
//				for(WebElement e1 : statesList2) {
//					
//					String stateName2 = e1.getAttribute("name");
//					System.out.println(stateName2);
//		}

		}
	}

	// *[local-name()='svg']//*[name()='g' and @fill-rule='evenodd']

	public static void createUser(String name) {
		String xpath = "//input[contains(text()='" + name + "')]";
		xpath = xpath.replaceAll("name", "name");
	}

}