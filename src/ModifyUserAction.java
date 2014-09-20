import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ModifyUserAction {
	String username ; // comes from frontend
	String name ; // comes from frontend
	//backend vars
	String userId;
	String fname;
	String lname;
	String phNo;
	String bday;
	String email;
	String accNo;
	
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute() throws SQLException{
		
		Connection conn = 	ConnectToDb.makeConnection();
		Statement stmt = conn.createStatement();
		//String query = "select * from users where userId like '"+username + "'";
		String query = "select * from users,currentuser  where users.userid=currentuser.userid";
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		userId = rs.getString(1);
		fname = rs.getString(2);
		lname = rs.getString(3);
		phNo = rs.getString(5);
		bday = rs.getString(6);
		email = rs.getString(7);
		accNo = rs.getString(9);
		System.out.println("******************"+ username + "***"+ name);
		conn.close();
		return "Success";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
