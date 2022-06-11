package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
    private By forgotPwdLink = By.linkText("Forgotten Password");
    private By registerLink= By.xpath("//aside[@id='column-right']//a[text()='Register']");
    private By links = By.cssSelector("div.list-group>a");
    private By logoutMessage = By.cssSelector("div#content>h1");
    private By forgotpswdFailMesg = By.cssSelector("div.alert.alert-danger");
    private By forgotpswdsucessMesg = By.cssSelector("div.alert.alert-success.alert-dismissible");
  

    
    public LoginPage(WebDriver driver)
    {
    	this.driver = driver;
    	eleUtil = new ElementUtil(this.driver);
    }
    
    
    public String getLoginPageTitle()
    {
    	String title = eleUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
    	System.out.println("Login page title is: "+title);
    	return title;
    }
	
    
    public String getLoginPageUrl()
    {
    	String url = eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
    	System.out.println("Url of the login page is: "+url);
    			return url;
    }
    
    public boolean isForgotpwdLinkExist()
    {
    	return eleUtil.waitForElementVisible(forgotPwdLink, Constants.DEFAULT_ELEMENT_WAIT_TIME).isDisplayed(); 
    			
    }
    
    
    public boolean isRegisterLinkExist()
    {
    	return eleUtil.waitForElementVisible(registerLink, Constants.DEFAULT_ELEMENT_WAIT_TIME).isDisplayed();
    			
    }
    
    public List<String> getLoginPageLinks()
    {
    	List<String> linksListVal = new ArrayList<String>();
    	List<WebElement> linksList = eleUtil.waitForElementsVisible(links, Constants.DEFAULT_ELEMENT_WAIT_TIME);
    	for(WebElement link:linksList)
    	{
    		linksListVal.add(link.getText().trim());
    	}
    	return linksListVal;
    }
    
    public AccountsPage doLogin(String username, String pswd)
    {
    	eleUtil.waitForElementVisible(emailId, Constants.DEFAULT_ELEMENT_WAIT_TIME).sendKeys(username);;
    	eleUtil.doSendKeys(password, pswd);
    	eleUtil.doClick(loginBtn);
    	return new AccountsPage(driver);
    }
    
    public ForgotPasswordPage verifyForgotPswdLink()
    {
    	if(isForgotpwdLinkExist())
    	{
    		eleUtil.doClick(forgotPwdLink);
    	}
    	return new ForgotPasswordPage(driver);
    			
    }
    
    public String getForgotPswdFailureMsg()
    {
    	String failMsg = eleUtil.waitForElementVisible(forgotpswdFailMesg, Constants.DEFAULT_ELEMENT_WAIT_TIME).getText();
    			return failMsg;
    }
    
    public String getForgotPswdSucessMsg()
    {
    	String sucessMsg = eleUtil.waitForElementVisible(forgotpswdsucessMesg, Constants.DEFAULT_ELEMENT_WAIT_TIME).getText();
    		return sucessMsg;
    }
    
    public String getLogoutMessage()
    {
    	String logoutMessage = eleUtil.waitForElementVisible(this.logoutMessage, Constants.DEFAULT_ELEMENT_WAIT_TIME).getText();
    	System.out.println("Logout message is: "+logoutMessage);
    	return logoutMessage;
    }
    
  
    
    public RegisterPage doClickOnRegisterLink()
    {
    	if(isRegisterLinkExist())
    	{
    		eleUtil.doClick(registerLink);
    	}
    	return new RegisterPage(driver);
    }
}
