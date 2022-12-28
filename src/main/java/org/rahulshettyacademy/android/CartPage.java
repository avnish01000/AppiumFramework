package org.rahulshettyacademy.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;

public class CartPage extends AndroidActions{
	
AndroidDriver driver;
	
	public CartPage(AndroidDriver driver)
	{
		super(driver);  //It will call parent class constructor i.e. AndroidActions Constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this); not able to initialize Page factory
	}
	
	@FindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@FindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	//@FindBy(id="com.androidsample.generalstore:id/termsButton")
	//private 
	//WebElement terms=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	
	@FindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	@FindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;	
	
	@FindBy(className="android.widget.CheckBox")
	private WebElement checkBox;	
	
	public List<WebElement> getProductList()
	{
		return productList;
	}
	
	public double getProductSum()
	{
		int productCount=productList.size();
		Double sum= 0.0;
		for(int i=0;i<productCount;i++)
		{
			String amountString=productList.get(i).getText();
			Double price=Double.parseDouble(amountString.substring(1));
			sum=sum+price;	
		}
		return sum;
	}	
	
	
	public Double getTotalAmountDisplayed()
	{
		return getFormattedAmount(totalAmount.getText());
							
	}
	
	public void acceptTermsConditions()
	{
		longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
		acceptButton.click();
		
	}
	
	
	public void submitOrder()
	{
		checkBox.click();
		proceed.click();
	}
	
}
