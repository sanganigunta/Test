package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.CommonsPage;
import com.qa.opencart.pages.ForgotPasswordPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductDetailedPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {

	DriverFactory df;
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected CommonsPage commonPage;
	protected Properties prop;
	protected SearchResultPage searchResultPage;
	protected AccountsPage accPage;
	protected ForgotPasswordPage forgotpswdPage;
	protected ProductDetailedPage pdpPage;
	protected RegisterPage regPage;
	protected SoftAssert softAssert;
	
	@BeforeTest()
	public void setUp()
	{
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage= new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	@AfterTest()
	public void tearDown()
	{
		driver.close();
	}
}
