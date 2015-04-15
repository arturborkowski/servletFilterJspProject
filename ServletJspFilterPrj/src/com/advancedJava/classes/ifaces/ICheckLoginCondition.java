package com.advancedJava.classes.ifaces;

import com.advancedJava.classes.UserRepository;

public interface ICheckLoginCondition {

	public boolean canCheck(String username, String password, UserRepository repo);
	public String check(String username, String password, UserRepository repo);
	
}
