package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utill.ExcelUtil;

public class ContactsTest
{
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homepage;
	ContactsPage contactspage;
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
		contactspage=homepage.gotoContactPage();
		
	}
	@DataProvider(name = "getContactsData")
	public Object[][] getContactsTestData() {
		Object contactsData[][] = ExcelUtil.getTestData("contacts");
		return contactsData;
	}

	@Test(dataProvider = "getContactsData")
	public void createContactsTest(String email, String firstName, String lastName, String jobTitle) {
		contactspage.createnewContacts(email, firstName, lastName, jobTitle);
	}


@AfterMethod
public void tearDown() {
	driver.quit();
}
	
	
}
