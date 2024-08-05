package com.TestAutomation.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.TestAutomation.Actions.Action;
import com.TestAutomation.baseClass.BaseClass;
import com.TestAutomation.pageFactory.HomePage;
import com.TestAutomation.pageFactory.LoginPage;
import com.TestAutomation.pageFactory.MyAccountPage;
import com.TestAutomation.dataProvider.DataProviders;

public class LoginPageTest extends BaseClass{

HomePage homePage;
LoginPage loginPage;
MyAccountPage myAccountPage;

@BeforeClass
	public void launchApplication() throws InterruptedException, IOException{
	launchBrowser();
	homePage = new HomePage();
	loginPage = homePage.clickSignIn();
	}

@AfterClass
	public void tearDown() {
	driver.quit();
	}

	@Test (priority = 1)
	public void loginSuccessTest() throws InterruptedException {
	loginPage.EnterEmailAddressInTextBox(prop.getProperty("email"));
	loginPage.EnterPasswordInTextBox(prop.getProperty("password"));
	Assert.assertEquals(Action.isDisplayed(driver, loginPage.passwordTextBoxHeader), true);
	Assert.assertEquals(Action.getText_Name(driver, loginPage.passwordTextBoxHeader), "Password");
	Assert.assertEquals(Action.isDisplayed(driver, loginPage.emailAddressTextBoxHeader), true);
	Assert.assertEquals(Action.getText_Name(driver, loginPage.emailAddressTextBoxHeader), "Email address");
	myAccountPage = loginPage.ClickOnSignInButton();
	Assert.assertEquals(myAccountPage.BreadCrumbTestForLoginSuccess(), "> My account");
	Assert.assertEquals(myAccountPage.SignOutButtonTextTest(), "Sign out");
	Assert.assertEquals(myAccountPage.SignOutButtonVisibilityTest(), true);
	Action.fluentWait(driver, myAccountPage.signOutButton, 10);
	}
}
