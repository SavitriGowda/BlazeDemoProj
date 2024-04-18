package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class ConfirmationPageObject extends TestBase {
	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[2]")
	WebElement idText;

	public ConfirmationPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void printText() {
		if (idText.isDisplayed()) {
			System.out.println("Purchage ID: " + idText.getText());
			System.out.println("Purchase Id stored in the console.");
		}
	}
}
