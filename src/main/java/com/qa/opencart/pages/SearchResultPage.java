package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By searchPageHeader = By.cssSelector("div#content>h1");
	private By productList = By.cssSelector("div.product-thumb h4");
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getSearchPageHeader()
	{
		String PageHeader = eleUtil.waitForElementVisible(searchPageHeader, Constants.DEFAULT_ELEMENT_WAIT_TIME).getText();
		return PageHeader;
	}
	
	public ProductDetailedPage selectProductFromSearchResult(String mainProductName)
	{
		 eleUtil.doClick(By.linkText(mainProductName));
		 return new ProductDetailedPage(driver);	
		 }
	
	
	
	


}
