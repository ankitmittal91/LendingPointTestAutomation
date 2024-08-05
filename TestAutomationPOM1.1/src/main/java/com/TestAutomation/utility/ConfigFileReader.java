package com.TestAutomation.utility;

import java.io.*;
import java.util.*;
import org.testng.annotations.*;

public class ConfigFileReader {
	
	public static Properties prop;

@BeforeTest
	public Properties ConfigFileRead() throws IOException {
		String configFilePath = "C:/Users/ankit.mittal/Downloads/TestAutomationPOM1/CommonConfigurations/Config.properties";
		try {
			FileInputStream configFileReader = new FileInputStream(configFilePath);
			prop = new Properties();
			prop.load(configFileReader);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
