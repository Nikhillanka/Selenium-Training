package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

	public WebDriver driver;
	By email=By.xpath("//input[@class='_2IX_2- VJZDxU']");
	By password=By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']");
	By login=By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getemail() 
	{
		return driver.findElement(email);
	}
	public WebElement getpassword() 
	{
		return driver.findElement(password);
	}
	public WebElement getlogin() 
	{
		return driver.findElement(login);
	}
}
