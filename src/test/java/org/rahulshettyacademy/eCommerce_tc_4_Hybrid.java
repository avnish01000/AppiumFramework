package org.rahulshettyacademy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import TestUtils.AndroidBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.rahulshettyacademy.android.CartPage;
import org.rahulshettyacademy.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest {

	@BeforeMethod(alwaysRun = true)
	public void preSetup()
	{
		//Resets to Home page before every Test Case
		formPage.setActivity();
	}
			
	@Test(dataProvider="getData",groups={"Smoke"})
	public void FillForm(HashMap<String, String> input) throws InterruptedException
	{	
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
		ProductCatalogue productCatalogue=formPage.submitForm();
		Thread.sleep(3000);
		
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		CartPage cartPage=productCatalogue.goToCartPage();
		
	
		Thread.sleep(10000);

		
		double totalSum=cartPage.getProductSum();
		double displayFormattedSum=cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
				
		Thread.sleep(8000);
		
		//Hybrid App Handling
		Set<String> contexts=driver.getContextHandles();
		for(String contextName:contexts)
		{
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElement(By.name("q")).sendKeys(("rahul shetty academy"));
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		
		driver.context("NATIVE_APP");
		
	}

   @DataProvider
	public Object[][] getData() throws IOException {
	  List<HashMap<String, String>> data=getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\eCommerce.json");

	  return new Object[][]
			   {
					   {data.get(0)},
					   {data.get(1)}
			   };
   }

	
}
