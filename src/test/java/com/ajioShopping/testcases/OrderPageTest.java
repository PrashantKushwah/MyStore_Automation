package com.ajioShopping.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ajioShopping.base.BaseClass;
import com.ajioShopping.pageobjects.AddToCartPage;
import com.ajioShopping.pageobjects.IndexPage;
import com.ajioShopping.pageobjects.OrderPage;
import com.ajioShopping.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	
	IndexPage index;
	SearchResultPage search;
	AddToCartPage addToCart;
	OrderPage order;
	
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testTotalPrice() {
		index = new IndexPage();
		search = index.searchProduct("t-shirt");
		addToCart = search.clickSearchResult();
		addToCart.addQuantity("2");
		addToCart.selectSize("M");
		addToCart.clickAddtoCart();
		order = addToCart.clickCheckout();
		double unitPrice = order.unitPrice();
		double totalPrice = order.totalPrice();
		double expectActualPrice = (unitPrice*2)+2;
		Assert.assertEquals(totalPrice, expectActualPrice);
	}
	

}
