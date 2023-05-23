package businsa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdDao {

	private Connection conn = null;

	// 생성자
	public ProdDao() {
		conn = DBConn.getInstance();
	}

	public void close() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Prod 라벨 불러오기

	public ArrayList<ProdVO> getProdList(String pd) {
		ArrayList<ProdVO> prodList = new ArrayList<ProdVO>();
		System.out.println(pd);
		String sql = "";
		sql += "SELECT PRODNAME,PRODPRICE,PRODSIZE,PRODINVEN ";
		sql += "FROM PROD ";
		sql += "WHERE SUBSTR(SHOPCODE, 1,1) = ? ";
		sql += "ORDER BY SHOPCODE ASC ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pd);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String prodname2 = rs.getString("prodname");
				String prodprice2 = rs.getString("prodprice");
				String prodsize2 = rs.getString("prodsize");
				String prodinven2 = rs.getString("prodinven");
				ProdVO vo = new ProdVO(prodname2, prodprice2, prodsize2, prodinven2);
				prodList.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}

		return prodList;

	}

	// PROD 이미지 불러오기 (prod)
	public ArrayList<ProdVO> getProdimageList(String pi) {
		ArrayList<ProdVO> prodimageList = new ArrayList<ProdVO>();
		System.out.println(pi); // 출력으로 이미지 불러오는것을 체크
		String sql = "";
		sql += "SELECT PRODIMAGE ";
		sql += "FROM  PROD  ";
		sql += "WHERE SUBSTR(SHOPCODE, 1,1) = ? ";
		sql += "ORDER BY SHOPCODE ASC ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pi);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String prodimage2 = rs.getString("PRODIMAGE");
				System.out.print(prodimage2);
				ProdVO vo = new ProdVO(prodimage2);
				prodimageList.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}

		return prodimageList;

	}

	

}
