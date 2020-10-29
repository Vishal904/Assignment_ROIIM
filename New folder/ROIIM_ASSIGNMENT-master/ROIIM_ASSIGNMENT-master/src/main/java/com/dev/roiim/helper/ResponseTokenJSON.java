package com.dev.roiim.helper;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;

public class ResponseTokenJSON {

   private String singleUseCustomerToken;

public String getSingleUseCustomerToken() {
	return singleUseCustomerToken;
}

public void setSingleUseCustomerToken(String singleUseCustomerToken) {
	this.singleUseCustomerToken = singleUseCustomerToken;
}
   
   

}
