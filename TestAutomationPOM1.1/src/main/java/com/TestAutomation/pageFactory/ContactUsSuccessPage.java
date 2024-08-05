package com.TestAutomation.pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.TestAutomation.Actions.Action;
import com.TestAutomation.baseClass.BaseClass;

public class ContactUsSuccessPage extends BaseClass{
	
	public ContactUsSuccessPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement successAlert;
	
	public String ContactUsAlertText() throws InterruptedException {
		return Action.getText_Name(driver, successAlert);
	}
}
