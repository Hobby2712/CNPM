package Entity;

import java.sql.Date;



public class TaoDangKy {
	private int id;
	private Date ngayBD;
	private Date ngayKT;
	private int isSV;
	
	
	public TaoDangKy() {
		super();
	}
	
	
	public TaoDangKy(int id, Date ngayBD, Date ngayKT, int isSV) {
		super();
		this.id = id;
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
		this.isSV = isSV;
	}
	
	public TaoDangKy( Date ngayBD, Date ngayKT) {
		super();
		
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getNgayBD() {
		return ngayBD;
	}
	public void setNgayBD(Date ngayBD) {
		this.ngayBD = ngayBD;
	}
	public Date getNgayKT() {
		return ngayKT;
	}
	public void setNgayKT(Date ngayKT) {
		this.ngayKT = ngayKT;
	}
	public int getIsSV() {
		return isSV;
	}
	public void setIsSV(int isSV) {
		this.isSV = isSV;
	}
}
