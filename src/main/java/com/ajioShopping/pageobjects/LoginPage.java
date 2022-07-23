package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class LoginPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="passwd")
	WebElement passwordField;
	
	@FindBy(id="SubmitLogin")
	WebElement submitBtn;
	
	@FindBy(id = "email_create")
	WebElement email_singup_field;
	
	@FindBy(id = "SubmitCreate")
	WebElement createBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String email, String password) {
		action.type(emailField, email);
		action.type(passwordField, password);
		action.click(driver, submitBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String email, String password) {
		action.type(emailField, email);
		action.type(passwordField, password);
		action.click(driver, submitBtn);
		return new AddressPage();
	}
	
	public SignUpPage createAccount(String email) {
		action.type(email_singup_field, email);
		action.click(driver, createBtn);
		return new SignUpPage();
	}

}
