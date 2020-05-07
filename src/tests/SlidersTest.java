package tests;


import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.offset.ElementOption.element;
import general.Testbase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import pageobjects.MainScreen;
import pageobjects.SlidersScreen;

public class SlidersTest extends Testbase {
	IOSDriver<IOSElement> driver;
	MainScreen mainScreen;
	SlidersScreen slidersScreen;
	
	@BeforeTest
	public void initiateDrive() throws MalformedURLException  {
			driver=mycapabilities();
            mainScreen=new MainScreen(driver);
            slidersScreen=new SlidersScreen(driver);
}
	
	@Test(priority=1)
	public void SliderTest() {
		mainScreen.SlidersMenuItem.click();
		slidersScreen.DefaultSlider.setValue("0.5");
		Assert.assertEquals(slidersScreen.DefaultSlider.getAttribute("value"),"48%");
	}
	@Test(priority=2)
	public void SliderTest2() {
		Dimension size=slidersScreen.DefaultSlider.getSize();
		TouchAction action=new TouchAction(driver);
		ElementOption press=element(slidersScreen.DefaultSlider,size.width/2 ,size.height/2);
		ElementOption move=element(slidersScreen.DefaultSlider,(int)(size.width*1.05),size.height/2);
		action.press(press).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(move).release();
		action.perform();
		Assert.assertEquals(slidersScreen.DefaultSlider.getAttribute("value"),"100%");
	}
}