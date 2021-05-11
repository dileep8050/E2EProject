package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;



public class Homepage extends base {
	private static Logger log = LogManager.getLogger(Homepage.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver Initialized Homepage");

	}

	@Test(dataProvider="getData")
	public void hompage(String username, String password, String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		l.getlogin().click();
		LoginPage lp=new LoginPage(driver);
		lp.getemail().sendKeys(username);
		lp.getpassword().sendKeys(password);
		Assert.assertTrue(false);
		lp.getsubmit().click();
		System.out.println(text);
		}
	@DataProvider
	public Object[][] getData()
	{
		//rows[size=2] - Two set of data required 0 index,1 index
		//columns[size=3] - Each set we need 3 values so 0 index,1 index,2 index
		Object[][] data=new Object[2][3];
		
		data[0][0]="nonretricteduser@gmail.com";
		data[0][1]="passNonrestricted";
		data[0][2]="This is not restirected user";
		
		data[1][0]="retricteduser@gmail.com";
		data[1][1]="passrestricted";
		data[1][2]="This is restirected user";
		log.info("Data provider passing data");
		return data;
		
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("Browser closed successfully");
	}
}
