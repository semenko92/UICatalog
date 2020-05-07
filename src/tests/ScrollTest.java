package tests;

import general.Testbase;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.MainScreen;
import pageobjects.TextFields;

public class ScrollTest extends Testbase {
	public class ScreenTest extends Testbase {
		IOSDriver<IOSElement> driver;
		MainScreen mainScreen;
		TextFields textFields;
		@BeforeTest
		public void initiateDrive() throws MalformedURLException  {
				driver=mycapabilities();
                mainScreen=new MainScreen(driver);
                textFields=new TextFields(driver);
}
		@Test(priority=1)
		public void scrollTest() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			HashMap<String,String> parameters=new HashMap<String,String>();
			parameters.put("direction", "down");
			js.executeScript("mobile: scroll", parameters);
			String expectedLabel="Text Fields";
			String actualLabel=mainScreen.TextFieldsMenuItem.getAttribute("label");
			//String actualLabel=driver.findElementByAccessibilityId("Text Fields").getAttribute("label");
			Assert.assertEquals(actualLabel, expectedLabel);
		}		
			@Test(priority=2, dependsOnMethods="scrollTest")
			public void textTest() {
			mainScreen.TextFieldsMenuItem.click();
			//driver.findElementByAccessibilityId("Text Fields").click();
			String expectedPlaceHolder="Placeholder text";
			String actualPlaceHolder=textFields.defaultTextField.getAttribute("value");
			Assert.assertEquals(actualPlaceHolder, expectedPlaceHolder);
			textFields.defaultTextField.click();
			textFields.defaultTextField.setValue("test2");
			//textFields.defaultTextField.sendKeys("Hello world");
			String actualTextValue=textFields.defaultTextField.getAttribute("value");
			String expectedTextValue="test2";
			Assert.assertEquals(actualTextValue, expectedTextValue);
			
			}
}
}