package com.facebook.web.automation.login;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebook.web.automation.configurations.BaseClass;
import com.facebook.web.automation.configurations.ConfigData;
import com.facebook.web.automation.locators.Loginlocators;
import com.facebook.web.automation.pages.Login;
import com.facebook.web.automation.testdata.LoginDataSet;
import com.facebook.web.automation.utility.DriverCommands;
import com.facebook.web.automation.utility.HighLighter;
import com.facebook.web.automation.utility.ReportGenerator;
public class Test_Login {
	WebDriver driver;
	ExtentTest logger;
	ExtentTest objlogtest;
	ExtentReports report = ReportGenerator.initializeextendreports();
	Login objpglogin;
	Test_Login objlog;
	

	public Test_Login () {

		try {
	
			driver = BaseClass.setup();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	objlogtest = report.createTest("Login Test Cases");
			}
	@Test(dataProvider = "logindata-provider", dataProviderClass = LoginDataSet.class)
	public void verify_successfullyLogintothePortal(String username,String password) {
	    logger = objlogtest.createNode("Verify successfully login to the Web portal");
		logger.log(Status.INFO, "Successfully navigates to " + ConfigData.baseurl);
		logger.log(Status.INFO, "Waiting page to load");
		logger.log(Status.INFO, "username"+username );
		logger.log(Status.INFO, "password"+password );
		
		try {
			objpglogin = new Login(driver);
			objpglogin.logintofbPortal(username,password,logger);
			logger.log(Status.INFO, "Successfully login to the Facebook");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)"); 
            

		}  catch (Exception e) {
			logger.log(Status.FAIL, "TestCase failed");
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
			logger.log(Status.INFO, "Exception" + e.toString());
			
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenShotPath;
			screenShotPath = ReportGenerator.capture(driver,timeStamp);
			try {
				logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath(screenShotPath));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		}
		

	
	@AfterClass
	public void closedriver() {
		report.flush();
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
