package com.TestAutomation.testcases;

import java.io.IOException;

import org.testng.annotations.*;

import com.TestAutomation.baseClass.BaseClass;
import com.TestAutomation.dataProvider.DataProviders;
import com.TestAutomation.pageFactory.*;
import com.TestAutomation.utility.*;

public class MyAccountPageTest extends BaseClass{
	
HomePage homePage;
LoginPage loginPage;
MyAccountPage myAccountPage;

	@BeforeClass
	public void LaunchApplicationAndLogin() throws InterruptedException, IOException {
		launchBrowser();
		homePage = new HomePage();
		loginPage = homePage.clickSignIn();
		loginPage.EnterEmailAddressInTextBox(prop.getProperty("email"));
		loginPage.EnterPasswordInTextBox(prop.getProperty("password"));
		myAccountPage = loginPage.ClickOnSignInButton();
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
	
	@Test (priority = 1 , dataProvider = "searchproduct" , dataProviderClass = DataProviders.class)
	public void SearchVerifyProduct(String productName) throws InterruptedException {
		myAccountPage.SearchProduct(productName);
		Thread.sleep(3000);
	}
}
