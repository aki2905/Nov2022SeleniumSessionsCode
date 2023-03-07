package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAttribute {

static WebDriver driver;
	

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		By links = By.tagName("a");
		By images = By.tagName("img");
		
		
//		List<WebElement>linksList = getElements(links);
//		System.out.println("total no.of links ==>" + linksList.size());
//		
//		for(WebElement e: linksList) {
//			String hrefVal = e.getAttribute("href");
//			String linkText = e.getText();
//		System.out.println(hrefVal+ "===>"+ linkText);
//			
//		}
		
//		List<WebElement>imgList = getElements(images);
//		System.out.println("total no.of images ==>"+ imgList.size());
//		
//		for (WebElement e: imgList) {
//			String srcVal = e.getAttribute("src");
//			System.out.println(srcVal);
//		}
		
		getElementArributes(images, "src");
		getElementArributes( links, "href");
		
		

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	
	public static void getElementArributes(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		for(WebElement e: eleList) {
			String attrVal = e.getAttribute(attrName);
			System.out.println(attrVal);
		}
				
	}

}

