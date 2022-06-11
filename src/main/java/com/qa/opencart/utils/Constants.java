package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE ="Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final List<String> LOGIN_PAGE_LINKS_LIST = Arrays.asList("Login","Register","Forgotten Password",
			"My Account","Address Book","Wish List","Order History","Downloads","Recurring payments","Reward Points","Returns",
			"Transactions","Newsletter");
	public static final String SEARCH_RESULT_PAGE_HEADER_FRACTION = "Search";
	public static final String ACCOUNTS_PAGE_TITLE ="My Account";
	public static final String ACCOUNTS_PAGE_URL_FRACTION ="route=account/account";
	public static final List<String> ACCOUNTS_PAGE_SECTION_HEADER_VAL = Arrays.asList("My Account",
			                                                                           "My Orders",
			                                                                           "My Affiliate Account",
			                                                                           "Newsletter");
	public static final String LOGIN_PAGE_LOGOUT_MSG = "Account Logout";
	
	public static final String FORGOTPSWD_FAILURE_MSG ="Warning: The E-Mail Address was not found in our records, please try again!";
	public static final String FORGOTPSWD_SUCCESS_MSG ="An email with a confirmation link has been sent your email address.";
	public static final String FORGOT_PSWD_PAGE_TITLE = "Forgot Your Password?";
	public static final String FORGOT_PSWD_PAGE_URL_FRACTION = "route=account/forgotten";
	
	public static final int DEFAULT_TIME_OUT =5;
	public static final int DEFAULT_ELEMENT_WAIT_TIME =10;
	
	public static final String REGISTER_SUCESSMSG ="Your Account Has Been Created!";
	public static final String REGISTER_SHEET_TEST_DATA_NAME = "Registerpage";
	
	
	

}
