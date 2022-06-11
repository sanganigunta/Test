package com.qa.opencart.test;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterTest extends BaseTest{

	
	@BeforeClass
	public void regSetUp()
	{
		regPage = loginPage.doClickOnRegisterLink();
		
	}
	
	public static String generateRandomEmail()
	{
		Random rand = new Random();
		String email = "febAutomationBatch"+rand.nextInt(1000)+"@gmail.com";
		return email;
	} 
	
	@Test()
	public void testclass()
	{
		System.out.println("test is passed");
	}
	
	@DataProvider()
	public Object[][] getuserRegisterData()
	{
		Object data[][] = ExcelUtil.getExcelSheetData(Constants.REGISTER_SHEET_TEST_DATA_NAME);
		return data;
	}
	
	@Test(dataProvider="getuserRegisterData")
	public void douserRegisterTest(String firstname, String lastname, String telephonenum, String password, String subscribe)
	{
		regPage.userRegister(firstname,lastname,generateRandomEmail(),password,telephonenum,subscribe);
		//System.out.println(msg);
	}
}
