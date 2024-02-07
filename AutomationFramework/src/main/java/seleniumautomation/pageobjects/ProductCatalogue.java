package seleniumautomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumautomation.abstractcomponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page Factory design Pattern
	@FindBy(css = "section[id='products'] div[class='container'] div[class='row'] div[class*='mb-3']")
	List<WebElement> items;

	@FindBy(css = "..ng-animating")
	WebElement spinner;

	By itemsBy = By.cssSelector("section[id='products'] div[class='container'] div[class='row'] div[class*='mb-3']");
	By addToCart = By.cssSelector("div[class='card-body'] button[class*='w-10']");
	By toastMessage = By.id("toast-container");
	By catalogueWait = By.cssSelector("section[id='products'] div[class='container'] div[class='row'] div[class*='mb-3'] b");

	
	public void waitForCatalogueElements() {
		waitForCatalogueElementToAppear(catalogueWait);
	}
	
	public List<WebElement> getItems() {
		waitForElementToAppear(itemsBy);
		return items;
	}

	public WebElement getProductByName(String productName) {
		WebElement product = items.stream()
				.filter(x -> x
						.findElement(By.cssSelector(
								"section[id='products'] div[class='container'] div[class='row'] div[class*='mb-3'] b"))
						.getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return product;
	}

	public void addProductToCart(String productName) throws InterruptedException{
		WebElement mydesProd = getProductByName(productName);
		mydesProd.findElement(addToCart).click();
		Thread.sleep(5000);
		clickOnCartButton();
//		waitForElementToAppear(toastMessage);
//		waitForElementToDisappear(spinner);
		
	}

}
