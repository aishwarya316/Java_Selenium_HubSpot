package com.qa.hubspot.utill;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;



import com.qa.hubspot.base.BasePage;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class robotUtil extends BasePage {
	

	public static void selectFile(Properties prop) throws AWTException
	{
		
	   StringSelection stringSelection = new StringSelection(prop.getProperty("file_Path"));
	   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	//setClipboardData(stringSelection);
	//native key strokes for CTRL, V and ENTER keys
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
