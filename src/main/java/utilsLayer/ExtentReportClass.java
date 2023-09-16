package utilsLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseLayer.BaseClass;

public class ExtentReportClass extends BaseClass{
	
	
	public static String date() {
		return new SimpleDateFormat("ddmmyyyy_HHmmss").format(new Date());
	}
	
	
	public static ExtentReports setUp(String reportName) {
		String path = System.getProperty("user.dir") + "\\ExtentReports\\" + reportName + date() + ".html";
		ExtentSparkReporter extS = new ExtentSparkReporter(path);
		ExtentReports extR = new ExtentReports();
		extR.attachReporter(extS);
		return extR;
	}
	
	public static String screenshot(String folderName, String screenshotName) throws IOException {
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\" + folderName + "\\" + screenshotName + date() +".png";
		FileUtils.copyFile(f,new File(path));
		return path;
	}
}











