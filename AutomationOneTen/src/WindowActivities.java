import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		System.setProperty("webdriver.chrome.driver", "D:\\RAHUL\\Bigdata\\Automation\\chrome-win32\\chrome.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		driver.get("https://www.google.com"); // there is waiting involved by default
		Thread.sleep(2000);
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice");// no waiting
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(4000);
		driver.quit();

	}

}
