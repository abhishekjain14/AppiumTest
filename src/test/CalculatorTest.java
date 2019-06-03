package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorTest {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Nougat Emulator");
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	}
	
	@Test 
	public void testCalcPass() throws Exception {
		WebElement eight=driver.findElement(By.id("com.android.calculator2:id/digit_8"));
		eight.click();
		WebElement divide=driver.findElement(By.id("divide"));
		divide.click();
		WebElement two=driver.findElement(By.id("com.android.calculator2:id/digit_2"));
		two.click();
		WebElement equalTo=driver.findElement(By.id("equals"));
		equalTo.click();
		WebElement result=driver.findElement(By.id("com.android.calculator2:id/result"));
		String resultValue = result.getText();
		assert resultValue.equals("4");
	}
	
	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}
