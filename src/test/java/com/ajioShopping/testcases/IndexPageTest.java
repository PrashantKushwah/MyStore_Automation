package com.ajioShopping.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ajioShopping.base.BaseClass;
import com.ajioShopping.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage index;
	
	@BeforeMethod
	public void setup(){
		launchApp();
	}
	
	
	@Test
	public void testMyLogo() {
		index = new IndexPage();
		boolean result = index.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifyTitle() {
		String actTitle = index.getMyStoreTile();
		Assert.assertEquals(actTitle, "My Store");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
