package org.rahulshettyacademy.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.apache.commons.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import static org.apache.commons.io.FileUtils.*;

public abstract class AppiumUtils {

	AppiumDriver driver;
	public AppiumDriverLocalService service;


	//GrandParent (AppiumUtils) --> AndroidActions -->PageObject Class
	public double getFormattedAmount(String number)
	{
		return Double.parseDouble(number.substring(1));
	}

	public void waitForElementToAppear(WebElement ele,AppiumDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(ele, "text", "Cart"));
	}

	public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException {
		//System.getProperty("user.dir")+"\\src\\test\\java\\testData\\eCommerce.json"
		String jsonContent= readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsonContent,
		new TypeReference<List<HashMap<String, String>>>(){
		});

		return data;
	}

	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port)
	{
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Dell\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
	}

	public String getScreenshotPath(String testCaseName,AppiumDriver driver) throws IOException {
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\Reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}
