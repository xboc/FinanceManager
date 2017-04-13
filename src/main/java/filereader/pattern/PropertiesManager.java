package filereader.pattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesManager {
	
	LinkedList<Properties> propertiesList = new LinkedList<Properties>();
	
	InputStream inputStream;

	public Properties readPropertiesFile(String propertyFileName) {
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
			String datetime = prop.getProperty("datetime");
			String valueDate = prop.getProperty("valuedate");
			String comment = prop.getProperty("comment");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	
	public Properties findPropertyMatchingOperationLine(String line) {
		if(propertiesList.size()==0){initPropertiesList("src\\test\\resources\\filereader\\pattern\\properties");}
		System.out.println(line);
		Iterator<Properties> it = propertiesList.iterator();
		
		while(it.hasNext()) {
			Properties prop = it.next();
			String patternStr = prop.getProperty("pattern");
			Pattern pattern = Pattern.compile(patternStr);
			Matcher matcher = pattern.matcher(line);
			if(matcher.find()){
//				System.out.println(matcher.group(0));
//				System.out.println("group 1 :"+matcher.group(1));
//				System.out.println("group 2 :"+matcher.group(2));
//				System.out.println("group 3 :"+matcher.group(3));
//				System.out.println("group 4 :"+matcher.group(4));
//				System.out.println("group 5 :"+matcher.group(5));
				return prop;
			}
		}
		
		return null;
	}
	
	public void initPropertiesList(String fileOrDirName) {
		File file = new File(fileOrDirName);
		if (file.isDirectory()) {
			String[] files = file.list();

			for(int i=0;i<files.length;i++){
				initPropertiesList(fileOrDirName+"\\"+files[i]);
			}
		} else {
			propertiesList.add(readPropertiesFile(fileOrDirName));
		}
	}

}
