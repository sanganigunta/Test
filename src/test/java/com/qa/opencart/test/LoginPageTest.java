package com.qa.opencart.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	
	@Test()
	public void getLoginPageTest()
	{
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test()
	public void getLoginpageUrlTest()
	{
		String url = loginPage.getLoginPageUrl();
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	
	
	@Test()
	public void isForgotPaswdLinkExistTest()
	{
		Assert.assertTrue(loginPage.isForgotpwdLinkExist());
	}
	
	@Test()
	public void isRegisterLinkExistTest()
	{
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	
	@Test()
	public void getLoginPageLinksTest()
	{
		List<String> listVal = new ArrayList<String>();
		listVal = loginPage .getLoginPageLinks();
		Collections.sort(listVal);
		Collections.sort(Constants.LOGIN_PAGE_LINKS_LIST);
		Assert.assertEquals(listVal, Constants.LOGIN_PAGE_LINKS_LIST);
	}

	@AfterClass()
	public void doLoginTest()
	{
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password"));
	}
	
}
