package businsa.model;
public class BusinsaVo {
	//field
	private String usercode;
	private String userid;
	private String passwd;
	private String username;
	private String phone;
	private String addr;
	private String email;
	private String joindate;
	private String size;
	private String oprodname ;
	private String oprodprice ;
	private String oprodsize ;
	private String oorderquan ;
	private String oorderdate;
	private String prodname;
	// 생성자
	public BusinsaVo() {	}
	


	



		




	public BusinsaVo(String usercode, String userid, String passwd, String username, String phone, String addr,
			String email, String joindate, String size, String oprodname, String oprodprice, String oprodsize,
			String oorderquan, String oorderdate, String prodname) {
	
		this.usercode = usercode;
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.phone = phone;
		this.addr = addr;
		this.email = email;
		this.joindate = joindate;
		this.size = size;
		this.oprodname = oprodname;
		this.oprodprice = oprodprice;
		this.oprodsize = oprodsize;
		this.oorderquan = oorderquan;
		this.oorderdate = oorderdate;
		this.prodname = prodname;
	}



	public BusinsaVo(String userid2, String passwd2, String username2, String phone2, String addr2, String email2) {
		this.userid   = userid2;
		this.passwd   = passwd2;
		this.username = username2;
		this.phone    = phone2;
		this.addr     = addr2;
		this.email    = email2;
	}



	public BusinsaVo(String oprodname2, String oprodsize2, String oprodprice2, String oorderquan2) {
		// TODO Auto-generated constructor stub
	}



	// Getter / Setter
	public String getUsercode() { return usercode; }
	public void setUsercode(String usercode) { this.usercode = usercode; }
	public String getUserid() { return userid; }
	public void setUserid(String userid) { this.userid = userid; }
	public String getPasswd() { return passwd; }
	public void setPasswd(String passwd) { this.passwd = passwd; }
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public String getAddr() { return addr; }
	public void setAddr(String addr) { this.addr = addr; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getJoindate() { return joindate; }
	public void setJoindate(String joindate) { this.joindate = joindate; }
	public String getSize() {	return size;}
	public void setSize(String size) {	this.size = size;}



	public String getOprodname() {		return oprodname;	}



	public void setOprodname(String oprodname) {		this.oprodname = oprodname;	}



	public String getOprodprice() {		return oprodprice;	}



	public void setOprodprice(String oprodprice) {		this.oprodprice = oprodprice;	}



	public String getOprodsize() {		return oprodsize;	}



	public void setOprodsize(String oprodsize) {		this.oprodsize = oprodsize;	}



	public String getOorderquan() {		return oorderquan;	}



	public void setOorderquan(String oorderquan) {		this.oorderquan = oorderquan;	}



	public String getOorderdate() {		return oorderdate;	}


	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public void setOorderdate(String oorderdate) {		this.oorderdate = oorderdate;	}


	// toString
	@Override
	public String toString() {
		return "BusinsaVo [usercode=" + usercode + ", userid=" + userid + ", passwd=" 
	+ passwd + ", username="+ username + ", phone=" + phone + ", addr=" 
				+ addr + ", email=" + email + ", joindate=" + joindate
				+ ", size=" + size + "]";
	}



}
