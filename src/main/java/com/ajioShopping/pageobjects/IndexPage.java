package com.ajioShopping.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajioShopping.actiondriver.Action;
import com.ajioShopping.base.BaseClass;

public class IndexPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//a[@class=\"login\"]")
	WebElement signInBtn;
	
	@FindBy(id = "search_query_top")
	WebElement searchProductBox;
	
	@FindBy(xpath = "//button[@name=\"submit_search\"]")
	WebElement searchBtn;
	
	@FindBy(xpath = "//img[@class=\"logo img-responsive\"]")
	WebElement myStoreLogo;
	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickSingInBtn() {
		action.click(driver, signInBtn);
		return new LoginPage();
		
	}
	
	public boolean validateLogo() {
		return action.isDisplayed(driver, myStoreLogo);
	}
	
	public String getMyStoreTile() {
		return action.getTitle(driver);
	}
	
	public SearchResultPage searchProduct(String productName) {
		action.type(searchProductBox, productName);
		action.click(driver, searchBtn);
		return new SearchResultPage();
	}

}
