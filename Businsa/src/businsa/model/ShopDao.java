package businsa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public  class ShopDao {

	private Connection conn = null;

	// 생성자
	public ShopDao() {
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
	
	
	// SHOP 라벨 불러오기 (Bose_shop)
	public ArrayList<ShopVO> getShopList(String also) {
		ArrayList<ShopVO> shopList = new ArrayList<ShopVO>();
		
		String sql = "";
		sql += "SELECT SHOPNAME, SHOPADDR ";
		sql += "FROM  SHOP  ";
		sql += "WHERE SUBSTR(SHOPCODE, 1,1) = ?  ";
		sql += "ORDER BY SHOPCODE ASC ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, also);
			rs = pstmt.executeQuery();     

			while (rs.next()) {
				String shopname2 = rs.getString("shopname");
				String shopaddr2 = rs.getString("shopaddr");
				ShopVO vo = new ShopVO(shopname2, shopaddr2);
				shopList.add(vo);
				
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

		return shopList;
	}

	// SHOP 이미지 불러오기 (Bose_shop)
	public ArrayList<ShopVO> getShopimageList(String shopcode) {
		ArrayList<ShopVO> shopimageList = new ArrayList<ShopVO>();
		System.out.println(shopcode); // 출력으로 이미지 불러오는것을 체크
		String sql = "";
		sql += "SELECT SHOPIMAGE ";
		sql += "FROM  SHOP  ";
		sql += "WHERE SUBSTR(SHOPCODE, 1,1) = ? ";
		sql += "ORDER BY SHOPCODE ASC ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shopcode);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String shopimage2 = rs.getString("shopimage");
				ShopVO vo = new ShopVO(shopimage2);
				shopimageList.add(vo);
				
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

		return shopimageList;
	
		
	}
		

}
