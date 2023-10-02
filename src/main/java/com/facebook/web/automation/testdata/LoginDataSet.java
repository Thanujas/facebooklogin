package com.facebook.web.automation.testdata;

import org.testng.annotations.DataProvider;

public class LoginDataSet {
	@DataProvider(name = "logindata-provider")
	public static Object[][] logindataProviderMethod() {
		
		  Object [][] data = new Object [1][2];
		  
		  data[0][0]= "thanuja.sanduni@gmail.com";
		  data[0][1]="test12345";
		 
		return data;
	}
}
