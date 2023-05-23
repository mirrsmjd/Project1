package businsa.model;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MemberDao {

	private static String driver = "oracle.jdbc.OracleDriver";
	private static String dburl  = "jdbc:oracle:thin:@192.168.0.200:1521:xe";
	private static String dbuid  = "businsa";
	private static String dbpwd  = "1234";
	
	private static Connection conn = null;

	// 생성자
	public MemberDao() {
		conn = DBConn.getInstance();
	}

	public void close() {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// DB에 회원정보 넣기
	public int insertMember(MemberVO vo) {
		String userid   = vo.getUserid();
		String passwd   = vo.getPasswd();
		String username = vo.getUsername();
		String phone    = vo.getPhone();
		String addr     = vo.getAddr();
		String email    = vo.getEmail();

		String sql = "";
		sql += "INSERT INTO MEMBER                                          ";
		sql += "   (USERCODE, USERID, PASSWD, USERNAME, PHONE, ADDR, EMAIL) ";
		sql += "VALUES                                                      ";
		sql += "   ('M-'|| SEQ_MEM.NEXTVAL,                                 ";
		sql += "	           ?,      ?,       ?,       ?,     ?,    ?  )  ";
		PreparedStatement pstmt  = null;
		int               aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, passwd);
			pstmt.setString(3, username);
			pstmt.setString(4, phone);
			pstmt.setString(5, addr);
			pstmt.setString(6, email);

			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return aftcnt;
	}
	
	// 아이디 중복체크
	public boolean findExistId(String userid) {
		MemberVO vo  = null;
		String   sql = "";
		sql += "SELECT COUNT(*) CNT  ";     
		sql += "FROM   MEMBER        ";
		sql += "WHERE  USERID = ?    ";
		PreparedStatement pstmt  = null;
		ResultSet         rs     = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int cnt = rs.getInt("CNT");
				if(cnt > 0) {
					return true;
				}
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
		public boolean checkMemCode(String userid) {
		      MemberVO mVo = null;
		      String    sql ="";
		      sql += "SELECT COUNT(*) CNT    ";     
		      sql += "FROM   MEMBER        ";
		      sql += "WHERE  USERID = ? ";
		      PreparedStatement pstmt = null;
		      ResultSet         rs    = null;
		      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, userid);
		         rs = pstmt.executeQuery();
		         if(rs.next()) {
		            int cnt = rs.getInt("CNT");
		            if(cnt > 0) {
		               return true;
		            }
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

		   public boolean checkMemPwd(String passwd) {
			  MemberVO mVo = null;
		      String   sql ="";
		      sql += "SELECT COUNT(*) CNT   ";     
		      sql += "FROM   MEMBER       ";
		      sql += "WHERE  PASSWD = ? ";
		      PreparedStatement pstmt  = null;
		      ResultSet         rs     = null;
		      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, passwd);
		         rs = pstmt.executeQuery();
		         if(rs.next()) {
		            int cnt = rs.getInt("CNT");
		            if(cnt > 0) {
		               return true;
		            }
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
			
		   public boolean checkUserId(String userid) {
				String   sql   = "";
				sql += "SELECT COUNT(*) CNT ";     
				sql += "FROM   MEMBER       ";
				sql += "WHERE  USERID = ?   ";
				PreparedStatement pstmt  = null;
				ResultSet         rs     = null;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userid);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						int cnt = rs.getInt("CNT");
						if(cnt > 0) {
							return true;
						} 
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
