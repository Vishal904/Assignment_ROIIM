package com.dev.roiim.helper;


public class CustomerJSON {

//    @GeneratedValue(generator = "UUID")
    private String merchantCustomerId;

    private DateOfBirthJSON dateOfBirth = new DateOfBirthJSON();

    private String locale = "en_US";

    
    
    public String getMerchantCustomerId() {
		return merchantCustomerId;
	}



	public void setMerchantCustomerId(String merchantCustomerId) {
		this.merchantCustomerId = merchantCustomerId;
	}



	public DateOfBirthJSON getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(DateOfBirthJSON dateOfBirth) {
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
