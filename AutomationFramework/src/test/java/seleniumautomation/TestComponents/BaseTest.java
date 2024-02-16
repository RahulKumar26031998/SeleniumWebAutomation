package seleniumautomation.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumautomation.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage lp;

	public WebDriver initializeDiver() throws IOException {

		// properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\seleniumautomation\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null? System.getProperty("browser") : prop.getProperty("browser");
		// prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			if(browserName.contains("headless")){
			opt.addArguments("headless");
			}
			
			driver = new ChromeDriver(opt);
			driver.manage().window().setSize(new Dimension(1440, 900));

		}

		else if (browserName.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver",
					"D:\\RAHUL\\Bigdata\\Automation\\Selenium\\geckodriver-v0.34.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (browserName.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.gecko.driver",
					"D:\\RAHUL\\Bigdata\\Automation\\Selenium\\edgedriver_win32\\msedgedriver.exe");
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToHashMap(String filePath) throws IOException {

		// read the json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// convert string to HashMap : we need Jackson Databond
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		String filePath = null;
        try{
        //take screenshot and save it in a file
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //copy the file to the required path
        File destinationFile = new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+"_image_" + System.currentTimeMillis()+ ".png");
        FileHandler.copy(sourceFile, destinationFile);
        String[] relatvePath = destinationFile.toString().split("reports");
        filePath = ".//" + relatvePath[1];
    }
    catch(Exception e){
        System.out.println("Failure to take screenshot "+e);
    }
    return filePath;
		
		
		
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDiver();
		lp = new LandingPage(driver);
		lp.openLandingPage("https://rahulshettyacademy.com/client/");
		return lp;
	}

	@AfterMethod(alwaysRun = true)
	public void closeApplication() {
		driver.quit();
	}

}
