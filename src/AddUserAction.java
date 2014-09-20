import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddUserAction {
	String userId;
	String name;
	String add1;
	String add2;
	String add3;
	String age;
	String phone;
	String userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getAdd3() {
		return add3;
	}

	public void setAdd3(String add3) {
		this.add3 = add3;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String execute() throws SQLException {
		if(userType.equalsIgnoreCase("client")){
			userId= "cl_"+userId;
		}else{
			userId= "br_"+userId;
		}
		Connection conn = ConnectToDb.makeConnection();
		Statement stmt = conn.createStatement();
		String fname = null;
		String lname = null;
		if (!name.contains(" ")) {
			fname = name;
		} else {
			String[] names = name.split(" ");
			fname = names[0];

			lname = names[1];
		}

		String defualtPass = "password";
		String email = null;
		String accNo = null;

		String query = "insert into users values('" + userId + "','" + fname
				+ "','" + lname + "','" + defualtPass + "','" + phone + "','"
				+ age + "','" + email + "','" + accNo + "','" + "1')";

		stmt.executeQuery(query);
		conn.close();
		return "Success";
	}
}
