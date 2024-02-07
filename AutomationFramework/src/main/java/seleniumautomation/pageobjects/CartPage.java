package seleniumautomation.pageobjects;

import java.util.List;
import java.util.stream.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumautomation.abstractcomponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "ul li div .cartSection h3")
	List<WebElement> cartItems;
	
	public boolean verifyProductName(String productName) {
		boolean check = cartItems.stream().anyMatch(y -> y.getText().equalsIgnoreCase(productName));
		clickOnCheckOutButton();
		return check;
	}
	
	
	

}
