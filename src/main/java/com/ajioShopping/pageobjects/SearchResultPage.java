package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class SearchResultPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//div[@class=\"product-image-container\"]//img")
	WebElement tshirtImg;
	
	public SearchResultPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean validateSearchResult() {
		return action.isDisplayed(driver, tshirtImg);
	}
	
	public AddToCartPage clickSearchResult() {
		action.click(driver, tshirtImg);
		return new AddToCartPage();
	}
}
