package seleniumsessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdonAllElements {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");

		

//		Select select = new Select(driver.findElement(country));
//		List<WebElement> countryList = select.getOptions();
//		System.out.println(countryList.size() - 1);
//
//		for (WebElement e : countryList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.equals("Brazil")) {
//				e.click();
//				break;
//			}
//		}
		By country = By.id("Form_getForm_Country");
		
//		if(getTotalDropdownOptions(country)-1 ==232) {
//			System.out.println("Country dropdown count is corrrect");
//		}
//		
//		if(getDropDownOptionsTextList(country).contains("India")){
//			System.out.println("India is present");
//		}
//		
//		List<String> expCountryList = Arrays.asList("India", "Brazil", "Belgium");
//		if(getDropDownOptionsTextList(country).containsAll(expCountryList)){
//			System.out.println("PASS");
//		}
		
		
		//Sorting Alphabetically as below:
		
		List<String> act_list = getDropDownOptionsTextList(country);
		Collections.sort(act_list);
		
		
		
		SelectDropdownValue(country, "North Korea");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getDropDownOpionsList(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions();
	}

	public static List<String> getDropDownOptionsTextList(By locator) {
		List<WebElement> optionsList = getDropDownOpionsList(locator);
		List<String> optionsTextList = new ArrayList<String>();
		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}
	
	public static void SelectDropdownValue(By locator, String expectedVal) {
		List<WebElement> optionsList = getDropDownOpionsList(locator);
		for(WebElement e:optionsList ) {
			String text = e.getText();
			System.out.println(text);
			
			if (text.equals(expectedVal)) {
				e.click();
				break;
			}
		}
	}

	public static int getTotalDropdownOptions(By locator) {
		int optionsCount =  getDropDownOpionsList(locator).size();
		System.out.println("Total option =>" + optionsCount);
		return optionsCount;
	}

}
