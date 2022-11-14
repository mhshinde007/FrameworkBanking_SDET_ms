package com.SdetBanking.TestCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.SdetBanking.Utilities.ReadConfig;

public class BaseClass {
	
//	Approach 1- Hardcoding
//	public String baseURL = "https://www.demo.guru99.com/V4/";
//	public String userName = "mngr347425";		
//	public String password = "pAgemeb";
//	public static WebDriver driver; 

//	Approach 2- creating config.prperties and readConfig.java -> followed in framework	
	
	ReadConfig readcfg = new ReadConfig();
	
	public String baseURL = readcfg.getURL1();
	public String userName = readcfg.getuname();		
	public String password = readcfg.getpwd();
	
	public static WebDriver driver; 
	public static Logger logger;
	

	@Parameters("browser")
	@BeforeClass
	public void setProperty(String br) 
	{
		logger	= Logger.getLogger("SDETBanking");
		PropertyConfigurator.configure("log4j.properties");
		//https://www.browserstack.com/guide/log4j-in-selenium
	
	//  Normal in one browser
	//	System.setProperty("webdriver.chrome.driver", "C:\Users\HP\eclipse-workspace\Banking_V1\Drivers\chromedriver.exe");
	//	driver= new ChromeDriver();
		
	// if want to run from xml with diff browser	
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readcfg.getChromePath());
			driver= new ChromeDriver();
		} else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readcfg.getFireFoxPath());
			driver= new FirefoxDriver();
		} 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.manage().window().maximize();
		
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
}
