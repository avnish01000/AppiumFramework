package org.rahulshettyacademy.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;

public class ProductCatalogue extends AndroidActions{
	
	AndroidDriver driver;
	
	public ProductCatalogue(AndroidDriver driver)
	{
		super(driver);//IT will call parent class constructor i.e. AndroidActions Constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this); not able to initialize Page factory
	}
	
	//@AndroidFindBy Giving Error
	
	@FindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;

	
	public void addItemToCartByIndex(int index)
	{
		addToCart.get(index).click();
	}
	
	public CartPage goToCartPage() throws InterruptedException
	{
		
		cart.click();
		return new CartPage(driver);
		
		
	}
	
	
}
