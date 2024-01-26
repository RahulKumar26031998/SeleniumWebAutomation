import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEnd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Checkbox UI diabled test
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("The Second Date Checkbox option is disabled");
		}
		else {
			if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
					Assert.assertFalse(true);
			}
		}

		// selecting departure from BGLR
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']"))
				.click();
		// arrival at Chennai
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
		Thread.sleep(3000);

//		selecting the departure date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		Thread.sleep(3000);

//		selecting the number of adults (updated dropdown)
		driver.findElement(By.id("divpaxinfo")).click();
		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		// selecting Friends and Family(CheckBox)
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		Thread.sleep(3000);
		
		//selecting the Currency
//		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("AED");
		Thread.sleep(3000);
		
		//Click on the Search Button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(6000);
		
		driver.quit();

	}

}
