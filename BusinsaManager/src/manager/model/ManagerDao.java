package manager.model;
// 이덕만
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDao {

	private Connection conn = null;

	// 생성자 - DB 연결
	public ManagerDao() {
		conn = DBConn.getInstance();
	}

	public void close() {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 매니저코드 체크
	public boolean checkManaCode(String inmanaCode) {
		String sql ="";
		sql += "SELECT *               ";     
		sql += "FROM   MANAGER         ";
		sql += "WHERE  MANAGERCODE = ? ";
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inmanaCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	// 매니저패스워드 체크
	public boolean checkManaPwd(String inmanaCode, String inmanaPwd) {
		String    sql ="";
		sql += "SELECT *                                  ";     
		sql += "FROM   MANAGER                            ";
		sql += "WHERE  MANAGERCODE = ? AND MANAGERPWD = ? ";
		PreparedStatement pstmt  = null;
		ResultSet         rs     = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inmanaCode);
			pstmt.setString(2, inmanaPwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
