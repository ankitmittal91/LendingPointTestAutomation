package com.TestAutomation.testcases;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;
import com.TestAutomation.Actions.Action;
import com.TestAutomation.baseClass.BaseClass;
import com.TestAutomation.pageFactory.ContactUsPage;
import com.TestAutomation.pageFactory.ContactUsSuccessPage;
import com.TestAutomation.pageFactory.HomePage;

public class ContactUsPageTest extends BaseClass{

HomePage homePage;
ContactUsPage contactUsPage;
ContactUsSuccessPage contactUsSuccessPage;

@BeforeClass
	public void launchApplication() throws InterruptedException, IOException{
		launchBrowser();
		homePage = new HomePage();
		contactUsPage = homePage.clickContactUs();
		Action.explicitWait(driver, contactUsPage.homebutton, 10);
	}

@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
	}


@Test (priority = 1)
	public void contactPageTitleTest() throws InterruptedException{
	Assert.assertEquals(contactUsPage.ReturnContactPageTitle(), "CUSTOMER SERVICE - CONTACT US");
	System.out.println(contactUsPage.ReturnContactPageTitle());
	}

@Test (priority = 2)
	public void contactPageSubHeadingTest() throws InterruptedException {
	Assert.assertEquals(contactUsPage.ReturnContactPageSubHeading(), "SEND A MESSAGE");
	System.out.println(contactUsPage.ReturnContactPageSubHeading());
	}

@Test (priority = 3)
	public void EmailAddressFieldTest() {
	Assert.assertEquals(contactUsPage.EnterEmailAddressInTextBox(), prop.getProperty("email"));
	}

@Test (priority = 4)
	public void OrderIdFieldTest() {
	Assert.assertEquals(contactUsPage.EnterOrderIdInTextBox(), prop.getProperty("orderId"));
	}

@Test (priority = 5)
	public void MessageFieldTest() {
	contactUsPage.EnterMessageInTextBoxAndSend();
	}

@Test (priority = 6)
	public void SubHeadingDropdownTest() throws InterruptedException {
	Assert.assertEquals(contactUsPage.SelectValueFromSubjectHeadingDropDown(), "Customer service");
	}

@Test (priority = 7)
	public void UploadAttachment() throws InterruptedException, AWTException {
	contactUsPage.UploadFile();
	Thread.sleep(5000);
	}

@Test (priority = 8)
	public void SendContactUsTest() throws InterruptedException {
	contactUsSuccessPage = contactUsPage.ClickOnSend();
	Thread.sleep(5000);
	Assert.assertEquals(contactUsSuccessPage.ContactUsAlertText(),"Your message has been successfully sent to our team.");
	}
}
