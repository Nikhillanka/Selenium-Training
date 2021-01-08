package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	public WebDriver driver;
	By name=By.xpath("(//*[name()='svg'])[2]");
	//By name=By.xpath("(//div[@class='exehdJ'])");
	//By name=By.xpath("(//*[class='zZ3yfL'])");
	
	By logout=By.xpath("//div[contains(text(),'Logout')]");
	
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
	//	PageFactory.initElements(driver, this);
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
