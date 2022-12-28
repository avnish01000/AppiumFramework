package org.rahulshettyacademy.pageObjects.IOS;

import io.appium.java_client.ios.IOSDriver;
import org.rahulshettyacademy.utils.IOSActions;

public class AlertViews extends IOSActions {

    IOSDriver driver;
    public AlertViews(IOSDriver driver) {
        super(driver);
        this.driver=driver;
    }
}
