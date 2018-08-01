package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;



public class TestBase 
{

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase()
	{
		prop = new Properties();
		try 
		{
			FileInputStream ip = new FileInputStream("C:\\Batch15\\FreeCRMFinal\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	}
		
		public static void initialization()
		{
			String browserName = prop.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
}
