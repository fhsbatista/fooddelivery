package com.fhsbatista.fooddelivery.services;

import com.fhsbatista.fooddelivery.notifications.NotificationType;
import com.fhsbatista.fooddelivery.notifications.Priority;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fhsbatista.fooddelivery.models.Customer;
import com.fhsbatista.fooddelivery.notifications.EmailNotificator;
import com.fhsbatista.fooddelivery.notifications.Notificator;

@Component
public class ActivateCustomer {

	private Notificator notificator;
	
	public ActivateCustomer(@NotificationType(Priority.URGENT) Notificator notificator) {
		this.notificator = notificator;
		System.out.println("Ativacao activate customer" + notificator);
	}
	

	public void activate(Customer customer) {
		customer.activate();
		
		notificator.notify(customer, "Your registration has been activated");
		
	}
}
