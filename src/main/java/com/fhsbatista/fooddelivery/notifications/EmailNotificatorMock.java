package com.fhsbatista.fooddelivery.notifications;

import com.fhsbatista.fooddelivery.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@NotificationType(Priority.LOW)
@Component
public class EmailNotificatorMock implements Notificator {
	@Autowired
	private NotificationProperties properties;

	public EmailNotificatorMock() {
		System.out.println("construtor notificador chamado");
	}
	
	public void notify(Customer customer, String message) {
		System.out.printf(
				"MOCK:: Notifying %s on email: %s\nServer: %s:%s",
				customer.getName(), 
				customer.getEmail(),
				properties.getHostServer(),
				properties.getPortServer()
				);
	}
}
