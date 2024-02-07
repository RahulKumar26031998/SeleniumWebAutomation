package seleniumautomation.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import seleniumautomation.TestComponents.BaseTest;
import seleniumautomation.pageobjects.CartPage;
import seleniumautomation.pageobjects.ConfirmationPage;
import seleniumautomation.pageobjects.LandingPage;
import seleniumautomation.pageobjects.OrderPage;
import seleniumautomation.pageobjects.ProductCatalogue;

public class StandAloneTest extends BaseTest {
	public WebDriver driver;

	@Test
	public void productErrorValidation() throws IOException, InterruptedException {

		// enter the creds and login
		ProductCatalogue productCatalogue = lp.loginApplication("rahulkumar1998@gmail.com", "Password@123/");
		Thread.sleep(2000);

		// find the items we can purchase and put them in a list

		// wait explicitly till the elements display
		productCatalogue.waitForCatalogueElements();
		// iterate using streams and find that card which is our desired product
		productCatalogue.getProductByName("IPHONE 13 PRO");

		// Add the item to Cart, wait for spinner to diappear and succes message to
		productCatalogue.addProductToCart("IPHONE 13 PRO");

		// appear;click on the cart button
		// verify that the product name is 'IPHONE 13 PRO' and validate if we have a
		// match; if true then we click on checkout button
		CartPage cart = new CartPage(driver);
		boolean verifyCartProduct = cart.verifyProductName("IPHONE 13 PRO");
		Assert.assertTrue(verifyCartProduct);

		/// select country and click on checkout
		OrderPage orderPageObject = new OrderPage(driver);
		orderPageObject.selectCountry("Ind");

		// Get the order Id and the Thank you message
		ConfirmationPage conf = new ConfirmationPage(driver);
		String confObjectId = conf.getOrderId();
		String confObjectMessage = conf.orderPlacedMessage();
		Assert.assertTrue(confObjectMessage.equalsIgnoreCase("Thankyou for the order."));
		System.out.println(
				"The order id of the product is : " + confObjectId + " and the message is : " + confObjectMessage);

	}

}
