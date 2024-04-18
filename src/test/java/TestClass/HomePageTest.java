package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestBase.TestBase;

public class HomePageTest extends TestBase {

	@Test(priority = 1)
	public void testHomePageTitle() {
		String title=homepageobject.getHomePageTitle();
		System.out.println("Title of HomePage: "+title);
		Assert.assertTrue(title.contains("Welcome to the Simple Travel Agency!"),"Invalid title of HomePage");
	}
	
	@Test(priority = 2)
	public void testDestOfTheWeekHyperLink() {
		SoftAssert softassert=new SoftAssert();
		String url=homepageobject.clickOnDestOfTheWeekHyperLink();
		System.out.println(url);
		softassert.assertTrue(url.contains("vacation"), "New tab URL does not contain 'vacation' ");
		softassert.assertAll();
	}
	
	@Test(priority = 3)
	public void testFindFlightTickets() {
		homepageobject.purchageFlightTicket();
	}
}
