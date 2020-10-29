package com.dev.roiim.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String email;

    private String customerId;

    private String CustomerOperation;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerOperation() {
		return CustomerOperation;
	}

	public void setCustomerOperation(String customerOperation) {
		CustomerOperation = customerOperation;
	}
    
    

}
