package kr.co.itcen.bookmall.vo;

public class UserVo {
	private Long no;
	private String name;
	private String phone_number;
	private String email;
	private String password;
	private String address;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", phone_number=" + phone_number + ", email=" + email
				+ ", password=" + password + ", address=" + address + "]";
	}

}
