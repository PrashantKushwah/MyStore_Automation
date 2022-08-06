package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	WebElement termsCondition;
	
	@FindBy(xpath = "(//span[contains(text(),\"Proceed to checkout\")])[2]")
	WebElement checkOut;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCheckbox() {
		action.JSClick(driver, termsCondition);
	}
	
	public PaymentSummaryPage clickCheckOut() {
		action.JSClick(driver, checkOut);
		return new PaymentSummaryPage();
	}

}
