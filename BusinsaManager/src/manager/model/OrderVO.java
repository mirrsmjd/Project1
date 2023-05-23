package manager.model;
// 이덕만
public class OrderVO {

	// 필드
	private String orderCode;
	private String userCode;
	private String ouserCode;
	private String prodCode;
	private String oprodCode;
	private int    orderQuan;
	private String orderDate;
	
	// 생성자
	public OrderVO() { }
	public OrderVO(String ordercode, String usercode, String prodcode, int orderquan, String orderdate) {
		this.orderCode = ordercode;
		this.userCode  = usercode;
		this.prodCode  = prodcode;
		this.orderQuan = orderquan;
		this.orderDate = orderdate;
	}
	// Getter / Setter
	public String getOrderCode() { return orderCode; }
	public void setOrderCode(String orderCode) { this.orderCode = orderCode; }
	public String getUserCode() { return userCode; }
	public void setUserCode(String userCode) { this.userCode = userCode; }
	public String getOuserCode() { return ouserCode; }
	public void setOuserCode(String ouserCode) { this.ouserCode = ouserCode; }
	public String getProdCode() { return prodCode; }
	public void setProdCode(String prodCode) { this.prodCode = prodCode; }
	public String getOprodCode() { return oprodCode; }
	public void setOprodCode(String oprodCode) { this.oprodCode = oprodCode; }
	public int getOrderQuan() { return orderQuan; }
	public void setOrderQuan(int orderQuan) { this.orderQuan = orderQuan; }
	public String getOrderDate() { return orderDate; }
	public void setOrderDate(String orderDate) { this.orderDate = orderDate; }
	
	// toString
	@Override
	public String toString() {
		return "OrderVO [orderCode=" + orderCode + ", userCode=" + userCode + ", ouserCode=" + ouserCode + ", prodCode="
				+ prodCode + ", oprodCode=" + oprodCode + ", orderQuan=" + orderQuan + ", orderDate=" + orderDate
				+ "]";
	}
}
