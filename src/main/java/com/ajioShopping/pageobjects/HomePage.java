package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class HomePage extends BaseClass {
	
	Action action = new Action();

	@FindBy(xpath = "//span[text()=\"My wishlists\"]")
	WebElement wishlistOption;

	@FindBy(xpath = "//span[text()=\"Order history and details\"]")
	WebElement orderHisOption;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyWishList() {
		return action.isDisplayed(driver, wishlistOption);
	}
	
	public boolean validateOrderHistory() {
		return action.isDisplayed(driver, orderHisOption);
	}

}
