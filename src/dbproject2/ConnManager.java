package dbproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {
	
	static private ConnManager  instance;
	Connection con;
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user = "batman";
	String password = "1234";
	
	private ConnManager() {
		try {
			Class.forName(driver);
			
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static public ConnManager getInstance(ConnManager instance){
		if (instance == null){
			instance = new ConnManager();
		}
		return instance;
	}
	
	public Connection getConnection(Connection con){
		return con;
	}
	
	public void disConnection(Connection con){
		if (con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
