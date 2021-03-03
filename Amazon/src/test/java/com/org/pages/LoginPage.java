package com.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	public WebDriver driver;

	public LoginPage(WebDriver ldriver) 
	{
		this.driver= ldriver;
	}
	@FindBy(id="ap_email") WebElement uname;
	@FindBy(id="ap_password") WebElement pass;
	@FindBy(id="continue") WebElement continueButton;
	@FindBy(id="signInSubmit") WebElement signInButton;//continue
	
	public void loginToAmazon(String username, String password) throws InterruptedException 
	{
		uname.sendKeys(username);
		continueButton.click();
	    pass.sendKeys(password);
	    signInButton.click();	
	    Thread.sleep(2000);
	    
	}
}
