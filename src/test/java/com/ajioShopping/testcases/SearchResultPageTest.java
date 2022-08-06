package com.ajioShopping.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ajioShopping.base.BaseClass;
import com.ajioShopping.pageobjects.IndexPage;
import com.ajioShopping.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	
	SearchResultPage search;
	IndexPage index;
	
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testSearchResult() {
		index = new IndexPage();
		search = index.searchProduct("t-shirt");
		boolean result = search.validateSearchResult();
		Assert.assertTrue(result);
	}

}
