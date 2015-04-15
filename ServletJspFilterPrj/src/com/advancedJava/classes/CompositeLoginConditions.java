package com.advancedJava.classes;

import java.util.ArrayList;
import java.util.List;

import com.advancedJava.classes.ifaces.ICheckLoginCondition;


public class CompositeLoginConditions {

private List<ICheckLoginCondition> conditionsList;
	
	public CompositeLoginConditions() {
		conditionsList = new ArrayList<ICheckLoginCondition>();
	}
	
	
	public List<ICheckLoginCondition> getConditionsList() {
		return this.conditionsList;
	}
	
	public void addCondition(ICheckLoginCondition condition) {
		this.conditionsList.add(condition);
	}

}
