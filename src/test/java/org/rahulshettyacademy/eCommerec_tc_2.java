package org.rahulshettyacademy;

import TestUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class eCommerec_tc_2 extends AndroidBaseTest {

    @BeforeMethod
    public void preSetup()
    {
        //Resets to Home page before every Test Case
        Activity activity=new Activity("com.androidsample.generalstore","com.androidsample.generalstore.SplashActivity");
        driver.startActivity(activity);
    }


@Test
public void FillForm_ErrorValidation() throws InterruptedException {
    driver.hideKeyboard();
    driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
    driver.findElement(By.id("android:id/text1")).click();
    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));

    //You can also Click on Element on above step itself
    driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();


    String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
    Assert.assertEquals(toastMessage, "Please enter your name:");
    Thread.sleep(3000);
}

@Test
    public void FillForm_PositiveFlow() throws InterruptedException {
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));

        //You can also Click on Element on above step itself
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Avnish Sharma");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);
        Thread.sleep(3000);
    }


}
