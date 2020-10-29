package com.dev.roiim.dto;

import com.dev.roiim.validator.isValidEmail;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CustomerDto {

    @NotEmpty
    @Size(min = 4)
    @isValidEmail
    private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
    


}
