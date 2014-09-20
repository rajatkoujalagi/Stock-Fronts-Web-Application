import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;







public class DeleteUserPopulateAction {
	private String deleteButton;
	List<Users> result = new ArrayList<Users>() ;
	public List<Users> getResult() {
		return result;
	}

	public void setResult(List<Users> result) {
		this.result = result;
	}
	public String getDeleteButton() {
		return deleteButton;
	}
	public void setDeleteButton(String deleteButton) {
		this.deleteButton = deleteButton;
	}
	public String execute() throws SQLException{
		System.out.println("in here");
		System.out.println("-----------checkBoxID ------>" + deleteButton) ;
		Connection conn = ConnectToDb.makeConnection();
		Statement stmt = conn.createStatement();
		String query = "delete from users where userid like "+"'"+deleteButton+"'";
		stmt.executeQuery(query);
		String queryUser = "select userId,firstname,lastname from users";
		ResultSet rs = stmt.executeQuery(queryUser);
		 while(rs.next()){
			 Users u = new Users();
			 u.userId = rs.getString(1);
			 u.name = rs.getString(2)+" "+rs.getString(3);
			 result.add(u);
			}
		conn.close();
		return "success";
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
}


  