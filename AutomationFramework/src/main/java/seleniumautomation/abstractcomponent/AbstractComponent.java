package seleniumautomation.abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumautomation.pageobjects.OrdersHistory;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	@FindBy(css = "ul li button[routerlink*='cart']")
	WebElement cartButLocation;

	@FindBy(css = "ul li button[type='button']")
	WebElement checkoutButLocation;

	@FindBy(css = "div[class='actions'] a[class*='ng-star-inserted']")
	WebElement placeOrderButton;
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement ordersButton;
	

	public void waitForCatalogueElementToAppear(By findBy) {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		w1.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		w1.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		w1.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitForElementToDisappear(WebElement ele1) {
		WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(15));
		w2.until(ExpectedConditions.invisibilityOf(ele1));
	}
	
	public void waitForOrderId(WebElement ele2) {
		WebDriverWait w3 = new WebDriverWait(driver, Duration.ofSeconds(15));
		w3.until(ExpectedConditions.visibilityOf(ele2));
	}
	
	public void waitForOrderSuccessMessage(WebElement ele3) {
		WebDriverWait w3 = new WebDriverWait(driver, Duration.ofSeconds(15));
		w3.until(ExpectedConditions.visibilityOf(ele3));
	}

	public void clickOnCartButton() {
		cartButLocation.click();
	}
	
	public OrdersHistory clickOnOrdersButton() {
		ordersButton.click();
		OrdersHistory ordershistory = new OrdersHistory(driver);
		return ordershistory;
	}

	public void clickOnCheckOutButton() {
		checkoutButLocation.click();
		
	}

	public void clickOnPlaceOrderButton() {
		placeOrderButton.click();

	}
	

}
