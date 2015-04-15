package com.advancedJava.classes;

import com.advancedJava.classes.ifaces.ICheckRegistrationCondition;
import com.advancedJava.classes.items.Message;
import com.advancedJava.classes.items.User;

public class RegistrationFulfillmentCondition implements
		ICheckRegistrationCondition {

	public RegistrationFulfillmentCondition() {}

	@Override
	public String check(User user, UserRepository repo) {
		if(user.getUsername().isEmpty()|| user.getPassword().isEmpty()
				|| user.getEmail().isEmpty()) 
			return Message.FIELDS_NOT_FILLED;
		else 
				return null;
	}

	@Override
	public boolean canCheck(User user, UserRepository repo) {
		// TODO Auto-generated method stub
		return false;
	}

}
