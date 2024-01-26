import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SynchronizationExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wai = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		// opening the url
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] my_list = { "Brocolli", "Beetroot", "Carrot" };

		cartMethod(driver, my_list);
		
		// click on the 'proceed to checkout' button		
		driver.findElement(By.xpath("//div[@class='action-block'] //button[text()='PROCEED TO CHECKOUT']")).click();
		wai.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='promoWrapper'] input[class='promoCode']")));
		//click the promocode box to enter the promocode value
		driver.findElement(By.cssSelector("div[class='promoWrapper'] input[class='promoCode']")).click();
		
		// apply the promo code
		driver.findElement(By.cssSelector("div[class='promoWrapper'] input[class='promoCode']")).sendKeys("rahulshettyacademy");
		
		// click on the apply button
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		
		// get the coupon applied text
		// explicit wait
		wai.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
		
	
		driver.quit();

	}

	public static void cartMethod(WebDriver driver, String[] my_list) throws InterruptedException {
		int counter = 0;

		// get all the elements which have the class value : product-name
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		// iterate through products
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			String[] veggieNameSplit = name.split("-");
			String veggieNameFormatted = veggieNameSplit[0].trim();
			// format name to get the actual vegetable name
			// check if name we extracted is present in my_list
			// we can convert name to ArrayList

			List my_list1 = Arrays.asList(my_list);

			// check only till 2 items selected and when done come out of the loop

			if (my_list1.contains(veggieNameFormatted)) { // contains works like regex unlike .getText() which takes
															// full string text
				// click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action'] //button[@type='button']")).get(i).click();
				Thread.sleep(5000);
				counter++;
				if (counter == my_list1.size()) {
					break;
				}
			}
		}

		// view items in my cart
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
	}

}
