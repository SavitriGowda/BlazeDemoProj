package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class ReservationPageObject extends TestBase {
	@FindBy(xpath = "//table[@class='table']//tbody//tr/td[6]")
	List<WebElement> listofPrice;
	
	public ReservationPageObject(){
		PageFactory.initElements(driver, this);
	}
	public void fildLowestPriceFlight() {
		double lowestPrice=Double.MAX_VALUE;
		int idx=-1;
		for(int i=1; i<=listofPrice.size();i++) {
			WebElement priceEle=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+i+"]/td[6]"));
			//System.out.println(priceEle.getText());
			String valuetext=priceEle.getText();
			double priceValue=Double.parseDouble(valuetext.replace("$", ""));
			System.out.println(priceValue);
			if(priceValue<lowestPrice) {
				lowestPrice=priceValue;
				idx=i;
			}
			
		}
		System.out.println(idx+" "+lowestPrice);
		driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+idx+"]/td[1]")).click();
		//System.out.println(text);
	}
	
}
