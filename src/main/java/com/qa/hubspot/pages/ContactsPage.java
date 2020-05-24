package com.qa.hubspot.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ContactsPage extends BasePage 
{
	WebDriver driver;
	
	
	@FindBy(id = "UIFormControl-34")
	WebElement emailID;
	
	@FindBy(id = "UIFormControl-36")
	WebElement firstName;
	
	@FindBy(id = "UIFormControl-40")
	WebElement lastName;
	
	@FindBy(id = "UIFormControl-48")
	WebElement jobTitle;
	
	
	@FindBy(xpath="//span[contains(text(),'Create contact')]")
	WebElement firstCreateContact;
	
	@FindBy(xpath="//footer[@class='private-modal__footer uiDialogFooter']")
	WebElement footerElement;
	
	@FindBy(xpath="//li//span[text()='Create contact']")
	WebElement secondCreateContact;
			
		@FindBy(xpath="//span[@class='private-checkbox__icon private-checkbox__dash']")
		List<WebElement> checkboxes;
 
		@FindBy(xpath="//li[3]//button[1]")
		WebElement deletebtn;
		
		@FindBy(xpath="//div[@class='UIMatchTextArea__PlaceholderText-sc-4i26wd-1 hoCvKw form-control private-form__control']")
		WebElement deletetxtbox;
		
		@FindBy(id="UIFormControl-41")
		WebElement textarea;
		
   @FindBy(xpath="//button[@class='uiButton private-button private-button--destructive private-button--default m-left-0 private-button--non-link']")
      WebElement seconddeletebtn;



	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
public void createnewContacts(String email,String firstname,String lastname,String jobtitle) throws InterruptedException 
{
	WebDriverWait wait=new WebDriverWait(driver,20);
	
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
	 
	
	 //wait.until(ExpectedConditions.elementToBeClickable(secondCreateContact));
	 Actions actions = new Actions(driver);
	 actions.moveToElement(secondCreateContact).click().build().perform();
		 
}
public void deleteContacts() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver,50);
	List<WebElement> chk = checkboxes;
	for (int i =0;i<chk.size()-1;i++)
	{
		if(!chk.get(i).isSelected())
		{
			chk.get(i).click();
			
			break;
		}
		}
	
	Thread.sleep(2000);
	Actions actions = new Actions(driver);
	try {
		deletebtn.click();
		}
	catch(NoSuchElementException e){
		WebElement ele=driver.findElement(By.xpath("//div[@class='private-microcopy IndexPageRedesignHeader__StyledTitleDetails-ljkrr-0 kbeUyE']"));
		String NoContactText = ele.getText();
		if(NoContactText.equals("0 contacts"))
		{
			System.out.println("there are not contacts to delete");
		}
	}
	Thread.sleep(2000);
	String txt=deletetxtbox.getText();
	Thread.sleep(2000);
	actions.moveToElement(deletetxtbox).click().build().perform();
	Thread.sleep(2000);
	actions.moveToElement(deletetxtbox).sendKeys(txt).build().perform();
	Thread.sleep(2000);

	if (seconddeletebtn.isEnabled())
	{
	   System.out.println("is Enabled");
		Thread.sleep(2000);
		actions.moveToElement(seconddeletebtn).click().build().perform();
		}
	else {
		System.out.println("not enabled yet.. :( ");
	}

}
}


