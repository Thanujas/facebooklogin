package com.facebook.web.automation.utility;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import com.facebook.web.automation.configurations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
 
public class DriverCommands {
	public static void clickAt(WebDriver driver, WebElement element, ExtentTest logger, String element_name) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", element);
			element.click();
			
			logger.log(Status.INFO, "User successfully click on  " +element);
			logger.log(Status.PASS, "<span style='font-weight:bold;'>Element Successfully Clicked</span>");
			Thread.sleep(ConfigData.objectload);
			
      
		} catch (Exception e) {
			logger.log(Status.FAIL, "Fail to find Check element present : " + element);
			logger.log(Status.INFO, "Exception" + e.toString());
			System.out.println("exception is "+e.toString());
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenShotPath;
			screenShotPath = ReportGenerator.capture(driver,timeStamp);
			try {
				logger.log(Status.FAIL, "Snapshot below driver commands: " + logger.addScreenCaptureFromPath(screenShotPath));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}
	
	public static void clickOn(WebDriver driver, WebElement element, ExtentTest logger, String element_name) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(3000); 
			executor.executeScript("arguments[0].click()", element);
			element.click();
			
			logger.log(Status.INFO, "User successfully click on  " +element);
			logger.log(Status.PASS, "<span style='font-weight:bold;'>Element Successfully Clicked</span>");
			Thread.sleep(ConfigData.objectload);
			
      
		} catch (Exception e) {
			logger.log(Status.FAIL, "Fail to find Check element present : " + element);
			logger.log(Status.INFO, "Exception" + e.toString());
			System.out.println("exception is "+e.toString());
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenShotPath;
			screenShotPath = ReportGenerator.capture(driver,timeStamp);
			try {
				logger.log(Status.FAIL, "Snapshot below driver commands: " + logger.addScreenCaptureFromPath(screenShotPath));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}
	
	

	public static void type(WebDriver driver, WebElement element, ExtentTest logger, String element_name,
			String typed_value) {

		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", element);
			element.clear();

			element.sendKeys(typed_value);
			logger.log(Status.INFO, "User typed value " + typed_value + " on  " + element_name+ "field");
			logger.log(Status.PASS, "Successfully enter input value as  "+"<span style='font-weight:bold;'>" + typed_value+"</span>");
			Thread.sleep(ConfigData.objectload);
		
		} catch (InterruptedException e) {
			logger.log(Status.FAIL, "fail to type " + typed_value + " on " + element_name);
			logger.log(Status.INFO, "Exception" + e.toString());
			System.out.println("exception is "+e.toString());
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
	
	public static void checktextDisplayPassList(WebDriver driver,List<WebElement>element ,ExtentTest logger,
			String expectedValue, String msg) {

		try {
			String actual = ((WebElement) element).getText();
			logger.log(Status.INFO, "<span style='font-weight:bold;'>Actual String is  </span>"+actual + "<span style='font-weight:bold;'> Expected String is </span>" +expectedValue);
			logger.log(Status.PASS, "<span style='font-weight:bold;'>Successfully compare two Strings</span>");
            System.out.println("actual text"+actual+"expected text"+expectedValue);
        
            
		} catch (Exception e) {
			logger.log(Status.FAIL, "Fail to find element");
			logger.log(Status.INFO, "Exception" + e.toString());
			System.out.println("exception is "+e.toString());
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

	public static void checktextPartialDisplayPass(WebDriver driver, WebElement element, ExtentTest logger,
			String expectedValue, String msg) {

		try {

			String actual = element.getText();
			System.out.println("actual value"+actual +"expected"+expectedValue);
			
			logger.log(Status.INFO, "<span style='font-weight:bold;'>Actual String is  </span>"+actual + "<span style='font-weight:bold;'> Expected String is </span>" +expectedValue);
			logger.log(Status.PASS, "<span style='font-weight:bold;'>Successfully compare two Strings as </span>"+"<span style='font-weight:bold;'>"+actual+"</span>");
			HighLighter.fnHighlightme(driver, element);
		} catch (Exception e) {
			logger.log(Status.FAIL, "Fail to find element");
			logger.log(Status.INFO, "Exception" + e.toString());
			System.out.println("exception is "+e.toString());
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

	public static void selectByVisibleText(WebDriver driver, WebElement element, ExtentTest logger, String text) {
		try {
			WebElement dropdown_element = element;
			Select dropdown = new Select(dropdown_element);
			dropdown.selectByVisibleText(text);
			logger.log(Status.INFO, "<span style='font-weight:bold;'> User successfully select dropdown option as </span>"+text);
			logger.log(Status.PASS, "<span style='font-weight:bold;'>Dropdown option successfully selected</span>");
			
		} catch (Exception e) {
			logger.log(Status.FAIL, "Fail to find element");
			logger.log(Status.INFO, "Exception" + e.toString());
			System.out.println("exception is "+e.toString());
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

	public static void sendKeys(WebDriver driver, ExtentTest logger, WebElement lelement, Keys typeValue,
			String EleName) {
		Actions actionObject = new Actions(driver);
		actionObject = actionObject.sendKeys(Keys.ENTER);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", lelement);
		lelement.sendKeys(typeValue);
		logger.log(Status.INFO, "User Type the  " +"<span style='font-weight:bold;'>"+typeValue+"</span>"+"on "+"<span style='font-weight:bold;'>" + lelement +"</span>"+ "field.");
	}
	
	public static void uploadfile(WebDriver driver, ExtentTest logger, WebElement uploadelement, String path,
			String EleName) {
		try {
			WebElement upload_element = uploadelement;
			upload_element.sendKeys(path);
			logger.log(Status.INFO, "User select the location path as  " +path + " : " );
			logger.log(Status.PASS,"File successfully uploaded");
		
		} catch (Exception e) {
			logger.log(Status.FAIL, "Fail to find element");
			logger.log(Status.INFO, "Exception" + e.toString());
			System.out.println("exception is "+e.toString());
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
	
	public static void clearElement(WebDriver driver, ExtentTest logger, WebElement element ) {
		try {
			element.clear();
			logger.log(Status.INFO, "Clear existing web elements   " +element + " : " );
			logger.log(Status.PASS,"Successfully clear the form");
			

		} catch (Exception e) {
			logger.log(Status.FAIL, "Fail to find element");
			logger.log(Status.INFO, "Exception" + e.toString());
			System.out.println("exception is "+e.toString());
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
	
	
	
	public static void maximumLengthValidation(WebDriver driver, ExtentTest logger, WebElement element, int expectedmax) throws InterruptedException {
		try {
		
		String actualfield = element.getAttribute("maxlength");
		int actualsize =Integer.parseInt(actualfield);
		if(actualsize==expectedmax ) {
			
			logger.log(Status.INFO, "Validatin element is "+element);
			logger.log(Status.INFO, "<span style='font-weight:bold;'>Actual Max Value is </span>"+actualsize+"</span>");
			logger.log(Status.INFO, "<span style='font-weight:bold;'>Expected Max Value is </span>"+expectedmax+"</span>");
			logger.log(Status.PASS,"Maximum Value matched");
			System.out.println("actual size "+actualsize+ "expected size"+expectedmax);
		
		}else {
			logger.log(Status.INFO, "Validatin element is "+element);
			System.out.println("Sizes are not matching . Hence testcases are failed");
			System.out.println("actual size "+actualsize+ "expected size"+expectedmax);
		
		}
		
		
		
	}
		catch (Exception e) {
			logger.log(Status.FAIL, "Fail to find element");
			logger.log(Status.INFO, "Exception" + e.toString());
			System.out.println("exception is "+e.toString());
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
	
	
	
	public static void logdisplayTextDisplayPass(WebDriver driver, WebElement element, ExtentTest logger) {

		try {

			String actual = element.getText();
			System.out.println("actual display value is "+actual );
			
			logger.log(Status.INFO, "<span style='font-weight:bold;'>Actual display String is  </span>"+actual );
			logger.log(Status.PASS, "<span style='font-weight:bold;'>Message display as  </span>"+"<span style='font-weight:bold;'>"+actual+"</span>");
			
		} catch (Exception e) {
			logger.log(Status.FAIL, "Fail to find element");
			logger.log(Status.INFO, "Exception" + e.toString());
			System.out.println("exception is "+e.toString());
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
	
	
	//Added by Anjali
	public static void checkElementPresent(WebDriver driver,ExtentTest logger, WebElement element, String name){
		JavascriptExecutor executor = (JavascriptExecutor) driver;			
		executor.executeScript("arguments[0].click();",element);
		logger.log(Status.INFO, "Click on "+name);
		
	}
	public static void checkLabelPresent(WebDriver driver,ExtentTest logger, WebElement element, String name) throws InterruptedException{
		JavascriptExecutor executor = (JavascriptExecutor) driver;	
		
		executor.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(3000); 
		executor.executeScript("arguments[0].click();",element);
	
		logger.log(Status.INFO, "Click on "+name);
		
	}
	
	public static void selectByIndex(WebDriver driver,ExtentTest logger,WebElement lelement,String selEleName,int selValue) throws InterruptedException
	{
		 WebElement mySelectEl =lelement;				
		 Select mySelect= new Select(mySelectEl);
	     mySelect.selectByIndex(selValue);
	     
		 WebElement option = mySelect.getFirstSelectedOption();
		 Thread.sleep(ConfigData.objectload);
		 logger.log(Status.PASS, "Selected "+selEleName+" :  "+option.getText());
		 
	 }
     public static void checkHeaders(WebDriver driver, ExtentTest logger, WebElement element, String header) {
    	 JavascriptExecutor executor = (JavascriptExecutor) driver;			
 		executor.executeScript("arguments[0].click();",element);
 		logger.log(Status.INFO, "Headers are: "+header);
     }
}
