import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// setting up the WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		// opening the url
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] my_list = { "Brocolli", "Beetroot", "Carrot" };
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
		Thread.sleep(2000);

		driver.quit();

	}

}
