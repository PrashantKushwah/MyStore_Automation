package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class OrderSummaryPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//span[contains(text(),\"I confirm my order\")]")
	WebElement confirmOrder;
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clikConfirmOrder() {
		action.click(driver,confirmOrder);
		return new OrderConfirmationPage();
	}
}
