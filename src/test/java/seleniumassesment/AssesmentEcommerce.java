
package seleniumassesment;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssesmentEcommerce {
	EcommercePageFunctionality epf;
	
	
	@Test
	public void m1() throws InterruptedException {
		
		epf.setup();
		epf.launchURLtest();
		epf.clickSearchBar();
		epf.searchProdouct();
		// epf.shopByCategory();
		epf.searchProdouctByBrand();
	}
	
	@BeforeClass
	public void m2() {
		epf= new EcommercePageFunctionality();
	}

}
