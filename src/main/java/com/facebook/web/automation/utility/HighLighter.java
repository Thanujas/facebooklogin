package com.facebook.web.automation.utility;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLighter {
	public static void fnHighlightme(WebDriver driver, WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int icnt = 0; icnt < 2; icnt++) {
			js.executeScript("arguments[0].style.border='4px groove green'", element);
			Thread.sleep(1000);
			js.executeScript("arguments[0].style.border=''", element);

		}

	}

	public static void fnHighlightme(WebDriver driver, List<WebElement> element1) throws InterruptedException {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int icnt = 0; icnt < 2; icnt++) {
			js.executeScript("arguments[0].style.border='4px groove green'", element1);
			Thread.sleep(1000);
			js.executeScript("arguments[0].style.border=''", element1);

		}
	}
	
}
