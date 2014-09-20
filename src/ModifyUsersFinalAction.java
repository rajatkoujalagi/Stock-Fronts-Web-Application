import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class ModifyUsersFinalAction {

	String userId;
	String fname;
	String lname;
	String phNo;
	String bday;
	String email;
	String accNo;
	//for next Page
	String username;
	String name;
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String execute() throws SQLException{
		Connection conn = ConnectToDb.makeConnection();
		Statement stmt = conn.createStatement();
		String query = "update  users set userid='" + userId + "',firstname='" + fname
				+ "',lastname='" + lname +  "',telephonenumber='" + phNo +"',birthdate='"+ bday+"',emailaddr='" + email +"',accountnumber='" + accNo + "'"
				+ "where userid like '"+userId+"'" ;
		username=userId;
		name = fname+lname;
		System.out.println(query);
		stmt.executeQuery(query);
		conn.close();
		return "Success";
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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


	public String getPhNo() {
		return phNo;
	}


	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}


	public String getBday() {
		return bday;
	}


	public void setBday(String bday) {
		this.bday = bday;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAccNo() {
		return accNo;
	}


	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
}
