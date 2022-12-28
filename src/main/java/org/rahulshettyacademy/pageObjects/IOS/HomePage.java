package org.rahulshettyacademy.pageObjects.IOS;

import io.appium.java_client.ios.IOSDriver;
import org.rahulshettyacademy.utils.IOSActions;

public class HomePage extends IOSActions {

    IOSDriver driver;
    public HomePage(IOSDriver driver) {
        super(driver);
        this.driver=driver;
    }
}
