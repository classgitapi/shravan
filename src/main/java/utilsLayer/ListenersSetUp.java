package utilsLayer;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersSetUp implements ITestListener {

	ExtentReports extR;
	ExtentTest extTest;

	public void onStart(ITestContext context) {
		extR = ExtentReportClass.setUp(context.getSuite().getName());

	}

	public void onTestStart(ITestResult result) {
		extTest = extR.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		extTest.log(Status.PASS, "Test Case Pass is:" + result.getMethod().getMethodName());
		try {
			extTest.addScreenCaptureFromPath(
					ExtentReportClass.screenshot("PassScreenshot", result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {
		extTest.log(Status.FAIL, "TestCase Fail is:" + result.getMethod().getMethodName());
		try {
			extTest.addScreenCaptureFromPath(
					ExtentReportClass.screenshot("FailScreenshot", result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		extTest.log(Status.SKIP, "Test Case Skip is:" + result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {
		extR.flush();

	}

}
