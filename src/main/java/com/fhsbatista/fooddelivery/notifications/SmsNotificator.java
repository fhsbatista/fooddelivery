package com.fhsbatista.fooddelivery.notifications;

import com.fhsbatista.fooddelivery.models.Customer;
import org.springframework.stereotype.Component;

@NotificationType(Priority.URGENT)
@Component
public class SmsNotificator implements Notificator{
    @Override
    public void notify(Customer customer, String message) {
        System.out.printf("Notifying %s through phone %s", customer.getName(), customer.getPhone());
    }
}
