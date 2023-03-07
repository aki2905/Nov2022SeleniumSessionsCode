package seleniumassesment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EcommerceAssessment {
	WebDriver driver;

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
	}

	@Test(priority = 1)
	public void launchURLtest() {
		String ActualURL = driver.getCurrentUrl();
		String ExpectedURL = "https://www.amazon.com/";
		System.out.println("User is able to launch the URL and it is:" + ActualURL);
		Assert.assertEquals(ActualURL, ExpectedURL);
	}

	@Test(priority = 2)
	public void clickSearchBar() throws InterruptedException {
		WebElement SearchBar = driver.findElement(By.xpath("//input[@type='text']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", SearchBar);
		Thread.sleep(3000);
		SearchBar.sendKeys("Iphone");
		Thread.sleep(3000);
		System.out.println("User is able to click on Search Bar");
	}

	@Test(priority = 3)
	public void searchProdouct() throws InterruptedException {
		WebElement SubmitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		SubmitBtn.click();
		Thread.sleep(3000);
		System.out.println("User is able to search the Product");
	}

	@Test(enabled = false)
	public void shopByCategory() throws InterruptedException {
		List<WebElement> shopByCatProd = driver.findElements(By.xpath("//div[@class='a-row a-color-base']//a"));
		System.out.println("The size is " + shopByCatProd.size());

		for (WebElement e : shopByCatProd) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("slider")) {
				e.click();
				break;
			}
			Thread.sleep(3000);
		}
		System.out.println("User is able to click");
	}

	@Test(priority = 4)
	public void searchProdouctByBrand() throws InterruptedException {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,500)");

		List<WebElement> PrdBrandList = driver.findElements(By.xpath(
				"//span[text()='Brands']/parent::div/following-sibling::ul//a/div//label//input[@type='checkbox']/ancestor::li"));

		WebElement SeeMore = driver.findElement(
				By.xpath("//span[text()='Brands']/parent::div//following-sibling::ul//span[text()='See more']"));
		SeeMore.click();
		Thread.sleep(5000);
		for (WebElement e : PrdBrandList) {
			String text = e.getText();
			System.out.println(text);
			String prdName = "Nokia";
			if (text.equals(prdName)) {
				e.click();
				break;
			}
		}
		System.out.println("-----");
		Thread.sleep(2000);
		WebElement pdtNameChcbx = driver.findElement(By.xpath(
				"//span[text()='Brands']/parent::div/following-sibling::ul//a/div//label//input[@type='checkbox']/ancestor::li[@aria-label='Motorola']//i"));
		WebElement pdtName = driver.findElement(By.xpath(
				"//span[text()='Brands']/parent::div/following-sibling::ul//a/div//label//input[@type='checkbox']/ancestor::li[@aria-label='Motorola']"));
		String prdctName = pdtName.getText();
		Thread.sleep(2000);
		System.out.println("The product checked on is " + prdctName);
		pdtNameChcbx.click();

	}

	@Test(priority = 5)
	public void searchProdouctByPriceRange() throws InterruptedException {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,500)");

		List<WebElement> priceRangeList = driver.findElements(By.xpath(
				"//span[text()='Price']/parent::div/following-sibling::ul//span[@class='a-list-item']//a/span[contains(text(),'$')]"));
		for (WebElement e : priceRangeList) {
			String text = e.getText();
			System.out.println(text);
		}

		WebElement priceRangeLocator = driver.findElement(By.xpath(
				"//span[text()='Price']/parent::div/following-sibling::ul//span[@class='a-list-item']//a/span[contains(text(),'$')]"));
		String pricrRangeValue = priceRangeLocator.getText();

		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", priceRangeLocator);
		Thread.sleep(3000);
		priceRangeLocator.click();
		System.out.println("The price range clicked on is " + pricrRangeValue);

	}

	@Test(priority = 6)
	public void clickProduct() throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,500)");

		List<WebElement> prdctNameList = driver
				.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		Thread.sleep(3000);
		for (WebElement e : prdctNameList) {
			String text = e.getText();
			// System.out.println(text);

			if (text.contains("Moto G stylus")) {
				e.click();
				break;

			}

		}

	}

	@Test(priority = 7)
	public void ViewProduct() throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,100)");
		Thread.sleep(5000);
		WebElement prdctTitlelocator = driver
				.findElement(By.xpath("//div[@id='titleSection']//h1[@id='title']//span[@id='productTitle']"));
		String ProductTitle = prdctTitlelocator.getText();
		System.out.println("The Product Title after searching is : " + ProductTitle);
	}

	@Test(priority = 8)
	public void AddToCart() throws InterruptedException {
		Thread.sleep(5000);
		WebElement addtoCart = driver.findElement(By.xpath(
				"//div[@class='a-section a-spacing-none a-padding-none']//div[@data-feature-name='addToCart']//span//span[@class='a-button-inner']"));
		addtoCart.click();
		String AddCart = driver
				.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none celwidget']//span"))
				.getText();
		Assert.assertEquals("Added to Cart", AddCart);
	}

	@Test(priority = 9)
	public void CheckoutProceedItem() throws InterruptedException {
		Thread.sleep(2000);
		WebElement proceedToRetailCheckout = driver.findElement(By.xpath("//input[@value='Proceed to checkout']"));
		proceedToRetailCheckout.click();

	}

	@Test(priority = 10)
	public void AmazonSignIn() throws InterruptedException {
		Thread.sleep(3000);
		WebElement EmailEnter = driver.findElement(By.xpath("//input[@type='email']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", EmailEnter);
		EmailEnter.sendKeys("sampletesting260@gmail.com");
		Thread.sleep(3000);

		WebElement ContinueBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", ContinueBtn);
		ContinueBtn.click();
		Thread.sleep(3000);

		WebElement PasswordEnter = driver.findElement(By.xpath("//input[@type='password']"));
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", PasswordEnter);
		PasswordEnter.sendKeys("testsample_jan25");
		Thread.sleep(3000);

		WebElement SignIn = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", SignIn);
		SignIn.click();
		Thread.sleep(3000);
	}

	@Test(priority = 11)
	public void FinalCheckOutPageValidation() throws InterruptedException {
		WebElement FinalCheckOutPage = driver.findElement(By.xpath(" //h1[contains(text(),'Checkout')]"));
		String CheckoutTitle = FinalCheckOutPage.getText();
		System.out.println(CheckoutTitle);
		if (CheckoutTitle.contains("Checkout")) {
			System.out.println("It is finally navigated to the checkout Page");
		}
		Assert.assertEquals(CheckoutTitle, "Checkout (1 item)");
	}

	@Test(priority = 12)
	public void BillingShipping_InformationPage() throws InterruptedException {
		WebElement FinalCheckOutPage = driver.findElement(By.xpath(" //h1[contains(text(),'Checkout')]"));
		String CheckoutTitle = FinalCheckOutPage.getText();
		System.out.println(CheckoutTitle);
		if (CheckoutTitle.contains("Checkout")) {
			System.out.println("It is finally navigated to the checkout Page");
		}
		Assert.assertEquals(CheckoutTitle, "Checkout (1 item)");
	}

	@Test(priority = 13)
	public void OrderSummaryFinalPage() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Order is successfully done");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
