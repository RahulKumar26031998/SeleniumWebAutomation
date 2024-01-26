import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UiAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("name")).sendKeys("Rahul Kumar");
		
		driver.findElement(By.name("email")).sendKeys("email@gmail.com");
		
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password123");
		
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement my_options = driver.findElement(By.id("exampleFormControlSelect1"));
		Select my_options1= new Select(my_options);
		my_options1.selectByIndex(1);
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		driver.findElement(By.name("bday")).sendKeys("12/26/1996");
		
		driver.findElement(By.className("btn-success")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		
		driver.quit();
		
		

	}

}
