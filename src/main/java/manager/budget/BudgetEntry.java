package manager.budget;

import domain.operation.Operation;
import manager.budget.classification.Classification;

public class BudgetEntry {
	
	private Operation operation ;
	
	private Classification classification;
	
	public BudgetEntry(Operation operation, Classification classification){
		this.classification = classification;
		this.operation = operation;
	}
	
}
