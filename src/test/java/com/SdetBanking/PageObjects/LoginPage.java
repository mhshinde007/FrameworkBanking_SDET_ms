package com.SdetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	@FindBy(name = "uid") private WebElement userID;
	@FindBy(name = "password") private WebElement pwd;
	@FindBy(name = "btnLogin") private WebElement loginButton;
	@FindBy(name = "btnReset") private WebElement resetButton;
	@FindBy(xpath = "//a[text()='Log out']") private WebElement LogoutButton;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUID (String uid) 
	{
		userID.sendKeys(uid);
	}
	
	public void enterpwd (String pswd) 
	{
		pwd.sendKeys(pswd);
	}
	
	public void clickLogin () 
	{
		loginButton.click();
	}

	public void clickLogOut () 
	{
		LogoutButton.click();
	}

}
