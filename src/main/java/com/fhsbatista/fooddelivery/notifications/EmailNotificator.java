package com.fhsbatista.fooddelivery.notifications;

import com.fhsbatista.fooddelivery.models.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NotificationType(Priority.LOW)
@Component
public class EmailNotificator implements Notificator {
	@Value("${notificator.email.host.server}")
	private String host;

	@Value("${notificator.email.host.port}")
	private Integer port;


	public EmailNotificator() {
		System.out.println("construtor notificador chamado");
	}
	
	public void notify(Customer customer, String message) {
		System.out.printf("Connecting to server %s:%s\n", host, port);
		System.out.printf(
				"Notifying %s on email: %s\n", 
				customer.getName(), 
				customer.getEmail()
				);
	}
}
