import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class ModifyCompanyAction {

	String comp;
	String name;
	String est;
	String type;
	String price;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStocks() {
		return stocks;
	}
	public void setStocks(String stocks) {
		this.stocks = stocks;
	}
	
	public String execute() throws SQLException{
		Connection conn = ConnectToDb.makeConnection();
		Statement stmt = conn.createStatement();
		String query = "update  company set compname='" + name + "',ipoyear='" + est
				+ "',ctype='" + type + "',link='" + price + "',nostocks='" + stocks + "'"
				+ "where compid like '"+comp+"' and ctype like '"+ type+"'" ;
		System.out.println(query);
		stmt.executeQuery(query);
		//System.out.println(query);
		conn.close();
		return "success";
	}
}
