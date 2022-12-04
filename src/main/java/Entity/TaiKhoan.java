package Entity;

public class TaiKhoan {
	private int id;
	private String userName;
	private String pass;
	private String uid;
	private int role;
	
	public TaiKhoan() {
		super();
	}

	public TaiKhoan(int id, String userName, String pass, String uid, int role) {
		super();
		this.id = id;
		this.userName = userName;
		this.pass = pass;
		this.uid = uid;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "TaiKhoan [id=" + id + ", userName=" + userName + ", pass=" + pass + ", uid=" + uid + ", role=" + role
				+ "]";
	}
	
}
