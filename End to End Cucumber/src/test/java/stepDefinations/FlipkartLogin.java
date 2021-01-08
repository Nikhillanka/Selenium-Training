package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageobjects.Homepage;
import pageobjects.Loginpage;
import resources.base;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@RunWith(Cucumber.class)
public class FlipkartLogin extends base {
	public WebDriver driver;
    @Given("^User is on FlipKart Login page$")
    public void user_is_on_flipkart_login_page() throws IOException {
    	driver=initalizeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
    }
    @When("^User login into Flipkart application with username and password$")
    public void user_login_into_flipkart_application_with_username_and_password() {
    	Loginpage l=new Loginpage(driver);
		l.getemail().sendKeys(prop.getProperty("email"));
		l.getpassword().sendKeys(prop.getProperty("password"));
		l.getlogin().click();
    }

    @Then("^FlipKart Home page is populated$")
    public void flipkart_home_page_is_populated() {
    	System.out.println("User Sucessfully Logged into Flipkart");
    }
    @And("^Flipkart Account is logged out$")
    public void flipkart_account_is_logged_out() throws InterruptedException  {
    	Homepage HP=new Homepage(driver);
    	Actions ae=new Actions(driver);
        ae.moveToElement(HP.getname()).clickAndHold().build().perform();	
		System.out.println("clicked the account name");		
		ae.moveToElement(HP.getlogout()).click().build().perform();	
		System.out.println("My Account is Looged out Sucessfully in Flipkart ");	
		Thread.sleep(3000);	
    }
    @And("^Browser Close$")
    public void Browser_close() {
        driver.close();
    }
}