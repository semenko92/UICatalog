package pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SwitchesScreen {
	public SwitchesScreen(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
	}
	@iOSXCUITFindBy(xpath="//XCUIElementTypeCell[1]/XCUIElementTypeSwitch")
	public MobileElement DefaultSwitch;
	

}
