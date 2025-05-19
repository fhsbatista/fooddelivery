package com.fhsbatista.fooddelivery.notifications;

import com.fhsbatista.fooddelivery.models.Customer;

public interface Notificator {
	void notify(Customer customer, String message);
}
