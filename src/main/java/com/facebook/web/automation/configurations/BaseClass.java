package com.facebook.web.automation.configurations;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;

public class BaseClass {
public static WebDriver driver;
	

    @BeforeTest
	public static WebDriver setup() throws InterruptedException {
    	
	  System.setProperty(ConfigData.drivername, ConfigData.driverpath);
       FirefoxOptions opt = new FirefoxOptions();
	   opt.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);

		driver = new FirefoxDriver(opt);
		driver.get(ConfigData.baseurl);
	    driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(ConfigData.pageToload);
		return driver;
  }
	
	 public static void closeDriver(WebDriver driver) {
	        if (driver != null) {
	            driver.quit();
	        }
	 }
}




