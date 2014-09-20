package net.rk.struts2.action;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class SearchStocks {
	String var1;
	
	 public SearchStocks(){}
	public String getVar1() {
		return var1;
	}
	public void setVar1(String var1) {
		this.var1 = var1;
	}
	public String execute() {
		Connection conn=null;
		String ret="stock";
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn =
				      DriverManager.getConnection ("jdbc:oracle:thin:rk7/rk7@oracle1.cise.ufl.edu:1521:orcl",
				                                   "rk7", "oracle123");
			  
	        System.out.println("Connected in Oracle");
	         String sql = "SELECT stockId,compId,ctype FROM stocks where rownum<=10";// WHERE";
	         //sql+=" user = ? AND password = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         //PreparedStatement ps = conn.prepareStatement("select * from login");
	          //ps.setString(1, stockId);
	          //ps.setString(2, compId);
	          //ps.setString(3, ctype);
	       // ps.setString(4, price);
	         var1="hey";
	          ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	// System.out.println("In loop");
	        	 System.out.println(rs.getString(1));
	        	 //stocks.add(new SearchStocksAction(rs.getString(1),rs.getString(2),rs.getString(3)));
	               //stocks.add(12);
	              }return "stock";
	         } 
		 catch (Exception e) { 
			 System.out.println("In catch oracle");
			 ret = "stock";} 
		 finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {}
	            }
	         }
		 System.out.println("After try catch");//+stocks);
	      return ret;
		
		/*if (add) {
			message= "add";
		}else if (modify){
			message="modify";
		}else if(delete){
			message="delete";
		}*/
		/*if(user){
			message=message+"User";
		}else if (company){
			message=message+"Company";
		}*/
		/*System.out.println("in adminaction");
		System.out.println("Message is : "+getMessage());
		return getMessage();*/
	}

	/*private boolean add = false;
	private boolean modify = false;
	private boolean delete = false;
	private boolean user = false;
	private boolean company = false;

	public void setAdd(boolean value) {
		System.out.println("add called");
		this.add = true;

	}

	public void setModify(boolean value) {
		System.out.println("modify called");
		this.modify = true;

	}
	
	public void setDelete(boolean value) {
		System.out.println("delete called");
		this.delete = true;

	}

	
	public void setCompany(boolean value) {
		System.out.println("Company called");
		this.company = true;

	}
	public void setUser(boolean value) {
		System.out.println("user called");
		this.user = true;

	}

	 private String message;
	    public String getMessage() {
	        return message;
	    }*/

}
