package com.weather.SmokeTestcases;

import io.appium.java_client.MobileElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_c334153_Verify_Lotame_onApp_Launch extends Driver {
	 public static List<String> container ;
	 public static String ids = null;
	public void Verify_Lotamecall_onapp_launch() throws InterruptedException, ParseException
	{
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		//Check address 
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
//		Ad.closeApp();
//		//Thread.sleep(500);
//		Ad.launchApp();
//		//Thread.sleep(500);
       
		//Verify User on Now Page
		    //Scroll the page to now page
		JavascriptExecutor js = (JavascriptExecutor) Ad ;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
		
		String RightNow = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAStaticText[1]").getText();
	
		System.out.println("Right Now Value is ::"+ RightNow.toString());
		Assert.assertEquals(RightNow.toString(),"Right Now");
		
		
		//Verify Lotame call on Flex
		//Navigate to flex for check factual call

				Ad.findElementByName("menu").click();
				Ad.findElementByName("📡  Network History").click();
				
				
				//click on search and search for Lotame call
				//Ad.findElementByClassName("UIASearchBar").click();
				//Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIATableView[1]/UIASearchBar[1]")).click();
				Ad.getKeyboard();
				Ad.findElementByClassName("UIASearchBar").sendKeys("pe=y");
				//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIASearchBar[1]").sendKeys("pe=y");
				Ad.findElement(By.name("Search")).click();
				
				//Static m_id for ipod touch
                String m_id = "0D1FDA1B-1C28-4153-B5FB-8A221532EF08";
				String Lotamecall = Ad.findElementByName("bcp.crwdcntrl.net/5/c=2215/tp=TWCN/mid="+m_id+"/e=app/seg=mobile").getText();
						//Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")).getText();
				//Assert BCP (Lotame call) is pressent or not 
				System.out.println("BCP Call ::" + Lotamecall.toString());
				//Assert.assertEquals("http://bcp.crwdcntrl.net/5/c=2215", Lotamecall.contains("http://bcp.crwdcntrl.net/5/c=2215"));
				System.out.println("Lotame data is :: "+Lotamecall);
				Ad.findElementByName("bcp.crwdcntrl.net/5/c=2215/tp=TWCN/mid="+m_id+"/e=app/seg=mobile").click();
				//Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")).click();
				Ad.findElementByName("Response Body: tap to view").click();
				
				//Get the json values into a string
				String LotameValue = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[1]").getText();
		        System.out.println("Lotame Call value is :: "+LotameValue.toString());
		       
		        //get Pub ad call to check sg values
		        Ad.findElementByName("pe=y").click();
		        Ad.findElementByName("📡  Network").click();
		        Ad.findElementByClassName("UIASearchBar").clear();
		        Ad.findElementByClassName("UIASearchBar").sendKeys("pubad");
		        Ad.findElementByName("pubads.g.doubleclick.net/gampad").click();
		        String Cust_param ;
		        
		        if(Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[29]/UIAStaticText[1]").getText().contains("cust_params"))
		        {
		        	Cust_param = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[29]/UIAStaticText[1]").getText();
		        }else
		        {
		        	Cust_param = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[27]/UIAStaticText[1]").getText();
		        }
		        System.out.println("Cust Param is ::"+ Cust_param.toString());
		        
		       
		        //Verify Sg value in Cust_param
		        String Content = Cust_param.toString();
		        String str[] = Content.split("&");
			    for (String ssss : str) {
				String s[] = ssss.split("=");
				if (s[0].equals("sg")) {
				     ids = s[1].toString();
				   // System.out.println("Pubad Sg are ::" + ids);
				    String[] items = ids.split(",");
				    container = Arrays.asList(items);
				    System.out.println("Pubad Sg are ::" + container);
				}
				}
		        
		        
		        
		     // Json file
		        JSONParser parser = new JSONParser();
		        
		            Object obj = parser.parse(LotameValue.toString());
		            //JSONArray array = (JSONArray)obj;
		            JSONObject jsonObject = (JSONObject) obj;
		            JSONObject mainTag = (JSONObject) jsonObject.get("Profile");
		    	    JSONObject AudiencesTag = (JSONObject) mainTag.get("Audiences");
		    	    JSONArray Audience = (JSONArray) AudiencesTag.get("Audience");
		    	    
		    	    if (Audience != null) {
		    			// Getting id
		    			Iterator<JSONObject> AudienceIterator = Audience.iterator();
		    			while (AudienceIterator.hasNext()) {
		    			    JSONObject AudienceObject = (JSONObject) AudienceIterator.next();
		    			    // System.out.println("zip object : " + zcszipObject);
		    			   String id = AudienceObject.get("id").toString();
		    			   
		    			    
		    			    List<String> list = new ArrayList<String>();
		    			    for (String str1 : container) {
		    					if (ids.contains(str1)) {
		    					    list.add(str1);
		    					}

		    				    }

		    				    System.out.println("JSon IDs list is :: " + list);
		    				    Assert.assertEquals(list, container);
		    				    break;
		    				    
		    			}
		    	    }
		    	    
		    	    Ad.findElementByName("📡  Network").click();
		    	    Ad.findElementByName("Cancel").click();
		    		Ad.findElementByName("💪  FLEX").click();
		    		Ad.findElementByName("Done").click();
	}
}
