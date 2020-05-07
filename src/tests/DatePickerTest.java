package tests;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import general.Testbase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.DatePickerScreen;
import pageobjects.MainScreen;

public class DatePickerTest extends Testbase {
	IOSDriver<IOSElement> driver;
	MainScreen mainScreen;
	DatePickerScreen datePickerScreen;
	
	@BeforeTest
	public void initiateDriver() throws MalformedURLException {
     driver =mycapabilities();
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     mainScreen=new MainScreen(driver);
     datePickerScreen=new DatePickerScreen(driver);
}
	@Test
	public void setDateTest() {
		mainScreen.DatePickerMenuItem.click();
		//	Sat, Mar 7
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		HashMap<String,String> parameters=new HashMap<String, String>();
		parameters.put("order", "next");
		parameters.put("offset", "0.4");
		////
		parameters.put("element", datePickerScreen.DateWheel.getId());
		js.executeScript("mobile: selectPickerWheelValue", parameters);
		datePickerScreen.HourWheel.setValue("3");
		datePickerScreen.MinuteWheel.setValue("50");
		datePickerScreen.AMPMWheel.setValue("PM");
	}
}