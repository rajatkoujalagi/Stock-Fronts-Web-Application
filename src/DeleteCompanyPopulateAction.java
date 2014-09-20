import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DeleteCompanyPopulateAction {
	private String deleteButton;
	List<Company> resultCompany = new ArrayList<Company>();

	public String getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(String deleteButton) {
		this.deleteButton = deleteButton;
	}

	public List<Company> getResultCompany() {
		return resultCompany;
	}

	public void setResultCompany(List<Company> resultCompany) {
		this.resultCompany = resultCompany;
	}

	public class Company {
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
	
	public String execute() throws SQLException{
		System.out.println("in here");
		System.out.println("-----------checkBoxID ------>" + deleteButton) ;
		 Connection conn = ConnectToDb.makeConnection();
		 Statement stmt = conn.createStatement ();
		 String query = "delete from company where compid like "+"'"+deleteButton+"'";
		stmt.executeQuery(query);
		 String queryComp = "select compID,compname,ctype from company";
		 ResultSet rs = stmt.executeQuery(queryComp);
		 while(rs.next()){
			 Company c = new Company();
			 c.compId = rs.getString(1);
			 c.compName = rs.getString(2);
			 c.ctype	= rs.getString(3);
			 resultCompany.add(c);
			 }
		 conn.close();
		return "success";
	}

}
