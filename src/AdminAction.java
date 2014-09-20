import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class AdminAction {
	List<Users> result = new ArrayList<Users>() ;
	List<Company> resultCompany = new ArrayList<Company>() ;


	public List<Company> getResultCompany() {
		return resultCompany;
	}

	public void setResultCompany(List<Company> resultCompany) {
		this.resultCompany = resultCompany;
	}

	public String execute() throws SQLException {
		
		if (add) {
			message= "add";
		}else if (modify){
			message="modify";
		}else if(delete){
			message="delete";
		}
		if(user){
			message=message+"User";
		}else if (company){
			message=message+"Company";
		}
		System.out.println("in adminaction");
		System.out.println("Message is : "+getMessage());
	
		if(message.contentEquals("deleteUser")){
			Connection conn = ConnectToDb.makeConnection();
			Statement stmt = conn.createStatement ();
			String query = "select userId,firstname,lastname from users";
			 ResultSet rs = stmt.executeQuery(query);
			 while(rs.next()){
				 Users u = new Users();
				 u.userId = rs.getString(1);
				 u.name = rs.getString(2)+" "+rs.getString(3);
				 result.add(u);
				
			 }
			 conn.close();
			}
		 if(message.contentEquals("deleteCompany")){
			 Connection conn = ConnectToDb.makeConnection();
			 Statement stmt = conn.createStatement ();
			 String query = "select compID,compname,ctype from company";
			 ResultSet rs = stmt.executeQuery(query);
			 while(rs.next()){
				 Company c = new Company();
				 c.compId = rs.getString(1);
				 c.compName = rs.getString(2);
				 c.ctype	= rs.getString(3);
				 resultCompany.add(c);
				 }
			 conn.close();
		 }
		 
		
		return getMessage();
	}

	public List<Users> getResult() {
		return result;
	}

	public void setResult(List<Users> result) {
		this.result = result;
	}

	private boolean add = false;
	private boolean modify = false;
	private boolean delete = false;
	private boolean user = false;
	private boolean company = false;

	public void setAdd(boolean value) {
		System.out.println("add called");
		this.add = true;

	}

	public void setModify(boolean value) {
		System.out.println("modify called");
		this.modify = true;

	}
	
	public void setDelete(boolean value) {
		System.out.println("delete called");
		this.delete = true;

	}

	
	public void setCompany(boolean value) {
		System.out.println("Company called");
		this.company = true;

	}
	public void setUser(boolean value) {
		System.out.println("user called");
		this.user = true;

	}

	 private String message;
	    public String getMessage() {
	        return message;
	    }
	    
	    public class Users{
	    	String userId;
	    	String name;
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
	    	
	    }
	    public class Company{
	    	String compId;
	    	String compName;
	    	String ctype;
	    	public String getCompId() {
				return compId;
			}
			public void setCompId(String compId) {
				this.compId = compId;
			}
			public String getCompName() {
				return compName;
			}
			public void setCompName(String compName) {
				this.compName = compName;
			}
			public String getCtype() {
				return ctype;
			}
			public void setCtype(String ctype) {
				this.ctype = ctype;
			}
			
	    }

}
