package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class SignUpPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//h1[@class=\"page-heading\"]")
	WebElement signUp;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateSignUp() {
		return action.isDisplayed(driver, signUp);
	}

}
