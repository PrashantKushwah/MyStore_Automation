package com.ajioShopping.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ajioShopping.base.BaseClass;
import com.ajioShopping.pageobjects.HomePage;
import com.ajioShopping.pageobjects.IndexPage;
import com.ajioShopping.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	
	IndexPage index = null;
	LoginPage login = new LoginPage();
	HomePage home = new HomePage();
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testWishList() {
		index = new IndexPage();
		login = index.clickSingInBtn();
		home = login.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean actual = home.validateMyWishList();
		Assert.assertTrue(actual);
	}
	
	@Test
	public void testOrderHistory() {
		index = new IndexPage();
		login = index.clickSingInBtn();
		home = login.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean actual = home.validateOrderHistory();
		Assert.assertTrue(actual);
	}
	
	

}
