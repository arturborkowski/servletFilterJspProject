package com.advancedJava.classes.ifaces;

import com.advancedJava.classes.UserRepository;
import com.advancedJava.classes.items.User;

public interface ICheckRegistrationCondition {

	public String check(User user, UserRepository repo);
	public boolean canCheck(User user, UserRepository repo);
	
}
