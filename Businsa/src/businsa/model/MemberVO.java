package businsa.model;

public class MemberVO {

	// Fields
	private String usercode;
	private String userid;
	private String passwd;
	private String username;
	private String phone;
	private String addr;
	private String email;
	private String joindate;
	
	// Constructor
	public MemberVO() { }

	public MemberVO(String userid, String passwd, String username,
			String phone, String addr, String email) {
		this.userid   = userid;
		this.passwd   = passwd;
		this.username = username;
		this.phone    = phone;
		this.addr     = addr;
		this.email    = email;
	}

	public MemberVO(String usercode, String userid, String passwd, String username,
			String phone, String addr, String email, String joindate) {
		this.usercode = usercode;
		this.userid   = userid;
		this.passwd   = passwd;
		this.username = username;
		this.phone    = phone;
		this.addr     = addr;
		this.email    = email;
		this.joindate = joindate;
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

	// toString
	@Override
	public String toString() {
		return "MemberVO [usercode=" + usercode + ", userid=" + userid 
				+ ", passwd=" + passwd + ", username=" + username
				+ ", phone=" + phone + ", addr=" + addr + ", email=" 
				+ email + ", joindate=" + joindate + "]";
	}
	
}
