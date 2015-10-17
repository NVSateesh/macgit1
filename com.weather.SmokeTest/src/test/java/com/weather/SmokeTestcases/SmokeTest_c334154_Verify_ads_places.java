package com.weather.SmokeTestcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_c334154_Verify_ads_places extends Driver {

	public void Verify_ads_places(){
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		JavascriptExecutor js = (JavascriptExecutor) Ad ;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
      
		
		

		MobileElement Screen = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
		//is number of cells/rows inside table correct
		List<MobileElement> pages = Screen.findElementsByClassName("UIACollectionView");
		System.out.println("page Size is "+ pages.size());

		////		MobileElement frames = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]");
		////		List<MobileElement> framCount = frames.findElementsByClassName("UIACollectionView");
		//		MobileElement frames = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]");
		//		List<MobileElement> framCount = frames.findElementsByClassName("UUIACollectionView");
		//		




		MobileElement el = (MobileElement) Ad.findElementByName("_aCurTempLabel");
		el.click();
		Ad.scrollTo("WIND");
		Ad.scrollToExact("COND");
		System.out.println("Scroll with Scroll to");
		MobileElement el2 =(MobileElement) Ad.findElementByName("WATCH NOW");
	    el2.swipe(SwipeElementDirection.DOWN,10);
		System.out.println("Swipe down");

		Boolean Adpresent = Ad.findElementByClassName("UIAWebView").isDisplayed();
		Dimension Size = Ad.findElementByClassName("UIAWebView").getSize();
		if(Adpresent=true)
		{
			System.out.println("Main add is presented ::");
			System.out.println( "Ad Width is :: "+Size.getWidth()+" "+"Ad Height is :: "+Size.getHeight() );
		}else
		{
			System.out.println("Add not presented");
		}


		for(int scroll = 2;scroll<=pages.size();scroll++)
		{ 
			Boolean SmallAdpresent = Ad.findElementByClassName("UIAWebView").isDisplayed();
			Dimension smalladSize = Ad.findElementByClassName("UIAWebView").getSize();

			try{
				js.executeScript("mobile: scroll", scrollObject);
				System.out.println("Scrolled one module");
				js.executeScript("mobile: scroll", scrollObject);
				System.out.println("Scrolled two modules");



				if(SmallAdpresent=true)
				{
					System.out.println("small add is presented ::");
					System.out.println("Small Ad Height is :: "+smalladSize.getHeight() + "Small Ad Width is :: "+smalladSize.getWidth());
				}
			}catch(WebDriverException e){
				System.out.println("small add is presented ::");
				System.out.println("Small Ad Height is :: "+smalladSize.getHeight() + "Small Ad Width is :: "+smalladSize.getWidth());

			}


		}
	}
}
