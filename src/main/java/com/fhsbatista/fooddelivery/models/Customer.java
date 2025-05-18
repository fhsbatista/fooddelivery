package com.fhsbatista.fooddelivery.models;

public class Customer {
	private String name;
	private String email;
	private String phone;
	private boolean active = false;
	
	public Customer(
			String name,
			String email,
			String phone
			) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void activate() {
		this.active = true;
	}
	
}
