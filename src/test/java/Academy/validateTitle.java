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



public class validateTitle extends base {
	
	private static Logger log = LogManager.getLogger(validateTitle.class.getName());
	public WebDriver driver;
	LandingPage l;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Launched browser with url");
	}

	@Test()
	public void ValidateTitleNavigation() throws IOException
	{
		l=new LandingPage(driver);
		Assert.assertEquals(l.gettitle().getText(), "FEATURED COURSES");
		
		log.info("Body text validated successfully");
	}
	@Test()
	public void ValidateheaderText() throws IOException
	{
		Assert.assertEquals(l.getheader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTIN");
		
		log.info("Header text validated successfully");
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("Browser closed successfully");
	}
}
