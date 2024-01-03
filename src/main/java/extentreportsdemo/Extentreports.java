package extentreportsdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports {
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
		// ExtentReports, ExtentSparkReporter
		// for extentsparreporters we need to provde path 
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation script results");
		reporter.config().setDocumentTitle("Test results ");
		
			
		 extent =new ExtentReports();		// ths is main class/method
		extent.attachReporter(reporter);				// attach reports created in above helper methods
		extent.setSystemInfo("Tester", "Sun Ren");
		
		
		
		
		
	}
	
	
	@Test
	public void extentdemo() {
		ExtentTest test= extent.createTest("Initial Demo Test");			// mandotory step before scrpt to start test 
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println(driver.getTitle());
		driver.close();
	//	test.fail("results not matched");
		
		
		extent.flush(); 	// mandotory step in ending to stop lstening and generate reports 
		
		
		
		
		
		
		
	}
}
