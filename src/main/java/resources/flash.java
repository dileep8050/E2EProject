package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class flash {
	WebDriver driver;
public WebElement expandRootElement(WebElement element)
{
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement ele=(WebElement)((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", element);
	return ele;
}

public void settings()
{
	driver.get("chrome://settings/content/siteDetails?site=https://oneclear.clearhub.tv/BC/Product/Modules/SignIn.aspx");	
	
	
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

}
