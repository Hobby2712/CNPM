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
		String query = "select deTai.id, deTai.tenDT, deTai.mucTieu, deTai.yeuCau, deTai.sanPham, deTai.soLuong, deTai.loaiDT, deTai.isKhacCN, deTai.trangthai, deTai.nienKhoa, u1.uFullName, deTai.GVPB, deTai.Diem\r\n"
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
				deTai.setSoLuong(rs.getInt(6));
				deTai.setLoaiDT(rs.getInt(7));
				deTai.setIsKhacCN(rs.getInt(8));
				deTai.setTrangThai(rs.getInt(9));
				deTai.setNienKhoa(rs.getInt(10));
				deTai.setGVHD(rs.getString(11));
				deTai.setGVPB(rs.getString(12));
				deTai.setDiem(rs.getInt(13));
				deTaiList.add(deTai);
			}
		} catch (Exception e) {
		}
		return deTaiList;
	}

	@Override
	public void insertDT(DeTai dt) {
		String query = "Insert into deTai values (?,?,?,?,?,?,?,0,?,?,null,null)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dt.getTenDT());
			ps.setString(2, dt.getMucTieu());
			ps.setString(3, dt.getYeuCau());
			ps.setString(4, dt.getSanPham());
			ps.setInt(5, dt.getSoLuong());
			ps.setInt(6, dt.getLoaiDT());
			ps.setInt(7, dt.getIsKhacCN());
			ps.setInt(8, dt.getNienKhoa());
			ps.setString(9, dt.getGVHD());
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public DeTai getDTByID(String id) {
		String query = "select deTai.id, deTai.tenDT, deTai.mucTieu, deTai.yeuCau, deTai.sanPham, deTai.soLuong, deTai.loaiDT, deTai.isKhacCN, deTai.trangthai, deTai.nienKhoa, u1.uFullName, deTai.GVPB, deTai.Diem\r\n"
				+ "from deTai join [user] u1\r\n"
				+ "on deTai.GVHD = u1.uId\r\n"
				+ "where deTai.id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new DeTai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12),
						rs.getInt(13));
			}
		} catch (Exception e) {
		}
		return null;
	}
	public static void main(String[] args) {
		DeTaiDAO dao = new DeTaiDAOImpl();
		System.out.print(dao.checkDotDKSV());
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
		String query = "select id from \r\n"
				+ "dotDangKy where ngayBD < GETDATE() and ngayKT > GETDATE() and isSV = 0";
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
		String query = "select id from \r\n"
				+ "dotDangKy where ngayBD < GETDATE() and ngayKT > GETDATE() and isSV = 1";
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
}
