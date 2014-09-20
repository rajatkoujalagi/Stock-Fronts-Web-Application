package net.rk.struts2.action;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BrokerMyClients {
	
	private String userid;
	private String name;
	private String phone;
	private int accno;
	private String cid;
	private List myclientslist;
	
	public List getMyclientslist() {
		return myclientslist;
	}

	public void setMyclients(List myclientslist) {
		this.myclientslist = myclientslist;
	}

	public BrokerMyClients(){}
	
	public BrokerMyClients(String cid,String name,String phone,int accno){
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.accno = accno;
	}
	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public int getAccno() {
		return accno;
	}



	public void setAccno(int accno) {
		this.accno = accno;
	}



	public String getCid() {
		return cid;
	}



	public void setCid(String cid) {
		this.cid = cid;
	}	
	
	
	public String execute(){
		Connection conn = null;
		String ret = "error";
		try {
	    	  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	    	   conn =
	    		      DriverManager.getConnection ("jdbc:oracle:thin:rk7/rk7@oracle1.cise.ufl.edu:1521:orcl",
	    		                                   "rk7", "oracle123");
	    	  
	    	   myclientslist = new ArrayList();
	    	   PreparedStatement ps1 = conn.prepareStatement("select userid from currentuser");
	    	   ResultSet rs1 = ps1.executeQuery();
	    	   if(rs1.next())
	    		   userid = rs1.getString(1);
	    	   
	    	   
	    	   System.out.println(userid);
	    	   
	    	   PreparedStatement ps2 = conn.prepareStatement("select clientid from deals where brokerid = ?");
	    	   ps2.setString(1, userid);
	    	   
	    	   ResultSet rs2 = ps2.executeQuery();
	    	   
	    	  while(rs2.next()){
	    		   cid= rs2.getString(1);
	    		   //System.out.println(rs2.getString(1));
	    		  // System.out.println(cid);
	    		   PreparedStatement ps3 = conn.prepareStatement("select firstname,lastname,telephonenumber,accountnumber from users where userid = ?");
	    		   ps3.setString(1, cid);
	    		   
	    		   ResultSet rs3 = ps3.executeQuery();
	    		   while(rs3.next()){
	    			   name = rs3.getString(1)+ " "+ rs3.getString(2);
	    			   phone  = rs3.getString(3);
	    			   accno = rs3.getInt(4);
	    			   System.out.println(name+" "+phone);
	    			   myclientslist.add(new BrokerMyClients(cid,name,phone,accno));
	    		   }
	    		   
	    		   //System.out.println(myclientslist);
	    		      
	    	   }return "mycl";
	    	   
	         
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
