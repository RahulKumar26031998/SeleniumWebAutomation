package seleniumautomation.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumautomation.TestComponents.BaseTest;
import seleniumautomation.TestComponents.Retry;
import seleniumautomation.pageobjects.CartPage;
import seleniumautomation.pageobjects.ConfirmationPage;
import seleniumautomation.pageobjects.OrderPage;
import seleniumautomation.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	// TODO Auto-generated method stub
	// open the website
	@Test(groups= {"purchaseOrder"}, retryAnalyzer = Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

		// enter the creds and login
		lp.loginApplication("rahulkumar1998@gmail.com", "Passsword@123/"); // wrong password intentionally
		Assert.assertEquals("Incorrect email email or password.", lp.getErrorMesssage());

	}

	
}
