package seleniumautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumautomation.abstractcomponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "td[class='em-spacer-1'] label[class*='ng-star']")
	WebElement orderId;

	@FindBy(css = "td h1")
	WebElement orderPlacedSuccessMessage;
	
	
	
	public String getOrderId() {
		waitForOrderId(orderId);
		String orderIdText = orderId.getText();
		System.out.println(orderIdText);
		return orderIdText;
	}

	public String orderPlacedMessage() {
		waitForOrderSuccessMessage(orderPlacedSuccessMessage);
		String orderSuccessText = orderPlacedSuccessMessage.getText();
		orderSuccessText.equalsIgnoreCase("Thankyou for the order.");
		System.out.println(orderSuccessText);
		return orderSuccessText;
	}
}
