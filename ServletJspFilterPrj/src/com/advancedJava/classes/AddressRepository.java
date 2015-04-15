package com.advancedJava.classes;

import java.util.List;

import com.advancedJava.classes.items.Address;
import com.advancedJava.classes.items.User;

public class AddressRepository {

	private List<Address> addresses;
	
	public AddressRepository(User user) {
		this.addresses = user.getAddresses();
	}
	
	
	
	public void add(Address a) {
		addresses.add(a);
	}
	
	public void remove(Address a) {
		addresses.remove(a);
	}
	
	public void remove(int addressId) {
		addresses.remove(getAddressById(addressId));
	}
	
	
	public Address getAddressById(int id){
		for(Address a: addresses ) {
			if(a.getId()==id)
				return a;
		}
		return null;
	}

}
