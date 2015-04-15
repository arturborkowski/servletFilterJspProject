package com.advancedJava.classes;

import com.advancedJava.classes.items.DummyDataBase;


public class DbProvider {

	private static DummyDataBase db;
	
	private DbProvider(){};
	
	public static DummyDataBase getDataBase() {
		if(db == null) {
			synchronized (DbProvider.class) {
				if(db == null) {
					db = new DummyDataBase();
				}
			}
		}
		return db;
	}
	
	
}
