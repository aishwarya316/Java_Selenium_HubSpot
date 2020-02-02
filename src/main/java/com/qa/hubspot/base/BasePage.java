package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.hubspot.commons.Constants;

public class BasePage {
WebDriver driver;
Properties prop;
FileInputStream ip;

public WebDriver initialize_driver(Properties prop){
	String browserName= prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(browserName.equals("InternetExplorer"))
	{
		driver=new InternetExplorerDriver();
	}
	driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	//driver.manage().window().fullscreen();
	
	return driver;
}
public Properties initialize_Properties() {
	prop= new Properties();
try {
		ip = new FileInputStream("F:\\selenium\\HybridFramework1\\src\\main\\java\\com\\qa\\hubspot\\configuration\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e1) {
	e1.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return prop;
}
}
