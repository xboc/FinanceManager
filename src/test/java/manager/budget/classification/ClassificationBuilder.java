package manager.budget.classification;

import manager.budget.BudgetBuilder;

public class ClassificationBuilder {

	public static Revenue aRevenue() {
		Revenue revenue = new Revenue("", BudgetBuilder.aBudget());
		return revenue;
	}
	
	public static Expense anExpense() {
		Expense expense = new Expense("", BudgetBuilder.aBudget());
		return expense;
	}
	
	

}
