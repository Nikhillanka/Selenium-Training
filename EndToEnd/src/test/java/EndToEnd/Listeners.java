package EndToEnd;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener{
//	ExtentTest test;
//	//ExtentReports extent =ExtentReporterNG.getExtentReports();
//	ExtentReports extent =ExtentReporterNG.getExtentReports();
//	
//	@Override
//	public void onTestStart(ITestResult result) {
//		// TODO Auto-generated method stub
//	//	ITestListener.super.onTestStart(result);
//		test=extent.createTest(result.getMethod().getMethodName());
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		// TODO Auto-generated method stub
//	//	ITestListener.super.onTestSuccess(result);
//		test.log(Status.PASS, "Test Passed");
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
//		//ITestListener.super.onTestFailure(result);
//		WebDriver driver=null;
//		test.fail(result.getThrowable());
//		String Testmethodname=result.getMethod().getMethodName();
//		try {
//			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			getScreenShotPath(Testmethodname,driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		// TODO Auto-generated method stub
//		//ITestListener.super.onTestSkipped(result);
//		test.log(Status.SKIP, "Test Skipped");
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		// TODO Auto-generated method stub
//		//ITestListener.super.onTestFailedWithTimeout(result);
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//	//	ITestListener.super.onStart(context);
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		// TODO Auto-generated method stub
//	//	ITestListener.super.onFinish(context);
//		extent.flush();
//	}
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG. getExtentReports();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//extentTest.get().log(Status.PASS, "Test Passed");
		//ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test passed");
		String testMethodNamesuccess =result.getMethod().getMethodName();
		try {
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch (Exception e)
		{

		}
		try {
		extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodNamesuccess, driver), result.getMethod().getMethodName());
		} catch (IOException e) {
		e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
		//WebDriver driver =null;
		extentTest.get().fail(result.getThrowable());
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}


}
