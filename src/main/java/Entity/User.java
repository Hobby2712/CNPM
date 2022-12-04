package Entity;

public class User {
	private String uId;
	private String fullName;
	private String email;
	private String address;
	private String phone;
	private String gioiTinh;
	private int chuyenNganh;
	private String image;
	
	public User() {
		super();
	}

	public User(String uId, String fullName, String email, String address, String phone, String gioiTinh,
			int chuyenNganh, String image) {
		super();
		this.uId = uId;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.gioiTinh = gioiTinh;
		this.chuyenNganh = chuyenNganh;
		this.image = image;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(int chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", fullName=" + fullName + ", email=" + email + ", address=" + address + ", phone="
				+ phone + ", gioiTinh=" + gioiTinh + ", chuyenNganh=" + chuyenNganh + ", image=" + image + "]";
	}
	
}
