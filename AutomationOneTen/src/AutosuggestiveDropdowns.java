import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("ul[id='ui-id-1'] a"));
		
		for(WebElement j : options) {
			System.out.println(j.getText());
		}
		
		for(WebElement i : options) {
			if(i.getText().equalsIgnoreCase("India")) {
			i.click();
			break;
			}
		}
		
		

	}

}
