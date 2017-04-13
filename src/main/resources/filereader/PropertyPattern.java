package filereader.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyPattern {
	
	private String str = "\"01/02/2016\"|\"Com : dsdsddssd\"|\"152.25\"|\"\"|\"EUR\"";
	
	private String pattern;
	
	private String valueDate;
	
	private String amount;
	
	private String comment;
	
	private String date;
	
	
	
	public PropertyPattern(String pattern, String valueDate, String amount, String comment) {
		this.pattern = pattern;
		this.valueDate = valueDate;
		this.amount = amount;
		this.comment = comment;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public String retrieveFromStringWithoutPattern() {
		System.out.println(str);
		Pattern pattern = Pattern.compile("\"(.*)\"\\|\"Com : (.*)\"\\|\"(.*)\"\\|\"(.*)\"\\|\"(.*)");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			System.out.println(matcher.group(0));
			System.out.println("group 1 :"+matcher.group(1));
			System.out.println("group 2 :"+matcher.group(2));
			System.out.println("group 3 :"+matcher.group(3));
			System.out.println("group 4 :"+matcher.group(4));
			System.out.println("group 5 :"+matcher.group(5));
			return matcher.group(1);
		}
		return null;
	}
	
}
