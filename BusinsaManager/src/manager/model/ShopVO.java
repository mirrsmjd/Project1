package manager.model;
// 이덕만
public class ShopVO {

	// 필드
	private String shopCode;
	private String shopName;
	private String shopPasw;
	private String shopPhone;
	private String shopAddr;
	private String shopTime;
	private String shopCeo;
	private String regiDate;
	private String outDate;

	// 생성자
	public ShopVO() { }
	public ShopVO(String shopCode, String shopName, String shopPasw, 
			String shopPhone, String shopAddr, String shopTime,
			String shopCeo, String regiDate) {
		this.shopCode  = shopCode;
		this.shopName  = shopName;
		this.shopPasw  = shopPasw;
		this.shopPhone = shopPhone;
		this.shopAddr  = shopAddr;
		this.shopTime  = shopTime;
		this.shopCeo   = shopCeo;
		this.regiDate  = regiDate;
	}
	public ShopVO(String shopCode, String shopName, String shopPhone,
			String shopAddr, String shopCeo, String regiDate, String outDate) {
		this.shopCode  = shopCode;
		this.shopName  = shopName;
		this.shopPhone = shopPhone;
		this.shopAddr  = shopAddr;
		this.shopCeo   = shopCeo;
		this.regiDate  = regiDate;
		this.outDate   = outDate;
	}
	public ShopVO(String shopCode, String shopName, String shopPhone,
			String shopAddr, String shopTime, String shopCeo) {
		this.shopCode  = shopCode;
		this.shopName  = shopName;
		this.shopPhone = shopPhone;
		this.shopAddr  = shopAddr;
		this.shopTime  = shopTime;
		this.shopCeo   = shopCeo;
	}
	
	// Getter / Setter
	public String getShopCode() { return shopCode; }
	public void setShopCode(String shopCode) { this.shopCode = shopCode; }
	public String getShopName() { return shopName; }
	public void setShopName(String shopName) { this.shopName = shopName; }
	public String getShopPasw() { return shopPasw; }
	public void setShopPasw(String shopPasw) { this.shopPasw = shopPasw; }
	public String getShopPhone() { return shopPhone; }
	public void setShopPhone(String shopPhone) { this.shopPhone = shopPhone; }
	public String getShopAddr() { return shopAddr; }
	public void setShopAddr(String shopAddr) { this.shopAddr = shopAddr; }
	public String getShopTime() { return shopTime; }
	public void setShopTime(String shopTime) { this.shopTime = shopTime; }
	public String getShopCeo() { return shopCeo; }
	public void setShopCeo(String shopCeo) { this.shopCeo = shopCeo; }
	public String getRegiDate() { return regiDate; }
	public void setRegiDate(String regiDate) { this.regiDate = regiDate; }
	public String getOutDate() { return outDate; }
	public void setOutDate(String outDate) { this.outDate = outDate; }
	
	// toString
	@Override
	public String toString() {
		return "ShopVO [shopCode=" + shopCode + ", shopName=" + shopName + ", shopPasw=" + shopPasw + ", shopPhone="
				+ shopPhone + ", shopAddr=" + shopAddr + ", shopTime=" + shopTime + ", shopCeo=" + shopCeo
				+ ", regiDate=" + regiDate + ", outDate=" + outDate + "]";
	}
}
