import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String text = "Rahul";

		// setting up the WebDriver
		System.setProperty("webdriver.gecko.driver",
				"D:\\RAHUL\\Bigdata\\Automation\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		// entering the value
		driver.findElement(By.id("name")).sendKeys(text);
		Thread.sleep(3000);

		// clicking on the alert button
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);

		// let the driver know about alert
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		// clicking on the confirm button on the Alert
		driver.findElement(By.id("name")).sendKeys(text);
		Thread.sleep(3000);

		// clicking on the cancel button on the Alert
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);

		driver.quit();
		
		
		// To handle Geolocation browser pop-up
//		To handle the web notifications as below example code
//
//		ChromeOptions options=new ChromeOptions();
//
//		Map<String, Object> prefs=new HashMap<String,Object>();
//
//		prefs.put("profile.default_content_setting_values.notifications", 1);
//
//		//1-Allow, 2-Block, 0-default
//
//		options.setExperimentalOption("prefs",prefs);
//
//		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
//
//		WebDriver driver = new ChromeDriver(options);
	}

}
