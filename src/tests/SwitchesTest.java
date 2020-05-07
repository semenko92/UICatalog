package tests;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import general.Testbase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.MainScreen;
import pageobjects.SwitchesScreen;

public class SwitchesTest extends Testbase  {
	IOSDriver<IOSElement> driver;
	MainScreen mainScreen;
	SwitchesScreen switchesScreen;
	
	@BeforeTest
	public void initiateDrive() throws MalformedURLException  {
			driver=mycapabilities();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            mainScreen=new MainScreen(driver);
            switchesScreen=new SwitchesScreen(driver);
}
	@Test
	public void switchesTest() {
		//скрол вниз для поиска элемента
		JavascriptExecutor js=(JavascriptExecutor)driver;
		HashMap<String,String> parameters=new HashMap<String,String>();
		parameters.put("direction", "down");
		js.executeScript("mobile: scroll", parameters);	
		// закончили скролл
		mainScreen.SwithcesMenuItem.click();
		switchesScreen.DefaultSwitch.click();
		Assert.assertEquals(switchesScreen.DefaultSwitch.getAttribute("value"),"0");
		
		
	}
	
}