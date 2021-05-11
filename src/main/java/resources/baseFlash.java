package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class baseFlash {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		// If want to execute through command or jenkins with dynamic value pass user below line
		//String browserName=System.getProperty("browser");
		//String browserName=prop.getProperty("browser");
		
		String browserName="chrome";
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
	
	public WebElement expandRootElement(WebElement element)
	{
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele=(WebElement)((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", element);
		return ele;
	}
	public void chromeFlashsettings(WebDriver driver)
	{
		driver.get("chrome://settings/content/siteDetails?site="+prop.getProperty("url1"));	
		
		
		WebElement root1 = driver.findElement(By.tagName("settings-ui"));
		WebElement shadowRoot1 = expandRootElement(root1);
		
		
		WebElement root2 = shadowRoot1.findElement(By.cssSelector("settings-main"));
		WebElement shadowroot2 = expandRootElement(root2);
		
		WebElement root3 = shadowroot2.findElement(By.cssSelector("settings-basic-page"));
		WebElement shadowroot4 = expandRootElement(root3);
		
		WebElement root5 = shadowroot4.findElement(By.tagName("settings-privacy-page"));
		WebElement shadowroot6 = expandRootElement(root5);
		
		WebElement root8 = shadowroot6.findElement(By.tagName("site-details"));
		WebElement shadowroot9 = expandRootElement(root8);
		
		WebElement root9 = shadowroot9.findElement(By.id("plugins"));
		WebElement shadowroot10 = expandRootElement(root9);
		
		WebElement FlashDropdown = shadowroot10.findElement(By.id("permission"));
		Select s = new Select(FlashDropdown);
		s.selectByValue("allow");
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFileName=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileHandler.copy(source, new File(destinationFileName));
		return testCaseName+".png";
	}
}
