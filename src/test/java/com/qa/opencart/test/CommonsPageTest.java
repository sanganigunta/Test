package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.CommonsPage;
import com.qa.opencart.pages.SearchResultPage;

public class CommonsPageTest extends BaseTest {
	
	@BeforeClass()
	public void CommonPagesetUp()
	{
		commonPage = new CommonsPage(driver);
	}
	
	@Test(priority =1)
	public void isLogoExistTest()
	{
		Assert.assertTrue(commonPage.isLogoExist());	
	}
	
	@Test(priority=2)
	public void isCartBtnExist()
	{
		Assert.assertTrue(commonPage.isCartBtnExist());
	}
	
	@Test(dataProvider ="sendProductName", priority=3)
	public SearchResultPage dosearchTest(String productName)
	{
		commonPage.dosearch(productName);
		return new SearchResultPage(driver);
	}
	
	@DataProvider()
	public Object[][] sendProductName()
	{
		return new Object[][] { {"macbook"},
			{"imac"},
			{"samsung"}
		};
			
		
	}

}
