package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(name = "username") 
	WebElement username;
	
	@FindBy(name = "password") 
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']") 
	WebElement loginButton;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]") 
	WebElement signUpButton;
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]") 
	WebElement crmLogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean validatecrmLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", loginButton);
		
		return new HomePage();
		
	}

}
