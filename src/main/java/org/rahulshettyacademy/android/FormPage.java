package org.rahulshettyacademy.android;

import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;

public class FormPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);//IT will call parent class constructor i.e. AndroidActions Constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this); not able to initialize Page factory
	}
	
	//@AndroidFindBy Giving Error
	
	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@FindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOptions;
	
	//NEed to docuble check this option
	@FindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleOptions;
	
	@FindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender)
	{
		if(gender.equalsIgnoreCase("female"))
			femaleOptions.click();
		else
			maleOptions.click();
				
	}
	
	public void setCountrySelection(String countryName)
	{
		countrySelection.click();
		scrollToText("Argentina");
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	public ProductCatalogue submitForm()
	{
		shopButton.click();
		return new ProductCatalogue(driver);
	}

	public void setActivity()
	{
		Activity activity=new Activity("com.androidsample.generalstore","com.androidsample.generalstore.SplashActivity");
		driver.startActivity(activity);
	}
	
}
