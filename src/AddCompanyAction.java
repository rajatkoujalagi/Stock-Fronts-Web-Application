import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddCompanyAction {
	
	String comp;
	String name;
	String est;
	String type;
	String link;
	String stocks;
	
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEst() {
		return est;
	}
	public void setEst(String est) {
		this.est = est;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getStocks() {
		return stocks;
	}
	public void setStocks(String stocks) {
		this.stocks = stocks;
	}

	public String execute() throws SQLException {

		Connection conn = ConnectToDb.makeConnection();
		Statement stmt = conn.createStatement();
	
		String query = "insert into company values('" + comp + "','" + name
				+ "','" + est + "','" + type + "','" + link + "','"
				+ stocks + "','1')";
		System.out.print(query);
		stmt.executeQuery(query);
		conn.close();
		
		return "Admin";
	}	

}
