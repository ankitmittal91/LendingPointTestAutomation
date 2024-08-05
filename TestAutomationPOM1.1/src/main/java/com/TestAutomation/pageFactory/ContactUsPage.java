package com.TestAutomation.pageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestAutomation.Actions.Action;
import com.TestAutomation.baseClass.BaseClass;

public class ContactUsPage extends BaseClass{

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='home']")
	public WebElement homebutton;
	
	@FindBy(xpath="//h1[@class='page-heading bottom-indent']")
	public WebElement contactPageTitle;
	
	@FindBy(xpath="//h3[@class='page-subheading']")
	WebElement contactPageSubHeading;
	
	@FindBy(xpath="//select[@id='id_contact']")
	WebElement subjectHeadingDropDown;
	
	@FindBy(xpath="//div[@id='uniform-id_contact']/span")
	WebElement subjectHeadingDropDownArea;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailTextBox;
	
	@FindBy(xpath="//input[@id='id_order']")
	WebElement orderIdTextBox;
	
	@FindBy(xpath="//textarea[@id='message']")
	WebElement messageTextArea;
	
	@FindBy(xpath="//button[@id='submitMessage']")
	WebElement sendButton;
	
	@FindBy(xpath="//input[@id='fileUpload']")
	WebElement fileUpload;
	
	public String ReturnContactPageTitle() throws InterruptedException {
		return Action.getText_Name(driver, contactPageTitle);
	}
	
	public String ReturnContactPageSubHeading() throws InterruptedException {
		return Action.getText_Name(driver, contactPageSubHeading);
	}
	
	public void ClickSubjectHeadingDropdown() {
		Action.click(driver, subjectHeadingDropDown);
	}
	
	
	public String EnterEmailAddressInTextBox() {
		Action.moveToElement(driver, emailTextBox);
		Action.type(emailTextBox, prop.getProperty("email"));
		return emailTextBox.getAttribute("value");
	}
	
	public String EnterOrderIdInTextBox() {
		Action.type(orderIdTextBox, prop.getProperty("orderId"));
		return orderIdTextBox.getAttribute("value");
	}
	
	public void EnterMessageInTextBoxAndSend() {
		Action.click(driver, messageTextArea);
		Action.type(messageTextArea, "This is a test message...");
	}
	
	public String SelectValueFromSubjectHeadingDropDown() throws InterruptedException {
		Action.moveToElement(driver, subjectHeadingDropDown);
		Action.selectByValue(subjectHeadingDropDown, "2");
		return Action.getText_Name(driver, subjectHeadingDropDownArea);
	}
	
	public void UploadFile() throws InterruptedException, AWTException {
		Action.moveToElement(driver, fileUpload);
		File uploadFile = new File(prop.getProperty("contactPageFileUploadPath"));
		System.out.print(uploadFile.getAbsolutePath());
		fileUpload.sendKeys(uploadFile.getAbsolutePath());
		/*
		 * Action.click(driver, fileUpload); Robot rb = new Robot(); StringSelection
		 * filePath = new
		 * StringSelection(prop.getProperty("contactPageFileUploadPath"));
		 * System.out.print(filePath);
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		 * Action.switchToNewWindow(driver); rb.keyPress(KeyEvent.VK_CONTROL);
		 * rb.keyPress(KeyEvent.VK_V); rb.keyRelease(KeyEvent.VK_V);
		 * rb.keyRelease(KeyEvent.VK_CONTROL); rb.keyPress(KeyEvent.VK_ENTER);
		 * rb.keyRelease(KeyEvent.VK_ENTER); Action.switchToOldWindow(driver);
		 */
	}
	
	public ContactUsSuccessPage ClickOnSend() {
		Action.click(driver, sendButton);
		Action.pageLoadTimeOut(driver, 10);
		return new ContactUsSuccessPage();
	}
	
}
