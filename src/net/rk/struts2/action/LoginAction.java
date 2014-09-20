package net.rk.struts2.action;

//import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

   private String username;
   private String password;
   private String name;

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
         String sql = "SELECT username FROM users WHERE";
         sql+=" userid = ? AND password = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         //Statement stmt = conn.createStatement();
         //stmt.executeQuery("insert into login(username) values('oracle')");
         //PreparedStatement ps = conn.prepareStatement("select * from login");
         ps.setString(1, username);
         ps.setString(2, password);
         
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
            name = rs.getString(1);
            ret = SUCCESS;
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
      return username;
   }

   public void setUser(String user) {
      this.username = user;
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
}

