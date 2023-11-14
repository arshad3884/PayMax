package appiumtests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class CalculatorTest {

	//static WebDriver driver;     //Can be use to test on all platforms android,iOS,Web 
	static AppiumDriver driver;    //Can be use to test on android & iOS
	//static AndroidDriver driver; 
	//static IOSDriver driver;
	
	public static void main(String[] args) {
		
		try {
			calculatorTest();
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public static void calculatorTest() throws Exception
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		//Setting Phone OR browser info
		cap.setCapability("deviceName", "Infinix X650C");
		cap.setCapability("udid", "054262505B004356");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9.0"); 
		cap.setCapability("automationName", "UiAutomator2"); //XCUITest for iOS, UiAutomator2 for Android
		//cap.setCapability(CapabilityType.BROWSER_NAME, "");
		//Setting Application info
		cap.setCapability("appPackage", "com.transsion.calculator");
		cap.setCapability("appActivity", "com.transsion.calculator.Calculator");
		//Initializing the driver and passing appium server url and capabilities
		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AppiumDriver(url, cap);
		System.out.println("Application Started......");
		Thread.sleep(5000);
		
		WebElement zero = driver.findElement(By.id("com.transsion.calculator:id/digit_0"));
		WebElement one = driver.findElement(By.id("com.transsion.calculator:id/digit_1"));
		WebElement two = driver.findElement(By.id("com.transsion.calculator:id/digit_2"));
		WebElement three = driver.findElement(By.id("com.transsion.calculator:id/digit_3"));
		WebElement four = driver.findElement(By.id("com.transsion.calculator:id/digit_4"));
		WebElement five = driver.findElement(By.id("com.transsion.calculator:id/digit_5"));
		WebElement six = driver.findElement(By.id("com.transsion.calculator:id/digit_6"));
		WebElement seven = driver.findElement(By.id("com.transsion.calculator:id/digit_7"));
		WebElement eight = driver.findElement(By.id("com.transsion.calculator:id/digit_8"));
		WebElement nine = driver.findElement(By.id("com.transsion.calculator:id/digit_9"));
		WebElement plus = driver.findElement(By.id("com.transsion.calculator:id/op_add"));
		WebElement subtract = driver.findElement(By.id("com.transsion.calculator:id/op_sub"));
		WebElement divide = driver.findElement(By.id("com.transsion.calculator:id/op_div"));
		WebElement equal = driver.findElement(By.id("com.transsion.calculator:id/eq"));
		WebElement result = driver.findElement(By.id("com.transsion.calculator:id/result"));
		one.click();
		three.click();
		plus.click();
		seven.click();
		equal.click();
		System.out.println(result.getText());
		/*
		driver.findElement(By.xpath("//android.widget.EditText[@index='0']")).sendKeys("4589685425");
		driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys("shehaqbaloch18@gmail.com");
		driver.findElement(By.xpath("//android.view.View[@index='3']")).sendKeys("Baloch!2");
		driver.findElement(By.xpath("//android.widget.Button[@index='4']")).click();
		*/
	}

}
