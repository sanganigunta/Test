package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.CommonsPage;

public class SearchResultPageTest extends BaseTest {
	
	@BeforeClass()
	public void slpSetup() {
	commonPage = new CommonsPage(driver);
	}
	
	@DataProvider
	public Object[][] getProductName()
	{
		return new Object[][]{
				{"MacBook"},
				{"iMac"},
				{"samsung"}
				
		};
	}
	
	@Test(dataProvider="getProductName")
	public void getSearchResultPageHeader(String prodName)
	{
		commonPage = new CommonsPage(driver);
		searchResultPage=commonPage.dosearch(prodName);
		String headerVal = searchResultPage.getSearchPageHeader();
		System.out.println(headerVal);
		Assert.assertTrue(headerVal.contains(prodName));
	}	
	
	@DataProvider()
	public Object[][] pdpHeader()
	{
		return new Object[][] {
			{"MacBook","MacBook Air"},
			{"MacBook","MacBook Pro"},
			{"samsung","Samsung SyncMaster 941BW"},
			{"imac","iMac"}
		};
	}
	
	@Test(dataProvider="pdpHeader")
	public void getProductNameonPDPTest(String productName, String mainProductName)
	{
		searchResultPage = commonPage.dosearch(productName);
		pdpPage = searchResultPage.selectProductFromSearchResult(mainProductName);
		Assert.assertTrue(pdpPage.getPDPProductName().contains(mainProductName));
	}
	
	@DataProvider()
	public Object[][] getImagesCountVal()
	{
		return new Object[][]
				{
			         {"MacBook","MacBook Air", 4},
			         {"MacBook","MacBook Pro",4},
			     	{"samsung","Samsung SyncMaster 941BW",1},
				};
	}
	
	@Test(dataProvider="getImagesCountVal")
	public void getPDPImagesCount(String productName, String mainProductName, int exctedCount)
	{
		searchResultPage = commonPage.dosearch(productName);
		pdpPage = searchResultPage.selectProductFromSearchResult(mainProductName);
		int imagesCount = pdpPage.getPDPproductsImagesCount();
		Assert.assertEquals(imagesCount,exctedCount);
	}
	
	@DataProvider()
	public Object[][] getDescription()
	{
		return new Object[][]
				{ 
			{"MacBook","MacBook Air","MacBook Air"},
			{"MacBook","MacBook Pro","Latest Intel mobile architecture"}
			};
	}
	
	@Test(dataProvider="getDescription")
	public void getPDPDescriptionTest(String productName, String mainProductName, String expectedString)
	{
		searchResultPage = commonPage.dosearch(productName);
		pdpPage = searchResultPage.selectProductFromSearchResult(mainProductName);
		String pdpDesc = pdpPage.getPDPDescription();
		softAssert.assertTrue(pdpDesc!=null);
		softAssert.assertFalse(pdpDesc.isEmpty());
		softAssert.assertTrue(pdpDesc.contains(expectedString));
		softAssert.assertAll();
		
	}

	
	@Test()
	public void getProductDescription()
	{
		searchResultPage = commonPage.dosearch("macbook");
		pdpPage = searchResultPage.selectProductFromSearchResult("MacBook Pro");
		Map<String, String> desc = pdpPage.getPDPPageProductInfo();
		desc.forEach((k,v)->System.out.println(k+":"+v));
		softAssert.assertEquals(desc.get("name"), "MacBook Pro");
		softAssert.assertEquals(desc.get("Brand"), "Apple");
		softAssert.assertEquals(desc.get("Product Code"), "Product 18");
		softAssert.assertEquals(desc.get("Reward Points"), "800");
		softAssert.assertEquals(desc.get("price"), "$2,000.00");
		softAssert.assertEquals(desc.get("taxPriceVal"), "Ex Tax: $2,000.00");
		softAssert.assertAll();
	}
}
