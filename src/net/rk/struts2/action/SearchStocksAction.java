package net.rk.struts2.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;

import com.opensymphony.xwork2.ActionSupport;

public class SearchStocksAction extends ActionSupport  {
	
	private String stockId;	
	private String compId;
	private String tcompid;
	public String getTcompid() {
		return tcompid;
	}

	public void setTcompid(String tcompid) {
		this.tcompid = tcompid;
	}
	private String ssa;
	String date;
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSsa() {
		return ssa;
	}

	public void setSsa(String ssa) {
		this.ssa = ssa;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	private String ctype;
	private int timestmp;
    private double price;
    
    public SearchStocksAction(){}
    public SearchStocksAction(String ssa){
    	this.ssa=ssa;
    }
    public SearchStocksAction(String stockId,String compId,String ctype, double price){
    	this.stockId=stockId;
    	this.compId=compId;
    	this.ctype=ctype;
    	this.price=price;
    }
	private List stocks;
	
	public List getStocks() {
		return stocks;
	}

	public void setStocks(List stocks) {
		this.stocks = stocks;
	}

	
	public String execute(){
		System.out.println("In search stocks");
		//ClientLog cl = new ClientLog();
		//ssa=cl.userid;
		
		String ret = ERROR;
		Connection conn = null;
		stocks=new ArrayList();
		
       /* stocks.add(new SearchStocksAction("S1", "C1", "Manufacturing", 5.0));
        stocks.add(new SearchStocksAction("S2", "C2", "Manufacturing", 5.0));
        stocks.add(new SearchStocksAction("S3", "C3", "Manufacturing", 5.0));
		
		return "search";
	}	*/
	
				
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn =DriverManager.getConnection ("jdbc:oracle:thin:rk7/rk7@oracle1.cise.ufl.edu:1521:orcl",
				                                   "rk7", "oracle123");
			  
	        System.out.println("Connected in Oracle");
	        
	        Statement stmt = conn.createStatement();
	         ResultSet rs1 = stmt.executeQuery("select * from currentUser");
	         //date="201403";
	         String temp="";
	         if(rs1.next()){
	        	 date=rs1.getString(2);	        	 
	         }
	         System.out.println("Text compid is "+tcompid);
	         String sql = "SELECT stockId,compname,stocks.ctype,price FROM stocks,company where dateid= ? and stocks.compid=company.compid";// WHERE";
	         //sql+=" user = ? AND password = ?";
	         System.out.println("Date is "+date);
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, date);
	        // System.out.println("Compid is "+compid);
	        // ps.setString(2, compId);
	         //PreparedStatement ps = conn.prepareStatement("select * from login");
	          //ps.setString(1, stockId);
	          //ps.setString(2, compId);
	          //ps.setString(3, ctype);
	       // ps.setString(4, price);
	         
	         
	         
	         System.out.println("SSA is "+ssa);
	          ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	 System.out.println("In loop");
	        	 stocks.add(new SearchStocksAction(rs.getString(1),rs.getString(2),rs.getString(3),(Math.floor(rs.getDouble(4)*100))/100));
	               //stocks.add(12);
	              }return "search";
	         } 
		 catch (Exception e) { 
			 System.out.println("In catch oracle"+e);
			 
			 ret = ERROR;} 
		 finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {}
	            }
	         }
		 System.out.println("After try catch"+stocks);
	      return ret;
	   }
	
	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}


}




