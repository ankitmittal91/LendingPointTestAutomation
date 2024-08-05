package com.TestAutomation.pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.TestAutomation.Actions.Action;
import com.TestAutomation.baseClass.BaseClass;

public class SignUpPage extends BaseClass{
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement genderMaleRadioButton;
	
	@FindBy(xpath="//div[@id='uniform-id_gender1']/span")
	WebElement spanGenderMaleRadioButton;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement firstNameTextBox;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement lastNameTextBox;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailTextBox;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement daysFieldDOB;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement monthsFieldDOB;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement yearsFieldDOB;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement signUpSubmitButton;

	public boolean ClickGenderMaleRadioButton() {
		Action.moveToElement(driver, genderMaleRadioButton);
		Action.click(driver, genderMaleRadioButton);
		return Action.isSelected(driver, genderMaleRadioButton);
	}
	
	public boolean EnterTextInFirstNameTextBox() {
		Action.moveToElement(driver, firstNameTextBox);
		Action.type(firstNameTextBox, "TestFirstName");
		return Action.isDisplayed(driver, firstNameTextBox);
	}
	
	public boolean EnterTextInLastNameTextBox() {
		Action.moveToElement(driver, lastNameTextBox);
		Action.type(lastNameTextBox, "TestLastName");
		return Action.isDisplayed(driver, lastNameTextBox);
	}
	
	public String TestEmailTextBoxValue() {
		return emailTextBox.getAttribute("value");
	}
	
	public boolean EnterPasswordInTextBox() {
		Action.moveToElement(driver, passwordTextBox);
		Action.type(passwordTextBox, prop.getProperty("password"));
		return Action.isDisplayed(driver, passwordTextBox);
	}
	
	public void EnterDOBDetails() {
		Action.selectByValue(daysFieldDOB, "2");
		Action.selectByValue(monthsFieldDOB, "2");
		Action.selectByValue(yearsFieldDOB, "1993");
	}
	
	public MyAccountPage ClickOnSubmitSignUpButton() {
		Action.moveToElement(driver, signUpSubmitButton);
		Action.click(driver, signUpSubmitButton);
		Action.pageLoadTimeOut(driver, 10);
		return new MyAccountPage();
	}
}
