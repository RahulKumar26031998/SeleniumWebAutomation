import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Rahul";
//		Chrome
		WebDriver driver = new ChromeDriver();

//		FireFox
//		System.setProperty("webdriver.gecko.driver", "D:\\RAHUL\\Bigdata\\Automation\\geckodriver-v0.34.0-win32\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();

//		Edge
//		System.setProperty("webdriver.edge.driver", "D:\\RAHUL\\Bigdata\\Automation\\edgedriver_win32\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("submit")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class ='login-container'] h2")).getText(),
				"Hello " + name + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		Thread.sleep(3000);
		driver.quit();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String password_text = driver.findElement(By.cssSelector("form p")).getText();
		String[] pass_arr = password_text.split("'");
		String[] pass_arr1 = pass_arr[1].split("'");
		String my_password = pass_arr1[0];
		return my_password;
	}

}
