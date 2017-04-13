package manager.budget.classification;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import domain.operation.Operation;
import manager.budget.Budget;

public abstract class Classification {

	private String name;

	private LinkedList<Operation> operationList = new LinkedList<Operation>();

	private Budget budget;

	private Double expected = 0.0;
	
	private Frequency frequency = Frequency.DAILY;

	public Classification(String name, Budget budget) {
		this.budget = budget;
		this.budget.addClassification(this);
		this.name = name;
	}

	public Double getCurrentTotalAmount() {
		Iterator<Operation> it = operationList.iterator();
		Double amount = new Double(0.0);
		while (it.hasNext()) {
			Operation op = (Operation) it.next();
			amount = amount + op.getAmount();
		}
		return amount;
	}

	public Double getTotalAmountForPeriod(Date from, Date to) {
		Iterator<Operation> it = operationList.iterator();
		Double amount = new Double(0.0);
		while (it.hasNext()) {
			Operation op = (Operation) it.next();
			if (op.getValueDate().after(from) && op.getValueDate().before(to)) {
				amount = amount + op.getAmount();
			}
		}
		return amount;
	}

	public void setExpectedAmount(Double expected) {
		this.expected = expected;
	}

	public Double getExpectedAmount() {
		return expected;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}
	
	public String getName(){
		return name;
	}
}
