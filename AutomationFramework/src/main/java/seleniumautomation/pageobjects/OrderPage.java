package seleniumautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumautomation.abstractcomponent.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div input[placeholder='Select Country']")
	WebElement countryNameBox;

	@FindBy(css = "button[class*='ng-star-inserted']:nth-of-type(2)")
	WebElement countryInDropdown;

	public void selectCountry(String countryName) {
		countryNameBox.sendKeys(countryName);
		countryInDropdown.click();
		clickOnPlaceOrderButton();

	}
}
