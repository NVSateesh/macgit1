package com.weather.appium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class ReadProperties {
	
	public void x(){

	File file = new File("/Users/monocept/Documents/workspace_luna/com.weather.SmokeTest/Config/DataFile.Properties");
	  
	Properties prop = new Properties();
	
	FileInputStream fileInput = null;
	 
	try {
		fileInput = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	//load properties file
	try {
		prop.load(fileInput);
	} catch (IOException e) {
		e.printStackTrace();
	}

}
}
