package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class ForgotPasswordPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By forgotPswdHeader = By.cssSelector("div#content>h1");
	private By emailId = By.id("input-email");
	private By continueBtn = By.cssSelector("input[value='Continue']");
	
	
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	public String getForgotPasswordPageTitle()
	{
		String title = eleUtil.waitForTitleIs(Constants.FORGOT_PSWD_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
		System.out.println("Forgotpassword page title: "+title);
		return title;
	}
	
	public String getForgotPasswordPageUrl()
	{
		String url = eleUtil.waitForUrlContains(Constants.FORGOT_PSWD_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
		System.out.println("Forgotpassword page url is: "+url);
		return url;
	}
	
	public String ForgotPswddPageHeader()
	{
		String header = eleUtil.waitForElementVisible(forgotPswdHeader, Constants.DEFAULT_ELEMENT_WAIT_TIME).getText();
		System.out.println("ForgotPassword page header is: "+header);
		return header;
	}
	
	public LoginPage sendMail(String mailId)
	{
		eleUtil.waitForElementVisible(emailId,Constants.DEFAULT_ELEMENT_WAIT_TIME).sendKeys(mailId);;
		eleUtil.doClick(continueBtn);
		return new LoginPage(driver);
	}

	
}
