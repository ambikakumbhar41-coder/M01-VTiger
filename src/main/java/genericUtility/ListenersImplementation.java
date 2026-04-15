package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {
	ExtentReports reports;
	ExtentTest test;
	JavaUtility jutil = new JavaUtility();
	String dateTimeStamp = jutil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--On Test Start executed");
		
		//Creating fields for every @Test method in the report
		test=reports.createTest(methodName);
	}

	@Override 
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--On Test Sucess executed");
		//Logging the status as PASS  for test method
				test.log(Status.PASS, methodName+"--successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--On Test Failure executed");
		
		
		//Logging the status as FAIL  for test method
				test.log(Status.FAIL, methodName+"--failed");
				test.log(Status.INFO, result.getThrowable());
		//Capturing the screenshot of the webpage
		
		String screenshotName = methodName+"-"+dateTimeStamp;
		
		
		SeleniumUtility sutil = new SeleniumUtility();
		
			try {
				String path=sutil.webpageScreenshot(BaseClass.sDriver, screenshotName);
				//Attaching the screenshot to the failed test in report
				test.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--On Test Skipped executed");
		
		//Logging the status as SKIP
		test.log(Status.SKIP, methodName+"--skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On Test Start executed");
		
		//Configuring the Extend Report
		ExtentSparkReporter repoter=new ExtentSparkReporter(".\\Extent_Reports\\report-"+dateTimeStamp+".html");
	    repoter.config().setDocumentTitle("Extent Report");
	    repoter.config().setReportName("VTiger Report");
	    repoter.config().setTheme(Theme.STANDARD);
	    
	    //Generate an empty report
	    reports=new ExtentReports();
	    reports.attachReporter(repoter);
	    reports.setSystemInfo("Base URL", "http://localhost:8888");
	    reports.setSystemInfo("Base browser", "chrome");
	    reports.setSystemInfo("Base browser", "chrome");
	    reports.setSystemInfo("Base Platform", "Windows");
	    reports.setSystemInfo("Test Engineer", "Ambika");
	   
	
	}
	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish executed");
		//Flushing the report
		reports.flush();
	}
}
	


