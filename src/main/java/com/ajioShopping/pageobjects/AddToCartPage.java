package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(id = "quantity_wanted")
	WebElement quantityField;
	
	@FindBy(id = "group_1")
	WebElement sizeField;
	
	@FindBy(name = "Submit")
	WebElement addToCart;
	
	@FindBy(xpath = "//h2[contains(., 'Product successfully added')]")
	WebElement cartMsg;
	
	@FindBy(xpath = "//a[@title=\"Proceed to checkout\"]")
	WebElement checkout;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addQuantity(String quantity) {
		action.type(quantityField, quantity);
	}
	
	public void selectSize(String size) {
		action.selectByVisibleText(sizeField, size);
	}
	
	public void clickAddtoCart() {
		action.click(driver, addToCart);
	}
	
	public boolean validateCart() {
		action.fluentWait(driver, cartMsg, 10);
		return action.isDisplayed(driver, cartMsg);
	}
	
	public OrderPage clickCheckout() {
		action.fluentWait(driver, cartMsg, 10);
		action.JSClick(driver, checkout);
		return new OrderPage();
	}
	
}
