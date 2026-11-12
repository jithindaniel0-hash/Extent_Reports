package swagLab_basePKG;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import swagLab_pagePKG.SwagLab_homepage;
import swagLab_pagePKG.SwagLab_loginpage;

public class SwagLab_base
{
	public static WebDriver driver;
	public SwagLab_loginpage loginobj;
	public SwagLab_homepage homeobj;
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeTest
	public void setup()
	{
		reporter=new ExtentSparkReporter("./Reports/swag_report.html");//create a report
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Testername", "ABC");
		extent.setSystemInfo("Browsername", "chrome");
		
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--incognito");
		driver=new ChromeDriver(option);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void objmtd()
	{
		loginobj=new SwagLab_loginpage(driver);
		homeobj=new SwagLab_homepage(driver);
	}
	
	@AfterMethod
	public void after_mtd(ITestResult result) throws Exception
	{
		 if(result.getStatus()==ITestResult.SUCCESS)
			{
				 test.log(Status.FAIL, "test case failed is: "+result.getName());
				 test.log(Status.FAIL, "test case failed is: "+result.getThrowable());	
				 String screenshotpath=screenshotMethod(driver,result.getName());
				 test.addScreenCaptureFromPath(screenshotpath);
			}
			
			else if(result.getStatus()==ITestResult.SKIP)
			{
				test.skip("Test Skipped: "+result.getName());
			}		
	}

	private String screenshotMethod(WebDriver driver2, String name) throws Exception {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"./Screenshot/"+name+".png";
		FileHandler.copy(src,new File(destination));
		return destination;
	}
	
	@AfterTest
	public void endreport()
	{
		extent.flush();
		driver.quit();
	}

}
