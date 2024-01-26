import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("textarea[jsname='yZiJbe']")).sendKeys("Ind");
		Thread.sleep(5000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("ul[jsname='bw4e9b'] div[class='wM6W7d']  b"));
		
		for(WebElement i : options) {
			if(i.getText().equalsIgnoreCase("vs Afg")) {
			i.click();
			break;
			}
		}
	}
}
