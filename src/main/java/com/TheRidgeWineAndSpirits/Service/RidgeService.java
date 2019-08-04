package com.TheRidgeWineAndSpirits.Service;

import java.util.ArrayList;
import java.util.List;

import com.TheRidgeWineAndSpirits.dao.MockDao;
import com.TheRidgeWineAndSpirits.dao.RidgeDao;
import com.TheRidgeWineAndSpirits.dao.RidgeDaoImpl;
import com.TheRidgeWineAndSpirits.model.EmailRequest;

public class RidgeService {

	private RidgeDao dao = new RidgeDaoImpl();
	
//	public EmailRequest emailRequest(EmailRequest request) {
//		return dao.emailRequest(request);
//		
//	}
	public String emailRequest(EmailRequest request) {
		AwsSnsPublish service = new AwsSnsPublish();
		String messageId = service.sendEmail(request);	
		return messageId;
	}

	public List<EmailRequest> getAllRequests() {
		return dao.getAllRequests();
	}

	public EmailRequest updateRequest(EmailRequest updateRequest) {
		dao.updateRequest(updateRequest);
		return updateRequest;
	}

	public EmailRequest addRequest(EmailRequest request) {
		return dao.addRequest(request);
	}

	public List<EmailRequest> getByRequestProductName(String requestProductName) {
		dao.getByRequestProductName(requestProductName);
		return null;
	}

	public List<EmailRequest> deleteByRequestNumber(int requestNumber) {
		List<EmailRequest> requests = dao.deleteByRequestNumber(requestNumber);
		return requests;
	}

	
	
}
