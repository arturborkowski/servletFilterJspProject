package com.advancedJava.classes;

import com.advancedJava.classes.ifaces.ICheckLoginCondition;
import com.advancedJava.classes.items.Message;

public class LoginCredentialsCorrectnessCheck implements ICheckLoginCondition {

	public LoginCredentialsCorrectnessCheck() {}



	@Override
	public String check(String username, String password, UserRepository repo) {
		
		if(canCheck(username, password, repo)) {
			if(repo.getByName(username).getPassword().equals(password))
				return null;
			else
				return Message.WRONG_PASS_OR_USERNAME;
		}
		return null;
	}
	
	@Override
	public boolean canCheck(String username, String password,
			UserRepository repo) {
		if(new LoginUserExistanceCondition().check(username, password, repo)==null)
			return true;
		else
			return false;
	}

}
