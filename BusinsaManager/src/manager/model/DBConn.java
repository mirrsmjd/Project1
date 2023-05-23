package manager.model;
// 이덕만
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String dburl  = "jdbc:oracle:thin:@192.168.0.200:1521:xe";
	private static String dbuid  = "businsa";
	private static String dbpwd  = "1234";
	
	private static Connection conn = null;
	
	// 생성자 - private : 외부에서 new 할수 없다.
	private DBConn() {	}
		
	public static Connection getInstance() {
		if(conn != null ) {
			return conn;
		}
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, dbuid, dbpwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
