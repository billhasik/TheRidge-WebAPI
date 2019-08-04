package com.TheRidgeWineAndSpirits.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.TheRidgeWineAndSpirits.model.EmailRequest;

public class RidgeDaoImpl implements RidgeDao{

	
	private static String sqlGetAllRequests = "SELECT requestNumber, requestDateTime, requestProductName," +
												" requestProductDescription, requestProductImage, requestCustomerName, " +
												" requestPhoneNumber, requestEmail " +
												"FROM ridgecustomerrequest;";
	
	private static String sqlUpdateRequestByNumber = "UPDATE ridgecustomerrequest SET requestProductName = ?," +
												" requestProductDescription = ?, requestProductImage = ?, requestCustomerName = ?, " +
												" requestPhoneNumber = ?, requestEmail = ? WHERE requestNumber = ?;";
	
	private static String sqlInsertNewRequest = "INSERT INTO ridgecustomerrequest (requestProductName, requestProductDescription, "
												+ "requestProductImage, requestCustomerName, requestPhoneNumber, requestEmail) "
												+ "VALUES (?,?,?,?,?,?);";
	
	private static String sqlSearchByRequestProductName = "SELECT requestNumber, requestDateTime, requestProductName," +
															" requestProductDescription, requestProductImage, requestCustomerName, " +
															" requestPhoneNumber, requestEmail " +
															"FROM ridgecustomerrequest "+
															"WHERE requestProductName = ?;";
	
	private static String sqlSearchByRequestNumber = "SELECT requestNumber, requestDateTime, requestProductName," +
													" requestProductDescription, requestProductImage, requestCustomerName, " +
													" requestPhoneNumber, requestEmail " +
													"FROM ridgecustomerrequest "+
													"WHERE requestNumber = ?;";
	
	private static String sqlDeleteByRequestNumber = "DELETE FROM ridgecustomerrequest WHERE requestNumber = ?;";

	@Override
	public List<EmailRequest> getAllRequests() {
		
		List<EmailRequest> requests = new ArrayList<EmailRequest>();
		
		ResultSet result = null;
		Statement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();

		try {			
			statement = conn.createStatement();			
			result = statement.executeQuery(sqlGetAllRequests);
			
			while(result.next()) {		
				requests.add(makeRequest(result));				
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {				
				result.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		return requests;
	}

	private EmailRequest makeRequest(ResultSet result) throws SQLException {
		EmailRequest request = new EmailRequest();									
		request.setRequestNumber(result.getString("requestNumber"));
		request.setRequestDateTime(result.getString("requestDateTime"));
		request.setRequestProductName(result.getString("requestProductName"));
		request.setRequestProductDescription(result.getString("requestProductDescription"));
		request.setRequestProductImage(result.getString("requestProductImage"));
		request.setRequestCustomerName(result.getString("requestCustomerName"));
		request.setRequestPhoneNumber(result.getString("requestPhoneNumber"));
		request.setRequestEmail(result.getString("requestEmail"));
		return request;
	}

	@Override
	public EmailRequest updateRequest(EmailRequest updateRequest) {
		int    rowCount = 0;
        PreparedStatement statement = null;
        
        Connection conn = MariaDbUtil.getConnection();

        try {                
            statement = conn.prepareStatement(sqlUpdateRequestByNumber);

            statement.setString(1, updateRequest.getRequestProductName());
            statement.setString(2, updateRequest.getRequestProductDescription());
            statement.setString(3, updateRequest.getRequestProductImage());
            statement.setString(4, updateRequest.getRequestCustomerName());
            statement.setString(5, updateRequest.getRequestPhoneNumber());
            statement.setString(6, updateRequest.getRequestEmail());
            statement.setString(7, updateRequest.getRequestNumber());

        
            rowCount = statement.executeUpdate();
            System.out.println("rows Updated: " + rowCount);
            
        } catch (SQLException e) {            
            e.printStackTrace();
        } finally {
            try {                
                statement.close();
                conn.close();
            } catch (SQLException e) {                
                e.printStackTrace();
            }
        }
        
        return updateRequest;    
	}

	@Override
	public EmailRequest addRequest(EmailRequest request) {
		int	rowCount = 0;
		PreparedStatement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();

		try {				
			statement = conn.prepareStatement(sqlInsertNewRequest);
			 statement.setString(1, request.getRequestProductName());
	         statement.setString(2, request.getRequestProductDescription());
	         statement.setString(3, request.getRequestProductImage());
	         statement.setString(4, request.getRequestCustomerName());
	         statement.setString(5, request.getRequestPhoneNumber());
	         statement.setString(6, request.getRequestEmail());
						
			rowCount = statement.executeUpdate();						
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {				
				statement.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		return request;
		
	}
	
	public List<EmailRequest> getByRequestNumber(int requestNumber){
		List<EmailRequest> requests = new ArrayList<EmailRequest>();
		
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();

		try {				
			statement = conn.prepareStatement(sqlSearchByRequestNumber);
			statement.setInt(1, requestNumber);
			result = statement.executeQuery();				
			while(result.next()) {						
				requests.add(makeRequest(result));				
			}					
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {				
				statement.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		return requests;
	}

	@Override
	public List<EmailRequest> deleteByRequestNumber(int requestNumber) {
		List<EmailRequest> requests = getByRequestNumber(requestNumber);

		int	rowCount = 0;
		PreparedStatement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();

		try {				
			statement = conn.prepareStatement(sqlDeleteByRequestNumber);
			statement.setInt(1, requestNumber);						
			rowCount = statement.executeUpdate();			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {				
				statement.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		return requests;
		
	}

	@Override
	public List<EmailRequest> getByRequestProductName(String requestProductName) {

		return null;
	}
}
