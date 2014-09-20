package net.rk.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.util.SubsetIteratorFilter.Decider;
import java.sql.*;

public class BuyStocks extends ActionSupport {
	private String sid;
	private String compid;
	private String message;
	private String date;
	private double price;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCompid() {
		return compid;
	}
	public void setCompid(String compid) {
		this.compid = compid;
	}
	private int quantity;
	private String currentUser;
	public String getSid() {
		return sid;
	}
	public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String execute(){
		Connection conn=null;
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn =DriverManager.getConnection ("jdbc:oracle:thin:rk7/rk7@oracle1.cise.ufl.edu:1521:orcl",
				                                   "rk7", "oracle123");
			  
	        System.out.println("Connected in Oracle");
	         
	         
	         
	         Statement stmt = conn.createStatement();
	         ResultSet rs1 = stmt.executeQuery("select * from currentUser");
	         if(rs1.next()){
	        	 currentUser=rs1.getString(1);
	        	 date = rs1.getString(2);
	         }
	         System.out.println("Current User is "+currentUser+" "+sid+" "+quantity);
	         PreparedStatement ps0 = conn.prepareStatement("select compid,ctype,price from stocks where stockid = ? and dateid = ? ");
	         ps0.setString(1, sid);
	         ps0.setString(2, date);
	         String ctype="";
	         ResultSet rs0 = ps0.executeQuery();
	         if(rs0.next()){
	        	 compid=rs0.getString(1);
	        	 ctype=rs0.getString(2);
	        	 price = rs0.getDouble(3);
	        	 /*price  = Math.floor(price*100)/100;*/
	        	 System.out.println(compid+" "+ctype+" "+price);
	         }
	         PreparedStatement ps2 = conn.prepareStatement("select nostocks from company where compid= ?  and ctype= ?");
	        ps2.setString(1, compid);
	         ps2.setString(2, ctype);
	         ResultSet rs2 = ps2.executeQuery();
	         int available=0;
	         
	         if(rs2.next()){
	        	 available = rs2.getInt(1);
	        	 System.out.println("available "+available);
	         }
	         if(available>=quantity){
	        	 PreparedStatement ps1 = conn.prepareStatement("insert into trades values(?,?,?,?,'Buy',?)");
	        	 ps1.setString(1, currentUser);
	        	 ps1.setString(2, sid);
	        	 ps1.setString(3, compid);
	        	 ps1.setInt(4, quantity);
	        	 ps1.setDouble(5, price);
	        	 ps1.executeQuery();
	        	 
	        	 PreparedStatement ps3 = conn.prepareStatement("update company set nostocks = ? where compid = ? and ctype = ?");
	        	 ps3.setInt(1, available-quantity);
	        	 ps3.setString(2, compid);
	        	 ps3.setString(3, ctype);
	        	 ps3.executeQuery();
	        	 message="Transaction Done";
	         	}
	         else{
	        	 message="Insufficient number of stocks";
	         }
	         } 
		 catch (Exception e) { 
			 System.out.println("In catch oracle"+e);
		 }
			  
		 finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {}
	            }
	         }
		 
	     
		return "buy";
	}
	
}
