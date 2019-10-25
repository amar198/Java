package com.medplat.read.propertyfiles;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

/**
 * @author amar
 * @version 0.1
 * 
 * Class to read a given property file.
 *
 */
public class ReadPropertyFile {

	/**
	 * @param sFileName: name of file
	 * @param sFilePath: absolute file path. if a blank value is passed then the code will try to open the path from the current working directory
	 * and try to open the file.
	 * 
	 * @return: returns the object to the property file which was opened.
	 */
	static public Properties readProperties(String sFileName, String sFilePath) {
		Properties prop = new Properties();
		
		try {
			if (sFilePath.trim().length() > 0) {
				prop.load(new FileReader(new File(sFilePath + File.pathSeparator + sFileName)));
			}
			else {
				prop.load(new FileReader(new File(sFileName)));
			}
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		
		return prop;
	}
}