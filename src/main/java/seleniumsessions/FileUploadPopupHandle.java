package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopupHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		Thread.sleep(3000);

		driver.findElement(By.name("upfile")).sendKeys("D:\\PracticeSelenium\\sampletest.txt");
		
		//<tag type="file"> -- this is mandatory attribute
		
		//autoIT/Sikuli/Robot - not recommended 
		
	}
}
