package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.commons.Constants;
import com.qa.hubspot.pages.LoginPage;

public class LoginTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {

		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		Thread.sleep(10000);
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void verifyLoginPageTitle() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page tile is " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGETITLE);
	}

	@Test(priority = 2)
	public void verfiySignUpLinkText() {
		Assert.assertTrue(loginPage.isSignUpVisible(), "sign up link is not visible");
	}

	@Test(priority = 3)
	public void verifyDoLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
