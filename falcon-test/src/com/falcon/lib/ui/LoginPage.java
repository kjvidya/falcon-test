package com.falcon.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	public WebElement getUserNameTextBox()
	{
		try
		{
			WebElement un = driver.findElement(By.name("username"));
			return un;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public WebElement getPasswordTextBox()
	{
		try
		{
			return driver.findElement(By.name("pwd"));
			
		}
		catch(Exception e)
		{
		return null;
		}
	}
	
	public WebElement getLoginButton()
	{
		try
		{
			return driver.findElement(By.xpath("//input[@type='submit']"));
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public WebElement getLoginErrorMsg()
	{
		try
		{
			return driver.findElement(By.xpath("//span[text()='username or password is invalid.please try again']"));
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public void WaitForLoginPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(getPasswordTextBox()));
		wait.until(ExpectedConditions.visibilityOf(getLoginButton()));
	}
}
