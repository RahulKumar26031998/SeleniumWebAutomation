package seleniumautomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumautomation.abstractcomponent.AbstractComponent;

public class OrdersHistory extends AbstractComponent {
	WebDriver driver;
	
	@FindBy(css="tbody tr td:nth-of-type(2)")
	List<WebElement> ordersList;
	
	By ordersHisBy = By.cssSelector("tbody tr td:nth-of-type(2)");
	
	public OrdersHistory(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean prodOrderHistory(String prodName) {
		boolean checkOrder = ordersList.stream().anyMatch(x->x.getText().equalsIgnoreCase(prodName));
		return checkOrder;
	}
	
	
}

