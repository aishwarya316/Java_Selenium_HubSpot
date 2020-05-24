package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage  {
	WebDriver driver;
	@FindBy(xpath="//h1[@class='private-header__heading']")
	WebElement HeaderTitle;
	
	@FindBy(xpath="//span[@class='account-name ']")
	WebElement accountName ;
	
	@FindBy(id="nav-primary-contacts-branch")
	WebElement firstContactsBtn;
	
	@FindBy(id="nav-secondary-contacts")
	WebElement secondContactsBtn;
	
	//@FindBy(id="nav-secondary-contacts")
	//WebElement secondContactsBtn;
	
	@FindBy(id="nav-primary-sales-branch")
	WebElement salesBtn;
	
	//@FindBy(id="	nav-secondary-documents")
    //WebElement documentBtn;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderTitle()
	{
		return HeaderTitle.getText();
	}
public String getLoggedInAccountName()
{
	
	return accountName.getText();
}
public ContactsPage gotoContactPage() throws InterruptedException
{
	firstContactsBtn.click();
	Thread.sleep(8000);
	secondContactsBtn.click();
	return new ContactsPage(driver);
}

public SalesPage  gotoSalesPage() throws InterruptedException{
	salesBtn.click();
	Thread.sleep(8000);
	//documentBtn.click();
	return new SalesPage(driver);
}
}
