package com.TheRidgeWineAndSpirits.model;

public class EmailRequest {

	private String requestNumber;
	private String requestDateTime;
	private String requestProductName;
	private String requestProductDescription;
	private String requestProductImage;
	private String requestCustomerName;
	private String requestPhoneNumber;
	private String requestEmail;
	
	public EmailRequest(){
		
	}
	
	public EmailRequest(String requestNumber,
					String requestDateTime,
					String requestProductName, 
					String requestProductDescription, 
					String requestProductImage,
					String requestCustomerName,
					String requestPhoneNumber, 
					String requestEmail){
		
		this.requestNumber = requestNumber;
		this.requestDateTime = requestDateTime;
		this.requestProductName = requestProductName;
		this.requestProductDescription = requestProductDescription;
		this.requestProductImage = requestProductImage;
		this.requestCustomerName = requestCustomerName;
		this.requestPhoneNumber = requestPhoneNumber;
		this.requestEmail = requestEmail;
	}

	public String getRequestNumber() {
		return requestNumber;
	}

	public String getRequestDateTime() {
		return requestDateTime;
	}

	public String getRequestProductName() {
		return requestProductName;
	}

	public String getRequestProductDescription() {
		return requestProductDescription;
	}

	public String getRequestProductImage() {
		return requestProductImage;
	}

	public String getRequestCustomerName() {
		return requestCustomerName;
	}

	public String getRequestPhoneNumber() {
		return requestPhoneNumber;
	}

	public String getRequestEmail() {
		return requestEmail;
	}

	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}

	public void setRequestDateTime(String requestDateTime) {
		this.requestDateTime = requestDateTime;
	}

	public void setRequestProductName(String requestProductName) {
		this.requestProductName = requestProductName;
	}

	public void setRequestProductDescription(String requestProductDescription) {
		this.requestProductDescription = requestProductDescription;
	}

	public void setRequestProductImage(String requestProductImage) {
		this.requestProductImage = requestProductImage;
	}

	public void setRequestCustomerName(String requestCustomerName) {
		this.requestCustomerName = requestCustomerName;
	}

	public void setRequestPhoneNumber(String requestPhoneNumber) {
		this.requestPhoneNumber = requestPhoneNumber;
	}

	public void setRequestEmail(String requestEmail) {
		this.requestEmail = requestEmail;
	}
	
	
	
	
	
}
