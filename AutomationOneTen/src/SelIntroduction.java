import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// The WebDriver is an interface providing methods without bodies to the class and its the responsibility of the class to implement those mthods
		
		//Chrome Browser
//      System.setProperty("webdriver.chrome.driver", "D:\\RAHUL\\Bigdata\\Automation\\Chromedriver\\chrome.exe");
		WebDriver driver = new ChromeDriver();
		
//		Firefox Browser
		// we need gecko driver for Firefox
		System.setProperty("webdriver.gecko.driver", "D:\\RAHUL\\Bigdata\\Automation\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver driver1 = new FirefoxDriver();
		
//		Edge Browser
		System.setProperty("webdriver.edge.driver", "D:\\RAHUL\\Bigdata\\Automation\\edgedriver_win32\\msedgedriver.exe");
		WebDriver driver2 = new EdgeDriver();
		
		driver.get("https://www.udemy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver1.get("https://www.udemy.com/");
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());
		
		driver2.get("https://www.udemy.com/");
		System.out.println(driver2.getTitle());
		System.out.println(driver2.getCurrentUrl());
		
		
		driver.quit();
		driver1.quit();
		driver2.quit();

	}

}
