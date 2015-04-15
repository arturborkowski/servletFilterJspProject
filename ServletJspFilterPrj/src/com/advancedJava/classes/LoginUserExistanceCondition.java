package com.advancedJava.classes;

import com.advancedJava.classes.ifaces.ICheckLoginCondition;
import com.advancedJava.classes.items.Message;

public class LoginUserExistanceCondition implements ICheckLoginCondition {

	public LoginUserExistanceCondition() {}

	

	@Override
	public String check(String username, String password, UserRepository repo) {
		
		if(repo.getByName(username) != null)
			return null;
		else
			return Message.NO_SUCH_USER;
	}
	
	
	
	@Override
	public boolean canCheck(String username, String password,
			UserRepository repo) {
		// TODO Auto-generated method stub
		return false;
	}

}
