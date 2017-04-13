package filereader;

import java.io.File;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import domain.operation.Operation;
import junit.framework.Assert;

public class DeutscheBankFileReaderTest {
	
	File file = new File("src\\test\\resources\\filereader\\db.txt");
	File file2 = new File("src\\test\\resources\\filereader\\db2.txt");
	
	DeutscheBankFileReader fileReader;
	
	@Before
	public void setup(){
		fileReader = new DeutscheBankFileReader();
	}

	@Test
	public void getOperationListFromFile() {
		LinkedList<Operation> list = fileReader.getOperationListFrom(file);
		System.out.println(list.size());
		Assert.assertEquals(3, list.size());
	}
	
	@Test
	public void convertToDomain(){
		Operation operation = null;
		try {
			operation = fileReader.convertToDomain("\"02/02/2016\"|\"Com : dsdsddssd\"|\"152.25\"|\"\"|\"EUR\"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(new Double(152.25), operation.getAmount());
		Assert.assertEquals(2, operation.getValueDate().getMonth());
		Assert.assertEquals(2, operation.getValueDate().getDay());
		Assert.assertEquals(2016, operation.getValueDate().getYear());
		Assert.assertEquals("dsdsddssd", operation.getComment());
	}
	
	@Test
	public void getOperationListFrom2Files() {
		LinkedList<Operation> list = fileReader.getOperationListFrom(file);
		list = fileReader.getOperationListFromFile(file2, list);
		
		System.out.println(list.size());
		Assert.assertEquals(6, list.size());
	}
	
	@Test
	public void getComment() {
		System.out.println(fileReader.createComment("123-456-789"));
		
		
	}
}
