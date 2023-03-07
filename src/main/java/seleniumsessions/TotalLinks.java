package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();

		// find all the links on the page
		List<WebElement> linkList = driver.findElements(By.tagName("a"));

		// print the total links count
		// and avoid the blank text

		int NumberofLinks = linkList.size();
		System.out.println("Total Links count" + linkList.size());

		// print the text of each link : For Loop
		for (int i = 0; i < NumberofLinks; i++) {
			String text = linkList.get(i).getText();
			// System.out.println(i + ":" +text);
			if (text.length() > 0) {
				System.out.println(i + ":" + text);
			}
			// System.out.println(i);

//			if(text.length()==0) {
//				System.out.println(i + ":" + text);
//			}
			int count =0;
			if(text.length()==0) {
				count ++;
			}
			System.out.println(count);

		}

	}

	// ???? get total blank links count ??? = assignmnent

	// print the text of each link : For Each Loop

//		int count = 0;
//		for (WebElement e:linkList ) {
//				String text = e.getText();
//			 if(text.length()>0) {
//				 System.out.println(count +":"+ text );
//			 }
//			count ++;
//		}

}
