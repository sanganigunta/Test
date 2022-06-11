package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	By accPageSectionheaders = By.cssSelector("div#content h2");
	By logoutLink = By.linkText("Logout");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getAccPageTitle()
	{
		String accPageTitle = driver.getTitle();
		System.out.println("Accounts page title is: "+accPageTitle);
		return accPageTitle;
	}
	
	public String getAccPageURL()
	{
		String accPageUrl = driver.getCurrentUrl();
		System.out.println("Accounts page url is: "+accPageUrl);
		return accPageUrl;
	}
	
	public List<String> getAccPageSectionHeader()
	{
		List<String> headerListVal = new ArrayList<String>();
		List<WebElement> accPageHeaderList = driver.findElements(accPageSectionheaders);
		for(WebElement accPageHeader:accPageHeaderList)
		{
			String headerText = accPageHeader.getText();
			headerListVal.add(headerText);
		}
		
		return headerListVal;
	}
	
	public boolean islogoutLinkExist()
	{
		return driver.findElement(logoutLink).isDisplayed();
	}
	
	public LoginPage doLogout()
	{
		if(islogoutLinkExist())
		{
			driver.findElement(logoutLink).click();
			}
		return new LoginPage(driver);
	}
	

}
