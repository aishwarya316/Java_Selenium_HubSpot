package com.qa.hubspot.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utill.robotUtil;

public class SalesPage extends BasePage {
	WebDriver driver;
	SalesPage salespage;
	By salesMenuOptns =By.xpath("//a[normalize-space(@class)='navSecondaryLink']");
	By uploadDocument= By.xpath("//button[@id='uiabstractdropdown-button-2']");
	By localfilebtn=By.xpath("//i18n-string[normalize-space(text())='Local file')]");
	
	SalesPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public SalesPage selectDocuments() throws AWTException, InterruptedException
	{
		List<WebElement> allMenuOptns=driver.findElements(salesMenuOptns);
		
		 for(WebElement link:allMenuOptns)
		 {
			 String str=link.getAttribute("innerText").replaceAll("\\s","").trim();
			 while(str.equals("Documents"))
			 {
				link.click();
				break;
			}
		 }
		 return new SalesPage(driver);
 }
	public void uploadDoc(WebDriver driver) throws AWTException, InterruptedException
	{
	
		salespage.selectDocuments();
		driver.findElement(uploadDocument).click();
		driver.findElement(localfilebtn).click();
	}
}

