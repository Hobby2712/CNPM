package DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectDB;
import DAO.HoiDongDAO;
import Entity.HoiDong;

public class HoiDongDAOImpl extends ConnectDB implements HoiDongDAO {
	@Override
	public List<HoiDong> getAllHD() {
		List<HoiDong> hdList = new ArrayList<>();
		String query = "select * from hoidong";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HoiDong hd = new HoiDong();
				hd.setId(rs.getInt(1));
				hd.setDetai(rs.getInt(2));
				hd.setSoLuong(rs.getInt(3));
				hd.setNgayPB(rs.getDate(4));
				hdList.add(hd);
			}
		} catch (Exception e) {
		}
		return hdList;
	}
	
	
	
	@Override
	public void insertHD(int detai, int SL, Date ngayPB) {
		String query = "Insert into hoidong values (?,?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ps.setInt(2, SL);
			ps.setDate(3, ngayPB);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	@Override
	public void deleteHD(int id) {
		String query = "delete from hoidong where id=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	@Override
	public List<HoiDong> getHDByCN(int chuyenNganh) {
		List<HoiDong> hdList = new ArrayList<>();
		String query = "select * from hoidong join deTai\r\n"
				+ "on hoidong.detai = deTai.id\r\n"
				+ "where chuyenNganh = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, chuyenNganh);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HoiDong hd = new HoiDong();
				hd.setId(rs.getInt(1));
				hd.setDetai(rs.getInt(2));
				hd.setSoLuong(rs.getInt(3));
				hd.setNgayPB(rs.getDate(4));
				hdList.add(hd);
			}
		} catch (Exception e) {
		}
		return hdList;
	}
	
	@Override
	public HoiDong getHDByID(int id) {
		String query = "select * from hoidong where id=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new HoiDong(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4));
				
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	@Override
	public void insertGVHD(int id, String uid) {
		String query = "insert into hoidong_info values(?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, uid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	@Override
	public void deleteGVHD(int id, String uid) {
		String query = "delete from hoidong_info\r\n"
				+ "where hd=? and gv=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, uid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	@Override
	public int soGVTrongHD(int id) {
		String query = "select count(*) from hoidong_info\r\n"
				+ "where hd=? ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	
	@Override
	public int soGVYCHD(int id) {
		String query = "select soLuong from hoidong\r\n"
				+ "where id=?  ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
}
