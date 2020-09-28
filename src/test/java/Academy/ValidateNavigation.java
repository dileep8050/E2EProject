package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;

import resources.base;



public class ValidateNavigation extends base {
	private static Logger log = LogManager.getLogger(ValidateNavigation.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver Initialized for ValidateNavigation");
		driver.get(prop.getProperty("url"));
	}

	@Test()
	public void validateNavigation() throws IOException
	{
		LandingPage l=new LandingPage(driver);
		Assert.assertTrue(l.getnavigation().isDisplayed());
		//Assert.assertTrue(false);
		log.info("Navigation validated successfully");

	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
