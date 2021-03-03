package com.org.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.org.pages.BaseClass;
import com.org.pages.LoginPage;

public class TestAmazonApplication extends BaseClass {

	@Test(priority=1)
	public void loginApp() throws InterruptedException, IOException {
		
	    logger = report.createTest("TestCase:1, loginApp()"); // logger will be responsible for all the Logging activity in the test.

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.loginToAmazon(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));
		
		logger.pass("Login Successfull..!");
		
	}
	@Test(priority=2)
	public void allLinks() throws InterruptedException 
	{
		logger = report.createTest("TestCase:2, allLinks()");
		Thread.sleep(2000);
		int size = driver.findElements(By.tagName("a")).size();
		System.out.println("Number of Links on Home Page are ="+size);
	}
	
}

//https://www.youtube.com/watch?v=bcMPotY18Uo&list=PL6flErFppaj0WwNOMFeXPVlNCDuJyPYFi&index=6