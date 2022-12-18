package Entity;

import java.sql.Date;

import DAO.DeTaiDAO;
import DAOImpl.DeTaiDAOImpl;

public class HoiDong {
	int id;
	int detai;
	int soLuong;
	Date ngayPB;
	
	public int getDetai() {
		return detai;
	}
	public void setDetai(int detai) {
		this.detai = detai;
	}
	public HoiDong(int id, int detai, int soLuong, Date ngayPB) {
		super();
		this.id = id;
		this.detai = detai;
		this.soLuong = soLuong;
		this.ngayPB = ngayPB;
	}
	public HoiDong() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Date getNgayPB() {
		return ngayPB;
	}
	public void setNgayPB(Date ngayPB) {
		this.ngayPB = ngayPB;
	}
	@Override
	public String toString() {
		return "HoiDong [id=" + id + ", detai=" + detai + ", soLuong=" + soLuong + ", ngayPB=" + ngayPB + "]";
	}
	
	public DeTai getDT(int id) {
		DeTaiDAO dao = new DeTaiDAOImpl();
		return dao.getDeTaiByID(id);
	}
}
