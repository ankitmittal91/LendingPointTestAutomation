package com.TestAutomation.baseClass;

import java.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.TestAutomation.Actions.Action;
import com.TestAutomation.utility.ConfigFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends ConfigFileReader{

	public static WebDriver driver;

	public static void launchBrowser() throws InterruptedException, IOException {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		} //abc
		else if(browserName.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();	
			}
		else if(browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();	
		}
		driver.manage().window().maximize();
		Thread.sleep(10); 
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));
	}

}
 
