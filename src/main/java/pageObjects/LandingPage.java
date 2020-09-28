package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By signIn=By.xpath("//span[contains(text(),'Login')]");
	private By title=By.xpath("//div[@class='text-center']/h2");
	private By navigation=By.cssSelector(".nav.navbar-nav.navbar-right");
	private By header=By.cssSelector("div[class*='video-banner'] h3");
	private By popup=By.xpath("//button[text()='NO THANKS']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getlogin()
	{
		return driver.findElement(signIn);
	}
	public WebElement getnavigation()
	{
		return driver.findElement(navigation);
	}
	public WebElement gettitle()
	{
		return driver.findElement(title);
	}
	public WebElement getheader()
	{
		return driver.findElement(header);
	}
	public int getPopUpSize()
	
	{
		return driver.findElements(popup).size();
	}
	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}
	
}
