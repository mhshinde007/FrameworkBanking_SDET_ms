package com.SdetBanking.TestCases;

import org.testng.annotations.Test;

import com.SdetBanking.PageObjects.LoginPage;

import org.testng.Assert;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() 
	{
		
	//	driver.get(baseURL);    removing from here and put in baseclass, when need to oprn diff browsers from xml
		logger.info("URL is opened");
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUID(userName);
		login.enterpwd(password);
		login.clickLogin();
		
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case passed");
		}else 
		{
			Assert.assertTrue(false);
			logger.info("Test Case failed");
		}
		
	
	}

}
