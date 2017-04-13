package manager.budget;

import java.util.LinkedList;

import manager.budget.classification.Classification;

public class BudgetBuilder {
	
	public LinkedList<Classification> classificationList = new LinkedList<Classification>();
	
	
	
	public static Budget aBudget(){
		Budget budget = new Budget("new Budget");
		
		budget.addClassification(null);
		
		return new Budget("new Budget");
		
	}
	
	public void withClassification(Classification classification) {
		classificationList.add(classification);
	}
	
	public Budget build() {
		return null;
	}
	
	

}
