package com.SdetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig () 
	{
		File src = new File ("./Configurations/config.properties");
		
		try {
			FileInputStream fls = new FileInputStream(src);
			pro = new Properties();
			pro.load(fls);		
			} 
		catch (IOException e) 
			{
			
			System.out.println("Exception is "+ e.getMessage());;
			} 
	}
	
	public String getURL1 () 
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getuname () 
	{
		String uname = pro.getProperty("userName");
		return uname;
	}
	
	public String getpwd () 
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getChromePath () 
	{
		String chromePath = pro.getProperty("chromepath");
		return chromePath ;
	}
	
	public String getFireFoxPath () 
	{
		String firefoxPath = pro.getProperty("ffoxpath");
		return firefoxPath ;
	}
}
