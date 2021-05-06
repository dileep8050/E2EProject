package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		// If want to execute through command or jenkins with dynamic value pass user below line
		//String browserName=System.getProperty("browser");
		String browserName=prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources"+"\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");	
			}
			driver=new ChromeDriver(options);
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources"+"\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFileName="http://localhost:8080/job/gitjenkins/ws"+"\\reports\\"+testCaseName+".png";
		FileHandler.copy(source, new File(destinationFileName));
		return destinationFileName;
	}
}
