package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class NSEHomePage {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;

	By searchBox = By.xpath("//input[contains(@class,'rbt-input-main')]");
	@FindBy(xpath="//div[@class='autocompleteList']")
	WebElement searchResult;

	public NSEHomePage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void driverInitialization() {
		driver.get("https://www.nseindia.com/");
	}

	public void enterSearch(String text) {
		wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		driver.findElement(searchBox).sendKeys(text);
	}

	public void clickEnter() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
	}
	
	public void clickSearchResult() {
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();
	}

}
