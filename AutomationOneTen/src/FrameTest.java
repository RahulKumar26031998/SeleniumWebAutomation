import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		driver.get("https://www.jqueryui.com/droppable");
		Actions a = new Actions(driver);
		// click on the object
		// driver.findElement(By.id("draggable")).click(); // gives error we did not
		// switch to frames because the element is in iframe

		// count the number of frames
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		// switch to frame first
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		driver.findElement(By.id("draggable")).click();

		// drag and drop the element
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		// switch back to the normal content
		driver.switchTo().defaultContent();
		
//		Thread.sleep(3000);
		driver.quit();
	}

}
