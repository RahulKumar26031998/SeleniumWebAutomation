import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutomationTask {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(40));

		// open the website
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

		// close the pop-up
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
				driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"))));
		w.until(ExpectedConditions
				.elementToBeClickable(By.id("webklipper-publisher-widget-container-notification-close-div"))).click();

		// select the Round-trip checkbox
		driver.findElement(By.cssSelector("li[data-cy='roundTrip'] span[class='tabsCircle appendRight5']")).click();

		// select from City
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("del");

		List<WebElement> fromCities = driver
				.findElements(By.cssSelector("ul[class='react-autosuggest__suggestions-list'] li"));

//		for(WebElement i : fromCities) {
//			System.out.println(i.getText());
//		}

		for (WebElement j : fromCities) {
			if (j.getText().equalsIgnoreCase("new Delhi, India")) {
				j.click();
				break;
			}
		}

//		select to destination City
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("ben");
		List<WebElement> ToCities = driver
				.findElements(By.cssSelector("ul[class='react-autosuggest__suggestions-list'] li"));

//		for(WebElement k : ToCities) {
//			System.out.println(k.getText());
//		}

		for (WebElement l : ToCities) {
			if (l.getText().equalsIgnoreCase("bengaluru, India")) {
				l.click();
				break;
			}
		}

		Thread.sleep(2000);
		// select the departure date
		driver.findElement(By.cssSelector("label[for='departure']")).click();
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[class='DayPicker-Week'] div[aria-selected='true']")));
		driver.findElement(By.cssSelector("div[class='DayPicker-Week'] div[aria-selected='true']")).click();

		Thread.sleep(2000);

		// selecting the April 5th 2024
		int x = 0;
		while (x < 3) {
			driver.findElement(By.xpath("//div[@class='DayPicker-NavBar'] //span[@aria-label='Next Month']")).click();
			x++;
		}
		driver.findElement(By.xpath("(//div[@class='dateInnerCell'] //p[text()='5'])[1]")).click();

//		Assert : Verify the message 'You are Booking for than 30 days'
		Assert.assertEquals(driver.findElement(By.id("range_error")).getText(),
				"You are booking for more than 30 days");

//		Select from_options1 = new Select(from_options);
//		from_options1.selectByVisibleText("New Delhi");

		// select Travellers and Class
		driver.findElement(By.xpath("//span[@class='lbl_input appendBottom5']")).click();
		driver.findElement(By.cssSelector("ul[class='guestCounter font12 darkText gbCounter'] li[data-cy='adults-9']"))
				.click();
		driver.findElement(
				By.cssSelector("ul[class='guestCounter font12 darkText gbCounter'] li[data-cy='children-3']")).click();
		driver.findElement(By.cssSelector("button[data-cy='travellerApplyBtn']")).click();

		// select 2 adult and 2 children
		driver.findElement(By.xpath("//span[@class='lbl_input appendBottom5']")).click();
		driver.findElement(By.cssSelector("ul[class='guestCounter font12 darkText gbCounter'] li[data-cy='adults-2']"))
				.click();
		driver.findElement(
				By.cssSelector("ul[class='guestCounter font12 darkText gbCounter'] li[data-cy='children-2']")).click();
		driver.findElement(By.cssSelector("button[data-cy='travellerApplyBtn']")).click();
		Thread.sleep(2000);

//		click on the Search button
		driver.findElement(By.xpath("//p[@data-cy='submit'] //a[contains(@class,'widgetSearchBtn')]")).click();
		
//		click on 'Okay, Got it!
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OKAY, GOT IT!']")));
		driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();
		

//      Take the default flights selected and click on Book Now
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
		
//		Verify if the 'Review your booking' Page is displayed
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'fareFamilyOverlay')]")));
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'fareFamilyOverlay')]")).isDisplayed());
		
//		Verify that review your Booking page is getting displayed
		
//		Verify that previously entered date and Time is getting displayed.
		
		
		driver.quit();

	}

}
