package com.ajioShopping.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ajioShopping.base.BaseClass;
import com.ajioShopping.pageobjects.AddToCartPage;
import com.ajioShopping.pageobjects.AddressPage;
import com.ajioShopping.pageobjects.HomePage;
import com.ajioShopping.pageobjects.IndexPage;
import com.ajioShopping.pageobjects.LoginPage;
import com.ajioShopping.pageobjects.OrderConfirmationPage;
import com.ajioShopping.pageobjects.OrderPage;
import com.ajioShopping.pageobjects.OrderSummaryPage;
import com.ajioShopping.pageobjects.PaymentSummaryPage;
import com.ajioShopping.pageobjects.SearchResultPage;
import com.ajioShopping.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass{
	
	LoginPage login;
	IndexPage index;
	SearchResultPage search;
	HomePage home;
	OrderPage order;
	AddToCartPage addToCart;
	AddressPage address;
	ShippingPage ship;
	PaymentSummaryPage payment;
	OrderSummaryPage orderSummary;
	OrderConfirmationPage orderConfirm;
	

	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void test_endToEnd() {
		index = new IndexPage();
		search = index.searchProduct("t-shirt");
		addToCart = search.clickSearchResult();
		addToCart.addQuantity("2");
		addToCart.selectSize("M");
		addToCart.clickAddtoCart();
		order = addToCart.clickCheckout();
		login = order.clickCheckOut();
		address = login.login1(prop.getProperty("username"), prop.getProperty("password"));
		ship = address.clickCheckOut();
		ship.clickCheckbox();
		payment  = ship.clickCheckOut();
		orderSummary = payment.clickBankwire();
		orderConfirm = orderSummary.clikConfirmOrder();
		String result = orderConfirm.verifyOrder();	
		Assert.assertEquals(result, "Your order on My Store is complete.");
	}
}
