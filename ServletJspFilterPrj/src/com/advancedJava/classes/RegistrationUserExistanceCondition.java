package com.advancedJava.classes;

import com.advancedJava.classes.ifaces.ICheckRegistrationCondition;
import com.advancedJava.classes.items.Message;
import com.advancedJava.classes.items.User;

public class RegistrationUserExistanceCondition implements
		ICheckRegistrationCondition {

	public RegistrationUserExistanceCondition() {}

	@Override
	public String check(User user, UserRepository repo) {
		if(repo.getAll().contains(repo.getByName(user.getUsername()))) 
			return Message.USER_EXISTS;
		else 
			return null;

	}

	@Override
	public boolean canCheck(User user, UserRepository repo) {
		// TODO Auto-generated method stub
		return false;
	}

}
