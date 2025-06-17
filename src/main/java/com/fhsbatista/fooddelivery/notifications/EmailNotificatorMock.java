package com.fhsbatista.fooddelivery.notifications;

import com.fhsbatista.fooddelivery.models.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@NotificationType(Priority.LOW)
@Component
public class EmailNotificatorMock implements Notificator {
	public EmailNotificatorMock() {
		System.out.println("construtor notificador chamado");
	}
	
	public void notify(Customer customer, String message) {
		System.out.printf(
				"MOCK:: Notifying %s on email: %s\n",
				customer.getName(), 
				customer.getEmail()
				);
	}
}
