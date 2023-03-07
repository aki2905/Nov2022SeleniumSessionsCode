package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		// find all the images on the page
		List<WebElement> imgList = driver.findElements(By.tagName("img"));

		int NumberOfImage = imgList.size();
		System.out.println("Total count of image: " + NumberOfImage);

		// if we give wrong tag name such as img11, it will give size 0 or we can say
		// empty list

//		List<WebElement> imgList1 = driver.findElements(By.tagName("img11"));
//
//		int NumberOfImage1 = imgList.size();
//		System.out.println("Total count of image: " + NumberOfImage);

	}
	
	
	//Note the difference:
	
	//FindElement   vs           FindElements
	//WebElement                 List<WebElement>
	//NoSuchElementException     empty list -> size is 0
	//Any action- performed      No action performed
}
