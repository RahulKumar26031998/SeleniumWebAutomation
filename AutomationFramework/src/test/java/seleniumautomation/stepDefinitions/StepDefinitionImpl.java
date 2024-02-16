package seleniumautomation.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seleniumautomation.TestComponents.BaseTest;
import seleniumautomation.pageobjects.CartPage;
import seleniumautomation.pageobjects.ConfirmationPage;
import seleniumautomation.pageobjects.LandingPage;
import seleniumautomation.pageobjects.OrderPage;
import seleniumautomation.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {
	public LandingPage lp;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage conf;
	
	@Given("I landed on the Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
	 // code
     lp = launchApplication();
	}
	
	@Given("^Logged in with the username (.+) and password (.+)$") // because (.+) is the regex values so we start with ^ and end with $
	public void logged_in_with_username_and_password(String userName, String password) {
		 productCatalogue = lp.loginApplication(userName, password);
	}
	
	@When("^I add the product (.+) to cart and checkOut$")
	public void I_add_the_product_to_cart_and_checkout(String productName) throws InterruptedException {
		productCatalogue.getProductByName(productName);
		productCatalogue.addProductToCart(productName);
		Thread.sleep(2000);
		CartPage cart = new CartPage(driver);
		boolean checkProduct = cart.verifyProductName(productName);
		Assert.assertTrue(checkProduct);
		}
	
	@And("^I enter countryname (.+) and submit the order$")
	public void I_enter_countryname_and_submit_the_order(String countryName) {
		OrderPage orderPageObject = new OrderPage(driver);
		orderPageObject.selectCountry(countryName);
		conf = new ConfirmationPage(driver);
	}
	
	@Then("{string}message is displayed on the ConfirmationPage")
	public void message_is_displayed_on_the_ConfirmationPage(String message) {
		String confObjectId = conf.getOrderId();
		String confObjectMessage = conf.orderPlacedMessage();
		Assert.assertTrue(confObjectMessage.equalsIgnoreCase(message));
		System.out.println(
				"The order id of the product is : " + confObjectId + " and the message is : " + confObjectMessage);
		driver.quit();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String message1) {
		Assert.assertEquals(message1, lp.getErrorMesssage());
		driver.quit();	
		}
}
