package org.rahulshettyacademy.utils;

import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils{

    IOSDriver driver;

    public IOSActions(IOSDriver driver)
    {

        this.driver=driver;
    }

    //GrandParent (AppiumUtils) --> IOSActions -->PageObject Class

}
