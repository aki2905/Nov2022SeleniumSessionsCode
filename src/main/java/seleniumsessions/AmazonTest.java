package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {
		
		String browserName="chrome";
		String urlName ="https://www.amazon.com";
		
		BrowserUtil brUtil = new BrowserUtil();
		brUtil.initDriver(browserName);
		
		brUtil.launchUrl(urlName);
		
		String actTitle = brUtil.getPageTitle();
		if(actTitle.contains("Amazon")) {
			System.out.println("Title test is Pass");
		}
		else {
			System.out.println("Title test is Fail");
		}
		
		String actUrl = brUtil.getPageUrl();
		if(actUrl.contains("amazon")) {
			System.out.println("URL test is Pass");
		}
		else {
			System.out.println("URL test is Fail");
		}
		
		brUtil.quitBrowser();

	}

}
