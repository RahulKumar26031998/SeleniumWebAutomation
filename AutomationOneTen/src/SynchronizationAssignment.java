import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String user = "rahulshettyacademy";
		String pass = "learning";
		//open the url
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		
		// feed the username and password
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		
		// select the usertype
		driver.findElement(By.xpath("(//input[@id='usertype'] )[2]")).click();
		
		// click Okay on the popup
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		// select consultant from the static dropdown
		WebElement dropItems = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropItems1 = new Select(dropItems);
		dropItems1.selectByVisibleText("Consultant");
		
		// accept the terms
		driver.findElement(By.id("terms")).click();
		
		// click on sign in
		driver.findElement(By.id("signInBtn")).click();

	}
}
