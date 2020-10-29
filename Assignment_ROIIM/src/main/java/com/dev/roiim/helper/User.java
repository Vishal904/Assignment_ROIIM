package com.dev.roiim.helper;


public class User {

//    @GeneratedValue(generator = "UUID")
    private String merchantCustomerId;

    private DateOfBirth dateOfBirth = new DateOfBirth();

    private String locale = "en_US";

    
    
    public String getMerchantCustomerId() {
		return merchantCustomerId;
	}



	public void setMerchantCustomerId(String merchantCustomerId) {
		this.merchantCustomerId = merchantCustomerId;
	}



	public DateOfBirth getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(DateOfBirth dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getLocale() {
		return locale;
	}



	public void setLocale(String locale) {
		this.locale = locale;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	private String email;


}
