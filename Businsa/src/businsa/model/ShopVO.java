package businsa.model;

public class ShopVO {

	
	// SHOP Fields
		private String shopcode;
		private String shoppasw;
		private String shopname;
		private String shopceo;
		private String shopphone;
		private String shopaddr;
		private String shoptime;
		private String regidate;
		private String shopimage;
		
		
		
		public ShopVO(String shopcode, String shoppasw, String shopname, String shopceo, String shopphone,
				String shopaddr, String shoptime, String regidate) {
			this.shopcode = shopcode;
			this.shoppasw = shoppasw;
			this.shopname = shopname;
			this.shopceo = shopceo;
			this.shopphone = shopphone;
			this.shopaddr = shopaddr;
			this.shoptime = shoptime;
			this.regidate = regidate;
		}

		public ShopVO(String shopname2, String shopaddr2) {
			this.shopname = shopname2;
			this.shopaddr = shopaddr2;
		}

		public ShopVO(String shopimage2) {
			this.shopimage = shopimage2;
		}
		
		
		
		
		


		// getter setter
	

		public String getShopcode() {
			return shopcode;
		}

		public void setShopcode(String shopcode) {
			this.shopcode = shopcode;
		}

		public String getShoppasw() {
			return shoppasw;
		}

		public void setShoppasw(String shoppasw) {
			this.shoppasw = shoppasw;
		}

		public String getShopname() {
			return shopname;
		}

		public void setShopname(String shopname) {
			this.shopname = shopname;
		}

		public String getShopceo() {
			return shopceo;
		}

		public void setShopceo(String shopceo) {
			this.shopceo = shopceo;
		}

		public String getShopphone() {
			return shopphone;
		}

		public void setShopphone(String shopphone) {
			this.shopphone = shopphone;
		}

		public String getShopaddr() {
			return shopaddr;
		}

		public void setShopaddr(String shopaddr) {
			this.shopaddr = shopaddr;
		}

		public String getShoptime() {
			return shoptime;
		}

		public void setShoptime(String shoptime) {
			this.shoptime = shoptime;
		}

		public String getRegidate() {
			return regidate;
		}

		public void setRegidate(String regidate) {
			this.regidate = regidate;
		}
		public String getShopimage() {
			return shopimage;
		}

		public void setShopimage(String shopimage) {
			this.shopimage = shopimage;
		}

		
		// toString
		@Override
		public String toString() {
			return "ShopVO [shopcode=" + shopcode + ", shoppasw=" + shoppasw + ", shopname=" + shopname + ", shopceo="
					+ shopceo + ", shopphone=" + shopphone + ", shopaddr=" + shopaddr + ", shoptime=" + shoptime
					+ ", regidate=" + regidate + ", shopimage=" + shopimage + "]";
		}
	
}
