package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class OrderPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//td[@class=\"cart_unit\"]/span/span[@class=\"price\"]")
	WebElement unitPrice;
	
	@FindBy(xpath = "//td/span[@id=\"total_price\"]")
	WebElement totalPrice;
	
	@FindBy(xpath = "//span[text()=\"Proceed to checkout\"]")
	WebElement proceedToCheckout;
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double unitPrice() {
		String unit = unitPrice.getText();
		String unit1 = unit.replaceAll("[^a-zA-Z0-9]","");
		double unitP = Double.parseDouble(unit1);
		return unitP/100;
	}
	
	public double totalPrice() {
		String total = unitPrice.getText();
		String total1 = total.replaceAll("[^a-zA-Z0-9]","");
		double totalP = Double.parseDouble(total1);
		return totalP/100;
	}
	
	public LoginPage clickCheckOut() {
		action.JSClick(driver, proceedToCheckout);
		return new LoginPage();
	}

}
