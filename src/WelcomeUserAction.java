// You need to import the java.sql package to use JDBC
import java.sql.*; 
//cl_Clor1975 pefaiv8Sh
// br_Gring1982  our1aeJah
//cl_Pentat     nei9aij6Ox



public class WelcomeUserAction{
	private boolean login = false;
	private boolean register = false;
	private String userid;
	private String password;
	private String name;
	//-------------------
	private String fname;
	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	private String date;
	private String status;
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setLogin(boolean login) {
		//System.out.println("Login called");
		this.login = true;
	}

	

	public void setRegister(boolean register) {
		//System.out.println("Register called");
		this.register = true;
		
	}
 
	public String getUsername() {
		return userid;
	}
 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.userid = username;
	}
 
	// all struts logic here
	public String execute() throws SQLException {
		
		System.out.println(userid);
		System.out.println(password);
		if(register){
			//System.out.println("register pressed"+register);
			return "RegisterPage";
			
		}else{
			//System.out.println("Login pressed"+login);
		Connection conn = ConnectToDb.makeConnection();
		Statement stmt = conn.createStatement ();
		
		
		if(userid.length()==0 ){
			conn.close();
			return "Error";
		}
		if(userid.substring(0, 2).equals("br")){
			String query = "select password,firstname,lastname from users where userId like '"+userid+"'";
			ResultSet rs = stmt.executeQuery(query);
			String pwFromDb = null;
			while(rs.next()){
				System.out.println(pwFromDb);
				pwFromDb = rs.getString(1);
				System.out.println(pwFromDb);
				name= rs.getString(2)+ " "+ rs.getString(3);
			}
			
			
			//new code here
			 String sql = "SELECT userid,firstname,lastname FROM users WHERE";
	         sql+=" userid = ?";// AND password = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         
	         ps.setString(1, userid);
	        
	         
	         ResultSet rs0 = ps.executeQuery();

	         while (rs0.next()) {
	            userid = rs0.getString(1);
	            /*fname = rs.getString(2);
	            lname = rs.getString(3);*/
	          //  name = rs.getString(2)+" "+rs.getString(3);
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
			
			if(pwFromDb.equals(password)){
				conn.close();
				return "Broker";
			}
	      }
		}
		if(userid.substring(0, 2).equals("cl")){
			String query = "select password,firstname,lastname from users where userId like '"+userid+"'";
			ResultSet rs = stmt.executeQuery(query);
			String pwFromDb = null;
			while(rs.next()){
				System.out.println(pwFromDb);
				pwFromDb = rs.getString(1);
				System.out.println(pwFromDb);
				name= rs.getString(2)+ " "+ rs.getString(3);
			}
			
			
			//new code here
			 String sql = "SELECT userid,firstname,lastname FROM users WHERE";
	         sql+=" userid = ?";// AND password = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         
	         ps.setString(1, userid);
	        
	         
	         ResultSet rs0 = ps.executeQuery();

	         while (rs0.next()) {
	            userid = rs0.getString(1);
	            /*fname = rs.getString(2);
	            lname = rs.getString(3);*/
	          //  name = rs.getString(2)+" "+rs.getString(3);
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
			
	            if(pwFromDb.equals(password)){
					return "Client";
				}
			
			//new code ends
			conn.close();
		}
	}       
		/// write code for admin verification
			if (userid.substring(0, 2).equals("ad")) {
				String query = "select password from admin where adminId like '"
						+ userid + "'";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);
				String pwFromDb = null;
				while (rs.next())
					pwFromDb = rs.getString(1);
				if (pwFromDb.equals(password)) {
					conn.close();
					return "Admin";

				}
			}
		conn.close();
		return "Error";
		}
	}


}