package com.TestAutomation.testcases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.TestAutomation.Actions.Action;
import com.TestAutomation.baseClass.BaseClass;
import com.TestAutomation.pageFactory.*;

public class SignUpPageTest extends BaseClass{
	
LoginPage loginPage;
HomePage homePage;
SignUpPage signUpPage;
MyAccountPage myAccountPage;

@BeforeClass
	public void LaunchApplication() throws InterruptedException, IOException {
	launchBrowser();
	homePage = new HomePage();
	loginPage = homePage.clickSignIn();
	}

@AfterClass
	public void teardown() {
	driver.quit();
}

@Test (priority = 1)
	public void SignUpButtonTextBoxUITest() {
	Assert.assertEquals(loginPage.EmailAddressInSignUpTextBoxVisible(), true);
	Assert.assertEquals(loginPage.SignUpButtonVisible(), true);
	}

@Test (priority = 2)
	public void ClickSignUpButton() {
	loginPage.EnterEmailAddressInSignUpTextBox();
	signUpPage = loginPage.ClickOnSignUpButton();
	}

@Test (priority = 3)
	public void ClickMaleGenderRadioButton() {
	Assert.assertEquals(signUpPage.ClickGenderMaleRadioButton(), true);
	}

@Test (priority = 4)
	public void FillSignUpForm() {
	Assert.assertEquals(signUpPage.EnterTextInFirstNameTextBox(), true);
	Assert.assertEquals(signUpPage.EnterTextInLastNameTextBox(), true);
	Assert.assertEquals(signUpPage.TestEmailTextBoxValue(), prop.getProperty("signUpEmailAddress"));
	Assert.assertEquals(signUpPage.EnterPasswordInTextBox(), true);
	signUpPage.EnterDOBDetails();
	myAccountPage = signUpPage.ClickOnSubmitSignUpButton();
	Action.fluentWait(driver, myAccountPage.signOutButton, 10);
	}
}