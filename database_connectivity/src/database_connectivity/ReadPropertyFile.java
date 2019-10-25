package database_connectivity;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ReadPropertyFile {

	public Properties getPropertiesFile() {
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader(new File("config.properties")));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return prop;
	}
}