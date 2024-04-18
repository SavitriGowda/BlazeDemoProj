package Pages;

import java.util.HashMap;
import java.util.regex.Pattern;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.TestBase;

public class PurchasePageObject extends TestBase{
	@FindBy(xpath = "//em[text()='914.76 '] ")
	WebElement totalCostText;
	
	@FindBy(xpath = "//input[@value='Purchase Flight']")
	WebElement purchFightBtn;
	
	@FindBy(id = "inputName")
	WebElement txt_name;

	@FindBy(id = "address")
	WebElement txt_addresse;
	
	@FindBy(id = "city")
	WebElement txt_city;
	
	@FindBy(id = "state")
	WebElement txt_state;
	
	@FindBy(id = "zipCode")
	WebElement txt_zipCode;
	
	@FindBy(className =  "form-inline")
	WebElement txt_CarDType;
	
	@FindBy(id = "creditCardNumber")
	WebElement txt_creditCardNumber;
	
	@FindBy(id = "creditCardMonth")
	WebElement txt_creditCardMonth;
	
	@FindBy(id = "creditCardYear")
	WebElement txt_creditCardYear;
	
	@FindBy(id = "nameOnCard")
	WebElement txt_nameOnCard;
	
	@FindBy(xpath = "//input[@value='Purchase Flight']")
	WebElement btn_submit;
	
	public PurchasePageObject() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifytotalCostPriceFormat() {
		// Pattern patt=Pattern.compile("\\ddd.\\dd");
		 return totalCostText.getText();
	}
	
	public ConfirmationPageObject clickOnPurchageFlightBtn()
	{
		purchFightBtn.click();
		return new ConfirmationPageObject();
	}
	
	public void purchaseFlight(HashMap<String, String> testData) {
		txt_name.sendKeys(testData.get("Name"));
		txt_addresse.sendKeys(testData.get("Address"));
		txt_city.sendKeys(testData.get("City"));
		txt_state.sendKeys(testData.get("State"));
		txt_zipCode.sendKeys(testData.get("ZipCode"));
		txt_CarDType.sendKeys(testData.get("Card Type"));
		txt_creditCardNumber.sendKeys(testData.get("Creadit Card Number"));
		txt_creditCardMonth.sendKeys(testData.get("Month"));
		txt_creditCardYear.sendKeys(testData.get("Year"));
		txt_nameOnCard.sendKeys(testData.get("Name On Card"));
		btn_submit.click();
		
	}
}
