 package net.rk.struts2.action;

//import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeUserAction_Old extends ActionSupport {

   private String user;
   private String password;
   private String name;
   private String userid;

   public String execute() {
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
         String sql = "SELECT firstname,lastname,userid FROM users WHERE";
    	 //  String sql = "INSERT into login(username,password) values(?,?)";
         sql+=" userid = ? AND password = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
        
         ps.setString(1, user);
         ps.setString(2, password);
        
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
            name = rs.getString(1)+" "+rs.getString(2);
            userid = rs.getString(3);
            /*if(userid.substring(0,2).contentEquals("cl"))
            	ret = "Client";
            if(userid.substring(0,2).contentEquals("br"))
            	ret = "Broker";
            if(userid.substring(0,2).contentEquals("ad"))
            	ret = "Admin";*/
            
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
      return ret;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   public void setUserid(String userid) {
	      this.userid = userid;
	}
   public String getUserid() {
	      return userid;
	   }
}

