package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class CommonsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By searchBox = By.cssSelector("div#search>input");
	private By searchIcon = By.cssSelector("div#search button");
	private By logo = By.cssSelector("div#logo");
	private By cartIcon = By.cssSelector("div#cart");
	
	public CommonsPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public SearchResultPage dosearch(String productName)
	{
		WebElement search = eleUtil.waitForElementVisible(searchBox, Constants.DEFAULT_ELEMENT_WAIT_TIME);
		search.clear();
		search.sendKeys(productName);
		eleUtil.doClick(searchIcon);
		return new SearchResultPage(driver);
	}
	
	public boolean isLogoExist()
	{
		return eleUtil.waitForElementVisible(logo, Constants.DEFAULT_ELEMENT_WAIT_TIME).isDisplayed();
		}

	public boolean isCartBtnExist()
	{
		return eleUtil.waitForElementVisible(cartIcon, Constants.DEFAULT_ELEMENT_WAIT_TIME).isDisplayed();
		}
}
