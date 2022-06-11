package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest{

	
	@BeforeClass
	public void accPageSetup()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test()
	public void getAccPageTitleTest()
	{
		String accPageTitle = accPage.getAccPageTitle();
		Assert.assertEquals(accPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test()
	public void getAccPageUrlTest()
	{
		String accPageUrl = accPage.getAccPageURL();
		Assert.assertTrue(accPageUrl.contains(Constants.ACCOUNTS_PAGE_URL_FRACTION));
	}
	
	@Test()
	public void getAccPageHeaderSectionListTest()
	{
		List<String> accPageSectionHeadersVal = accPage.getAccPageSectionHeader();
		Assert.assertEquals(accPageSectionHeadersVal, Constants.ACCOUNTS_PAGE_SECTION_HEADER_VAL);
	}
	
	@Test()
	public void isLogoutLinkExistTest()
	{
		Assert.assertTrue(accPage.islogoutLinkExist());
		
	}
	
	@AfterClass()
	public void DoLogoutTest()
	{
		loginPage = accPage.doLogout();
		String logoutMesg = loginPage.getLogoutMessage();
		Assert.assertEquals(logoutMesg, Constants.LOGIN_PAGE_LOGOUT_MSG);
	}
}
