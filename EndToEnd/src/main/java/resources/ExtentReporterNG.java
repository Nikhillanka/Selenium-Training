package resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG extends base {
	static ExtentReports extent ;
	public static ExtentReports getExtentReports()
	{
		String path =System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("NIKHIL Automation Test Results");
		reporter.config().setDocumentTitle("End to End Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "NIKHIL LANKA");	
	//	extent.setSystemInfo("Tester", prop.getProperty("Tester"));	
		return extent;
		
	}
}
