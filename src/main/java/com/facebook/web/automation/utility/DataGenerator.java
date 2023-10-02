package com.facebook.web.automation.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerator {
	public static String email = null ;
	//public static String email1 = null ;
	//public static String email2 = null ;
	
	public static String RanStr = null ;
	public static String RanInt = null ;
	
	public static String generatedEmail(){
		return email ;
	}
	/*public static String generatedTestEmail(){
		return email1 ;
	}
	public static String generatedtestEmailupdate(){
		return email2 ;
	}*/
	
	public static String generateEmail() 
	{
		int length=30;
	    String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
	            "1234567890";   //numbers

	    String emailtest="";
	    String temp=RandomStringUtils.random(length,allowedChars);
	    emailtest=temp.substring(0,temp.length()-9)+"@test.org";
	    email = emailtest ;
	    return emailtest;
	}
	
	/*public static String generateEmailtest() 
	{
		int length=30;
	    String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
	            "1234567890";   //numbers

	    String emailActivate1="";
	    String temp=RandomStringUtils.random(length,allowedChars);
	    emailActivate1=temp.substring(0,temp.length()-9)+"@testCBA.org";
	    email1 = emailActivate1 ;
	    return emailActivate1;
	}
	public static String generateEmailupdate() {
		int length=15;
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    "_-.";   //special characters
		  String emailActivate="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  emailActivate=temp.substring(0,temp.length()-9)+"@act.org";
		  email2 = emailActivate ;
		  return emailActivate;
		 }*/
	
	public static String generateRandomString(int length)
	{
	    String RanStr=RandomStringUtils.randomAlphabetic(length);
		return RanStr;
	}

	public static String generateRandomNumber(int length)
	{
		String RanInt=RandomStringUtils.randomNumeric(length);
		return RanInt;
	}

	public static String generateRandomAlphaNumeric(int length)
	{
	    String genRanAlphaNumeric = RandomStringUtils.randomAlphanumeric(length);
		return genRanAlphaNumeric;
	}

	public static String generateStringWithAllobedSplChars(int length)
	{
	    String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
	            "1234567890"; //numbers
	   String RanStrInt=RandomStringUtils.random(length, allowedChars);
	   return RanStrInt;
	}
	public static String generateRandomNumber2(int length)
	{
		String allowedChars= "123456789"; //numbers
		   //return RandomStringUtils.random(length, allowedChars);
		String RanInt=RandomStringUtils.random(length,allowedChars);
		return RanInt;
	}
	
	public static String generateUrl(int length) 
	{
	    String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
	            "1234567890"; //Numbers
	    String url="";
	    String temp=RandomStringUtils.random(length,allowedChars);
	    url=temp.substring(0,3)+"."+temp.substring(4,temp.length()-4)+"."+temp.substring(temp.length()-3);
	    return url;
	}
}
