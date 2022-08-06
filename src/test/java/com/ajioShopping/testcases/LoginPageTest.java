package com.ajioShopping.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ajioShopping.base.BaseClass;
import com.ajioShopping.pageobjects.HomePage;
import com.ajioShopping.pageobjects.IndexPage;
import com.ajioShopping.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	IndexPage indexPage;
	
	@BeforeMethod
	public void setup(){
		launchApp();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	@Test
	public void testLogin() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickSingInBtn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL = homePage.getURL();
		String expURL = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expURL);
	}
}
