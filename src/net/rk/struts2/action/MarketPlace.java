package net.rk.struts2.action;

//import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.util.SubsetIteratorFilter.Decider;



public class MarketPlace extends ActionSupport {

   private String user;
   private String password;
   private String name;
   private String userid;
   private String compname;
   private String ipoyear;
   private String link;
   private int nostocks;
   //private ArrayList<ClientMakeTransaction> al;
   private String stockId;	
	private String compid;
	private String ctype;
private List stocks;
	public void setIpoyear(String ipoyear){
		this.ipoyear=ipoyear;
	}
	public String getIpoyear(){
		return ipoyear;
	}
	public String getLink(){
		return link;
	}
	public void setLink(String link){
		this.link=link;
	}
	public int getNostocks(){
		return nostocks;
	}
	public void setNostocks(int stocks){
		this.nostocks = stocks;
	}
	public List getStocks() {
		return stocks;
	}
	public void setStocks(List stocks) {
		this.stocks = stocks;
	}
	public MarketPlace(String compname,String compid,String ipoyear,String ctype, String link,int nostocks){
    	this.compname=compname;
    	this.compid=compid;
    	this.ipoyear=ipoyear;
    	this.ctype=ctype;
    	this.link=link;
    	this.nostocks = nostocks;
    }
	public String getCompid() {
		return compid;
	}

	public void setCompid(String compid) {
		this.compid = compid;
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
   public String getCompname(){
	   return compname;
   }
   public void setCompname(String comp){
	   this.compname=comp;
   }
/*   public void setAl(ArrayList<ClientMakeTransaction> al){
	   this.al=al;
   }
   public ArrayList<ClientMakeTransaction> getAl(){
	   return al;
   }*/
   
   public MarketPlace(){}
   public MarketPlace(String name){
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
	   System.out.println("In market place");
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
         String sql = "SELECT compname,compid,ipoyear,ctype,link,nostocks from company";
    	 //  String sql = "INSERT into login(username,password) values(?,?)";
         
         PreparedStatement ps = conn.prepareStatement(sql);
        
         
        
         ResultSet rs = ps.executeQuery();
         user="Hey";
         //ClientMakeTransaction co = new ClientMakeTransaction();
         while (rs.next()) {
        	 //user=rs.getString(1);
        	 stocks.add(new MarketPlace(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
        	// System.out.println(stocks);
        	 //co.setUser(user);
        	// al.add(new ClientMakeTransaction(user));
          //  System.out.println(al);
         }return "test";
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
      return ret;
   }
   
}

