package com.SdetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SdetBanking.PageObjects.LoginPage;
import com.SdetBanking.Utilities.XLUtils;

public class TC_LoginTest_DDT_002 extends BaseClass{
	
	@Test (dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException 
	{
		LoginPage login = new LoginPage(driver);
		login.enterUID(user);
		login.enterpwd(pwd);
		login.clickLogin();		
		
		Reporter.log("UID & PWD Entered");
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) 
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
			logger.info("login failed");
			
			Reporter.log("TC Failed");
			
		}else 
		{
			Assert.assertTrue(true);
			login.clickLogOut();
			
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
			
			Reporter.log("TC Passed");
			
		}	
	}
		
	public boolean isAlertPresent() //user defined method to check if Alert is Present
	{
		try 
		{
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e) 
		{
			return false;
		}
	}
	
	@DataProvider (name="LoginData")
	String [][] getData() throws IOException 
	{
		String path = System.getProperty("user.dir")+ "/src/test/java/com/SdetBanking/TestData/LoginData.xlsx";	
		int rownum = XLUtils.getRowCount(path,"Sheet1");
		int cellnum = XLUtils.getCellCount(path,"Sheet1", rownum);	
		String LoginData[][] = new String [rownum][cellnum];		
		for (int i=1; i<=rownum ; i++) 
		{
			for (int j=0; j<cellnum ; j++)     // ithe j chya jagi i zalta mhnun ArrayIndexOutOfBoundExcption ala hota
			{
				LoginData[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}		
		return LoginData;
	}
}
