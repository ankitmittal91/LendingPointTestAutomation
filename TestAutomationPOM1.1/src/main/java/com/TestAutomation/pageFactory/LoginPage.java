package com.TestAutomation.pageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 
import com.TestAutomation.Actions.Action;
import com.TestAutomation.baseClass.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailAddressTextBox;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement loginButton;
	
	@FindBy(xpath="//label[@for='email']")
	public WebElement emailAddressTextBoxHeader;
	
	@FindBy(xpath="//label[@for='passwd']")
	public WebElement passwordTextBoxHeader;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement signUpEmailAddressTextBox;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement signUpButton;
	
	public void EnterEmailAddressInTextBox(String username) {
		Action.moveToElement(driver, emailAddressTextBox);
		Action.click(driver, emailAddressTextBox);
		Action.type(emailAddressTextBox, username);
	}
	
	public void EnterPasswordInTextBox(String password) {
		Action.moveToElement(driver, passwordTextBox);
		Action.click(driver, passwordTextBox);
		Action.type(passwordTextBox, password);
	}
	
	public MyAccountPage ClickOnSignInButton() {
		Action.moveToElement(driver, loginButton);
		Action.click(driver, loginButton);
		Action.pageLoadTimeOut(driver, 10);
		return new MyAccountPage();
	}
	
	public boolean EmailAddressInSignUpTextBoxVisible() {
		Action.moveToElement(driver, signUpEmailAddressTextBox);
		return Action.isDisplayed(driver, signUpEmailAddressTextBox);
	}
	
	public void EnterEmailAddressInSignUpTextBox() {
		Action.moveToElement(driver, signUpEmailAddressTextBox);
		Action.click(driver, signUpEmailAddressTextBox);
		Action.type(signUpEmailAddressTextBox, prop.getProperty("signUpEmailAddress"));
	}
	
	public boolean SignUpButtonVisible() {
		Action.moveToElement(driver, signUpButton);
		return Action.isDisplayed(driver, signUpButton);
	}
	
	public SignUpPage ClickOnSignUpButton() {
		Action.click(driver, signUpButton);
		Action.pageLoadTimeOut(driver, 10);
		return new SignUpPage();
	}
}
