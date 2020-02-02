package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ContactsPage extends BasePage 
{
	WebDriver driver;
	
	
	@FindBy(id = "uid-ctrl-1")
	WebElement emailID;
	
	@FindBy(id = "uid-ctrl-2")
	WebElement firstName;
	
	@FindBy(id = "uid-ctrl-3")
	WebElement lastName;
	
	@FindBy(id = "uid-ctrl-5")
	WebElement jobTitle;
	
	
	@FindBy(xpath="//span[contains(text(),'Create contact')]")
	WebElement firstCreateContact;
	
	@FindBy(xpath="//li//span[text()='Create contact']")
	WebElement secondCreateContact;
			
			
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
public void createnewContacts(String email,String firstname,String lastname,String jobtitle)
{
	WebDriverWait wait=new WebDriverWait(driver, 20);
	
	wait.until(ExpectedConditions.elementToBeClickable(firstCreateContact));
	firstCreateContact.click();
	
	
	
	wait.until(ExpectedConditions.elementToBeClickable(emailID));
	emailID.sendKeys(email);
	
	wait.until(ExpectedConditions.elementToBeClickable(firstName));
	firstName.sendKeys(firstname);
	
	wait.until(ExpectedConditions.elementToBeClickable(lastName));
	lastName.sendKeys(lastname);
	
	wait.until(ExpectedConditions.elementToBeClickable( jobTitle ));
	 jobTitle .sendKeys(jobtitle);
	 
	 wait.until(ExpectedConditions.elementToBeClickable(secondCreateContact));
		secondCreateContact.click();
}
}
