package com.weather.driver;

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;
	

	public abstract class Driver {

		protected static AppiumDriver Ad;
		
		//File file = new File("/Users/monocept/Documents/workspace_luna/com.weather.SmokeTest/Config/DataFile.Properties");
		  
		protected  Properties properties = new Properties();
		
//		public void Dr()
//		{
//			//driver=null;
//			Ad=null;
//			
//		}
//		
//		public boolean isElemenetPresent(By by) throws Exception
//		{
//			
//			try{
//				//driver.findElement(by);
//				Ad.findElement(by);
//			return true;
//			}catch (NoSuchElementException e){
//			return false;
//			}
//		}
	}
	
