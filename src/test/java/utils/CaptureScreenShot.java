package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;




public class CaptureScreenShot {
	WebDriver  driver;
	
	public CaptureScreenShot(WebDriver driver) {
		
this.driver=driver;
		
	}
	
	

	
//	public void takescreenshot(ITestResult result) throws IOException {
//		TakesScreenshot screenshot = ((TakesScreenshot)driver);
//		File source=screenshot.getScreenshotAs(OutputType.FILE);
//		String dateTime = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>source"+source);
//		File destination = new File("C:\\Users\\lenovo\\eclipse-workspace\\newframework\\ScreenShots\\fullspage"+dateTime+result.getName()+".png");
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%"+result.getTestName());
//		FileUtils.copyFile(source, destination);
//	}
	
	//Creating a method getScreenshot and passing two parameters 
	//driver and screenshotName
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
	                //below line is just to append the date format with the screenshot name to avoid duplicate names		
	                String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
	                //Returns the captured file path
			return destination;
	}
	
	

}

//https://mvnrepository.com/artifact/commons-io/commons-io (link for download dependency for screenshot ko source se destination par copy karne k liye)
//
//<!-- https://mvnrepository.com/artifact/commons-io/commons-io --> ( ye hai dependency jo aapko pom.xml m dalni h, for screenshot ko source se destination par copy karne k liye)
//<dependency>
//    <groupId>commons-io</groupId>
//    <artifactId>commons-io</artifactId>
//    <version>2.11.0</version>
//</dependency>
