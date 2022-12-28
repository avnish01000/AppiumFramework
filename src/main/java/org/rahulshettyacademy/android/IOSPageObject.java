package org.rahulshettyacademy.android;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class IOSPageObject {
IOSDriver driver;
	
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews;
	
 public void selectAlertVies()
 {
	 alertViews.click();
	 
 }

}
