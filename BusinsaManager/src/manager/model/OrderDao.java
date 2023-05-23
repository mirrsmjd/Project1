package manager.model;
// 이덕만
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OrderDao {

	private Connection conn = null;

	// 생성자 - DB 연결
	public OrderDao() {
		conn = DBConn.getInstance();
	}

	public void close() {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 구매목록 DB에서 가져오기
	public Vector<Vector> getOrderList() {
		Vector<Vector> orderList = new Vector<Vector>();
		String sql = "";
		sql += "SELECT O.ORDERCODE, M.USERNAME, S.SHOPNAME, S.SHOPADDR,         ";
		sql += "       P.PRODNAME, P.PRODPRICE, P.PRODSIZE, O.ORDERQUAN,        ";
		sql += "       O.ORDERDATE, M.USERCODE, P.PRODCODE                      ";
		sql += "FROM   MEMBER M JOIN ORDERLIST O ON M.USERCODE = O.USERCODE     ";
		sql += "                JOIN PROD P          ON O.PRODCODE = P.PRODCODE ";
		sql += "                JOIN SHOP S          ON P.SHOPCODE = S.SHOPCODE ";
		sql += "ORDER BY O.ORDERDATE DESC                                       ";

		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		int cnt = 1;
		try {
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				String num       = "" +  cnt;
				String ordercode = rs.getString("ORDERCODE");
				String username  = rs.getString("USERNAME");
				String shopname  = rs.getString("SHOPNAME");
				String shopaddr  = rs.getString("SHOPADDR");
				String prodname  = rs.getString("PRODNAME");
				int    prodprice = rs.getInt("PRODPRICE");  
				String prodsize  = rs.getString("PRODSIZE");
				int    orderquan = rs.getInt("ORDERQUAN");   
				String orderdate = rs.getString("ORDERDATE"); 
				String usercode  = rs.getString("USERCODE");   
				String prodcode  = rs.getString("PRODCODE");   

				Vector v = new Vector(); 
				v.add(num);
				v.add(ordercode);
				v.add(username);
				v.add(shopname);
				v.add(shopaddr);
				v.add(prodname);
				v.add(prodprice);
				v.add(prodsize);
				v.add(orderquan);
				v.add(orderdate);
				v.add(usercode);
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
	// 구매코드 체크
	public boolean checkOrderCode(String inOrderCode) {
		String sql = "";
		sql += "SELECT COUNT(*) CNT  ";
		sql += "FROM   ORDERLIST     ";
		sql += "WHERE  ORDERCODE = ? ";
		PreparedStatement pstmt  = null;
		ResultSet         rs     = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inOrderCode);
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
	// 구매 정보 가져오기
	public OrderVO getCode(String inOrdercode) {
		OrderVO orderVo = null;
		String  sql     = "";
		sql += "SELECT ORDERCODE, USERCODE, OUSERCODE, PRODCODE, OPRODCODE, ";
		sql += "       ORDERQUAN, ORDERDATE                                 ";
		sql	+= "FROM   ORDERLIST                                            ";
		sql += "WHERE  ORDERCODE = ?                                        ";
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inOrdercode);
			rs    = pstmt.executeQuery();
			if(rs.next()) {
				String ordercode  = rs.getString("ORDERCODE");
				String usercode   = "";
				if(rs.getString("USERCODE") != null) {
					usercode = rs.getString("USERCODE");
				} else {
					usercode = rs.getString("OUSERCODE");
				}
				String prodcode = "";
				if(rs.getString("PRODCODE") != null) {
					prodcode = rs.getString("PRODCODE");
				} else {
					prodcode = rs.getString("OPRODCODE");
				}
				int    orderquan  = rs.getInt("ORDERQUAN");
				String orderdate  = rs.getString("ORDERDATE");
				
				orderVo = new OrderVO(ordercode, usercode, prodcode, orderquan, orderdate);
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
		return orderVo;
	}
}
