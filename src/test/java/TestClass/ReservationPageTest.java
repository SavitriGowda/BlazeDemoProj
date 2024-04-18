package TestClass;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ReusableComponent.ExcelOperations;
import TestBase.TestBase;

public class ReservationPageTest extends TestBase {
	
	@Test
	public void testFindLowestPriceFlight() {
		homepageobject.purchageFlightTicket();
		reservationpageobject.fildLowestPriceFlight();
	}
	
	
}
