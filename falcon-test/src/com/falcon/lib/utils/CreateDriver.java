package com.falcon.lib.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CreateDriver {
	
	public static WebDriver getBrowserInstance()
	{
		WebDriver driver = null;
		String browser = DataHandlers.getDataFromProperties("configuration","browser");
		String url = DataHandlers.getDataFromProperties("configuration","url");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./browser-servers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriiver.gecko.driver","./browser-servers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriiver.ie.driver","./browser-servers/iedriver.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println(".....Invalid Browser Option check configuration properties" +"file in config-data folder....");
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		if(url.equalsIgnoreCase("prod"))
		{
		   driver.get("http://actitime.com");
		
		}
		else
		{
		  driver.get("http://localhost");
		}
		return driver;
}
	
	

}
