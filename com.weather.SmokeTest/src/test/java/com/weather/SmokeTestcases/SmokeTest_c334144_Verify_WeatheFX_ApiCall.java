package com.weather.SmokeTestcases;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_c334144_Verify_WeatheFX_ApiCall extends Driver{

	public static String wfxtg ;
	public static List<String> wfxcontainer;
	
	public static List<String>  Adwfxdata ;
	public static String wfxids = null;
	public static String Currentlist[] = null;
	public void Verify_WeatherFX_Apicall() throws ParseException, Exception {

		System.out.println("Case Started");

	
		//		
		String[] str ={"/bin/bash", "-c", "idevicesyslog | grep Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters >> /Users/aparna/Documents/sys1.log"};

		//Thread.sleep(10000);
		Process p = Runtime.getRuntime().exec(str);

		Thread.sleep(20000);
		System.out.println("Writing is completed  :" + p.exitValue());
		BufferedReader r = new BufferedReader(new FileReader("/Users/aparna/Documents/sys1.log"));

		String line = "";
		String allLine = "";
		
		while((line=r.readLine()) != null)
		{
			System.out.println("Sys data is ::"+line);


		}

		String FilePath = "/Users/aparna/Documents/sys1.log";

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
				 
//				 for (int i=0; i<5)
				 if(sb.toString().contains("Requesting ad: /7646/app_iphone_us/display/feed/feed_1")){
					// System.out.println("index of first one ::::"+sb.toString().indexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
					 //System.out.println("index of second one ::::"+sb.toString().indexOf("Oct  9 12:43:59 iPod TheWeather[686] <Warning>: Get"));
		      String req = sb.toString().substring( sb.toString().lastIndexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
		      req = req.substring(req.indexOf("{")+1,req.indexOf("}"));
		      String[] arrays = req.split(";");
		      System.out.println("Verifing the "+req);
		      for(String keys : arrays){
		    	  System.out.println(keys);
		    	  if(keys.contains("=")){
		    		  String[] key = keys.split("=");
			    	 // System.out.println(key[0] + "---"+key[1]);
			    	  mapkeys.put(key[0], key[1]);
		    	  }
		    	  
		    	  
		      }
		      for(Entry<String, String> entryKeys : mapkeys.entrySet()){
		    	  //System.out.println("key : "+entryKeys.getKey() + "----"+"value:"+entryKeys.getValue());
		    	  if(entryKeys.getKey().contains("wfxtg"))
		    	  {
		    		  System.out.println("wfxtg vaues are :" + entryKeys.getValue());
		    	  }
		    	 
		      }
		 
					 }
				 br.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		

		System.out.println("Vrify wfxtg test case done");


	}
}


