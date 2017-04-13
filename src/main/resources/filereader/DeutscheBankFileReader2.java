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
import filereader.pattern.PropertiesManager;

public class DeutscheBankFileReader2 extends FileReader {

	private PropertiesManager propertiesManager = new PropertiesManager();

	@Override
	public Operation convertToDomain(String line) {
		/*
		 * line = line.replaceAll("\"", ""); String[] ss=line.split("\\|"); //
		 * System.err.println(ss.length); // System.err.println(ss[0]); //
		 * System.err.println(ss[1]); // System.err.println(ss[2]); //
		 * System.err.println(ss[3]); // System.err.println(ss[4]); //
		 * System.err.println(ss[2].length()); if("".equals(ss[2])){ return new
		 * DebitOperation(new Double(ss[3]), ss[1],ss[1],new Date(ss[0])); }else
		 * { return new CreditCardOperation(new Double(ss[2]), ss[1],ss[1],new
		 * Date(ss[0])); }
		 */
		System.out.println(line);
		Properties properties = propertiesManager.findPropertyMatchingOperationLine(line);
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
				Double amount = new Double(matcher.group(properties.getProperty("amount")));

				return new DebitOperation(amount, (Account) null, (Account) null, new Date());
			}
		} else {
			return null;

			// new CreditCardOperation(new Double(ss[2]), ss[1],ss[1],new
			// Date(ss[0]));
		}

	}

}
