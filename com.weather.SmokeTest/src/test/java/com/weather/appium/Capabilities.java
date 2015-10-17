package com.weather.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import atu.testng.reports.ATUReports;

import com.weather.driver.Driver;

public class Capabilities extends Driver {

	
	@SuppressWarnings("deprecation")
	public void dcap() throws InterruptedException, IOException {

//		//Appium auto start
		Start_Stop_AppiumServer appiumStart = new Start_Stop_AppiumServer();
		System.out.println("Stopping the appium server");
		appiumStart.stopAppiumServer();
		System.out.println("Appium server is stopped");
		//Thread.sleep(10000);
		System.out.println("Starting the appium server");
		appiumStart.startAppiumServer();
		System.out.println("Appium server is started and running");
		Thread.sleep(100000);

		// Reading the properties file
		File file = new File("/Users/monocept/Documents/workspace_luna/com.weather.SmokeTest/Config/DataFile.Properties");
		  
		FileInputStream fileInput = null;
		 
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties = new Properties();
		
		//load properties file
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
	}
		
		//properties.load(this.getClass().getClassLoader().getResourceAsStream("/Users/monocept/Documents/workspace_luna/com.weather.SmokeTest/Config/DataFile.Properties"));

	    //Capabilities
		ATUReports.add("Setting the Capabilities of the iOS device and version",false);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		System.out.println("Started");
		// capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
		capabilities.setCapability("appium-version", properties.getProperty("appiumVersion"));
		capabilities.setCapability("platformName", properties.getProperty("platformName"));
		capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
		capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
		//capabilities.setCapability("app", "/Users/aparna/Downloads/TheWeather.app");


		capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
		capabilities.setCapability(CapabilityType.VERSION, properties.getProperty("platformVersion"));
		capabilities.setCapability(CapabilityType.PLATFORM, properties.getProperty("platform"));
		//capabilities.setCapability("device", "iPhone 6");
		capabilities.setCapability("udid",properties.getProperty("udid"));
		//capabilities.setCapability("udid","707cc1d9c294b37fe5e70b7584163a100ae6166f");
		//capabilities.setCapability("udid","c87e18b1235f1480f32f2725762260fb893492b9");
		//capabilities.setCapability("app", "/Users/monocept/Documents/workspace_luna/com.weather.SmokeTest/build/TheWeather.ipa");
		capabilities.setCapability("app", properties.getProperty("appPath"));
		capabilities.setCapability("appPackage", "com.weather.Weather");
		capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
		capabilities.setCapability("newCommandTimeout", 100000);
		capabilities.setCapability("autoAcceptAlerts",true);
		
		ATUReports.add("Platfom Version is :: "+ properties.getProperty("platformVersion"),false);
		ATUReports.add("Device Name is :: "+ properties.getProperty("deviceName"),false);

		//Driver found
		System.out.println("Found the Device/Simulator");
        
		//Communicate with Remote web driver
		//WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Ad = new IOSDriver (new URL("http://127.0.0.1:4721/wd/hub"), capabilities);
		//System.out.println("Verify for networkapp launched");
		Ad.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("Capabilities are launched");
		
		ATUReports.add("Capabilities are set up and running",false);
		
	}
}