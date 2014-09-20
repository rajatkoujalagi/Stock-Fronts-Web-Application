import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ShowStatistics {
String clientName ;
String clientId;
String clientNoDeals;

String brokerName ;
String brokerId;
String brokerNoDeals;

String popBrokerName;
String popBrokerId;
String popBrokerNoDeals;

String maxProfitClientId;
String maxProfitClientName;
String maxProfitVal;

String maxLossClientId;
String maxLossClientName;
String maxLossVal;

String maxProfitBrokerId;
String maxProfitBrokerName;
String maxProfitBrokerVal;

String maxLossBrokerId;
String maxLossBrokerName;

String compId;
String compName;
String maxTransaction;


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



public String getMaxTransaction() {
	return maxTransaction;
}



public void setMaxTransaction(String maxTransaction) {
	this.maxTransaction = maxTransaction;
}



public String getMaxLossBrokerId() {
	return maxLossBrokerId;
}



public void setMaxLossBrokerId(String maxLossBrokerId) {
	this.maxLossBrokerId = maxLossBrokerId;
}



public String getMaxLossBrokerName() {
	return maxLossBrokerName;
}



public void setMaxLossBrokerName(String maxLossBrokerName) {
	this.maxLossBrokerName = maxLossBrokerName;
}



public String getMaxLossBrokerVal() {
	return maxLossBrokerVal;
}



public void setMaxLossBrokerVal(String maxLossBrokerVal) {
	this.maxLossBrokerVal = maxLossBrokerVal;
}



String maxLossBrokerVal;

public String getMaxProfitBrokerId() {
	return maxProfitBrokerId;
}



public void setMaxProfitBrokerId(String maxProfitBrokerId) {
	this.maxProfitBrokerId = maxProfitBrokerId;
}



public String getMaxProfitBrokerName() {
	return maxProfitBrokerName;
}



public void setMaxProfitBrokerName(String maxProfitBrokerName) {
	this.maxProfitBrokerName = maxProfitBrokerName;
}



public String getMaxProfitBrokerVal() {
	return maxProfitBrokerVal;
}



public void setMaxProfitBrokerVal(String maxProfitBrokerVal) {
	this.maxProfitBrokerVal = maxProfitBrokerVal;
}



public String getMaxLossClientId() {
	return maxLossClientId;
}



public void setMaxLossClientId(String maxLossClientId) {
	this.maxLossClientId = maxLossClientId;
}



public String getMaxLossClientName() {
	return maxLossClientName;
}



public void setMaxLossClientName(String maxLossClientName) {
	this.maxLossClientName = maxLossClientName;
}



public String getMaxLossVal() {
	return maxLossVal;
}



public void setMaxLossVal(String maxLossVal) {
	this.maxLossVal = maxLossVal;
}



public String getMaxProfitClientId() {
	return maxProfitClientId;
}



public void setMaxProfitClientId(String maxProfitClientId) {
	this.maxProfitClientId = maxProfitClientId;
}



public String getMaxProfitClientName() {
	return maxProfitClientName;
}



public void setMaxProfitClientName(String maxProfitClientName) {
	this.maxProfitClientName = maxProfitClientName;
}



public String getMaxProfitVal() {
	return maxProfitVal;
}



public void setMaxProfitVal(String maxProfitVal) {
	this.maxProfitVal = maxProfitVal;
}



public String getPopBrokerName() {
	return popBrokerName;
}



public void setPopBrokerName(String popBrokerName) {
	this.popBrokerName = popBrokerName;
}



public String getPopBrokerId() {
	return popBrokerId;
}



public void setPopBrokerId(String popBrokerId) {
	this.popBrokerId = popBrokerId;
}



public String getPopBrokerNoDeals() {
	return popBrokerNoDeals;
}



public void setPopBrokerNoDeals(String popBrokerNoDeals) {
	this.popBrokerNoDeals = popBrokerNoDeals;
}







public String getClientNoDeals() {
	return clientNoDeals;
}



public void setClientNoDeals(String clientNoDeals) {
	this.clientNoDeals = clientNoDeals;
}




public String getBrokerId() {
	return brokerId;
}



public void setBrokerId(String brokerId) {
	this.brokerId = brokerId;
}



public String getBrokerName() {
	return brokerName;
}



public void setBrokerName(String brokerName) {
	this.brokerName = brokerName;
}





	
	
	public String getBrokerNoDeals() {
	return brokerNoDeals;
}



public void setBrokerNoDeals(String brokerNoDeals) {
	this.brokerNoDeals = brokerNoDeals;
}



	public String getClientName() {
	return clientName;
}



public void setClientName(String clientName) {
	this.clientName = clientName;
}



public String getClientId() {
	return clientId;
}



public void setClientId(String clientId) {
	this.clientId = clientId;
}



	public String execute() throws SQLException{
		// for client
		Connection conn = ConnectToDb.makeConnection();
		Statement stmt = conn.createStatement ();
		String q1 = "create view temp as select * from (SELECT COUNT(userid) as count, userid as id FROM trades where userid like 'cl_%' GROUP BY userid ORDER BY count DESC) WHERE rownum <= 1";
		String q2 = "SELECT users.userid, users.firstname, users.lastname, temp.count FROM temp, users WHERE users.userid =temp.id";
		String q3 = "drop view temp";
		stmt.executeQuery(q1);
		ResultSet rs1 = stmt.executeQuery(q2);
		rs1.next();
			clientId = rs1.getString(1);
			clientName = rs1.getString(2) +" "+ rs1.getString(3);
			clientNoDeals = rs1.getString(4);
		stmt.executeQuery(q3);
		//client over
		
		String q4 = "create view temp as select * from (SELECT COUNT(userid) as count, userid as id FROM trades where userid like 'br_%' GROUP BY userid ORDER BY count DESC) WHERE rownum <= 1";
		String q5 = "SELECT users.userid, users.firstname, users.lastname, temp.count FROM temp, users WHERE users.userid =temp.id";
		String q6 = "drop view temp";
		stmt.executeQuery(q4);
		ResultSet rs2 = stmt.executeQuery(q5);
		rs2.next();
			brokerId = rs2.getString(1);
			brokerName = rs2.getString(2) +" "+ rs2.getString(3);
			brokerNoDeals = rs2.getString(4);
		stmt.executeQuery(q6);
		// broker part1 over
		String q7 = "create view temp as select * from (SELECT COUNT(clientId) as count, brokerId as id FROM deals GROUP BY brokerId ORDER BY count DESC) WHERE rownum <= 1";
		String q8 = "SELECT users.userid, users.firstname, users.lastname, temp.count FROM temp, users WHERE users.userid =temp.id";
		String q9 = "drop view temp";
		stmt.executeQuery(q7);
		ResultSet rs3 = stmt.executeQuery(q8);
		rs3.next();
			popBrokerId = rs3.getString(1);
			popBrokerName = rs3.getString(2) +" "+ rs3.getString(3);
			popBrokerNoDeals = rs3.getString(4);
		stmt.executeQuery(q9);
		// end popular client
		
		String q10 = "create view temp_buy as select userid, stockid, compid, SUM(price) as buy_price, SUM(quantity) as buy_quantity from trades where sellorbuy like 'Buy' group by userid, stockid, compid";
		String q11 ="create view temp_sell as select userid, stockid, compid, SUM(price) as sell_price, SUM(quantity) as sell_quantity from trades where sellorbuy like 'Sell' group by userid, stockid, compid";
		String q12 = "create view temp_trades as select t1.userid, t1.stockid, t1.compid, t1.buy_price, t1.buy_quantity, t2.sell_price, t2.sell_quantity from temp_buy t1, temp_sell t2 where t1.userid=t2.userid AND  t1.stockid=t2.stockid AND t1.compid=t2.compid";		
		
		stmt.executeQuery(q10);
		stmt.executeQuery(q11);
		stmt.executeQuery(q12);
		
		String q13="create view max_profit_client as select * from (select userid, (sell_price*sell_quantity - buy_price*buy_quantity) as result from temp_trades WHERE userid like 'cl_%' ORDER BY result DESC) WHERE rownum <=1";
		String q14="SELECT users.userid, users.firstname, users.lastname, max_profit_client.result FROM max_profit_client, users WHERE users.userid = max_profit_client.userid";
		String q15 = "drop view max_profit_client";
		stmt.executeQuery(q13);
		ResultSet rs4 = stmt.executeQuery(q14);
		rs4.next();
		 maxProfitClientId = rs4.getString(1);
		 maxProfitClientName = rs4.getString(2)+" "+rs4.getString(3);
		 maxProfitVal = rs4.getString(4);
		 stmt.executeQuery(q15);
		// end max profit client
		 
		 String q16 = "create view max_loss_client as select * from (select userid, (buy_price*buy_quantity - sell_price*sell_quantity) as result from temp_trades WHERE userid like 'cl_%' ORDER BY result DESC) WHERE rownum <=1";
		 String q17= "SELECT users.userid, users.firstname, users.lastname, max_loss_client.result FROM max_loss_client, users WHERE users.userid = max_loss_client.userid";
		stmt.executeQuery(q16);
		ResultSet rs5 = stmt.executeQuery(q17);
		rs5.next();
		maxLossClientId= rs5.getString(1);
		maxLossClientName = rs5.getString(2)+" "+ rs5.getString(3);
		maxLossVal = rs5.getString(4);
		stmt.executeQuery("drop view max_loss_client");
		// end max loss client
		
		 String q18 = "create view max_profit_broker as select * from (select userid, (sell_price*sell_quantity - buy_price*buy_quantity) as result from temp_trades WHERE userid like 'br_%' ORDER BY result DESC) WHERE rownum <=1";
		 String q19= "SELECT users.userid, users.firstname, users.lastname, max_profit_broker.result FROM max_profit_broker, users WHERE users.userid = max_profit_broker.userid";
		stmt.executeQuery(q18);
		ResultSet rs6 = stmt.executeQuery(q19);
		rs6.next();
		maxProfitBrokerId= rs6.getString(1);
		maxProfitBrokerName = rs6.getString(2)+" "+ rs6.getString(3);
		maxProfitBrokerVal = rs6.getString(4);
		stmt.executeQuery("drop view max_profit_broker");
		//end
		
		 String q20 = "create view max_loss_broker as select * from (select userid, (buy_price*buy_quantity - sell_price*sell_quantity) as result from temp_trades WHERE userid like 'br_%' ORDER BY result DESC) WHERE rownum <=1";
		 String q21= "SELECT users.userid, users.firstname, users.lastname, max_loss_broker.result FROM max_loss_broker, users WHERE users.userid = max_loss_broker.userid";
		stmt.executeQuery(q20);
		ResultSet rs7 = stmt.executeQuery(q21);
		rs7.next();
		maxLossBrokerId= rs7.getString(1);
		maxLossBrokerName = rs7.getString(2)+" "+ rs7.getString(3);
		maxLossBrokerVal = rs7.getString(4);
		stmt.executeQuery("drop view max_loss_broker");
		//end max loss broker
		 stmt.executeQuery("drop view temp_buy");
		 stmt.executeQuery("drop view temp_sell");
		 stmt.executeQuery("drop view temp_trades");
		 //System.out.println("************************************************");
// end all
		 String q30 = "create view temp_company as select * from (SELECT COUNT(compid) as count, compid as id FROM trades GROUP BY compid ORDER BY count DESC) WHERE rownum <= 1";
		 String q31="SELECT company.compid,company.compname,temp_company.count FROM temp_company, company WHERE company.compid =temp_company.id";
		stmt.executeQuery(q30);
		ResultSet rs10 = stmt.executeQuery(q31);
		rs10.next();
		compId = rs10.getString(1);
		compName = rs10.getString(2);
		maxTransaction = rs10.getString(3);

		stmt.executeQuery("drop view temp_company");
		conn.close();
		return "Success";
	}
}
