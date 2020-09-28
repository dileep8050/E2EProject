package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;

import resources.base;
import resources.baseFlash;



public class flashtest extends baseFlash {
	private static Logger log = LogManager.getLogger(ValidateNavigation.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		System.out.println("Driver Initialized for flash");
		
	}
	
	@Test()
	public void validateNavigation() throws IOException
	{
		chromeFlashsettings(driver);
		driver.get(prop.getProperty("url1"));
		System.out.println("we are in home page");

	}
	@AfterTest
	public void tearDown()
	{
		//driver.close();
	}
}
