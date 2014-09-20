package net.rk.struts2.action;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.util.SubsetIteratorFilter.Decider;
import java.sql.*;
import java.sql.*;
public class MyStocks extends ActionSupport {
	private String sid;
	private String compid;
	private String message;
	private String ctype;
	private List stocks;
	private String userid;
	private String name;
	private String sellorbuy;
	private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getSellorbuy() {
		return sellorbuy;
	}
	public void setSellorbuy(String sellorbuy) {
		this.sellorbuy = sellorbuy;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private double bprice;
	private String date;
	public double getBprice() {
		return bprice;
	}
	public void setBprice(double bprice) {
		this.bprice = bprice;
	}
	public double getCprice() {
		return cprice;
	}
	public void setCprice(double cprice) {
		this.cprice = cprice;
	}
	private double cprice;
	public List getStocks() {
		return stocks;
	}
	public void setStocks(List stocks) {
		this.stocks = stocks;
	}
	public MyStocks(){}
	public MyStocks(String sid,int quantity,double bprice,double cprice,String sellorbuy){
		this.sid=sid;
		//this.compid=compid;
		this.quantity=quantity;
		this.bprice = bprice;
		this.cprice = cprice;
		this.sellorbuy = sellorbuy;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
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
		stocks=new ArrayList();
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
	         name="";
	         PreparedStatement ps60 = conn.prepareStatement("select firstname,lastname from users where userid = ?");
	         ps60.setString(1, userid);
	         ResultSet rs60 = ps60.executeQuery();
	         if(rs60.next())
	        	 name = rs60.getString(1)+" "+rs60.getString(2);
	         
	         
	         
	         PreparedStatement ps30 = conn.prepareStatement("select quantity*price from trades where userid = ? and sellorbuy='Buy'");
	            ps30.setString(1, currentUser);
	            ResultSet rs30 = ps30.executeQuery();
	            double in = 0;
	            if(rs30.next())
	            	in = rs30.getDouble(1);
	            
	            PreparedStatement ps40 = conn.prepareStatement("select quantity*price from trades where userid = ? and sellorbuy='Sell'");
	            ps40.setString(1, currentUser);
	            ResultSet rs40 = ps40.executeQuery();
	            double out = 0;
	            if(rs40.next())
	            	out = rs40.getDouble(1);
	            
	            if((out-in)>0){
	            	status = "In Profit";
	            }
	            else if((out-in)<0){
	            	status = "In Loss";
	            }
	            else{
	            	status = "No stocks bought";
	            }
	         
	         
	         
	         //System.out.println("Current User is "+currentUser+" "+sid+" "+quantity);
	         Statement smt = conn.createStatement();
	         smt.executeQuery("delete from mystocks");
	         PreparedStatement ps1 = conn.prepareStatement("select distinct(stockid) from trades where userid= ? ");
	         ps1.setString(1, currentUser);
	         ResultSet rs2 = ps1.executeQuery();
	         
	         while(rs2.next()){
	        	 String tempsid = rs2.getString(1);
	        	 int bought=0,sold=0;
	        	 PreparedStatement ps2 = conn.prepareStatement("select sum(quantity) from trades where sellorbuy='Buy' and stockid = ? ");
	        	 ps2.setString(1, tempsid);
	        	 ResultSet rs3 = ps2.executeQuery();
	        	 if(rs3.next())
	        		 bought=rs3.getInt(1);
	        	 
	        	 PreparedStatement ps3 = conn.prepareStatement("select sum(quantity) from trades where sellorbuy='Sell' and stockid = ? ");
	        	 ps3.setString(1, tempsid);
	        	 
	        	 ResultSet rs4 = ps3.executeQuery();
	        	 if(rs4.next())
	        		 sold=rs4.getInt(1);
	        	 
	        	 System.out.println(bought+ " bought and sold "+sold);
	        	 if(bought>sold){
	        		 PreparedStatement ps4 = conn.prepareStatement("insert into mystocks values(?,?)");
	        		 ps4.setString(1, tempsid);
	        		 ps4.setInt(2, bought-sold);
	        		 ps4.executeQuery();
	        		 //stocks.add(new MyStocks(tempsid,bought-sold));
	        	 }
	         }
	         
	         PreparedStatement ps5 = conn.prepareStatement("select stockid,quantity,price,sellorbuy from trades where userid = ?");
	         ps5.setString(1, currentUser);
	         ResultSet rs5 = ps5.executeQuery();
	         while(rs5.next()){
	        	 sid = rs5.getString(1);
	        	 quantity=rs5.getInt(2);
	        	 bprice=rs5.getDouble(3);
	        	 bprice  = Math.floor(bprice*100)/100;
	        	 sellorbuy=rs5.getString(4);
	        	 PreparedStatement ps6 = conn.prepareStatement("select price from stocks where dateid=? and stockid=?");
	        	 ps6.setString(1, date);
	        	 ps6.setString(2, sid);
	        	 ResultSet rs6 = ps6.executeQuery();
	        	 if(rs6.next()){
	        		 cprice = rs6.getDouble(1);
	        		 cprice = Math.floor(cprice*100)/100;
	        	 }
	        	 
	        	 stocks.add(new MyStocks(sid,quantity,bprice,cprice,sellorbuy));
	        	 
	         }
	         
	         
	         //System.out.println(stocks.toArray());
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
		 
	     
		return "myst";
	}
	
}
