package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinitions {
	
	WebDriver driver;
	@When("^I loggin into primusbank url on Chrome$")
	public void i_loggin_into_primusbank_url_on_Chrome() throws Throwable {
		
		driver = new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
	
	}

	@When("^I select branch dropdown$")
	public void i_select_branch_dropdown() throws Throwable {
		Select dlist = new Select(driver.findElement(By.id("drlist")));
		dlist.selectByVisibleText("Qualityanalist");
	    
	}

	@When("^I enter uid in usernameField$")
	public void i_enter_uid_in_usernameField() throws Throwable {
		driver.findElement(By.id("txtuId")).sendKeys("Swapnab");
	}

	@When("^I enter pwd in passwordField$")
	public void i_enter_pwd_in_passwordField() throws Throwable {
		driver.findElement(By.id("txtPword")).sendKeys("9398686734");
		
	}

	@When("^I click on loginButton$")
	public void i_click_on_loginButton() throws Throwable {
		driver.findElement(By.id("login")).click();

	}

	@Then("^I validate the title of the Home page$")
	public void i_validate_the_title_of_the_Home_page() throws Throwable {
	
		String act_val = driver.getTitle();
		
		String exp_val="Primus BANK";
		
		Assert.assertEquals(act_val, exp_val, "Validation Success");
	
	
	}
		
	@When("^I wait for LogoutButton$")
	public void i_wait_for_LogoutButton() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("\"//*[@src='images/admin_but_03.jpg']\"")));
		
	}

	@Then("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		
		driver.quit();
	}

}
