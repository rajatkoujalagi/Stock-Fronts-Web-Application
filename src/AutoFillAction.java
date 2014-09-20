import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class AutoFillAction {
	
private String comp;
	String id;
	String name;
	String year;
	String type;
	String link;
	
	public String getId() {
		return id;
	}

	

	

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	String stocks;

	public String execute() throws SQLException 
	{
		
		Connection conn = ConnectToDb.makeConnection();
		Statement stmt = conn.createStatement ();
		
		String query = "select * from company where compId like '"+comp+"'";
		ResultSet rs = stmt.executeQuery(query);
		
		rs.next();
		id = rs.getString(1);
		name = rs.getString(2);
		year = rs.getString(3);
		type = rs.getString(4);
		link = rs.getString(5);
		stocks = rs.getString(6);
		comp=id;
		System.out.println("name check is :**************** "+name);
	
		conn.close();
		return "modify";
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}



	

}
