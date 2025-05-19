package com.fhsbatista.fooddelivery.services;

import org.springframework.stereotype.Component;

import com.fhsbatista.fooddelivery.models.Customer;
import com.fhsbatista.fooddelivery.notifications.EmailNotificator;
import com.fhsbatista.fooddelivery.notifications.Notificator;

@Component
public class ActivateCustomer {
	private Notificator notificator;
	
	public ActivateCustomer(Notificator notificator) {
		this.notificator = notificator;
		System.out.println("Ativacao activate customer" + notificator);
	}
	

	public void activate(Customer customer) {
		customer.activate();
		
		notificator.notify(customer, "Your registration has been activated");
		
	}
}
