package com.qa.hubspot.utill;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility {

	public static WebElement getElement(By selector, WebDriver driver) {
		WebElement ele = driver.findElement(selector);
		return ele;
	}

	public static void SelectByValue(WebDriver driver, By selector, String value) {
		WebElement element = getElement(selector, driver);
		Select sel = new Select(element);
		sel.selectByValue(value);

	}

	public static void deSelectByValue(WebDriver driver, By selector, String value) {

		WebElement element = getElement(selector, driver);
		Select sel = new Select(element);
		if (sel.isMultiple() == true) {
			sel.deselectByValue(value);
		}
		System.out.println("cannot deselect singleselect options");
	}

	public  static boolean isMultiple(WebDriver driver, By selector) {
		WebElement element = getElement(selector, driver);
		Select sel = new Select(element);
		System.out.println(sel.isMultiple());
     return sel.isMultiple();
	}

	public static void getAllOptions(WebDriver driver, By selector) {
		WebElement element = getElement(selector, driver);
		Select sel = new Select(element);
		List<WebElement> options = sel.getOptions();
		System.out.println("no. of options present: " + options.size());
		for (int i = 0; i < options.size(); i++) {
			String opts = options.get(i).getText();
			System.out.println(opts);
		}
	}

	public static void SelectByIndex(WebDriver driver, By selector, int n) {
		WebElement element = getElement(selector, driver);
		Select sel = new Select(element);
		List<WebElement> options = sel.getOptions();
		if (n < options.size()) {
			sel.selectByIndex(n);
		} else {
			System.out.println("Enter index value less than " + options.size());
		}
	}

public static void SelectAllOptions(WebDriver driver, By selector)
{ 
	WebElement element = getElement(selector, driver);
	Select sel = new Select(element);
	if(sel.isMultiple()){
	List<WebElement> options = sel.getAllSelectedOptions();
	for (int i=0;i<options.size();i++)
	{
	System.out.println(options);
}
	}
	else{
		System.out.println("it is multiselect");
	}
}
}