package com.org.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) 
	{
		if (browserName.equals("Chrome")) 
		{
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriverr.exe");
            driver = new ChromeDriver();
            driver.get(appURL);
		} 
		
		else if (browserName.equals("FireFox")) 
		{

			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			FirefoxOptions opt = new FirefoxOptions();
			opt.addPreference("privacy.trackingprotection.socialtracking.enabled", false);
			opt.addPreference("privacy.socialtracking.block_cookies.enabled", false);
			driver = new FirefoxDriver(opt);
        } 
		
		else if (browserName.equals("IE")) 
		{
			System.setProperty("webdriver.IE.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
        } 
		else 
		{
			System.out.println("Sorry We do not support this browser");
		}
		
        driver.manage().timeouts().pageLoadTimeout(30 , TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) 
	{
		driver.quit();
	}
}
