package net.rk.struts2.action;

import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;
public class ClientLog {
	public String userid;
	private String fname;
	private String name;
	private String date;
	private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	private String lname;
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String execute(){
		Connection conn = null;
		String ret = "error";
		try {
	    	  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	    	   conn =
	    		      DriverManager.getConnection ("jdbc:oracle:thin:rk7/rk7@oracle1.cise.ufl.edu:1521:orcl",
	    		                                   "rk7", "oracle123");
	    	  
	         /*String URL = "jdbc:mysql://localhost/test";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "root");*/
	         String sql = "SELECT userid,firstname,lastname FROM users WHERE";
	         sql+=" userid = ?";// AND password = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         //Statement stmt = conn.createStatement();
	         //stmt.executeQuery("insert into login(username) values('oracle')");
	         //PreparedStatement ps = conn.prepareStatement("select * from login");
	         ps.setString(1, userid);
	         //ps.setString(2, password);
	         
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	            userid = rs.getString(1);
	            /*fname = rs.getString(2);
	            lname = rs.getString(3);*/
	            name = rs.getString(2)+" "+rs.getString(3);
	           // SearchStocksAction ssa = new SearchStocksAction(userid);
	            //ssa.setSsa(userid);
	            System.out.println(userid);
	            Statement st = conn.createStatement();
	            date="201403";
	            String temp = String.valueOf((1 + (int)(Math.random()*(31))));
	            if(temp.length()==1)
	            	date = date+"0"+temp;
	            else
	            	date = date + temp;
	            st.executeQuery("delete from currentUser");
	            PreparedStatement ps2 = conn.prepareStatement("insert into currentUser values(?,?)");
	            ps2.setString(1, userid);
	            ps2.setString(2, date);
	            ps2.executeQuery();
	            
	            
	            PreparedStatement ps3 = conn.prepareStatement("select quantity*price from trades where userid = ? and sellorbuy='Buy'");
	            ps3.setString(1, userid);
	            ResultSet rs3 = ps3.executeQuery();
	            double in = 0;
	            if(rs3.next())
	            	in = rs3.getDouble(1);
	            
	            PreparedStatement ps4 = conn.prepareStatement("select quantity*price from trades where userid = ? and sellorbuy='Sell'");
	            ps4.setString(1, userid);
	            ResultSet rs4 = ps4.executeQuery();
	            double out = 0;
	            if(rs4.next())
	            	out = rs4.getDouble(1);
	            
	            if((out-in)>0){
	            	status = "In Profit";
	            }
	            else if((out-in)<0){
	            	status = "In Loss";
	            }
	            else{
	            	status = "No stocks bought";
	            }
	            if(userid.substring(0,2).equals("br"))
	            	ret = "br";
	            else
	            	ret = "success";
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

}
