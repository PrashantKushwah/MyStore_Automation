package com.ajioShopping.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ajioShopping.base.BaseClass;
import com.ajioShopping.pageobjects.AddToCartPage;
import com.ajioShopping.pageobjects.IndexPage;
import com.ajioShopping.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	
	IndexPage index;
	SearchResultPage search;
	AddToCartPage add_to_cart;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testAddToCart() {
		index = new IndexPage();
		search = index.searchProduct("t-shirt");
		add_to_cart = search.clickSearchResult();
		add_to_cart.addQuantity("2");
		add_to_cart.selectSize("M");
		add_to_cart.clickAddtoCart();
		boolean actual = add_to_cart.validateCart();
		Assert.assertTrue(actual);
	}

}
