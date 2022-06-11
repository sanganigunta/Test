package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class ProductDetailedPage {
	
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productName = By.cssSelector("div#content h1");
	private By productimages = By.cssSelector(".thumbnails img");
	private By productInformation = By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[position()=1]//li");
	private By productPrice = By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[position()=2]//li");
	private By productDesc =By.cssSelector("div.tab-content>#tab-description");
	
	
	public ProductDetailedPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getPDPProductName()
	{
		String productNameVal = eleUtil.waitForElementVisible(productName, Constants.DEFAULT_ELEMENT_WAIT_TIME).getText();
		System.out.println("Name of the product in the PDP is: "+productNameVal);
		return productNameVal;
		}
	
	public int getPDPproductsImagesCount()
	{
		return eleUtil.waitForElementsVisible(productimages, Constants.DEFAULT_ELEMENT_WAIT_TIME).size();
	}
	
	public String getPDPDescription()
	{
		String descText = eleUtil.waitForElementVisible(productDesc, Constants.DEFAULT_ELEMENT_WAIT_TIME).getText();
		return descText;
	}
	
	public Map<String,String> getPDPPageProductInfo()
	{   Map<String,String> productDesc = new HashMap<String, String>();
	    productDesc.put("name", getPDPProductName());
		List<WebElement> metaData =  eleUtil.waitForElementsVisible(productInformation, Constants.DEFAULT_ELEMENT_WAIT_TIME);
		for(WebElement dataVal:metaData)
		{
			String metaDataVal = dataVal.getText();
			String key =metaDataVal.split(":")[0].trim();
			String value =metaDataVal.split(":")[1].trim();
			productDesc.put(key, value);
		}
		
		List<WebElement> priceVal = eleUtil.getElements(productPrice);
		String actualPrice = priceVal.get(0).getText().trim();
		String taxPrice = priceVal.get(1).getText().trim();
		productDesc.put("price", actualPrice);
		productDesc.put("taxPriceVal",taxPrice);
		return productDesc;
	}
	

}
