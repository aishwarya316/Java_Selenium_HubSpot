package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {
WebDriver driver;

	@FindBy(id="username")
	WebElement emailID;
	
	@FindBy(id="password")
	WebElement password ;
	
	@FindBy(id="loginBtn")
	WebElement loginButton ;
	
	@FindBy(linkText="Sign up")
	WebElement  signUpLink ;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean isSignUpVisible()
	{
		return signUpLink.isDisplayed();
	}
	public HomePage doLogin(String un,String pwd)
	{
		emailID.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage(driver);
	}
	
}
