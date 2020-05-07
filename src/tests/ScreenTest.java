package tests;

import java.net.MalformedURLException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import general.Testbase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.General;
import pageobjects.MainScreen;


public class ScreenTest extends Testbase {
	IOSDriver<IOSElement> driver;
	MainScreen mainScreen;
	General general;
	
	@BeforeTest
public void initiateDrive() throws MalformedURLException  {
		driver=mycapabilities();
		mainScreen=new MainScreen(driver);
	general=new General(driver);
	}	
	@Test
	public void ButtonsTest() throws MalformedURLException  {
		MainScreen mainScreen=new MainScreen(driver);
		String expectedScreenCaption="Buttons";
		String actualScreenCaption;
        //driver.findElementByXPath("//XCUIElementTypeApplication[@name='UICatalog']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]").click();
        mainScreen.ButtonsMenuItem.click();
        actualScreenCaption=general.screenTitle.getAttribute("name");
		actualScreenCaption=driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Buttons']").getAttribute("label");
        Assert.assertEquals(actualScreenCaption, expectedScreenCaption);
        
	}
  

        @Test
        public void DatePickerTest() throws MalformedURLException  {
        	MainScreen mainScreen=new MainScreen(driver);
        	String expectedScreenCaption="Date Picker";
        	mainScreen.DatePickerMenuItem.click();
    		String actualScreenCaption;
    		//driver.findElementByAccessibilityId("Date Picker").click();
    		actualScreenCaption=general.screenTitle.getAttribute("name");
            Assert.assertEquals(actualScreenCaption, expectedScreenCaption);


	}
    @AfterMethod
    public void cleanup(){
    	
        driver.findElementByXPath("//XCUIElementTypeButton[@name='UICatalog']").click();
    }
}
