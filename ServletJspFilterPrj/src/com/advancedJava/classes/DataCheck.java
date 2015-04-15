package com.advancedJava.classes;

import com.advancedJava.classes.ifaces.ICheckLoginCondition;
import com.advancedJava.classes.ifaces.ICheckRegistrationCondition;
import com.advancedJava.classes.items.User;


public class DataCheck {



	public static String isRegistrationPossible(User user,  UserRepository uRepo) {
		
		String checkMessage;
		CompositeRegistrationConditions list = new CompositeRegistrationConditions();
		list.addCondition(new RegistrationUserExistanceCondition());
		list.addCondition(new RegistrationFulfillmentCondition());
		
		
		for(ICheckRegistrationCondition cond: list.getConditionsList()) {
			checkMessage = cond.check(user, uRepo);
			if(checkMessage != null)
				return checkMessage;
		}
		return null;		
	}
	
	
	public static String isLoginPossible(String username, String password, UserRepository uRepo) {
	
		String checkMessage;
		CompositeLoginConditions list = new CompositeLoginConditions();
		list.addCondition(new LoginCredentialsCorrectnessCheck());
		list.addCondition(new LoginUserExistanceCondition());
		
		for(ICheckLoginCondition cond: list.getConditionsList()) {
			checkMessage = cond.check(username, password, uRepo);
			if(checkMessage != null)
				return checkMessage;
		}
		
		return null;

	}
}
