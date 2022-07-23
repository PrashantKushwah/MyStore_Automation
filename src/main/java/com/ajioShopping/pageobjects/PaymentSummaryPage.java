package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class PaymentSummaryPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(className = "bankwire")
	WebElement banwirePay;
	
	@FindBy(className = "cheque")
	WebElement chequePay;
	
	public PaymentSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickBankwire() {
		action.click(driver, banwirePay);
		return new OrderSummaryPage();
	}

}
