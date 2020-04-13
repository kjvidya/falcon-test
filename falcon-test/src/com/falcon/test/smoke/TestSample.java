package com.falcon.test.smoke;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.falcon.lib.ui.LoginPage;
import com.falcon.lib.utils.CreateDriver;

public class TestSample {
	
	WebDriver driver;
	LoginPage login;
	@BeforeMethod
	public void precondition()
	{
		driver = CreateDriver.getBrowserInstance();
		login = new LoginPage(driver);
		
	}
	@AfterMethod
	public void postcondition()
	{
		driver.close();
	}
	@Test
	public void testSample()
	{
		String actualTitle = driver.getTitle();
		String expectedTitle = "actiTime-Login";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	

}
