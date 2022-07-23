package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class AddressPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//span[text()=\"Proceed to checkout\"]")
	WebElement checkOut;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage clickCheckOut() {
		action.click(driver, checkOut);
		return new ShippingPage();
	}

}
