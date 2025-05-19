package com.fhsbatista.fooddelivery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fhsbatista.fooddelivery.models.Customer;
import com.fhsbatista.fooddelivery.services.ActivateCustomer;

@Controller
public class CustomerController {
	private ActivateCustomer activateCustomer;
	
	public CustomerController(ActivateCustomer activateCustomer) {
		this.activateCustomer = activateCustomer;
	}
	
	@PostMapping("/activate")
	@ResponseBody
	public String activate() {
		Customer john = new Customer("John", "john@john.com", "1191111111");
		activateCustomer.activate(john);
		
		return "activated";
	}
}
