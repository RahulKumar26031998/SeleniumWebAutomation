package seleniumautomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumautomation.abstractcomponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement userId = driver.findElement(By.id("userEmail"));
//	WebElement password = driver.findElement(By.id("userPassword"));

	// Page Factory design Pattern
	@FindBy(id = "userEmail")
	WebElement userId;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement loginClick;
	
	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	WebElement credsErrorMessage;

	public ProductCatalogue loginApplication(String email, String userPassword) {
		userId.sendKeys(email);
		password.sendKeys(userPassword);
		loginClick.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMesssage() {
		waitForWebElementToAppear(credsErrorMessage);
		String errorMsg = credsErrorMessage.getText();
		return errorMsg;
	}
	
	public void openLandingPage(String url) {
		driver.get(url);
	}

}
