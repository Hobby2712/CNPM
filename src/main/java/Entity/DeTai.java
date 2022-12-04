package Entity;

public class DeTai {
	private int id;
	private String tenDT;
	private String mucTieu;
	private String yeuCau;
	private String sanPham;
	private int soLuong;
	private int loaiDT;
	private int isKhacCN;
	private int trangThai;
	private int nienKhoa;
	private String GVHD;
	private String GVPB;
	private float Diem;
	
	public DeTai() {
		super();
	}

	

	public DeTai(int id, String tenDT, String mucTieu, String yeuCau, String sanPham, int soLuong, int loaiDT,
			int isKhacCN, int trangThai, int nienKhoa, String gVHD, String gVPB, float diem) {
		super();
		this.id = id;
		this.tenDT = tenDT;
		this.mucTieu = mucTieu;
		this.yeuCau = yeuCau;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.loaiDT = loaiDT;
		this.isKhacCN = isKhacCN;
		this.trangThai = trangThai;
		this.nienKhoa = nienKhoa;
		GVHD = gVHD;
		GVPB = gVPB;
		Diem = diem;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public String getMucTieu() {
		return mucTieu;
	}

	public void setMucTieu(String mucTieu) {
		this.mucTieu = mucTieu;
	}

	public String getYeuCau() {
		return yeuCau;
	}

	public void setYeuCau(String yeuCau) {
		this.yeuCau = yeuCau;
	}

	public String getSanPham() {
		return sanPham;
	}

	public void setSanPham(String sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getIsKhacCN() {
		return isKhacCN;
	}

	public void setIsKhacCN(int isKhacCN) {
		this.isKhacCN = isKhacCN;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(int nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	public String getGVHD() {
		return GVHD;
	}

	public void setGVHD(String gVHD) {
		GVHD = gVHD;
	}

	public String getGVPB() {
		return GVPB;
	}

	public void setGVPB(String gVPB) {
		GVPB = gVPB;
	}

	public float getDiem() {
		return Diem;
	}

	public void setDiem(float diem) {
		Diem = diem;
	}



	public int getLoaiDT() {
		return loaiDT;
	}



	public void setLoaiDT(int loaiDT) {
		this.loaiDT = loaiDT;
	}



	@Override
	public String toString() {
		return "DeTai [id=" + id + ", tenDT=" + tenDT + ", mucTieu=" + mucTieu + ", yeuCau=" + yeuCau + ", sanPham="
				+ sanPham + ", soLuong=" + soLuong + ", loaiDT=" + loaiDT + ", isKhacCN=" + isKhacCN + ", trangThai="
				+ trangThai + ", nienKhoa=" + nienKhoa + ", GVHD=" + GVHD + ", GVPB=" + GVPB + ", Diem=" + Diem + "]";
	}
	
	
}
