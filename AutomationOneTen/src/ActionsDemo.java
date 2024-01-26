import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("Webdriver.gecko.driver",
				"D:\\RAHUL\\Bigdata\\Automation\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// maximize the window
		driver.manage().window().maximize();
		// open the amazon site
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.id("nav-link-accountList"));

		// use the shift key on keyboard for entering value in Caps and then selecting
		// that text
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
				.doubleClick().build().perform();
		// moves to specific element and do a right click
		a.moveToElement(move).contextClick().build().perform();
		
		//drag and drop
//		a.moveToElement("").dragAndDrop(move, move)

		Thread.sleep(3000);

		driver.quit();

	}

}
