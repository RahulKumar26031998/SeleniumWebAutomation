import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		System.setProperty("webdriver.chrome.driver", "D:\\RAHUL\\Bigdata\\Automation\\Chromedriver\\chrome.exe");
		// implicit wait
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("Password");
		driver.findElement(By.className("submit")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);;
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rahul Kumar");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("def@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("ghi@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("8290932");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Rahul");
		driver.findElement(By.cssSelector("input[type*='Pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
