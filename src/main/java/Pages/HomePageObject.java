package Pages;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableComponent.UtilClass;
import TestBase.TestBase;

public class HomePageObject extends TestBase {
	@FindBy(linkText = "destination of the week! The Beach!")
	WebElement destlink;

	@FindBy(xpath = "//div[@class='container']/h1")
	WebElement homepageTitle;

	@FindBy(name = "fromPort")
	WebElement departCity;

	@FindBy(name = "toPort")
	WebElement destCity;

	@FindBy(xpath = "//input[@value='Find Flights']")
	WebElement BtnOfFinTicket;

	public HomePageObject() {
		PageFactory.initElements(driver, this);
	}

	// Title of homepage
	public String getHomePageTitle() {
		return homepageTitle.getText();
	}

	// Click on hyperLink(destination of the week! The Beach!)
	public String clickOnDestOfTheWeekHyperLink() {
		// driver.switchTo().newWindow(WindowType.TAB);
		String homePageTabId = driver.getWindowHandle();
		destlink.sendKeys(Keys.CONTROL + "n", Keys.RETURN);
		Set<String> allWindIds = driver.getWindowHandles();
		String newTabUrl = "";
		assert driver.getWindowHandles().size() > 1 : "New Tab did not open";
		System.out.println("No od Windows opened : " + driver.getWindowHandles().size());
		for (String chileWindowId : allWindIds) {

			if (!chileWindowId.equals(homePageTabId)) {
				driver.switchTo().window(chileWindowId);
				newTabUrl = driver.getCurrentUrl();
			}
		}
		closeChildWindow(allWindIds, homePageTabId);

		return newTabUrl;

	}

	public void closeChildWindow(Set<String> allWindIds, String parentWindId) {
		for (String chileWindowId : allWindIds) {

			if (!chileWindowId.equals(parentWindId)) {
				driver.switchTo().window(chileWindowId).close();

			}
		}
	}

	// Purchase Ticket
	public ReservationPageObject purchageFlightTicket() {
		UtilClass.selectOption(departCity, "Mexico City");
		UtilClass.selectOption(destCity, "London");
		BtnOfFinTicket.click();
		return new ReservationPageObject();
	}
	
}
