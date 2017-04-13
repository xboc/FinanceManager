package domain.operation.comment;

public class PredefinedComment extends Comment {
	
	private String comment;
	
	public PredefinedComment(String comment){
		this.comment=comment;
	}
	
	public String toString(){
		return "+++"+comment.substring(0,3)+"-"+comment.substring(3,7)+"-"+comment.substring(7,10)+"+++";
	}
	

}
