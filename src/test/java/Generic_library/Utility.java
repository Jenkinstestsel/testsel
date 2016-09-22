package Generic_library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {

//	 this class used to access the properties file(Config.properties) to access setting for the project

	public static String getValue(String skey) throws Exception {
//		User.dir will get the current project folder path
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Config.properties");
//	properties class help you to fetch the value from the property file based on key
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(skey);
		
		
		

		
		
	}
}
