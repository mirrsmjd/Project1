package manager.model;
// 이덕만
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ProdDao {

	private Connection conn = null;

	// 생성자 - DB 연결
	public ProdDao() {
		conn = DBConn.getInstance();
	}

	public void close() {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 등록된 상품목록 DB에서 가져오기
	public Vector<Vector> getProdpList() {
		Vector<Vector> prodList = new Vector<Vector>();
		String sql = "";
		sql += "SELECT   PRODCODE, PRODNAME, PRODPRICE, PRODSIZE, ";     
		sql += "         PRODINVEN, PRODREGIDATE, SHOPCODE        ";
		sql += "FROM     PROD                                     ";
		sql += "ORDER BY SHOPCODE ASC                            ";

		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		int cnt = 1;
		try {
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				String num      = "" +  cnt;
				String prodcode     = rs.getString("PRODCODE");
				String prodname     = rs.getString("PRODNAME");
				int    prodprice    = rs.getInt("PRODPRICE");
				String prodsize     = rs.getString("PRODSIZE");
				String prodinven    = rs.getString("PRODINVEN"); 
				String prodregidate = rs.getString("PRODREGIDATE");      
				String shopcode     = rs.getString("SHOPCODE");   

				Vector v = new Vector();  
				v.add(num);
				v.add(prodcode);
				v.add(prodname);
				v.add(prodprice);
				v.add(prodsize);
				v.add(prodinven);
				v.add(prodregidate);
				v.add(shopcode);

				prodList.add(v); 
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
		return prodList;
	}
	// 상품코드 체크
	public boolean checkProdCode(String inProdCode) {
		String   sql   = "";
		sql += "SELECT COUNT(*) CNT ";     
		sql += "FROM   PROD         ";
		sql += "WHERE  PRODCODE = ? ";
		PreparedStatement pstmt  = null;
		ResultSet         rs     = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inProdCode);
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
	// 단종제품코드 체크
	public boolean checkOProdCode(String inOProdCode) {
		String   sql   = "";
		sql += "SELECT COUNT(*) CNT ";     
		sql += "FROM   OUTPROD         ";
		sql += "WHERE  OPRODCODE = ? ";
		PreparedStatement pstmt  = null;
		ResultSet         rs     = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inOProdCode);
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
	// 상품 정보 DB에서 가져오기
	public ProdVO getProd(String prcode) {
		ProdVO prodVO = null;
		String   sql  = "";
		sql += "SELECT PRODCODE, PRODNAME, PRODPRICE, PRODSIZE, ";     
		sql += "       PRODINVEN, PRODREGIDATE, SHOPCODE        ";
		sql += "FROM   PROD                                     ";
		sql += "WHERE  PRODCODE = ?                             ";
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prcode);
			rs    = pstmt.executeQuery();
			if(rs.next()) {
				String prodCode     = rs.getString("PRODCODE");
				String prodName     = rs.getString("PRODNAME");
				int    prodprice    = rs.getInt("PRODPRICE");
				String prodsize     = rs.getString("PRODSIZE");
				int    prodinven    = rs.getInt("PRODINVEN");
				String prodregidate = rs.getString("PRODREGIDATE");
				String shopcode     = rs.getString("SHOPCODE");

				prodVO = new ProdVO(prodCode, prodName, prodprice, prodsize,
						prodinven, prodregidate, shopcode);
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
		return prodVO;
	}
	// 단종 제품 정보 DB에서 가져오기
	public ProdVO getOutProd(String prcode) {
		ProdVO prodVo = null;
		String   sql  = "";
		sql += "SELECT OPRODCODE, OPRODNAME, OPRODPRICE,            ";     
		sql += "       OPRODSIZE, ISHOPCODE, OSHOPCODE, PRODOUTDATE ";
		sql += "FROM   OUTPROD                                      ";
		sql += "WHERE  OPRODCODE = ?                                ";
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prcode);
			rs    = pstmt.executeQuery();
			if(rs.next()) {
				String oprodcode   = rs.getString("OPRODCODE");
				String oprodname   = rs.getString("OPRODNAME");
				int    oprodprice  = rs.getInt("OPRODPRICE");
				String oprodsize   = rs.getString("OPRODSIZE");
				String shopcode    = "";
				if(rs.getString("ISHOPCODE") != null) {
					shopcode = rs.getString("ISHOPCODE");
				} else {
					shopcode = rs.getString("OSHOPCODE");
				}
				String prodoutdate = rs.getString("PRODOUTDATE");

				prodVo = new ProdVO(oprodcode, oprodname, oprodprice,
						oprodsize, shopcode, prodoutdate);
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
		return prodVo;
	}
	//가입된 상호 상품목록(단종포함) DB에서 가져오기
	public Vector<Vector> getProdList(String shopCode) {
		Vector<Vector> prodList = new Vector<Vector>();
		String sql = "";
		sql += "SELECT  DISTINCT P.PRODCODE, P.PRODNAME, P.PRODPRICE, P.PRODSIZE,  ";
		sql += "	    P.PRODINVEN, P.PRODREGIDATE, P.SHOPCODE,                   ";
		sql += "        OP.OPRODCODE, OP.OPRODNAME, OP.OPRODPRICE, OP.OPRODSIZE,   ";
		sql += "        OP.ISHOPCODE, OP.OSHOPCODE, OP.PRODOUTDATE                 ";
		sql += "FROM    PROD P FULL JOIN ORDERLIST O ON P.PRODCODE = O.PRODCODE    ";
		sql += "               FULL JOIN OUTPROD OP  ON O.OPRODCODE = OP.OPRODCODE ";
		sql += "WHERE   P.SHOPCODE = ? OR OP.ISHOPCODE = ? OR OP.OSHOPCODE = ?     ";

		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		int cnt = 1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shopCode);
			pstmt.setString(2, shopCode);
			pstmt.setString(3, shopCode);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				String num      = "" +  cnt;
				String prodcode = ""; 
				if(rs.getString("PRODCODE") != null) {
					prodcode = rs.getString("PRODCODE");
				} else {
					prodcode = rs.getString("OPRODCODE");
				}
				String prodname = "";
				if(rs.getString("PRODNAME") != null) {
					prodname = rs.getString("PRODNAME");
				} else {
					prodname = rs.getString("OPRODNAME");
				}
				int prodprice = 0;
				if(rs.getInt("PRODPRICE") !=0) {
					prodprice = rs.getInt("PRODPRICE");
				} else {
					prodprice = rs.getInt("OPRODPRICE");
				}
				String prodsize = "";
				if(rs.getString("PRODSIZE") != null) {
					prodsize = rs.getString("PRODSIZE");
				} else {
					prodsize = rs.getString("OPRODSIZE");
				}
				int prodinven    = rs.getInt("PRODINVEN"); 
				String prodregidate = rs.getString("PRODREGIDATE");
				String prodoutdate  = rs.getString("PRODOUTDATE");
				String shopcode     = "";
				if(rs.getString("SHOPCODE") != null) {
					shopcode = rs.getString("SHOPCODE"); 
				} else if(rs.getString("ISHOPCODE") != null) {
					shopcode = rs.getString("ISHOPCODE");
				} else {
					shopcode = rs.getString("OSHOPCODE"); 
				}
				Vector v = new Vector();  
				v.add(num);
				v.add(prodcode);
				v.add(prodname);
				v.add(prodprice);
				v.add(prodsize);
				v.add(prodinven);
				v.add(prodregidate);
				v.add(prodoutdate);
				v.add(shopcode);

				prodList.add(v); 
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
		return prodList;
	}
	// 상품 단종 1단계
	public int delete1(String inProdCode) {
		String   sql   = "";
		sql += "INSERT INTO OUTPROD (OPRODCODE, OPRODNAME, OPRODPRICE, OPRODSIZE, ISHOPCODE) ";
		sql += "SELECT               PRODCODE, PRODNAME, PRODPRICE, PRODSIZE, SHOPCODE      ";
		sql	+= "FROM   PROD                                                                 ";
		sql	+= "WHERE  PRODCODE = ?                                                         ";
		PreparedStatement pstmt  = null;
		int               aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inProdCode);
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
	// 상품 단종 2단계
	public void delete2(String inProdCode) {
		String   sql   = "";
		sql += "UPDATE ORDERLIST     "; 
		sql += "SET    OPRODCODE = ? ";
		sql += "WHERE  PRODCODE  = ? ";
		PreparedStatement pstmt  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inProdCode);
			pstmt.setString(2, inProdCode);
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
	// 상품 단종 3단계
	public void delete3(String inProdCode) {
		String   sql   = "";
		sql += "DELETE FROM PROD    ";
		sql += "WHERE  PRODCODE = ? ";
		PreparedStatement pstmt  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inProdCode);
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
	// 폐업 하는 상호에 등록된 제품코드 가져오기
	public Vector<String> getprodList(String inShopCode) {
		Vector<String> prodList = new Vector<>();
		String sql = "";
		sql += "SELECT PRODCODE     ";
		sql += "FROM   PROD         ";
		sql += "WHERE  SHOPCODE = ? ";

		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inShopCode);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				String prodcode = rs.getString("PRODCODE");
				prodList.add(prodcode);				
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
		return prodList;
	}
}
