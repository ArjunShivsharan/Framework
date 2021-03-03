package com.org.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.org.utility.BrowserFactory;
import com.org.utility.ConfigDataProvider;
import com.org.utility.ExcelDataProvider;
import com.org.utility.Helper;

public class BaseClass
{
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
     
		
	@BeforeSuite 
	public void setUpSuite() 
	{
		Reporter.log("Setting up reports and Tests are getting ready..!", true); // To create Logs for our understanding..
		
		//Always keep extent report in beforeSuite
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/FreeAmazon_"+Helper.getCurrentDateTime()+".html")); 
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting  Done and Test can be Started..!", true);
	}
	
	@BeforeClass	
	public void setUp() 
	{
		Reporter.log("Trying to Start Browser and Application...", true);
		
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		
		Reporter.log("Browser and Application are  Up and Running..!", true);
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		Reporter.log("Tests are about to End..!", true);
		
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			logger.fail("Test Failed..!", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build()); 
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) 
		{
			logger.pass("Test Passed..!", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build()); 
		}
		else if(result.getStatus()==ITestResult.SKIP) 
		{
			logger.skip("Test Skipped..!", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build()); 
		}
		report.flush();// after performing test it will create the report
		
		Reporter.log("Test Completed >>> Reports Generated..!", true);
	}
}
