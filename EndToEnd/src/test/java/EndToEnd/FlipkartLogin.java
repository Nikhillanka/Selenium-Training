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

public class FlipkartLogin extends base {
	public WebDriver driver;
	@BeforeMethod
	public void Beforemethod() throws IOException
	{
		driver=initalizeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void Aftermethod() 
	{
		driver.close();
	}
	
		@Test(dataProvider="getlogintestdetails")
	public void Login(String email,String Password) throws IOException
	{
		Loginpage l=new Loginpage(driver);
		l.getemail().sendKeys(email);
		l.getpassword().sendKeys(Password);
		l.getlogin().click();	
		System.out.println("User Sucessfully Logged into Flipkart");	
	}
	
	
    @Test(dataProvider="getlogintestdetails")
    public void Logout(String email,String Password) throws IOException, InterruptedException 
    {
    	Login(email,Password);
    	Homepage HP=new Homepage(driver);
    	Actions ae=new Actions(driver);
        ae.moveToElement(HP.getname()).clickAndHold().build().perform();	
		System.out.println("clicked the account name");		
		ae.moveToElement(HP.getlogout()).click().build().perform();	
		System.out.println("My Account is Looged out Sucessfully in Flipkart ");	
		Thread.sleep(3000);	
		
    	}
    
}
