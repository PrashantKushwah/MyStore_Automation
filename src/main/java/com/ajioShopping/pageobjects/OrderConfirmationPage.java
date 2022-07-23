package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath = "//strong[contains(text(),\"Your order on My Store is complete.\")]")
	WebElement orderConfirm;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyOrder() {
		String confirmMsg = orderConfirm.getText();
		return confirmMsg;
	}
}
