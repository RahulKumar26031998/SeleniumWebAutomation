import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		int i=1;
		while(i<6) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		WebElement my_options = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select my_sel= new Select(my_options);
		my_sel.selectByIndex(2);
		Thread.sleep(3000);
		
		// clicking the checkbox
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		Thread.sleep(3000);
		// count of checkbox
//		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		
		
		driver.quit();	
	}
}
