package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJSPopup {

	public static void main(String[] args) throws InterruptedException {
		
		//js alert - alert, prompt, confirmation pop-up
		//auth pop up
		//browser window pop-up, advertisement pop-up
		//file upload pop-up
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		
//		Thread.sleep(3000);
//		
//		Alert alert= driver.switchTo().alert();
//		String textAlert= alert.getText();
//		System.out.println(textAlert);
//		
//		alert.accept();
//		//alert.dismiss();
		
		
//		//confirm
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Thread.sleep(3000);
//		Alert alert= driver.switchTo().alert();
//		String textAlert = alert.getText();
//		System.out.println(textAlert);
//		alert.accept();  //Click on OK
//		//alert.dismiss(); //click on Cancel
		
		
		//prompt
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		Alert alert= driver.switchTo().alert();
		String enterText = "I am a girl";
		alert.sendKeys(enterText);
		alert.accept();
		
		
		String textResult= driver.findElement(By.xpath("//h4//following-sibling::p")).getText();
		System.out.println("Actual text result is: " + textResult);
		
	    String expectedResult = "You entered: "+enterText;
	    System.out.println("Expected result is: " +expectedResult);
	    
	    if (expectedResult.equals(textResult)) {
	    	System.out.println("PASS");
	    }else
	    	System.out.println("FAIL");
	    		
	    		
		
		
		
		
		
		 
		

	}

}
