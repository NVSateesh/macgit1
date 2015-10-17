package com.weather.SmokeTestcases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_C334145_factualCall extends Driver {

	public void verify_facualcal_onfresh_launch() throws InterruptedException, IOException
	{
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		
		String CurrentLocation = Ad.findElementByClassName("UIAStaticText").getText();
		//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]").getText();
		if(CurrentLocation.toString()!=null)
		{
			System.out.println("CurrentLocation is ::"+ CurrentLocation);
		}else
		{
			System.out.println("Add current location");
			Ad.findElementByName("UIAStaticText").click();
			Ad.findElementByName("").click();
			Ad.findElement(By.name("Back")).click();
		}
		


		//Verify LBS status
		//Ad.findElementByName("menu icon").click();
		//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
		Ad.findElementByClassName("UIAButton").click();
		if(Ad.findElementByName("Follow Me Forecast, Weather for your current location").isEnabled())
		{
			System.out.println("LBS is Enabled");
			//Ad.findElementByName("menu icon").click();
			//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
			Ad.findElementByClassName("UIAButton").click();
		}else
		{
			Ad.findElementByName("Follow Me Forecast, Weather for your current location").click();
			Thread.sleep(2000);
			//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
			Ad.findElementByClassName("UIAButton").click();
		}

		//Kill the app and Relaunch
//		Ad.closeApp();
//		Thread.sleep(500);
//		Ad.launchApp();
//		Thread.sleep(500);

		//Navigate to flex for check factual call

		Ad.findElementByName("menu").click();

		//MobileElement Network = (MobileElement)Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIATableView[1]/UIATableCell[1]"));
		//Network.click();
		//Ad.findElementByClassName("UIAStaticText").click();
		Ad.findElementByName("📡  Network History").click();
		
		//click on search and search for Factual call
		//Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIATableView[1]/UIASearchBar[1]")).click();
		Ad.findElementByClassName("UIASearchBar").click();
		Ad.getKeyboard();
		
		//Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIASearchBar[1]")).sendKeys("geopulse");
		Ad.findElementByClassName("UIASearchBar").sendKeys("geopulse");
		Ad.findElement(By.name("Search")).click();

		String factulcall = Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).getText();
		 // =Ad.findElementByName("7620026f-cfb6-4d0c-9f8e-434ff0cd34d0?audience=true&proximity=true").getText();
				 //Ad.findElementByClassName("UIAStaticText").getText();
		 
		System.out.println("Factula data is :: "+factulcall);
		//https://geopulse.factual.com/geopulse/
		if(factulcall.contains("7620026f-cfb6-4d0c-9f8e-434ff0cd34d0?audience=true&proximity=true"))
		{
			//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
			Ad.findElementByName("7620026f-cfb6-4d0c-9f8e-434ff0cd34d0?audience=true&proximity=true").click();
				Ad.findElementByName("Request Body: tap to view").click();
			
			String RequestData = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[1]").getText();
			
			System.out.println("Request Data ::" + RequestData );
			//System.out.println("linktext is ::"+ Ad.findElementByName("7620026f-cfb6-4d0c-9f8e-434ff0cd34d0?audience=true&proximity=true").getTagName('a'));
			
						// Loop to read all lines one by one from file and print It.
						
							// return mbrLastName;
							String entriesTxt = RequestData;
							String[] aEntriesText = entriesTxt.split("&");
							String totalEntriesText = aEntriesText[aEntriesText.length - 1];
							// return Integer.parseInt(totalEntriesText);
							int totalLength = aEntriesText.length;
			
							for (int i = 1; i <= totalLength; i++) {
								String FindText = aEntriesText[aEntriesText.length - i];
								// System.out.println("Lenth number is : "+(totalLength-i)+ ":"
								// + FindText);
								if (FindText.contains("user-id")) {
									String[] Value = FindText.split("=");
									String ExactValue = Value[Value.length - 1];
									System.out.println("The value is :" + ExactValue);
									if (ExactValue.contains("nl") || ExactValue.contains("user-id")) {
										System.out.println("NO Values found for ord");
			
									} else
			
									{
										System.out.println("user-id vales is :" + FindText.contains("user-id"));
										System.out.println(FindText);
									}
								}
			
				
				}
		}
		
	}
}
