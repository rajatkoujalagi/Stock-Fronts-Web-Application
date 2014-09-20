package net.rk.struts2.action;

//import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

public class ClientMakeTransaction extends ActionSupport {

   private String user;
   private String password;
   private String name;
   private String userid;
   private String comp;
   //private ArrayList<ClientMakeTransaction> al;
   private String stockId;	
	private String compId;
	private String ctype;
private List stocks;
	
	public List getStocks() {
		return stocks;
	}
	public void setStocks(List stocks) {
		this.stocks = stocks;
	}
	public ClientMakeTransaction(String stockId,String compId,String ctype){
    	this.stockId=stockId;
    	this.compId=compId;
    	this.ctype=ctype;
    	
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

	/*public double getPrice() {
		return price;
	}*/
	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
   public String getComp(){
	   return comp;
   }
   public void setComp(String comp){
	   this.comp=comp;
   }
/*   public void setAl(ArrayList<ClientMakeTransaction> al){
	   this.al=al;
   }
   public ArrayList<ClientMakeTransaction> getAl(){
	   return al;
   }*/
   
   public ClientMakeTransaction(){}
   public ClientMakeTransaction(String name){
	   this.name=name;
   }
	public String getUser() {
	      return user;
	   }

	   public void setUser(String user) {
	      this.user = user;
	   }
   public String execute() {
	   //ArrayList<String> al = new ArrayList<String>();
	   stocks=new ArrayList();
      String ret = "error";
      Connection conn = null;

      try {
    	  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    	   conn =
    		      DriverManager.getConnection ("jdbc:oracle:thin:rk7/rk7@oracle1.cise.ufl.edu:1521:orcl",
    		                                   "rk7", "oracle123");
    	  
         /*String URL = "jdbc:mysql://localhost/test";
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(URL, "root", "root");*/
         String sql = "SELECT stocks.stockid,company.compname,stocks.ctype from stocks,company where company.compid=stocks.compid and rownum<=10";
    	 //  String sql = "INSERT into login(username,password) values(?,?)";
         
         PreparedStatement ps = conn.prepareStatement(sql);
        
         
        
         ResultSet rs = ps.executeQuery();
         user="Hey";
         ClientLog cl = new ClientLog();
         userid=cl.userid;
         //ClientMakeTransaction co = new ClientMakeTransaction();
         while (rs.next()) {
        	 //user=rs.getString(1);
        	 stocks.add(new ClientMakeTransaction(rs.getString(1),rs.getString(2),rs.getString(3)));
        	// System.out.println(stocks);
        	 //co.setUser(user);
        	// al.add(new ClientMakeTransaction(user));
          //  System.out.println(al);
         }
      } catch (Exception e) {
         ret = "error";
      } finally {
         if (conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
            }
         }
      }
      return "test";
   }
   
}

