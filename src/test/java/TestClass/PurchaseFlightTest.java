package TestClass;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ReusableComponent.ExcelOperations;
import TestBase.TestBase;

public class PurchaseFlightTest extends TestBase {
ExcelOperations excel=new ExcelOperations(System.getProperty("user.dir")+"\\Cust_Info.xlsx","Sheet1");
	@Test
	public void testTotalCostFormat() {
		homepageobject.purchageFlightTicket();
		reservationpageobject.fildLowestPriceFlight();
		String totalCost = purchasepageobject.VerifytotalCostPriceFormat();
		Assert.assertTrue(totalCost.matches("\\d+\\.\\d{2}"),
				"Total Cost field does not have a price in xxx.xx format");
	}
	@Test(dataProvider = "getData")
	public void testPurchageFlight(Object obj) {
		homepageobject.purchageFlightTicket();
		reservationpageobject.fildLowestPriceFlight();
		HashMap<String, String> testData= (HashMap<String, String>) obj;
		purchasepageobject.purchaseFlight(testData);
		confirmationpage.printText();
		
	}

	@DataProvider(name = "getData")
	public Object[][] getTestData() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData=excel.getTestDataInMap(i);
			obj[i-1][0]=testData;
		}
		return obj;

	}
}
