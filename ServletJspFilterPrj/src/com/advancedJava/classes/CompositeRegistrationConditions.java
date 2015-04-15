package com.advancedJava.classes;

import java.util.ArrayList;
import java.util.List;

import com.advancedJava.classes.ifaces.ICheckRegistrationCondition;

public class CompositeRegistrationConditions {

	private List<ICheckRegistrationCondition> conditionsList;
	
	public CompositeRegistrationConditions() {
		conditionsList = new ArrayList<ICheckRegistrationCondition>();
	}
	
	
	public List<ICheckRegistrationCondition> getConditionsList() {
		return this.conditionsList;
	}
	
	public void addCondition(ICheckRegistrationCondition condition) {
		this.conditionsList.add(condition);
	}

	 
	
}
