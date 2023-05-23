package manager.model;
// 이덕만
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MemberDao {

	private Connection conn = null;

	// 생성자 - DB 연결
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

	// 가입된 회원목록 DB에서 가져오기
	public Vector<Vector> getMemberList() {
		Vector<Vector> memList = new Vector<Vector>();
		String sql = "";
		sql += "SELECT   USERCODE, USERID, PASSWD, USERNAME,  ";     
		sql += "         PHONE, ADDR, EMAIL, JOINDATE         ";
		sql += "FROM     MEMBER                               ";
		sql += "ORDER BY USERCODE DESC                         ";

		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		int cnt = 1;
		try {
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				String num      = "" +  cnt;
				String usercode = rs.getString("USERCODE");
				String userid   = rs.getString("USERID");
				String passwd   = rs.getString("PASSWD");
				String username = rs.getString("USERNAME");
				String phone    = rs.getString("PHONE"); 
				String addr     = rs.getString("ADDR");      
				String email    = rs.getString("EMAIL");   
				String joindate = rs.getString("JOINDATE");   

				Vector v = new Vector();  
				v.add(num);
				v.add(usercode);
				v.add(userid);
				v.add(passwd);
				v.add(username);
				v.add(phone);
				v.add(addr);
				v.add(email);
				v.add(joindate);

				memList.add(v); 
				cnt ++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memList;
	}
	// 회원코드 체크
	public boolean checkUserCode(String inUserCode) {
		String   sql   = "";
		sql += "SELECT COUNT(*) CNT ";     
		sql += "FROM   MEMBER       ";
		sql += "WHERE  USERCODE = ? ";
		PreparedStatement pstmt  = null;
		ResultSet         rs     = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inUserCode);
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
	// 탈퇴회원코드 체크
	public boolean checkOUserCode(String inOUserCode) {
		String   sql   = "";
		sql += "SELECT COUNT(*) CNT  ";     
		sql += "FROM   OUTMEMBER     ";
		sql += "WHERE  OUSERCODE = ? ";
		PreparedStatement pstmt  = null;
		ResultSet         rs     = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inOUserCode);
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
	// 회원정보 DB에서 가져오기
	public MemberVO getMember(String inUser) {
		MemberVO memVo = null;
		String   sql   = "";
		sql += "SELECT USERCODE, USERID, PASSWD, USERNAME, PHONE, ";
		sql += "       ADDR, EMAIL, JOINDATE                      ";
		sql += "FROM   MEMBER                                     ";
		sql += "WHERE  USERCODE = ? OR USERID =? OR EMAIL = ?     ";
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inUser);
			pstmt.setString(2, inUser);
			pstmt.setString(3, inUser);
			rs    = pstmt.executeQuery();
			if(rs.next()) {
				String usercode = rs.getString("USERCODE");
				String ouserid  = rs.getString("USERID");
				String passwd   = rs.getString("PASSWD");
				String username = rs.getString("USERNAME");
				String phone    = rs.getString("PHONE");
				String addr     = rs.getString("ADDR");
				String email    = rs.getString("EMAIL");
				String joindate = rs.getString("JOINDATE");

				memVo = new MemberVO(usercode, ouserid, passwd, username, phone,
						addr, email, joindate);
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
		return memVo;
	}
	// 탈퇴한 회원정보 DB에서 가져오기
	public MemberVO getOutMember(String inOUser) {
		MemberVO memVo = null;
		String   sql   = "";
		sql += "SELECT OUSERCODE, OUSERNAME, OPHONE, OEMAIL, ";
		sql += "       OJOINDATE, SECESDATE                  ";
		sql += "FROM   OUTMEMBER                             ";
		sql += "WHERE  OUSERCODE= ? OR OEMAIL = ?            ";
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inOUser);
			pstmt.setString(2, inOUser);
			rs    = pstmt.executeQuery();
			if(rs.next()) {
				String usercode  = rs.getString("OUSERCODE");
				String username  = rs.getString("OUSERNAME");
				String phone     = rs.getString("OPHONE");
				String email     = rs.getString("OEMAIL");
				String joindate  = rs.getString("OJOINDATE");
				String secesdate = rs.getString("SECESDATE");

				memVo = new MemberVO(usercode, username, phone,
						email, joindate, secesdate);
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
		return memVo;
	}
	// 회원,탈퇴회원 구매목록 DB에서 가져오기
	public Vector<Vector> getmemOrderList(String usercode) {
		Vector<Vector> orderList = new Vector<Vector>();
		String sql = "";
		sql += "SELECT O.ORDERCODE, S.SHOPNAME, OS.OSHOPNAME, S.SHOPADDR, OS.OSHOPADDR,  ";
		sql += "       P.PRODNAME, OP.OPRODNAME, P.PRODPRICE, OP.OPRODPRICE, P.PRODSIZE, ";
		sql += "       OP.OPRODSIZE, O.ORDERQUAN, O.ORDERDATE, S.SHOPCODE, OS.OSHOPCODE, ";
		sql += "       P.PRODCODE, OP.OPRODCODE                                          ";
		sql += "FROM   SHOP S FULL JOIN PROD P ON S.SHOPCODE = P.SHOPCODE                ";
		sql += "              FULL JOIN ORDERlIST O ON P.PRODCODE = O.PRODCODE           ";
		sql += "              FULL JOIN OUTPROD OP  ON O.OPRODCODE = OP.OPRODCODE        ";
		sql += "              FULL JOIN OUTSHOP OS  ON OP.OSHOPCODE = OS.OSHOPCODE       ";
		sql	+= "WHERE  O.USERCODE = ? OR O.OUSERCODE = ?                                 ";
		sql += "ORDER BY ORDERDATE DESC                                                  ";

		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		int cnt = 1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usercode);
			pstmt.setString(2, usercode);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				String num        = "" +  cnt;
				String ordercode  = rs.getString("ORDERCODE");
				String shopname = "";
				if(rs.getString("SHOPNAME") != null) {
					shopname = rs.getString("SHOPNAME");
				} else {
					shopname = rs.getString("OSHOPNAME");
				}
				String shopaddr  = "";
				if(rs.getString("SHOPADDR") != null) {
					shopaddr = rs.getString("SHOPADDR");
				} else {
					shopaddr = rs.getString("OSHOPADDR");
				}
				String prodname = "";
				if(rs.getString("PRODNAME") != null) {
					prodname = rs.getString("PRODNAME");
				} else {
					prodname = rs.getString("OPRODNAME");
				}
				int prodprice  = 0;
				if(rs.getInt("PRODPRICE") != 0) {
					prodprice  = rs.getInt("PRODPRICE");
				} else {
					prodprice  = rs.getInt("OPRODPRICE");
				}
				String prodsize = "";
				if(rs.getString("PRODSIZE") != null) {
					prodsize = rs.getString("PRODSIZE");
				} else {
					prodsize = rs.getString("OPRODSIZE");
				}
				int    orderquan  = rs.getInt("ORDERQUAN");   
				String orderdate  = rs.getString("ORDERDATE"); 
				String shopcode = "";
				if(rs.getString("SHOPCODE") != null) {
					shopcode = rs.getString("SHOPCODE");
				} else {
					shopcode = rs.getString("OSHOPCODE");
				}
				String prodcode   = "";   
				if(rs.getString("PRODCODE") != null) {
					prodcode = rs.getString("PRODCODE");
				} else {
					prodcode = rs.getString("OPRODCODE");
				}

				Vector v = new Vector(); 
				v.add(num);
				v.add(ordercode);
				v.add(shopname);
				v.add(shopaddr);
				v.add(prodname);
				v.add(prodprice);
				v.add(prodsize);
				v.add(orderquan);
				v.add(orderdate);
				v.add(shopcode); 
				v.add(prodcode);

				orderList.add(v); 
				cnt ++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}
	// 회원아이디 체크
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
	// 회원 이메일 체크
	public boolean checkUserEmail(String inUserEmail) {
		String   sql   = "";
		sql += "SELECT COUNT(*) CNT ";     
		sql += "FROM   MEMBER       ";
		sql += "WHERE  EMAIL = ?   ";
		PreparedStatement pstmt  = null;
		ResultSet         rs     = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inUserEmail);
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
	// 탈퇴회원 이메일 체크
	public boolean checkOUserEmail(String inUserEmail) {
		String   sql   = "";
		sql += "SELECT COUNT(*) CNT ";     
		sql += "FROM   OUTMEMBER    ";
		sql += "WHERE  OEMAIL = ?   ";
		PreparedStatement pstmt  = null;
		ResultSet         rs     = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inUserEmail);
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
	// 회원 탈퇴 1단계
	public int delete1(String inUser) {
		String   sql   = "";
		sql += "INSERT INTO OUTMEMBER (OUSERCODE, OUSERNAME, OPHONE, OEMAIL, OJOINDATE) ";
		sql += "SELECT                 USERCODE, USERNAME, PHONE, EMAIL, JOINDATE       ";
		sql	+= "FROM   MEMBER                                                           ";
		sql	+= "WHERE  USERCODE = ?                                                     ";
		PreparedStatement pstmt  = null;
		int               aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inUser);
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
	// 회원 탈퇴 2단계
	public void delete2(String inUser) {
		String   sql   = "";
		sql += "UPDATE ORDERLIST     "; 
		sql += "SET    OUSERCODE = ? ";
		sql += "WHERE  USERCODE  = ? ";
		PreparedStatement pstmt  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inUser);
			pstmt.setString(2, inUser);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 회원 탈퇴 3단계
	public void delete3(String inUser) {
		String   sql   = "";
		sql += "DELETE FROM MEMBER ";
		sql += "WHERE USERCODE = ? ";
		PreparedStatement pstmt  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inUser);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
