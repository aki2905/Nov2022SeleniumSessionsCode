package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		// SID - session id

		WebDriver driver = new ChromeDriver(); // SID -123
		driver.get("https://www.amazon.com"); // SID -123
		String title = driver.getTitle(); // SID -123
		System.out.println(title);

		System.out.println(driver.getCurrentUrl()); // SID -123

		//driver.close();
		//System.out.println(driver.getTitle());
		// For above line, when driver. close is used = session id will be 123 only but it will be invalid as driver is closed
		// NoSuchSessionException: invalid session id

		driver.quit(); //SID -123
		//System.out.println(driver.getTitle());
		// For above line, when driver. quit is used = session id will be null
		// NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?

		System.out.println(driver.getTitle()); // SID -null
		
		
		
		//Note:
		//Whenever we are writing [driver = new ChromeDriver();] say 5 times , so new session ID will be created say 5 different SID will be created
		

	}

}
