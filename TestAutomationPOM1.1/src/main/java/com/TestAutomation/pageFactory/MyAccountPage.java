package com.TestAutomation.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestAutomation.Actions.Action;
import com.TestAutomation.baseClass.BaseClass;

public class MyAccountPage extends BaseClass{

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='breadcrumb clearfix']")
	WebElement breadCrumb;
	
	@FindBy(xpath="//a[@class='logout']")
	public WebElement signOutButton;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement searchTextBox;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchSubmitButton;
	
	public String BreadCrumbTestForLoginSuccess() throws InterruptedException {
		return Action.getText_Name(driver, breadCrumb);
	}
	
	public boolean SignOutButtonVisibilityTest() {
		return Action.isDisplayed(driver, signOutButton);
	}
	
	public String SignOutButtonTextTest() throws InterruptedException {
		return Action.getText_Name(driver, signOutButton);
	}
	
	public void SearchProduct(String productName) {
		Action.type(searchTextBox, productName);
		Action.click(driver, searchSubmitButton);
	}
}
