package businsa.model;

public class ProdVO {

	
	// PROD Fields
	private String prodcode;
	private String prodname;
	private String prodprice;
	private String prodsize;
	private String prodinven;
	private String prodregidate;
	private String shopcode;
	private String prodimage;
	
	
	public ProdVO(String prodcode, String prodname, String prodprice, String prodsize, String prodinven,
			String prodregidate, String shopcode, String prodimage) {
		super();
		this.prodcode = prodcode;
		this.prodname = prodname;
		this.prodprice = prodprice;
		this.prodsize = prodsize;
		this.prodinven = prodinven;
		this.prodregidate = prodregidate;
		this.shopcode = shopcode;
		this.prodimage = prodimage;
	}

	
	
	
	
	public ProdVO(String prodname2, String prodprice2, String prodsize2, String prodinven2) {
		this.prodname = prodname2;
		this.prodprice = prodprice2;
		this.prodsize = prodsize2;
		this.prodinven = prodinven2;
	}


	public ProdVO(String prodimage2) {
		this.prodimage = prodimage2;
	}


	// getter setter
	public String getProdcode() {
		return prodcode;
	}


	public void setProdcode(String prodcode) {
		this.prodcode = prodcode;
	}


	public String getProdname() {
		return prodname;
	}


	public void setProdname(String prodname) {
		this.prodname = prodname;
	}


	public String getProdprice() {
		return prodprice;
	}


	public void setProdprice(String prodprice) {
		this.prodprice = prodprice;
	}


	public String getProdsize() {
		return prodsize;
	}


	public void setProdsize(String prodsize) {
		this.prodsize = prodsize;
	}


	public String getProdinven() {
		return prodinven;
	}


	public void setProdinven(String prodinven) {
		this.prodinven = prodinven;
	}


	public String getProdregidate() {
		return prodregidate;
	}


	public void setProdregidate(String prodregidate) {
		this.prodregidate = prodregidate;
	}


	public String getShopcode() {
		return shopcode;
	}


	public void setShopcode(String shopcode) {
		this.shopcode = shopcode;
	}


	public String getProdimage() {
		return prodimage;
	}


	public void setProdimage(String prodimage) {
		this.prodimage = prodimage;
	}


	// toString
	@Override
	public String toString() {
		return "ProdVO [prodcode=" + prodcode + ", prodname=" + prodname + ", prodprice=" + prodprice + ", prodsize="
				+ prodsize + ", prodinven=" + prodinven + ", prodregidate=" + prodregidate + ", shopcode=" + shopcode
				+ ", prodimage=" + prodimage + "]";
	}
	
	
	
}
