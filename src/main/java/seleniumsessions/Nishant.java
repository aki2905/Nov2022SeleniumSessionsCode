package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nishant {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div")).click();
		
		WebElement search= driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		search.click();
		WebElement suggestions=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/ul/li[9]/div[1]/div[2]/div[1]"));
		System.out.println(""+suggestions);
		
		driver.close();
		
		
		//

	}

}
