package Cucumber;

import org.testng.ITestContext;
			
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(features = "src/test/java/Cucumber", glue = "seleniumautomation.stepDefinitions", monochrome = true, 
tags = "@ErrorValidation", plugin = {"html:target/cucumber.html" })

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
