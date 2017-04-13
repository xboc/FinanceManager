package filereader.pattern;

import java.util.Properties;

import org.junit.Test;

public class PropertiesManagerTest {
	
	private String propertyFileName = "src\\test\\resources\\filereader\\pattern\\properties\\db.properties";
	
	
	private PropertiesManager propertiesManager = new PropertiesManager();
	
	@Test
	public void findPropertyMatchingOperationLineTest(){
		
		propertiesManager.propertiesList.add(propertiesManager.readPropertiesFile(propertyFileName));
		
		String line = "\"01/02/2016\"|\"Com : dsdsddssd\"|\"152.25\"|\"\"|\"EUR\"";
		
		Properties prop = propertiesManager.findPropertyMatchingOperationLine(line);
		
		System.out.println(prop);
		
	}
	
	@Test
	public void initPropertiesListTest() {
		String fileName = "src\\test\\resources\\filereader\\pattern\\properties";
		propertiesManager.initPropertiesList(fileName);
		System.out.println(propertiesManager.propertiesList);
	}

}
