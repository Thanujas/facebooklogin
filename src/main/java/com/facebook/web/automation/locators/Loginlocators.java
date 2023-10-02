package com.facebook.web.automation.locators;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.facebook.web.automation.configurations.ConfigData;
import com.facebook.web.automation.utility.HighLighter;

public class Loginlocators {
	static WebDriver driver;
	public static WebElement element = null;

	public Loginlocators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public static WebElement username_Field(WebDriver driver) throws InterruptedException {
		System.out.println("inside username");
		Wait<WebDriver> gWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(ConfigData.fluenttime))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		element = gWait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id='email']")))
				.findElement(By.xpath("//*[@id='email']"));

		HighLighter.fnHighlightme(driver, element);
		 System.out.println("return element"+element);
		return element;
	}
	
	public static WebElement password_Field(WebDriver driver) throws InterruptedException {

		Wait<WebDriver> gWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(ConfigData.fluenttime))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		element = gWait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id='pass']")))
				.findElement(By.xpath("//*[@id='pass']"));

		HighLighter.fnHighlightme(driver, element);
		System.out.println(element);
		return element;
	}
	
	public static WebElement loginbutton_Field(WebDriver driver) throws InterruptedException {

		Wait<WebDriver> gWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(ConfigData.fluenttime))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		element = gWait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@name='login']")))
				.findElement(By.xpath("//*[@name='login']"));

		HighLighter.fnHighlightme(driver, element);
		return element;
	}	
	
}
