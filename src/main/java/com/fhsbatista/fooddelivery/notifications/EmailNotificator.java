package com.fhsbatista.fooddelivery.notifications;

import com.fhsbatista.fooddelivery.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@NotificationType(Priority.LOW)
@Component
public class EmailNotificator implements Notificator {
	@Autowired
	private NotificationProperties properties;

	public void teste() {
		System.out.println("Host: " + properties.getHostServer());
		System.out.println("Port: " + properties.getPortServer());
	}


	public EmailNotificator() {
		System.out.println("construtor notificador chamado");
	}
	
	public void notify(Customer customer, String message) {
		System.out.printf(
				"Connecting to server %s:%s\n",
				properties.getHostServer(),
				properties.getPortServer()
		);
		System.out.printf(
				"Notifying %s on email: %s\n", 
				customer.getName(), 
				customer.getEmail()
				);
	}
}
