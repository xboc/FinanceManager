package filereader.pattern.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class OperationPatternProperties {

	InputStream inputStream;

	public Properties getPatternProperties(String propertyFileName) {
		Properties prop = new Properties();
		try {
			inputStream = new FileInputStream(new File(propertyFileName));
					//getClass().getClassLoader().getResourceAsStream(propertyFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException();
			}
			Date time = new Date(System.currentTimeMillis());
			String pattern = prop.getProperty("pattern");
			String from = prop.getProperty("from");
			String to = prop.getProperty("to");
			String amount = prop.getProperty("amount");
			String datetime = prop.getProperty("dateime");
			String valueDate = prop.getProperty("valuedate");
			String comment = prop.getProperty("comment");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}
	
}
