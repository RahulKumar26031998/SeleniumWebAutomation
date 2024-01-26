import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[@value='BLR']")).click();
//		Thread.sleep(4000);
//		or
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(3000);
//		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText());
//		Thread.sleep(4);
//		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
//		Thread.sleep(3000);
//		or
//		driver.findElement(By.id("glsctl00_mainContent_ddl_destinationStation1_CTNR")).click();
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value = 'MAA']")).click();
		driver.quit();		

	}

}
