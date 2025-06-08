package com.fhsbatista.fooddelivery.notifications;

import com.fhsbatista.fooddelivery.models.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@NotificationType(Priority.LOW)
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
