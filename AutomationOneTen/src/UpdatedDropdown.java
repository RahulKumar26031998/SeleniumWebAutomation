import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println(driver.findElement(By.className("paxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		
//		for(int i = 0; i<3; i++) {
//		driver.findElement(By.id("hrefIncAdt")).click();
//		}
		
		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.className("buttonN")).click();
		System.out.println(driver.findElement(By.className("paxinfo")).getText());
		driver.quit();
	}

}
