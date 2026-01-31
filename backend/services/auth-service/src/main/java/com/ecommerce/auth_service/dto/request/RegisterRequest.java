package com.ecommerce.auth_service.dto.request;

public class RegisterRequest {

    private String email;
    private String password;

    private String title;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mobileNumber;

    private String companyName;
    private String gstNumber;
    private String jobRole;
    private String primaryUse;

    private Boolean contactEmail;
    private Boolean contactPhone;
    private Boolean contactSms;
    private Boolean rememberMe;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String getPrimaryUse() {
		return primaryUse;
	}
	public void setPrimaryUse(String primaryUse) {
		this.primaryUse = primaryUse;
	}
	public Boolean getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(Boolean contactEmail) {
		this.contactEmail = contactEmail;
	}
	public Boolean getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(Boolean contactPhone) {
		this.contactPhone = contactPhone;
	}
	public Boolean getContactSms() {
		return contactSms;
	}
	public void setContactSms(Boolean contactSms) {
		this.contactSms = contactSms;
	}
	public Boolean getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
    
    
}
