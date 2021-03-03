package com.org.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Helper {

	// Screenshots, Alerts, Frames, Multi Windows, Sync Issue, javascript executer
	
	public static String captureScreenShot(WebDriver driver) 
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath = System.getProperty("user.dir")+"/screenshots/Amazon_"+getCurrentDateTime()+".png";
		
		try {
			
			FileHandler.copy(source , new File(screenShotPath));
			
			System.out.println("ScrrenShot Captured Succefully..!");
			
		} catch (IOException e) {
			System.out.println("Unable to capture Screenshot" +e.getMessage());
		}
		
		return screenShotPath;
	}
	
	
	public static String getCurrentDateTime() 
	{
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss"); 
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
}


 