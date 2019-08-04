package com.TheRidgeWineAndSpirits.dao;

import java.util.List;

import com.TheRidgeWineAndSpirits.model.EmailRequest;

public interface RidgeDao {
	

	public List<EmailRequest> getAllRequests();

	public EmailRequest updateRequest(EmailRequest updateRequest);

	public EmailRequest addRequest(EmailRequest request);

	public List<EmailRequest> getByRequestProductName(String requestProductName);

	public List<EmailRequest> deleteByRequestNumber(int requestNumber);
}
