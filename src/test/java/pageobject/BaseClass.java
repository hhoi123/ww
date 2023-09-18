package pageobject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;dasdasdasd
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.gargoylesoftware.htmlunit.javascript.host.file.File;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CaptureScreenShot;
import utils.ConifgReaderUtils;


public class BaseClass {
	ConifgReaderUtils obj=new ConifgReaderUtils();
	CaptureScreenShot obj5;
	WebDriver driver;
	

	ExtentSparkReporter htmlreporter;
	public  static ExtentReports reports;
	public  ExtentTest test;
	
	@BeforeSuite
	public void startreport() {
		htmlreporter = new ExtentSparkReporter("C:\\Users\\lenovo\\eclipse-workspace\\newframework\\Reports");
		reports = new ExtentReports();
	reports.attachReporter(htmlreporter);
		System.out.println("<<<<<<<<<<<<<<<<<000000000000000000000000000000000>>>>>>>>>>>>>>>>>");
		reports.setSystemInfo("Tester name", "Ankit Srivastava");
	reports.setSystemInfo("OS", "Window 11");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Machine", "Local");
		
	htmlreporter.config().setDocumentTitle("Extent Report");
	htmlreporter.config().setReportName("Test Report");
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setTimeStampFormat("EEEE, MMMM, dd, yyyy, hh:mm a '('zzz')'");
	}
	
	
	@BeforeMethod
	public void launchbrowser() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new  ChromeDriver();
		String baseurl=(String) obj.readdata("url");
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obj5=new CaptureScreenShot(driver);
	}
	@AfterMethod
	public void closebrowser(ITestResult result) throws Exception {
		System.out.println("status???????????????????"+result);
		System.out.println("??????????????????????not if");
		if(ITestResult.FAILURE==result.getStatus()) {
			//obj5.takescreenshot(result);
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>FAIL CASE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			test.fail(result.getThrowable());
			 String screenshotPath = obj5.getScreenshot(driver, result.getName());
			 test.addScreenCaptureFromPath(screenshotPath);
		
			// test.log(Status.FAIL,(Markup)test.addScreenCaptureFromPath(screenshotPath));
		
		
		
	}else if(ITestResult.SUCCESS==result.getStatus()) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>PASS CASE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}else if(ITestResult.SKIP==result.getStatus()) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.YELLOW));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SKIP CASE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
		System.out.println("??????????????????quit");
		driver.quit();
		}
	
	@AfterSuite
	public void endreport() {
		reports.flush();
	}
	
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void fillvalues(By locator,String value) {
		driver.findElement(locator).sendKeys(value);
	}
	public boolean Iselementdisplay(By locator) {
	return	driver.findElement(locator).isDisplayed();
	}
	public void explicitweight(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void thread() throws InterruptedException {
		Thread.sleep(3000);
	}
	

}


//@AfterMethod
//public void closebrowser(ITestResult result) throws IOException {
//	System.out.println("status???????????????????"+result);
//	System.out.println("??????????????????????not if");
//	if(ITestResult.FAILURE==result.getStatus()) {
//		obj5.takescreenshot(result);
//		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>FAIL CASE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		test.fail(result.getThrowable());

