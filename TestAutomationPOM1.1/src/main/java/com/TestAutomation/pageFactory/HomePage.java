package com.TestAutomation.pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.TestAutomation.baseClass.BaseClass;

public class HomePage extends BaseClass{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='login']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@title='Contact us']")
	WebElement contactUsButton;
	
	public LoginPage clickSignIn() {
		loginButton.click();
		return new LoginPage();
	}
	
	public ContactUsPage clickContactUs() {
		contactUsButton.click();
		return new ContactUsPage();
	}
}
