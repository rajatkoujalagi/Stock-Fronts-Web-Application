// You need to import the java.sql package to use JDBC
import java.sql.*; 

public class ConnectToDb {
	
	
	public static Connection makeConnection() throws SQLException{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	  Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:hr/hr@oracle1.cise.ufl.edu:1521:orcl", "rk7", "oracle123");

	   return conn;
	    
	 }
	
/*public static void main(String[] args) throws SQLException {
	Connection conn = ConnectToDb.makeConnection();
	Statement stmt = conn.createStatement ();
	 ResultSet rset = stmt.executeQuery ("select password from users where userid like 'cl_Rects1963'");
	
	 while (rset.next ())
		 
	      System.out.println (rset.getString (1));
	 conn.close();
}*/

}
