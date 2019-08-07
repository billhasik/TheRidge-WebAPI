package com.TheRidgeWineAndSpirits.dao;

import java.util.ArrayList;
import java.util.List;

import com.TheRidgeWineAndSpirits.model.EmailRequest;
import com.TheRidgeWineAndSpirits.model.Item;

public class MockDao implements RidgeDao {

	private static List<EmailRequest> requests = new ArrayList<EmailRequest>();
	
	static {
		requests.add(new EmailRequest("1", "06-30-1993", "Red wine", "red", null, "Betty", "205-792-3128", "@anon"));
		requests.add(new EmailRequest("1", "07-30-1993", "White wine", "white", null, "Fred", "501-792-3128", "@anon2"));
	}
	

	@Override
	public List<EmailRequest> getAllRequests() {
		
		return requests;
	}


	@Override
	public EmailRequest updateRequest(EmailRequest updateRequest) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public EmailRequest addRequest(EmailRequest request) {
		return null;
		
	}


	@Override
	public List<EmailRequest> getByRequestProductName(String requestProductName) {
		return null;
		
	}


	@Override
	public List<EmailRequest> deleteByRequestNumber(int requestNumber) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Item> getAllNewItems() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Item> getAllNewWineItems() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Item> getAllNewLiquorItems() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Item> getAllNewBeerItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
