package com.fhsbatista.fooddelivery.notifications;

import org.springframework.stereotype.Component;

import com.fhsbatista.fooddelivery.models.Customer;

@Component
public class EmailNotificator implements Notificator {
	public EmailNotificator() {
		System.out.println("construtor notificador chamado");
	}
	
	public void notify(Customer customer, String message) {
		System.out.printf(
				"Notifying %s on email: %s\n", 
				customer.getName(), 
				customer.getEmail()
				);
	}
}
