package businsa.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;










public class BusinsaDao {

	private Connection conn = null;
	public Object addprodtitle;

	// 생성자
	public BusinsaDao() {
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
	public int insertMember(BusinsaVo vo) {
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
		BusinsaVo vo  = null;
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
// table 에 넣어줄 값
	public Vector<Vector> getMemberList() {
      
		Vector<Vector>  list = new Vector<Vector>();   // 조회된 결과전체 대응 : rs
		
		String  sql = "";
		sql  +=  "SELECT  USERID, USERNAME, ADDR, EMAIL,PHONE,";
		sql  +=  " TO_CHAR(JOINDATE, 'YYYY-MM-DD HH24:MI') INDATE";
		sql  +=  " FROM   MEMBER ";
		sql  +=  " ORDER  BY USERID ASC ";
		
		PreparedStatement  pstmt = null;
		ResultSet          rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs    = pstmt.executeQuery();
			while( rs.next() ) {			
				String  userid    =  rs.getString(1);
				//String  userid    =  rs.getString(1);           // 1: 칼럼번호(1~)
				String  username  =  rs.getString(2);  // 2
				String  addr       =  rs.getString(3);       // 3
				String  email    =  rs.getString(4);    // 4
			    String  phone    =  rs.getString(5);    // 5
				String  indate    =  rs.getString(6);           // 5
			
				Vector  v         = new Vector();  // 안쪽 Vector : 한 줄 Row 를 의미
				v.add( userid );
				v.add( username );
				v.add( phone );
				v.add( addr );
				v.add(email);
				v.add( indate );
				
				list.add( v );  //  전체 목록에 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs    != null )  rs.close();
				if( pstmt != null )  pstmt.close();
			} catch (SQLException e) {
			}
		}
			
		return  list;
		
	
		
	
	}

	



public int insertprod(BusinsaVo vo) {
	String   oprodname  =vo.getOprodname(); 
	String   oorderquan =vo.getOorderquan();   
	String   oprodsize =vo.getOprodsize();  
	String   oprodprice =vo.getOprodprice();

	//INSERT INTO ORDERLIST 
	// ( ORDERCODE, PRODCODE,SHOPCODE,ORDERQUAN,USERCODE) 
	// VALUES 
	//  ('ORDER-6','PROD-10'  ,'B-001',2 ,'M-1045'  );  

String            sql    = "";
sql  += "INSERT INTO ORDERLIST ";
sql  += "  ( ORDERCODE, PRODCODE,SHOPCODE,ORDERQUAN,USERCODE)";
sql  += "  VALUES ";
sql  += "  (        ?,      ?,        ?   ,? ,?   ) ";		
PreparedStatement pstmt  = null;
int               aftcnt = 0;
try {
	pstmt  = conn.prepareStatement(sql);
	pstmt.setString(1, oprodname);
	pstmt.setString(2, oorderquan);
	pstmt.setString(3, oprodsize);
	pstmt.setString(4, oprodprice);

	
	aftcnt = pstmt.executeUpdate();
	
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	try {
		if(pstmt != null) pstmt.close();
	} catch (SQLException e) {
	}
}
return  0;



}
	

public Vector<Vector> getprodList(String userid) {
	Vector<Vector>  list = new Vector<Vector>();   // 조회된 결과전체 대응 : rs
	

	String  sql = ""; 
	sql  += " SELECT  S.SHOPNAME, S.SHOPPHONE, M.ADDR, P.PRODNAME,";
	sql  += " P.PRODPRICE, P.PRODSIZE, O.ORDERQUAN, ";
	sql  += " 	TO_CHAR(O.ORDERDATE, 'YYYY-MM-DD ') INDATE  ";         
	sql  += " FROM   MEMBER M JOIN ORDERLIST O ON M.USERCODE = O.USERCODE";       
	sql  += "  JOIN PROD P          ON O.PRODCODE = P.PRODCODE " ;      
	sql  += "  JOIN SHOP S          ON P.SHOPCODE = S.SHOPCODE";      
	sql  += " Where m.userid = '"+userid+"'";
	sql  +="  ORDER BY O.ORDERDATE DESC";    
	
	
	PreparedStatement  pstmt = null;
	ResultSet          rs    = null;
	try {
		pstmt = conn.prepareStatement(sql);
		
		rs    = pstmt.executeQuery();
		while( rs.next() ) {			
			String  SHOPNAME    =  rs.getString(1);
			//String  userid    =  rs.getString(1);           // 1: 칼럼번호(1~)
			String  SHOPPHONE  =  rs.getString(2);  // 2
			String  ADDR       =  rs.getString(3);       // 3
			String  PRODNAME    =  rs.getString(4);    // 4
		    String  PRODPRICE  =  rs.getString(5);           // 5
		    String  PRODSIZE  =  rs.getString(6);           // 5
		    String  ORDERQUAN  =  rs.getString(7);           // 5
		    String  ORDERDATE  =  rs.getString(8);           // 5
			Vector  v         = new Vector();  // 안쪽 Vector : 한 줄 Row 를 의미
			v.add( SHOPNAME );
			v.add( SHOPPHONE );
			v.add( ADDR );
			v.add( PRODNAME );
			v.add(PRODPRICE);
			v.add(PRODSIZE);
			v.add(ORDERQUAN);
			v.add(ORDERDATE);
		
			
			list.add( v );  //  전체 목록에 추가
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if( rs    != null )  rs.close();
			if( pstmt != null )  pstmt.close();
		} catch (SQLException e) {
		}
	}
		
	return  list;
	
}


public int deleteMember() {
	// TODO Auto-generated method stub
	String  sql = "";
	sql += "DELETE FROM  ORDERLIST";
	sql += " WHERE ORDERCODE ='ORDER-30' ";
	
	
	PreparedStatement  pstmt  = null ;
	
	int                aftcnt = 0;
	try {
		pstmt = conn.prepareStatement(sql);
	
		
		aftcnt = pstmt.executeUpdate();			
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if(pstmt != null)  pstmt.close();
		} catch (SQLException e) {
		}
	}
	return aftcnt;
	
}

public boolean checkMemCode(String userid) {
	   BusinsaVo mVo = null;
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

public String clothslabel() {
	String cloths = null;
	String sql = "";
	sql += "SELECT PRODNAME                                      ";
	sql += " FROM PROD ";
	sql += " WHERE                                  ";
	sql += " PRODCODE='PROD-11'                                  ";
		PreparedStatement  pstmt = null;
		ResultSet          rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			

			rs = pstmt.executeQuery();

			if( rs.next() ) {			
				String prodname1 = rs.getString("prodname");
				
				cloths = 	prodname1;		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs    != null )  rs.close();
				if( pstmt != null )  pstmt.close();
			} catch (SQLException e) {
			}
		}
		
		return cloths;		
	}

	public String pricelabel() {
		String price = null;
		String sql = "";
		sql += "SELECT PRODPRICE                                      ";
		sql += " FROM PROD ";
		sql += " WHERE                                  ";
		sql += " PRODCODE='PROD-11'                                  ";
			PreparedStatement  pstmt = null;
			ResultSet          rs    = null;
			try {
				pstmt = conn.prepareStatement(sql);
				

				rs = pstmt.executeQuery();

				if( rs.next() ) {			
					String prodprice = rs.getString("prodprice");
					
					price = 	prodprice;		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if( rs    != null )  rs.close();
					if( pstmt != null )  pstmt.close();
				} catch (SQLException e) {
				}
			}
			
			return price;		
	}

	

	public boolean checkMemPwd(String textpwd) {
		BusinsaVo mVo = null;
	      String    sql ="";
	      sql += "SELECT COUNT(*) CNT    ";     
	      sql += "FROM   MEMBER        ";
	      sql += " WHERE PASSWD = ? ";
	      PreparedStatement pstmt = null;
	      ResultSet         rs    = null;
	      try {
	         pstmt = conn.prepareStatement(sql);
	        
	         
	         pstmt.setString(1, textpwd);
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

	public String sizeabel() {
		String size = null;
		String sql = "";
		sql += "SELECT PRODSIZE                                      ";
		sql += " FROM PROD ";
		sql += " WHERE                                  ";
		sql += " PRODCODE='PROD-11'                                  ";
			PreparedStatement  pstmt = null;
			ResultSet          rs    = null;
			try {
				pstmt = conn.prepareStatement(sql);
				

				rs = pstmt.executeQuery();

				if( rs.next() ) {			
					String prodsize = rs.getString("prodsize");
					
					size = 	prodsize;		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if( rs    != null )  rs.close();
					if( pstmt != null )  pstmt.close();
				} catch (SQLException e) {
				}
			}
			
			return size;
	}

	public Vector<Vector> addBuycloths(String userid, String cl, String string) {
	      Vector<Vector>  list = new Vector<Vector>(); 
	      String sql="";
	      sql += "INSERT INTO ORDERLIST";
	      sql += "  (  ORDERCODE,USERCODE,PRODCODE,ORDERQUAN)";
	      sql += "  VALUES";
	      sql += "  ('ORDER-'||TO_CHAR(SYSDATE,'MMDD')||SEQ_ORDER.NEXTVAL,";
	      sql += "        (select usercode from member where userid='"+userid+"')";
	      sql += " ,(select prodcode from prod where prodname='"+cl+"')"; 
	      sql += "   ,"+string+")";
	      PreparedStatement  pstmt = null;
	     int  aftcnt =0;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         aftcnt    = pstmt.executeUpdate();
	          //  전체 목록에 추가
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if( pstmt != null )  pstmt.close();
	         } catch (SQLException e) {
	         }
	      }
	         
	      return  list;
	      
	   }
}
