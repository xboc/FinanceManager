package filereader;

import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import domain.account.Account;
import domain.operation.CreditCardOperation;
import domain.operation.DebitOperation;
import domain.operation.Operation;
import domain.operation.comment.Comment;
import domain.operation.comment.PredefinedComment;
import filereader.pattern.PropertiesManager;

public class KeytradeFileReader extends FileReader {

	private PropertiesManager propertiesManager = new PropertiesManager();

	@Override
	public Operation convertToDomain(String line) throws Exception {
		System.out.println(line);
		Properties properties = propertiesManager.findPropertyMatchingOperationLine(line);
		if(properties == null) {
			throw new Exception("Properties not found "+line);
		}else 
		if (properties.get("creditCardAmount") == null) {

			Pattern pattern = Pattern.compile((String) properties.get("pattern"));
			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				System.out.println(matcher.group(0));
				System.out.println("group 1 :" + matcher.group(1));
				System.out.println("group 2 :" + matcher.group(2));
				System.out.println("group 3 :" + matcher.group(3));
				System.out.println("group 4 :" + matcher.group(4));
				System.out.println("group 5 :" + matcher.group(5));
				Double amount = new Double(matcher.group(Integer.parseInt(properties.getProperty("amount"))));
				Date valueDate = new Date(matcher.group(1));
				Comment comment = createComment(matcher.group(3));
				DebitOperation operation = new DebitOperation(amount, (Account) null, (Account) null, valueDate);
				operation.setComment(comment);
				return operation;
			}
				throw new Exception();
		} else {
			return null;

			// new CreditCardOperation(new Double(ss[2]), ss[1],ss[1],new
			// Date(ss[0]));
		}
	}

	public Comment createComment(String comment) {
		if (comment.matches("\\d{3}-\\d{3}-\\d{3}")) {
			return new PredefinedComment(comment);
		} else {
			return null;
		}
	}

}
