package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

	public WebDriver driver;
	By name=By.xpath("(//*[name()='svg'])[2]");
	//By name=By.xpath("(//*[class='zZ3yfL'])");
	
	By logout=By.xpath("//div[contains(text(),'Logout')]");
	
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getname() 
	{
		return driver.findElement(name);
	}
	public WebElement getlogout() 
	{
		return driver.findElement(logout);
	}
	
}
