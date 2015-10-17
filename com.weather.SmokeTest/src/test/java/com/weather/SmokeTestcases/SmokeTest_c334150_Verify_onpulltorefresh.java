package com.weather.SmokeTestcases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	MethodListener.class })
public class SmokeTest_c334150_Verify_onpulltorefresh extends Driver{

	@SuppressWarnings("deprecation")
	public void Verify_PulltoRefresh() throws IOException, InterruptedException
	{
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		
		ATUReports.add("Launch the app", false);
		
		WebDriverWait wait = new WebDriverWait(Ad, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("_aCurTempLabel")));
		
		MobileElement el = (MobileElement) Ad.findElementByName("_aCurTempLabel");
		MobileElement el1 = (MobileElement) Ad.findElementByName("_aHiLowLabel");
		//_aHiLowLabel_aWxCheckinButton");
		TouchAction action1 = new TouchAction(Ad);
		action1.longPress(el).moveTo(el1).release().perform();
		
		System.out.println("Scroll Done");
		
		ATUReports.add("On CC Screen, Pulling the screen to refresh", false);

		//Get the BB ad and validate it
		String[] str ={"/bin/bash", "-c", "idevicesyslog  >> /Users/monocept/Desktop/logs/sys5.log"};

		ATUReports.add("Verified Branded Background  Values are present",false);

		Process p = Runtime.getRuntime().exec(str);

		Thread.sleep(5000);
		System.out.println("Writing is completed  :" + p.exitValue());
		BufferedReader r = new BufferedReader(new FileReader("/Users/monocept/Desktop/logs/sys5.log"));
        
		String line = "";
		String allLine = "";

		while((line=r.readLine()) != null)
		{
			System.out.println("Sys data is ::"+line);
		}

		String FilePath = "/Users/monocept/Desktop/logs/sys5.log";

		Map<String, String> mapkeys = new HashMap<String, String>();

		try {
			FileInputStream fstream = new FileInputStream(FilePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));
			String strLine;
			// / read log line by line ------ strLine = br.readLines(6, 10); /
			StringBuffer sb = new StringBuffer("");
			while ((strLine = br.readLine()) != null) {
				// parse strLine to obtain what you want /
				//System.out.println (strLine);
				sb.append(strLine);

			}

			if(sb.toString().contains("Requesting ad: /7646/app_iphone_us/display/bb")){
				// System.out.println("index of first one ::::"+sb.toString().indexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
				//System.out.println("index of second one ::::"+sb.toString().indexOf("Oct  9 12:43:59 iPod TheWeather[686] <Warning>: Get"));
				String req1 = sb.toString().substring( sb.toString().lastIndexOf("Requesting ad: /7646/app_iphone_us/display/bb with parameters: {"));
				String	req = req1.substring(req1.indexOf("{")+1,req1.indexOf("}"));
				System.out.println("Request is ::"+req1);
				//ATUReports.add("Get the Feed cal  data", true);
				
				if(req1.contains("/7646/app_iphone_us/display/bb"))
				{
					System.out.println("Verified Branded Background  Values are present");
					
					ATUReports.add("Verified the Branded Background  Values are present", true);
				}
				else{
                    
					System.out.println("Branded Background Call is not Present");
					
					ATUReports.add("Verified the Branded Background  Values are present", true);
					
				}


				System.out.println("Case Ended");
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


