package filewriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import domain.operation.Operation;

public class FileWriter {

	public LinkedList<Operation> getOperationListFromFile(File file, LinkedList<Operation> list) {
		/*int errorCounter = 0;
		BufferedWriter bw = null;
		try {
			bw = new Buffered(new java.io.FileWriter(file));
			String line = bw.write(line);
			while (line != null) {

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
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Nombre d'erreur : " + errorCounter);
		}*/
		return list;
	}

}
