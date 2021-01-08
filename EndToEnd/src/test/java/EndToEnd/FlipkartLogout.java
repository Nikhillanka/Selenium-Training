package EndToEnd;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import resources.base;

public class FlipkartLogout extends base{
	public WebDriver driver;
/*@BeforeTest
	public void Beforetest() throws IOException
	{
		driver=initalizeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@AfterTest
	public void Aftertest() 
	{
		driver.close();
	}*/
	@BeforeTest
	public void Beforemethod() throws IOException
	{
		driver=initalizeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@AfterTest
	public void Aftermethod() 
	{
		driver.close();
	}
	

	@Test
	public void Logout() throws IOException, InterruptedException
	{
		//FlipkartLogin FL=new FlipkartLogin();
		//FL.Login(prop.getProperty("email"),prop.getProperty("password"));
		//Login();
		Loginpage l=new Loginpage(driver);
		l.getemail().sendKeys(prop.getProperty("email"));
		l.getpassword().sendKeys(prop.getProperty("password"));
		l.getlogin().click();
		Homepage HP=new Homepage(driver);
    	Actions ae=new Actions(driver);
        ae.moveToElement(HP.getname()).clickAndHold().build().perform();	
		System.out.println("clicked the account name");		
		ae.moveToElement(HP.getlogout()).click().build().perform();	
		System.out.println("My Account is Looged out Sucessfully in Flipkart ");
		Thread.sleep(3000);
		//extent.flush();
	}

}
