package com.TheRidgeWineAndSpirits.controller;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.TheRidgeWineAndSpirits.Service.RidgeService;
import com.TheRidgeWineAndSpirits.model.EmailRequest;
import com.TheRidgeWineAndSpirits.model.Message;

@Path("controller")
public class RidgeController {

	
	@POST
	@Path("/emailRequest")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public Response emailRequest(EmailRequest request) {
		RidgeService service = new RidgeService();	
		String result = service.emailRequest(request);
		service.addRequest(request);
		Message message = new Message();
		message.setMessage(result);
		
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("/getAllRequests")
	@Produces({MediaType.APPLICATION_JSON})
	public List<EmailRequest> getAllRequests(){
		RidgeService service = new RidgeService();	
		return service.getAllRequests();
	}
	
	@PUT
	@Path("/updateRequest")
	@Produces(MediaType.APPLICATION_JSON)
	public EmailRequest updateRequest(EmailRequest updateRequest) {
		RidgeService service = new RidgeService();
		return service.updateRequest(updateRequest);
	}
	
	@POST
	@Path("/addRequest")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public EmailRequest addRequest(EmailRequest request){
		EmailRequest newRequest = new RidgeService().addRequest(request);
		return newRequest;
	}
	
	@DELETE
	@Path("/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmailRequest> deleteByKey(@PathParam("value") int requestNumber) {
		RidgeService service = new RidgeService();
		return service.deleteByRequestNumber(requestNumber);
	}
	
//	@GET             suppose to be a search function for SQL but just used angular instead
//	@Path("/ProductName")
//	@Consumes({MediaType.APPLICATION_JSON})
//	@Produces({MediaType.APPLICATION_JSON})
//	public List<EmailRequest> getByRequestProductName(String requestProductName){
//		RidgeService service = new RidgeService();	
//		return service.getByRequestProductName(requestProductName);
//	}
}
