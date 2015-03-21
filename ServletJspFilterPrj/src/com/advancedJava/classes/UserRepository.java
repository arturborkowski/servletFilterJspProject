package com.advancedJava.classes;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	private DummyDataBase db;
	
	public UserRepository(DummyDataBase db) {
		this.db = db;
	}
	
	
	public void add(User user) {
		db.users.add(user);
	}
	
	public User get(int index) {
		return db.users.get(index);
	}
	
	public User getByName(String name) {
		for(User u: db.users) {
			if(u.getUsername().equals(name))
				return u;
		}
		return null;
	}
	
	public List<User> getAll() {
		return db.users;
	}
	
	public List<User> getPremiumUsers() {
		List<User> list = new ArrayList<User>();
		for(User u: db.users) {
			if(u.getPrivilage() == Privilage.PREMIUM) {
				list.add(u);
			}
		}
		return list;
	}

}
