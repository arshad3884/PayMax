package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class PayMax {

	static AndroidDriver driver;
	@BeforeTest
	public void setCapabilities() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Infinix X650C");
		cap.setCapability("udid", "054262505B004356");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9.0");
		cap.setCapability("automationName", "UiAutomator2");// XCUITest for iOS, UiAutomator2 for Android
		cap.setCapability(AndroidMobileCapabilityType.IGNORE_UNIMPORTANT_VIEWS, true);
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		//cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		//cap.setCapability("app", "location of the .app or .ipa file");
		
		/*
		cap.setCapability("deviceName", "Pixel 7");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10.0");
		cap.setCapability("automationName", "UiAutomator2");// XCUITest for iOS, UiAutomator2 for Android
		cap.setCapability(AndroidMobileCapabilityType.IGNORE_UNIMPORTANT_VIEWS, true);
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true); 
		//cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		*/
		// Setting Application info
		//cap.setCapability("app", "C:\\Users\\hp\\Desktop\\Paymax 11-09-023.apk");
		cap.setCapability("appPackage", "org.cordova.paymax");
		cap.setCapability("appActivity", "org.cordova.paymax.MainActivity");
		
		// Initializing the driver and passing appium server url and capabilities
		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AndroidDriver(url, cap);
		System.out.println("Application Started......");
	}
	@Test
	public void validCredsEmailLogin() throws InterruptedException
	{
		driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(By.xpath(".//android.widget.EditText[@hint='Enter User Name or Email']")).sendKeys("shehaqbaloch18@gmail.com");
		driver.findElement(By.xpath(".//android.widget.EditText[@hint='Enter Password']")).sendKeys("Baloch!2");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Login\")")).click();
		Thread.sleep(15000);
		WebElement HomeIcon = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Home\")"));
		Assert.assertEquals(HomeIcon.isDisplayed(), true);
	}
	@Test
	public void invalidCredsEmailLogin()
	{
		driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(By.xpath(".//android.widget.EditText[@hint='Enter User Name or Email']")).sendKeys("invalid@gmail.com");
		driver.findElement(By.xpath(".//android.widget.EditText[@hint='Enter Password']")).sendKeys("Qwerty@123");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Login\")")).click();
		WebElement error = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Either Phone number or password entered is incorrect. Review and enter correct information\")"));
		Assert.assertTrue(error.isDisplayed());
	}
	@Test
	public void invalidCredsPhoneLogin()
	{
		driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Phone Number\")")).click();
		//Select Country Code
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Country code\")")).click();
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\"Search the country Search the country\"]")).sendKeys("United States");
		driver.findElement(By.xpath("(.//android.widget.Button[@index=0])[4]")).click();
		//Enter Phone Number and password
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\" (201) 555-0123\"]")).sendKeys("2015550123");
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\"Enter Password\"]")).sendKeys("Qwerty@123");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Login\")")).click();
		WebElement error = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Either Phone number or password entered is incorrect. Review and enter correct information\")"));
		Assert.assertTrue(error.isDisplayed());
	}
	@Test
	public void validCredsPhoneLogin()
	{
		driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Phone Number\")")).click();
		//Select Country Code
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Country code\")")).click();
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\"Search the country Search the country\"]")).sendKeys("United States");
		driver.findElement(By.xpath("(.//android.widget.Button[@index=0])[4]")).click();
		//Enter Phone Number and password
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\" (201) 555-0123\"]")).sendKeys("");//Valid Creds Required
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\"Enter Password\"]")).sendKeys(""); // Valid Creds Required
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Login\")")).click();
		
		WebElement HomeIcon = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Home\")"));
		Assert.assertEquals(HomeIcon.isDisplayed(), true);	
	}
	
	String newUserEmail = "tester123@yopmail.com";
	@Test
	public void signupUsingValidDetails()
	{
		String phone = "2013335555";
		String firstName = "Tester";
		String lastName = "OneTwoThree";
		String userName = "tester123";
		
		driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Register an Account\")")).click();
		//Select Country Code
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Country code\")")).click();
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\"Search the country Search the country\"]")).sendKeys("United States");
		driver.findElement(By.xpath("(.//android.widget.Button[@index=0])[4]")).click();
		//Fill Signup Form
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\" (201) 555-0123\"]")).sendKeys(phone);
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\"Enter Email\"]")).sendKeys(newUserEmail);
		//Click any element to minimize the keyboard
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign Up\")")).click();
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\"Enter First Name\"]")).sendKeys(firstName);
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\"Enter Last Name\"]")).sendKeys(lastName);
		driver.findElement(By.xpath(".//android.widget.EditText[@hint=\"Enter User Name\"]")).sendKeys(userName);
		//Selecting user type
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"customer\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"termcheck\")")).click();
		//Click in Signup/ SendOTP button
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Send OTP\")")).click();
		WebElement OTPPage = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"OTP Verification\")"));
		Assert.assertTrue(OTPPage.isDisplayed());
	}
	@Test (dependsOnMethods = "signupUsingValidDetails")
	public void OTPVerificationUsingValidOTP() throws MalformedURLException, InterruptedException
	{
		driver.startActivity(new Activity("com.android.chrome", "com.google.android.apps.chrome.Main"));

		//driver.get("https://yopmail.com");
		//driver.findElement(By.xpath(".//android.widget.EditText[@hint=\"Login Enter your inbox here\"]")).sendKeys(newUserEmail);
		//driver.findElement(By.xpath("(.//android.widget.Button)[1]")).click();
				
		
		/*
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		*/
		
		driver.findElement(By.xpath("(.//android.widget.EditText)[1]")).sendKeys("");
		driver.findElement(By.xpath("(.//android.widget.EditText)[2]")).sendKeys("");
		driver.findElement(By.xpath("(.//android.widget.EditText)[3]")).sendKeys("");
		driver.findElement(By.xpath("(.//android.widget.EditText)[4]")).sendKeys("");
		driver.findElement(By.xpath("(.//android.widget.EditText)[5]")).sendKeys("");
		driver.findElement(By.xpath("(.//android.widget.EditText)[6]")).sendKeys("");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Verify\")")).click();
		
	}
	
}
