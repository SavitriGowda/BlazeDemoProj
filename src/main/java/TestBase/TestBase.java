package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.ConfirmationPageObject;
import Pages.HomePageObject;
import Pages.PurchasePageObject;
import Pages.ReservationPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public HomePageObject homepageobject;
	public ReservationPageObject reservationpageobject;
	public PurchasePageObject purchasepageobject;
	public ConfirmationPageObject confirmationpage;
	
	public TestBase() {
		prop=new Properties();
		try {
			FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Config\\Config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialize() {
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homepageobject=new HomePageObject();
		reservationpageobject=new ReservationPageObject();
		purchasepageobject=new PurchasePageObject();
		confirmationpage=new ConfirmationPageObject();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
