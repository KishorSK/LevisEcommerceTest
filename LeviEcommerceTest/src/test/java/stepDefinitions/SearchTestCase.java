package stepDefinitions;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExtendManager;

public class SearchTestCase {
	
	WebDriver driver;
	ExtentTest test;
	
	@Given("I open the Levi website")
	public void i_open_the_levi_website() 
	{
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://levi.in/");
	    String actualUrl = driver.getCurrentUrl();
        
        // Check if the actual URL matches the expected URL
        if (!actualUrl.equals("https://levi.in/")) {
            test = ExtendManager.getInstance().createTest("Levi Website Test");
            test.fail("Failed to open Levi website. Actual URL: " + actualUrl + ", Expected URL: " + "https://levi.in/");
            Assert.fail("Failed to load correct URL: " + actualUrl);
        } else {
            test = ExtendManager.getInstance().createTest("Open Levi Website");
            test.pass("Opened Levi website successfully");
        }	
}

	@When("I search for {string}")
	public void i_search_for(String string) 
	{
		driver.findElement(By.xpath("//input[@id='st-search']")).sendKeys(string);
	}

	@Then("I should see search results relevant to {string}")
	public void i_should_see_search_results_relevant_to(String string) 
	{
	    String resultname =driver.findElement(By.xpath("//span[@class='st-summary-label']/strong[contains(text(),'jeans')]")).getText();
	    System.out.println(resultname);
	    Assert.assertTrue(resultname.toLowerCase().contains(string.toLowerCase()));
	    test.pass("Verified search results for " + string);
	    driver.quit();
	    //test
	}
}
