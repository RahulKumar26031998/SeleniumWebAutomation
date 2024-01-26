import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UiEnableDisable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		// isEnabled() is consistent in working
		Thread.sleep(3000);
//		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
//		driver.findElement(By.name("ctl00$mainContent$view_date2")).click();
//		Thread.sleep(3000);
//		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());// not consistent

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("Disabled");
			Assert.assertFalse(true);
		} else {
			if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
				System.out.println("Enabled");
				Assert.assertTrue(true);
			}
		}

		driver.quit();

	}

}
