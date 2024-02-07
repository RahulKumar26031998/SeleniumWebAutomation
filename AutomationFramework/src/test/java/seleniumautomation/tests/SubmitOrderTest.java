package seleniumautomation.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumautomation.TestComponents.BaseTest;
import seleniumautomation.pageobjects.CartPage;
import seleniumautomation.pageobjects.ConfirmationPage;
import seleniumautomation.pageobjects.OrderPage;
import seleniumautomation.pageobjects.OrdersHistory;
import seleniumautomation.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	String productName = "IPHONE 13 PRO";

	// TODO Auto-generated method stub
	// open the website
	@Test(dataProvider = "getData", groups = { "purchaseOrder" })
	public void findDesiredProduct(HashMap<String, String> input) throws IOException, InterruptedException {

		// enter the creds and login
		ProductCatalogue productCatalogue = lp.loginApplication(input.get("email"), input.get("password"));
		Thread.sleep(2000);

		// find the items we can purchase and put them in a list

		// wait explicitly till the elements display
		productCatalogue.waitForCatalogueElements();
		// iterate using streams and find that card which is our desired product
		productCatalogue.getProductByName(input.get("productName"));
		// Add the item to Cart, wait for spinner to diappear and succes message to
		// appear
		productCatalogue.addProductToCart(input.get("productName"));

		// appear;click on the cart button
		// verify that the product name is 'IPHONE 13 PRO' and validate if we have a
		// match; if true then we click on checkout button
		CartPage cart = new CartPage(driver);
		boolean verifyCartProduct = cart.verifyProductName(input.get("productName"));
		Assert.assertTrue(verifyCartProduct);

		// select country and click on checkout
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

	@Test(dependsOnMethods = { "findDesiredProduct" })
	public void verifyOrdersHistory(String email, String password) throws InterruptedException {
		ProductCatalogue productCatalogue = lp.loginApplication(email, password);
		Thread.sleep(2000);
		OrdersHistory ord = lp.clickOnOrdersButton();
		boolean ordersCheck = ord.prodOrderHistory(productName);
		Assert.assertTrue(ordersCheck);

	}

//	@DataProvider
//	public Object[][] getData() {
//		Object[][] testData =  new Object[][] {{"rahulkumar1998@gmail.com","Password@123/","IPHONE 13 PRO"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
//		return testData;
//	}

	// Extend Reports

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToHashMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\seleniumautomation\\data\\purchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "rahulkumar1998@gmail.com");
//		map.put("password", "Password@123/");
//		map.put("productName", "IPHONE 13 PRO");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "shetty@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("productName", "ADIDAS ORIGINAL");
	}

}
