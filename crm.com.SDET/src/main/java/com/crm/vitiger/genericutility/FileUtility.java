package com.crm.vitiger.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Ravikiran
 *
 */

public class FileUtility {
	/**
	 * its used to read the data from commonData.properties file based on key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/Commondata/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
	
	}
	
	

}
