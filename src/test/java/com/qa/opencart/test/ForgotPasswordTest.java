package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class ForgotPasswordTest extends BaseTest{

	@BeforeClass()
	public void getForgotpaswdPage()
	{
		forgotpswdPage = loginPage.verifyForgotPswdLink();
	}
	
	
	@Test(priority=1)
	public void getForgotPasswordPageTitleTest()
	{
		String title = forgotpswdPage.getForgotPasswordPageTitle();
		Assert.assertEquals(title, Constants.FORGOT_PSWD_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void getForgotPasswordPageUrlTest()
	{
		String url = forgotpswdPage.getForgotPasswordPageUrl();
		Assert.assertTrue(url.contains(Constants.FORGOT_PSWD_PAGE_URL_FRACTION));
	}
	
	@Test(priority=3)
	public void getForgotPasswordPageHeaderTest()
	{
		String header = forgotpswdPage.ForgotPswddPageHeader();
		Assert.assertEquals(header, Constants.FORGOT_PSWD_PAGE_TITLE);
	}
	
	@DataProvider()
	public Object[][] sendMailToForgotPaswdsucessMsg()
	{
		return new Object[][]
				{ {"divya.sanganigunta@gmail.com"},
			     {"naveenanimation20@gmail.com"}
			
				};
	}

	@DataProvider()
	public Object[][] sendMailToForgotPaswdFailMsg()
	{
		return new Object[][]
				{ {"divya.sanganigunta1234@gmail.com"},
			     {"test1234@gmail.com"},
			     {"    "},
			     {"1323a#$5t6yz7"}
			
				};
	}
	
	
	@Test(dataProvider="sendMailToForgotPaswdFailMsg",priority=4)
	public void SendMailGmailFailTest(String failMailId)
	{
		loginPage = forgotpswdPage.sendMail(failMailId);
		String failMsg = loginPage.getForgotPswdFailureMsg();
	    Assert.assertTrue(failMsg.contains(Constants.FORGOTPSWD_FAILURE_MSG));
		loginPage.verifyForgotPswdLink();
		}
	
	@Test(dataProvider="sendMailToForgotPaswdsucessMsg",priority=5)
	public void SendMailGmailSucessTest(String sucessmail)
	{
		loginPage = forgotpswdPage.sendMail(sucessmail);
		String failMsg = loginPage.getForgotPswdSucessMsg();
		Assert.assertTrue(failMsg.contains(Constants.FORGOTPSWD_SUCCESS_MSG));
		loginPage.verifyForgotPswdLink();
		}
}
