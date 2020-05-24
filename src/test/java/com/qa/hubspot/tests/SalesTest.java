package com.qa.hubspot.tests;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.SalesPage;
import com.qa.hubspot.utill.robotUtil;

public class SalesTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homepage;
	SalesPage salespage;

	@BeforeMethod
	public void setUp() throws InterruptedException, AWTException  {
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		Thread.sleep(10000);
		loginPage = new LoginPage(driver);
		homepage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
		salespage= homepage.gotoSalesPage();
		salespage=salespage.selectDocuments();
	

	}
	
	@Test()
	public void documentschk()throws AWTException, InterruptedException
	{
		
		Thread.sleep(10000);
		salespage.uploadDoc(driver);
		//robotUtil.selectFile(prop);
	}
	
@AfterMethod()
	public void tearDown()
	{
	driver.quit();
	}
}
