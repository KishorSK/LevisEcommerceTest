package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ExtendManager;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeClass
    public static void startReport() {
        extent = ExtendManager.getInstance();
    }

    @AfterClass
    public static void endReport() {
        extent.flush(); // Generates the report
    }
}

