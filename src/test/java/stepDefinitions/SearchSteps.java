package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import io.cucumber.java.en.Then;
import Factory.Driver;
import Pages.NSEHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SearchSteps {

    WebDriver driver;
    NSEHomePage homePage=new NSEHomePage();
    SoftAssert softassert;

    @Given("User should be in home page")
    public void user_should_be_in_home_page() {
    	homePage.driverInitialization();
    }

    @When("user should be enter the details in search bar and click enter button")
    public void user_should_be_enter_the_details_in_search_bar_and_click_enter_button() throws InterruptedException {
        homePage.enterSearch("SME Market");
       // homePage.clickEnter();
        homePage.clickSearchResult();
        Thread.sleep(2000); // next step we'll upgrade to WebDriverWait
    }

    @Then("User should get the required details")
    public void user_should_get_the_required_details() {
        Assert.assertTrue(driver.getPageSource().contains("SME Market"), "Result not found!");
        //driver.quit();
    }
}
