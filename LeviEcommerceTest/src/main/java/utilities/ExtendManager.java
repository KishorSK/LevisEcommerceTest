package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendManager {

	private static  ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent == null)
		{
			String reportpath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
			ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportpath);
			extent= new ExtentReports();
			extent.attachReporter(sparkReport);
		}
		return extent;
	}
	
}
