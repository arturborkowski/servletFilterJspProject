package com.advancedJava.classes.ifaces;

import javax.servlet.http.HttpServletRequest;



public interface IBuilder<T> {

	public T build(HttpServletRequest req);
	
}
