package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectDB;
import DAO.DeTaiDAO;
import Entity.DeTai;

public class DeTaiDAOImpl extends ConnectDB implements DeTaiDAO {
	@Override
	public List<DeTai> getAllDeTai() {
		List<DeTai> deTaiList = new ArrayList<>();
		String query = "select deTai.id, deTai.tenDT, deTai.mucTieu, deTai.yeuCau, deTai.sanPham, deTai.chuThich, deTai.soLuong, deTai.loaiDT, deTai.isKhacCN, deTai.chuyenNganh, deTai.trangthai, deTai.nienKhoa, u1.uFullName, deTai.GVPB, deTai.Diem\r\n"
				+ "from deTai join [user] u1\r\n"
				+ "on deTai.GVHD = u1.uId\r\n"
				+ "where deTai.trangthai = 2 ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeTai deTai = new DeTai();
				deTai.setId(rs.getInt(1));
				deTai.setTenDT(rs.getString(2));
				deTai.setMucTieu(rs.getString(3));
				deTai.setYeuCau(rs.getString(4));
				deTai.setSanPham(rs.getString(5));
				deTai.setChuThich(rs.getString(6));
				deTai.setSoLuong(rs.getInt(7));
				deTai.setLoaiDT(rs.getInt(8));
				deTai.setIsKhacCN(rs.getInt(9));
				deTai.setChuyenNganh(rs.getInt(10));
				deTai.setTrangThai(rs.getInt(11));
				deTai.setNienKhoa(rs.getInt(12));
				deTai.setGVHD(rs.getString(13));
				deTai.setGVPB(rs.getString(14));
				deTai.setDiem(rs.getInt(15));
				deTaiList.add(deTai);
			}
		} catch (Exception e) {
		}
		return deTaiList;
	}

	@Override
	public void insertDT(DeTai dt) {
		String query = "Insert into deTai values (?,?,?,?,?,?,?,?,?,1,?,?,null,null)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dt.getTenDT());
			ps.setString(2, dt.getMucTieu());
			ps.setString(3, dt.getYeuCau());
			ps.setString(4, dt.getSanPham());
			ps.setString(5, dt.getChuThich());
			ps.setInt(6, dt.getSoLuong());
			ps.setInt(7, dt.getLoaiDT());
			ps.setInt(8, dt.getIsKhacCN());
			ps.setInt(9, dt.getChuyenNganh());
			ps.setInt(10, dt.getNienKhoa());
			ps.setString(11, dt.getGVHD());
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public DeTai getDTByID(String id) {
		String query = "select deTai.id, deTai.tenDT, deTai.mucTieu, deTai.yeuCau, deTai.sanPham, deTai.chuThich, deTai.soLuong, deTai.loaiDT, deTai.isKhacCN, deTai.chuyenNganh, deTai.trangthai, deTai.nienKhoa, u1.uFullName, deTai.GVPB, deTai.Diem\r\n"
				+ "from deTai join [user] u1\r\n" + "on deTai.GVHD = u1.uId\r\n" + "where deTai.id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new DeTai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12),
						rs.getString(13), rs.getString(14), rs.getInt(15));
			}
		} catch (Exception e) {
		}
		return null;
	}

	
	@Override
	public void insertNhom(int detai, String uid) {
		String query = "Insert into nhom values (?,?,1)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ps.setString(2, uid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public boolean checkDotDKGV() {
		String query = "select id from \r\n" + "dotDangKy where ngayBD < GETDATE() and ngayKT > GETDATE() and isSV = 0";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean checkDotDKSV() {
		String query = "select id from \r\n" + "dotDangKy where ngayBD < GETDATE() and ngayKT > GETDATE() and isSV = 1";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public int getIDdeTai(String user) {
		String query = "select detai from nhom join taiKhoan\r\n" + "on nhom.uid = taiKhoan.uid\r\n"
				+ "where taiKhoan.userName=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public void insertTV(int detai, String uid) {
		String query = "Insert into nhom values (?,?,0)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ps.setString(2, uid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void deleteTV(int detai, String uid) {
		String query = "delete from nhom where detai=? and uid=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ps.setString(2, uid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void duyetDeTai(int detai) {
		String query = "update deTai\r\n" + "set trangthai = 2\r\n" + "where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void tuChoiDeTai(int detai) {
		String query = "update deTai\r\n" + "set trangthai = 3\r\n" + "where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public List<DeTai> getDuyetDeTai() {
		List<DeTai> deTaiList = new ArrayList<>();
		String query = "select deTai.id, deTai.tenDT, deTai.mucTieu, deTai.yeuCau, deTai.sanPham, deTai.chuThich, deTai.soLuong, deTai.loaiDT, deTai.isKhacCN, deTai.chuyenNganh, deTai.trangthai, deTai.nienKhoa, u1.uFullName, deTai.GVPB, deTai.Diem\r\n"
				+ "from deTai join [user] u1\r\n" + "on deTai.GVHD = u1.uId\r\n" + "where deTai.trangthai = 1";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeTai deTai = new DeTai();
				deTai.setId(rs.getInt(1));
				deTai.setTenDT(rs.getString(2));
				deTai.setMucTieu(rs.getString(3));
				deTai.setYeuCau(rs.getString(4));
				deTai.setSanPham(rs.getString(5));
				deTai.setChuThich(rs.getString(6));
				deTai.setSoLuong(rs.getInt(7));
				deTai.setLoaiDT(rs.getInt(8));
				deTai.setIsKhacCN(rs.getInt(9));
				deTai.setChuyenNganh(rs.getInt(10));
				deTai.setTrangThai(rs.getInt(11));
				deTai.setNienKhoa(rs.getInt(12));
				deTai.setGVHD(rs.getString(13));
				deTai.setGVPB(rs.getString(14));
				deTai.setDiem(rs.getInt(15));
				deTaiList.add(deTai);
			}
		} catch (Exception e) {
		}
		return deTaiList;
	}

	@Override
	public DeTai getDeTaiByID(int detai) {
		String query = "select deTai.id, deTai.tenDT, deTai.mucTieu, deTai.yeuCau, deTai.sanPham, deTai.chuThich, deTai.soLuong, deTai.loaiDT, deTai.isKhacCN, deTai.chuyenNganh, deTai.trangthai, deTai.nienKhoa, u1.uFullName, deTai.GVPB, deTai.Diem\r\n"
				+ "from deTai join [user] u1\r\n" + "on deTai.GVHD = u1.uId\r\n" + "where id=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new DeTai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12),
						rs.getString(13), rs.getString(14), rs.getInt(15));
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	@Override
	public int soLuongSV(int detai) {
		String query = "select count(*) from nhom where detai=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	
	@Override
	public List<DeTai> getDeTaiHD(String maGV) {
		List<DeTai> deTaiList = new ArrayList<>();
		String query = "select * from detai\r\n"
				+ "where GVHD like ? and trangthai=2";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,"%" + maGV + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeTai deTai = new DeTai();
				deTai.setId(rs.getInt(1));
				deTai.setTenDT(rs.getString(2));
				deTai.setMucTieu(rs.getString(3));
				deTai.setYeuCau(rs.getString(4));
				deTai.setSanPham(rs.getString(5));
				deTai.setChuThich(rs.getString(6));
				deTai.setSoLuong(rs.getInt(7));
				deTai.setLoaiDT(rs.getInt(8));
				deTai.setIsKhacCN(rs.getInt(9));
				deTai.setChuyenNganh(rs.getInt(10));
				deTai.setTrangThai(rs.getInt(11));
				deTai.setNienKhoa(rs.getInt(12));
				deTai.setGVHD(rs.getString(13));
				deTai.setGVPB(rs.getString(14));
				deTai.setDiem(rs.getInt(15));
				deTaiList.add(deTai);
			}
		} catch (Exception e) {
		}
		return deTaiList;
	}
	
	public static void main(String[] args) {
		DeTaiDAO dao = new DeTaiDAOImpl();
		dao.insertNhom(4, "20110627");
	}
	
	@Override
	public void insertSVQT(int detai, String uid) {
		String query = "insert into svQuanTam values(?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ps.setString(2, uid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	@Override
	public void deleteSVQT(int detai, String uid) {
		String query = "delete from svQuanTam \r\n"
				+ "where detai=? and uid=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ps.setString(2, uid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	@Override
	public List<DeTai> getDeTai() {
		List<DeTai> deTaiList = new ArrayList<>();
		String query = "select deTai.id, deTai.tenDT, deTai.mucTieu, deTai.yeuCau, deTai.sanPham, deTai.chuThich, deTai.soLuong, deTai.loaiDT, deTai.isKhacCN, deTai.chuyenNganh, deTai.trangthai, deTai.nienKhoa, u1.uFullName, deTai.GVPB, deTai.Diem\r\n"
				+ "from deTai join [user] u1\r\n"
				+ "on deTai.GVHD = u1.uId";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeTai deTai = new DeTai();
				deTai.setId(rs.getInt(1));
				deTai.setTenDT(rs.getString(2));
				deTai.setMucTieu(rs.getString(3));
				deTai.setYeuCau(rs.getString(4));
				deTai.setSanPham(rs.getString(5));
				deTai.setChuThich(rs.getString(6));
				deTai.setSoLuong(rs.getInt(7));
				deTai.setLoaiDT(rs.getInt(8));
				deTai.setIsKhacCN(rs.getInt(9));
				deTai.setChuyenNganh(rs.getInt(10));
				deTai.setTrangThai(rs.getInt(11));
				deTai.setNienKhoa(rs.getInt(12));
				deTai.setGVHD(rs.getString(13));
				deTai.setGVPB(rs.getString(14));
				deTai.setDiem(rs.getInt(15));
				deTaiList.add(deTai);
			}
		} catch (Exception e) {
		}
		return deTaiList;
	}
	
	@Override
	public int soDT() {
		String query = "select count(*) from deTai";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	
}
