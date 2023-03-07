package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http:/www.londonfreelance.org/courses/frames/index.html");
		Thread.sleep(3000);
		
		//int frameSize = driver.findElements(By.xpath("//frame")).size();
		
		int frameSize = driver.findElements(By.tagName("frame")).size();
		System.out.println(frameSize);
		
		//driver.switchTo().frame(2);  //type 1
		//driver.switchTo().frame("main"); //type 2
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']"))); //type 3
		
		String header = driver.findElement(By.tagName("h2")).getText();
		
		System.out.println(header);
		
		driver.switchTo().defaultContent();
		
		//frame
		//iframe - security of the web element
		//nested frame

	}

}
