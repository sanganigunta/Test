package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPswd = By.id("input-confirm");
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]//input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]//input[@type='radio']");
	private By privacyPolicy = By.name("agree");
	private By continueBtn = By.xpath("//input[@value='Continue']");
	private By registerSuccessMsg = By.cssSelector("div#content>h1");
	
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil= new ElementUtil(this.driver);
	}
	
	
	public void userRegister(String firstName, String lastName,String email, String telePhoneNum,String password, String subscribe)
	{
		eleUtil.waitForElementVisible(this.firstName, Constants.DEFAULT_ELEMENT_WAIT_TIME).sendKeys(firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telePhoneNum);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(confirmPswd, password);
		 if(subscribe.equalsIgnoreCase("yes"))
		 {
			 eleUtil.doClick(subscribeYes);
		 }
		 else
		 {
			 eleUtil.doClick(subscribeNo);
		 }
		 
		 eleUtil.doClick(privacyPolicy);
        // eleUtil.doClick(continueBtn);
      //  String registerMsg = eleUtil.waitForElementVisible(registerSuccessMsg, Constants.DEFAULT_ELEMENT_WAIT_TIME).getText();
       //  return registerMsg;
       }
	
	

}
