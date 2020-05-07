package tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import general.Testbase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.ActionSheetsScreen;
import pageobjects.MainScreen;

public class ActionSheetsTest extends Testbase {
	IOSDriver<IOSElement> driver;
	MainScreen mainScreen;
	ActionSheetsScreen actionSheetsScreen;


@BeforeTest
public void initiateDrive() throws MalformedURLException  {
		driver=mycapabilities();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainScreen=new MainScreen(driver);
        actionSheetsScreen=new ActionSheetsScreen(driver);
}
        @Test
      public void dialogWindowTest() {
	mainScreen.ActionSheetMenuItem.click();
	actionSheetsScreen.okCancelButton.click();
	actionSheetsScreen.okButton.click();
}



}