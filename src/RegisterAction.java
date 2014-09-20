import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class RegisterAction {
	String email;
	String passwd;
	String name ;
	String add1;
	String add2 ;
	String add3;
	String phone;
	String age;
	String extension = null;
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
		
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	String account;
	private boolean client=false;
	private boolean broker=false;
	
	public String execute() throws SQLException{
		Connection conn = ConnectToDb.makeConnection();
		Statement stmt = conn.createStatement();
		String accNo=null;
		String fname = null;
		String lname = null;
		String zipcode = "32608";
		if (!name.contains(" ")) {
			fname = name;
		} else {
			String[] names = name.split(" ");
			fname = names[0];

			lname = names[1];
		}
		String userId = extension + fname;
		

		String queryUsers = "insert into users values('" + userId + "','" + fname
				+ "','" + lname + "','" + passwd + "','" + phone + "','"
				+ age + "','" + email + "','" + accNo + "','" + "1')";
		stmt.executeQuery(queryUsers);
		
		String queryAdd = "insert into address values('" + userId + "','" + add1 + "','" + add2
				+ "','" + add3 + "','" + zipcode  + "')";
		
		stmt.executeQuery(queryAdd);
		conn.close();
		if(extension.equals("cl_"))
		return "Client";
		else{
		return "Broker";
		}
	}


	public void setClient(boolean client) {
		System.out.println("client called");
		extension="cl_";
		this.client = true;
	}


	public void setBroker(boolean broker) {
		System.out.println("broker");
		extension = "br_";
		this.broker = true;
	}
}
