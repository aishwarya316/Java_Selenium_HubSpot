package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.commons.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homepage;

	@BeforeMethod
	public void setUp() throws InterruptedException {

		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		Thread.sleep(10000);
		loginPage = new LoginPage(driver);
		homepage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
	}

	@Test(priority = 1)
	public void verifyGetHomePageTitleTest() throws InterruptedException {
        String header = homepage.getHeaderTitle();
		System.out.println("header title is  " + header);
		Assert.assertEquals(header, Constants.HOME_PAGETITLE);
	}

	@Test(priority = 2)
	public void verifyLoggedInAccountNameTest() {
		String accountName = homepage.getLoggedInAccountName();
		System.out.println("Logged in account name is  "+accountName);
		Assert.assertEquals(accountName, prop.getProperty("account_Name"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
