package com.ajioShopping.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ajioShopping.base.BaseClass;
import com.ajioShopping.pageobjects.IndexPage;
import com.ajioShopping.pageobjects.LoginPage;
import com.ajioShopping.pageobjects.SignUpPage;

public class SignUpPageTest extends BaseClass{
	
	IndexPage index;
	LoginPage login;
	
	SignUpPage signup = new SignUpPage();
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testSignUp() {
		index = new IndexPage();
		login = index.clickSingInBtn();
		signup = login.createAccount("testpk@gmail.com");
		boolean actual = signup.validateSignUp();
		Assert.assertTrue(actual);
	}
}
