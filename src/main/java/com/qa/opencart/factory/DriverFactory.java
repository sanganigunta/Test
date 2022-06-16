package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory{
	
	WebDriver driver;
	Properties prop;
	public OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop)
	{
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is: "+browserName);
		optionsManager = new OptionsManager(prop);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please pass the correct browser name: "+browserName);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
	}
	
	public synchronized WebDriver getDriver()
	{
		return tlDriver.get();
			}
	
	public Properties init_prop()
	{
		FileInputStream ip =null;
		prop = new Properties();
		
		String envName = System.getProperty("envValue");
		System.out.println("Entered environment value is: "+envName);
		
		if(envName==null)
		{
			System.out.println("No environment is bening passed.... hence running in QA environment. ");
			try {
				ip = new FileInputStream(".\\src\\resources\\test\\configurations\\qa.Config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		else {
		try {
		switch (envName.toLowerCase())
		{
		case "qa":
			ip = new FileInputStream(".\\src\\resources\\test\\configurations\\qa.Config.properties");
			break;
		case "dev": 
			ip = new FileInputStream(".\\src\\resources\\test\\configurations\\dev.Config.properties");
			break;
		case "int":
			ip = new FileInputStream(".\\src\\resources\\test\\configurations\\stag.Config.properties");
			break;
		case "uat":
			ip = new FileInputStream(".\\src\\resources\\test\\configurations\\uat.Config.properties");
			break;
		case "prod":
				ip = new FileInputStream(".\\src\\resources\\test\\configurations\\Config.properties");
			break;

		default:System.out.println("Please pass the correct environment: "+envName);
		break;
		}
		}
		
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		return prop;
	}
	public String getScreenshot()
	{
		TakesScreenshot ts = (TakesScreenshot)getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String path = ".//screenshots"+System.currentTimeMillis()+".png";
		File desFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, desFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
	
	
	
}
