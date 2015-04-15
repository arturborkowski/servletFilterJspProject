package com.advancedJava.classes;

import javax.servlet.http.HttpServletRequest;

import com.advancedJava.classes.ifaces.IBuilder;
import com.advancedJava.classes.items.Address;

public class AddressBuilder implements IBuilder<Address> {

	

	@Override
	public Address build(HttpServletRequest req) {
		
		if(req.getParameter("addressType").equals("default") || req.getParameter("province").equals("default")) {
			return null;
		}
		else {
		
			Address a = new Address();
			a.setType(req.getParameter("addressType"));
			a.setStreet(req.getParameter("street"));
			a.setHouseNumber(req.getParameter("houseNumber"));
			a.setCity(req.getParameter("city"));
			a.setPostalCode(req.getParameter("postalCode"));
			a.setProvince(req.getParameter("province"));
			return a;
		}
	}

}
