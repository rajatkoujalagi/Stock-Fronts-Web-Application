package net.rk.struts2.action;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.util.SubsetIteratorFilter.Decider;
import java.sql.*;
import java.sql.*;

public class SellStocks extends ActionSupport {
	private String compid;
	private String userid;
	private String ctype;
	private String sid;
	private String date;
	private double price;
	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	public int getQuantity() {
		return quantity;
	}
	private int quantity;
	private String currentUser;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private String message;
	public String getCompid() {
		return compid;
	}
	public void setCompid(String compid) {
		this.compid = compid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
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
	        	 date=rs1.getString(2);
	         }
	         userid = currentUser;
	         PreparedStatement ps6 = conn.prepareStatement("select firstname,lastname from users where userid = ?");
	         ps6.setString(1, userid);
	         ResultSet rs6 = ps6.executeQuery();
	         name="";
	         if(rs6.next())
	        	 name = rs6.getString(1)+" "+rs6.getString(2);
	         System.out.println("Current User is "+currentUser+" "+sid+" "+quantity);
	         PreparedStatement ps0 = conn.prepareStatement("select stocks.compid,stocks.ctype,mystocks.quantity from mystocks,stocks where mystocks.stockid=stocks.stockid and mystocks.stockid = ?");
	         ps0.setString(1, sid);
	         String ctype="";
	         int quant=0;
	         ResultSet rs0 = ps0.executeQuery();
	         
	         if(rs0.next()){
	        	 compid=rs0.getString(1);
	        	 ctype=rs0.getString(2);
	        	 quant=rs0.getInt(3);
	        	 System.out.println(compid+" "+ctype+" "+quant);
	         }
	         else{
	        	 message="Invalid stock";
	         }
	         PreparedStatement ps5 = conn.prepareStatement("select price from stocks where stockid=? and dateid=?");
	         ps5.setString(1, sid);
	         ps5.setString(2,date);
	         ResultSet rs5 = ps5.executeQuery();
	         
	         if(rs5.next())
	        	 price = rs5.getDouble(1);      	    	         	 
	         
	         PreparedStatement ps2 = conn.prepareStatement("select nostocks from company where compid= ?  and ctype= ?");
		        ps2.setString(1, compid);
		         ps2.setString(2, ctype);
		         ResultSet rs2 = ps2.executeQuery();
		         
		         int available=0;
		         
		         if(rs2.next()){
		        	 available = rs2.getInt(1);
		        	 System.out.println("available "+available);
		         }
		     if(quant>=quantity){
	        	 PreparedStatement ps1 = conn.prepareStatement("insert into trades values(?,?,?,?,'Sell',?)");
	        	 ps1.setString(1, currentUser);
	        	 ps1.setString(2, sid);
	        	 ps1.setString(3, compid);
	        	 ps1.setInt(4, quantity);
	        	 ps1.setDouble(5, price);
	        	 ps1.executeQuery();
	        	 
	        	 PreparedStatement ps3 = conn.prepareStatement("update company set nostocks = ? where compid = ? and ctype = ?");
	        	 ps3.setInt(1, available+quantity);
	        	 ps3.setString(2, compid);
	        	 ps3.setString(3, ctype);
	        	 ps3.executeQuery();
	        	 
	        	 PreparedStatement ps4 = conn.prepareStatement("update mystocks set quantity = ? where stockid = ? ");
	        	 ps4.setInt(1, quant-quantity);
	        	 ps4.setString(2, sid);
	        	 ps4.executeQuery();
	        	 message="Transaction Done";
		     }
		     else{
		    	 message="Invalid entry";
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
		 
	     
		return "sell";
	}
	
}
