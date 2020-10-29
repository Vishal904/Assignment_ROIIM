package com.dev.roiim.helper;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;

public class TokenJSON {

//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
    private String merchantRefNum;

    private String[] paymentTypes = {"CARD"};

	public String getMerchantRefNum() {
		return merchantRefNum;
	}

	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}

	public String[] getPaymentTypes() {
		return paymentTypes;
	}

	public void setPaymentTypes(String[] paymentTypes) {
		this.paymentTypes = paymentTypes;
	}
    
    
}
