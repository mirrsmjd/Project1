package manager.model;
// 이덕만
public class ProdVO {
	
	// 필드
	private String prodCode;
	private String prodName;
	private int prodPrice;
	private String prodSize;
	private int    prodInven;
	private String prodRegiDate;
	private String prodOutDate;
	private String shopCode;
	private String oshopCode;
	
	// 생성자
	public ProdVO() { }
	public ProdVO(String prodCode, String prodName, int prodprice,
			String prodsize, int prodinven, String prodregidate,
			String shopcode) {
		this.prodCode     = prodCode;
		this.prodName     = prodName;
		this.prodPrice    = prodprice;
		this.prodSize     = prodsize;
		this.prodInven    = prodinven;
		this.prodRegiDate = prodregidate;
		this.shopCode     = shopcode;
	}
	public ProdVO(String prodCode, String prodName, int prodprice,
			String prodsize, String shopCode, String prodoutdate) {
		this.prodCode     = prodCode;
		this.prodName     = prodName;
		this.prodPrice    = prodprice;
		this.prodSize     = prodsize;
		this.shopCode     = shopCode;
		this.prodOutDate  = prodoutdate;
	}
	
	// Getter / Setter
	public String getProdCode() { return prodCode; }
	public void setProdCode(String prodCode) { this.prodCode = prodCode; }
	public String getProdName() { return prodName; }
	public void setProdName(String prodName) { this.prodName = prodName; }
	public int getProdPrice() { return prodPrice; }
	public void setProdPrice(int prodPrice) { this.prodPrice = prodPrice; }
	public String getProdSize() { return prodSize; }
	public void setProdSize(String prodSize) { this.prodSize = prodSize; }
	public int getProdInven() { return prodInven; }
	public void setProdInven(int prodInven) { this.prodInven = prodInven; }
	public String getProdRegiDate() { return prodRegiDate; }
	public void setProdRegiDate(String prodRegiDate) { this.prodRegiDate = prodRegiDate;}
	public String getProdOutDate() { return prodOutDate; }
	public void setProdOutDate(String prodOutDate) { this.prodOutDate = prodOutDate; }
	public String getShopCode() { return shopCode; }
	public void setShopCode(String shopCode) { this.shopCode = shopCode; }
	public String getOshopCode() { return oshopCode; }
	public void setOshopCode(String oshopCode) { this.oshopCode = oshopCode; }
	
	// toString
	@Override
	public String toString() {
		return "ProdVO [prodCode=" + prodCode + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodSize="
				+ prodSize + ", prodInven=" + prodInven + ", prodRegiDate=" + prodRegiDate + ", prodOutDate="
				+ prodOutDate + ", shopCode=" + shopCode + ", oshopCode=" + oshopCode + "]";
	}
}
