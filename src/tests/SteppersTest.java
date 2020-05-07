package tests;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import general.Testbase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.MainScreen;
import pageobjects.SlidersScreen;
import pageobjects.SteppersScreen;

public class SteppersTest extends Testbase {
	IOSDriver<IOSElement> driver;
	MainScreen mainScreen;
	SlidersScreen slidersScreen;
	SteppersScreen steppersScreen;
	
	@BeforeTest
	public void initiateDrive() throws MalformedURLException  {
			driver=mycapabilities();
            mainScreen=new MainScreen(driver);
            steppersScreen=new SteppersScreen(driver);
            
	}
	@Test
	//это был скрол вниз
	public void stepperTest() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	HashMap<String,String> parameters=new HashMap<String,String>();
	parameters.put("direction", "down");
	js.executeScript("mobile: scroll", parameters);
	mainScreen.SteppersMenuItem.click();
	//проскролили до кнопки
	steppersScreen.Increment1.click();
	steppersScreen.Increment1.click();
     Assert.assertEquals(steppersScreen.Result1.getAttribute("value"),"2");
     //driver.cleanup();
	
}
}