package net.rk.struts2.action;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BrokerChangeToClient {
	
	private String userid;
	private String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String execute(){
		Connection conn = null;
		String ret = "error";
		try {
	    	  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	    	   conn =
	    		      DriverManager.getConnection ("jdbc:oracle:thin:rk7/rk7@oracle1.cise.ufl.edu:1521:orcl",
	    		                                   "rk7", "oracle123");
	    	  
	    	   
	    	   System.out.println("Client from broker change client "+userid);
	    	   message="Client id set to "+userid;
	    	   
	    	   
	    	   
	    	   PreparedStatement ps1 = conn.prepareStatement("update currentuser set userid = ? ");
	    	   ps1.setString(1, userid);
	    	   ps1.executeQuery();
	    	   return "brct";      
	    	   
	    	   
	         
	      } catch (Exception e) {
	    	  System.out.println(e);
	         ret = "error";
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      return ret;
		
	}

}
