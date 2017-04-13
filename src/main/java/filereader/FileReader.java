package filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

import domain.operation.Operation;
import manager.AccountManager;

public abstract class FileReader {
	
	public LinkedList<Operation> getOperationListFromFile(File file, LinkedList<Operation> list){
		int errorCounter = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new java.io.FileReader(file));
			String line = br.readLine();
			while (line != null){
				
				Operation operation;
				try {
					operation = convertToDomain(line);
					list.add(operation);
				} catch (Exception e) {
					System.err.println("Not able to convert operation line to domain object");
					e.printStackTrace();
					errorCounter++;
				}
				
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Nombre d'erreur : "+errorCounter);
		}
		return list;
	}
	
	public LinkedList<Operation> getOperationListFrom(File f){
		return getOperationListFromFile(f, new LinkedList<Operation>() );
	}
	
	public abstract Operation convertToDomain(String line) throws Exception;
	
}
