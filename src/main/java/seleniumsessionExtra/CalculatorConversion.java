package seleniumsessionExtra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorConversion {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.calculator.net/conversion-calculator.html.");

		driver.manage().window().maximize();
		
		System.out.println("User is able to launch the application");
		Thread.sleep(3000);

		WebElement TempTab = driver.findElement(By.xpath("//a[text()='Temperature']"));
		WebElement FromBox = driver.findElement(By.xpath("//input[@name='fromVal']"));
		WebElement ToBox = driver.findElement(By.xpath("//div[@class='panel2']//input[@type='text' and @name='toVal']"));
		WebElement ToBox1 = driver.findElement(By.cssSelector("td input[name='toVal']"));
		WebElement ToDropdown = driver.findElement(By.xpath("//div[@class='panel2']//select[@name='calTo']//option[@value='3']"));
		//WebElement Result = driver.findElement(By.xpath("//b[text()='Result:']"));
		WebElement fcResult = driver.findElement(By.xpath("//div[@id='fcresult']"));

		
		
		
		TempTab.click();
		System.out.println("User is able to click on the Temperature tab");
		
		Thread.sleep(3000);
		
		//ToDropdown.click();
		
		FromBox.sendKeys("4");
		
		String ResultInTo= ToBox.getText();
		System.out.println("The result after converting is:" + ResultInTo);
		
		String FinalResult=fcResult.getText();
		System.out.println(FinalResult);

	
	
		

	}

}
