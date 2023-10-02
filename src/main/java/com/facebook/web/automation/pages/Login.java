package com.facebook.web.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.facebook.web.automation.configurations.ConfigData;
import com.facebook.web.automation.locators.Loginlocators;
import com.facebook.web.automation.utility.DriverCommands;
import com.facebook.web.automation.utility.HighLighter;
import com.facebook.web.automation.utility.ReportGenerator;

public class Login {
	WebDriver driver;
	ExtentTest logger;
	ExtentReports report = ReportGenerator.initializeextendreports();
	
	
	
	  public Login(WebDriver driver) {
		  this.driver = driver;
	      PageFactory.initElements(driver, this); 
	      }
	  
	 
	
	public void logintofbPortal(String strusername, String strpassword,ExtentTest logger) throws IOException {
                 
		try {
			 
		    DriverCommands.type(driver,Loginlocators.username_Field(driver), logger,"Username Feild",strusername);
		    System.out.println("username done");
		    DriverCommands.type(driver,Loginlocators.password_Field(driver), logger,"Password Feild",strpassword);
		    System.out.println("password done");
		    DriverCommands.clickAt(driver, Loginlocators.loginbutton_Field(driver), logger, "Login Button");
		   

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

	}

}

