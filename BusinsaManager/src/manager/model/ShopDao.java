package manager.model;
// 이덕만
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ShopDao {

	private Connection conn = null;

	// 생성자 - DB 연결
	public ShopDao() {
		conn = DBConn.getInstance();
	}

	public void close() {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 상호목록 DB에서 가져오기
	public Vector<Vector> getShopList() {
		Vector<Vector> shopList = new Vector<Vector>();
		String sql = "";
		sql += "SELECT   SHOPCODE, SHOPNAME, SHOPPASW, SHOPPHONE, ";     
		sql += "         SHOPADDR, SHOPTIME, SHOPCEO, REGIDATE ";
		sql += "FROM     SHOP                                    ";
		sql += "ORDER BY SHOPCODE DESC                           ";

		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		int cnt = 1;
		try {
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				String num      = "" +  cnt;
				String shopcode  = rs.getString("SHOPCODE");
				String shopname  = rs.getString("SHOPNAME");
				String shoppasw  = rs.getString("SHOPPASW");
				String shopphone = rs.getString("SHOPPHONE");
				String shopaddr  = rs.getString("SHOPADDR"); 
				String shoptime  = rs.getString("SHOPTIME");      
				String shopceo   = rs.getString("SHOPCEO");   
				String regidate  = rs.getString("REGIDATE");   

				Vector v = new Vector();  
				v.add(num);
				v.add(shopcode);
				v.add(shopname);
				v.add(shoppasw);
				v.add(shopphone);
				v.add(shopaddr);
				v.add(shoptime);
				v.add(shopceo);
				v.add(regidate);

				shopList.add(v); 
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
		return shopList;
	}
	// 상호코드 체크
	public boolean checkShopCode(String inShopCode) {
		String   sql   = "";
		sql += "SELECT COUNT(*) CNT ";     
		sql += "FROM   SHOP         ";
		sql += "WHERE  SHOPCODE = ? ";
		PreparedStatement pstmt  = null;
		ResultSet         rs     = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inShopCode);
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
	// 폐업 코드 체크
	public boolean checkOShopCode(String inOShopCode) {
		String   sql   = "";
		sql += "SELECT COUNT(*) CNT  ";     
		sql += "FROM   OUTSHOP       ";
		sql += "WHERE  OSHOPCODE = ? ";
		PreparedStatement pstmt  = null;
		ResultSet         rs     = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inOShopCode);
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
	// 상호 정보 DB에서 가져오기
	public ShopVO getShop(String inShop) {
		ShopVO shopVo = null;
		String   sql  = "";
		sql += "SELECT SHOPCODE, SHOPNAME, SHOPPASW, SHOPPHONE, ";     
		sql += "       SHOPADDR, SHOPTIME, SHOPCEO, REGIDATE    ";
		sql += "FROM   SHOP                                     ";
		sql += "WHERE  SHOPCODE = ?                             ";
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inShop);
			rs    = pstmt.executeQuery();
			if(rs.next()) {
				String shopCode  = rs.getString("SHOPCODE");
				String shopName  = rs.getString("SHOPNAME");
				String shopPasw  = rs.getString("SHOPPASW");
				String shopPhone = rs.getString("SHOPPHONE");
				String shopAddr  = rs.getString("SHOPADDR");
				String shopTime  = rs.getString("SHOPTIME");
				String shopCeo   = rs.getString("SHOPCEO");
				String regiDate  = rs.getString("REGIDATE");

				shopVo = new ShopVO(shopCode, shopName, shopPasw, shopPhone,
						shopAddr, shopTime, shopCeo, regiDate);
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
		return shopVo;
	}
	// 폐업 가게 정보 DB에서 가져오기
	public ShopVO getOutShop(String inShop) {
		ShopVO shopVo = null;
		String   sql  = "";
		sql += "SELECT OSHOPCODE, OSHOPNAME, OSHOPPHONE,      ";     
		sql += "       OSHOPADDR, OSHOPCEO, OREGIDATE, OUTDATE ";
		sql += "FROM   OUTSHOP                                ";
		sql += "WHERE  OSHOPCODE = ?                           ";
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inShop);
			rs    = pstmt.executeQuery();
			if(rs.next()) {
				String shopCode  = rs.getString("OSHOPCODE");
				String shopName  = rs.getString("OSHOPNAME");
				String shopPhone = rs.getString("OSHOPPHONE");
				String shopAddr  = rs.getString("OSHOPADDR");
				String shopCeo   = rs.getString("OSHOPCEO");
				String regiDate  = rs.getString("OREGIDATE");
				String outDate   = rs.getString("OUTDATE");

				shopVo = new ShopVO(shopCode, shopName, shopPhone,
						shopAddr, shopCeo, regiDate,  outDate);
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
		return shopVo;
	}
	// 업종별 리스트
	public Vector<Vector> getByShopList(String bycode) {
		Vector<Vector> shopList = new Vector<>();
		String sql = "";
		sql += "SELECT S.SHOPCODE, OS.OSHOPCODE, S.SHOPNAME, OS.OSHOPNAME, S.SHOPPASW,   ";
		sql += "       S.SHOPPHONE, OS.OSHOPPHONE, S.SHOPADDR, OS.OSHOPADDR, S.SHOPTIME, ";
		sql += "       S.SHOPCEO , OS.OSHOPCEO, S.REGIDATE, OS.OREGIDATE, OS.OUTDATE      ";
		sql += "FROM   SHOP S FULL JOIN OUTPROD OP ON S.SHOPCODE = OP.ISHOPCODE           ";
		sql += "              FULL JOIN OUTSHOP OS ON OP.OSHOPCODE = OS.OSHOPCODE        ";
		sql	+= "WHERE  SUBSTR(S.SHOPCODE, 0, 1) = ? OR SUBSTR(OS.OSHOPCODE, 0, 1) = ?    ";

		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		int cnt = 1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bycode);
			pstmt.setString(2, bycode);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				String num       = "" +  cnt;
				String shopcode  = "";
				if(rs.getString("SHOPCODE") != null) {
					shopcode = rs.getString("SHOPCODE");
				} else {
					shopcode = rs.getString("OSHOPCODE");
				}
				String shopname  = "";
				if(rs.getString("SHOPNAME") != null) {
					shopname = rs.getString("SHOPNAME");
				} else {
					shopname = rs.getString("OSHOPNAME");
				}
				String shoppasw  = "";
				if(rs.getString("SHOPPASW") != null) {
					shoppasw = rs.getString("SHOPPASW");
				} else {
					shoppasw = "";
				}
				String shopphone = "";
				if(rs.getString("SHOPPHONE") != null) {
					shopphone = rs.getString("SHOPPHONE");
				} else {
					shopphone = rs.getString("OSHOPPHONE");
				}
				String shopaddr = "";
				if(rs.getString("SHOPADDR") != null) {
					shopaddr = rs.getString("SHOPADDR");
				} else {
					shopaddr = rs.getString("OSHOPADDR");
				}
				String shoptime = "";
				if(rs.getString("SHOPTIME") != null) {
					shoptime = rs.getString("SHOPTIME");
				} else {
					shoptime = "";
				}
				String shopceo  = "";
				if(rs.getString("SHOPCEO") != null) {
					shopceo = rs.getString("SHOPCEO");
				} else {
					shopceo = rs.getString("OSHOPCEO");
				}
				String regidate  = "";   
				if(rs.getString("REGIDATE") != null) {
					regidate = rs.getString("REGIDATE");
				} else {
					regidate = rs.getString("OREGIDATE");
				}
				String outdate = rs.getString("OUTDATE");

				Vector v = new Vector(); 
				v.add(num);
				v.add(shopcode);
				v.add(regidate);
				v.add(outdate);
				v.add(shopname);
				v.add(shoppasw);
				v.add(shopphone);
				v.add(shopaddr);
				v.add(shoptime);
				v.add(shopceo);

				shopList.add(v); 
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
		return shopList;
	}
	// 신규상호 DB에 등록
	public int insertShop(ShopVO shopVO) {
		String shopCode  = shopVO.getShopCode();
		String shopName  = shopVO.getShopName();
		String shopAddr  = shopVO.getShopAddr();
		String shopPhone = shopVO.getShopPhone();
		String shopCeo   = shopVO.getShopCeo();
		String shopTime  = shopVO.getShopTime();

		String sql = "";
		sql += "INSERT INTO SHOP                                ";
		sql += "   (SHOPCODE, SHOPNAME, SHOPADDR, SHOPPHONE,    ";
		sql	+= "    SHOPCEO, SHOPTIME)                          ";
		sql += "VALUES                                          ";
		sql += "   ( ?||'-'|| SEQ_SHOP.NEXTVAL, ?, ?, ?, ?, ? ) ";
		PreparedStatement pstmt  = null;
		int               aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shopCode);
			pstmt.setString(2, shopName);
			pstmt.setString(3, shopAddr);
			pstmt.setString(4, shopPhone);
			pstmt.setString(5, shopCeo);
			pstmt.setString(6, shopTime);

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
	// 폐업 1단계
	public int delete1(String inShopCode) {
		String   sql   = "";
		sql += "INSERT INTO OUTSHOP (OSHOPCODE, OSHOPNAME, OSHOPCEO, OSHOPADDR, ";
		sql += "                     OSHOPPHONE, OREGIDATE)                      ";
		sql += "SELECT               SHOPCODE, SHOPNAME, SHOPCEO, SHOPADDR,     ";
		sql	+= "                     SHOPPHONE, REGIDATE                        ";
		sql	+= "FROM   SHOP                                                     ";
		sql	+= "WHERE  SHOPCODE = ?                                                         ";
		PreparedStatement pstmt  = null;
		int               aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inShopCode);
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
	// 폐업 2단계
	public void delete2(String inShopCode) {
		String   sql   = "";
		sql += "UPDATE OUTPROD       "; 
		sql += "SET    OSHOPCODE = ? ";
		sql += "WHERE  ISHOPCODE  = ? ";
		PreparedStatement pstmt  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inShopCode);
			pstmt.setString(2, inShopCode);
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
	// 페업 3단계
	public void delete3(String inShopCode) {
		String   sql   = "";
		sql += "DELETE FROM SHOP    ";
		sql += "WHERE  SHOPCODE = ? ";
		PreparedStatement pstmt  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inShopCode);
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
