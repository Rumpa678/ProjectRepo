package steller.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author RUPA
 *
 */
public class Fileutility {
/**
 * 	
 * @param key
 * @return
 * @throws IOException
 */
	
public String getPropertyKeyValue(String key) throws IOException {
	FileInputStream fis=new FileInputStream(Ipathconstants.propertyFilePath);
	Properties prop=new Properties();
	prop.load(fis);
	String value=prop.getProperty(key);
	return value;
}
}
