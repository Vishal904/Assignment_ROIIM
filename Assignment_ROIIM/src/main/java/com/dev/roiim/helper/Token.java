package com.dev.roiim.helper;

public class Token {

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
