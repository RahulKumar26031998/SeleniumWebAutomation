import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandleTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// open the page
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		Actions a = new Actions(driver);

		// locate the url
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();

		// count the number of windows opened
		Set<String> winHan = driver.getWindowHandles(); // stores parent id and child id

		// get the parentId and the childId of the two windows
		Iterator<String> iter = winHan.iterator();
		String parentId = iter.next();
		String childId = iter.next();
		// now switch to the Child window
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String url = driver.findElement(By.cssSelector(".im-para.red")).getText();
		String[] url1 = url.split("at ");
		String[] url2 = url1[1].split(" with");
		String emailId = url2[0];
		System.out.println(emailId);
		
		//paste the emailId in the parent Window
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
		
		Thread.sleep(3000);

		driver.quit();

	}

}
