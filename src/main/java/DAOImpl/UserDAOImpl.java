package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectDB;
import DAO.UserDAO;
import Entity.User;

public class UserDAOImpl extends ConnectDB implements UserDAO {

	@Override
	public User getInfo(String user) {
		String query = "select * from [user] join taiKhoan\r\n" + "on [user].uId = taiKhoan.uid\r\n"
				+ "where taiKhoan.userName = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8));
			}
		} catch (Exception e) {
		}
		return null;
	}


	@Override
	public void editInfo(String email, String address, String phone, String uid) {
		String query = "update [user]\r\n" + "set uEmail = ?,\r\n" + "uAddress = ?,\r\n" + "uPhone = ?\r\n"
				+ "where [uId]= ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.setString(4, uid);

			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public List<User> getSVQuanTam(int detai) {
		List<User> uList = new ArrayList<>();
		String query = "select * from [user] join svQuanTam\r\n" + "on [user].uId = svQuanTam.uid\r\n"
				+ "where detai=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setuId(rs.getString(1));
				u.setFullName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setGioiTinh(rs.getString(6));
				u.setChuyenNganh(rs.getInt(7));
				u.setImage(rs.getString(8));
				uList.add(u);
			}
		} catch (Exception e) {
		}
		return uList;
	}

	@Override
	public List<User> getTVNhom(int detai) {
		List<User> uList = new ArrayList<>();
		String query = "select * from [user] join nhom\r\n" + "on [user].uid = nhom.uid\r\n"
				+ "where nhom.detai=? and isTruongNhom=0";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setuId(rs.getString(1));
				u.setFullName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setGioiTinh(rs.getString(6));
				u.setChuyenNganh(rs.getInt(7));
				u.setImage(rs.getString(8));
				uList.add(u);
			}
		} catch (Exception e) {
		}
		return uList;
	}
	
	@Override
	public List<User> getAllTVNhom(int detai) {
		List<User> uList = new ArrayList<>();
		String query = "select * from [user] join nhom\r\n" + "on [user].uid = nhom.uid\r\n"
				+ "where nhom.detai=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, detai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setuId(rs.getString(1));
				u.setFullName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setGioiTinh(rs.getString(6));
				u.setChuyenNganh(rs.getInt(7));
				u.setImage(rs.getString(8));
				uList.add(u);
			}
		} catch (Exception e) {
		}
		return uList;
	}
	
	@Override
	public boolean checkUserInNhom(String uid) {
		String query = "select * from [user] join nhom \r\n"
				+ "on [user].uid = nhom.uid\r\n"
				+ "where nhom.uid = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
	
	@Override
	public int getCNByuid(String uid) {
		String query = "select [user].uChuyenNganh from [user] join taiKhoan\r\n"
				+ "on [user].uId = taiKhoan.uid\r\n"
				+ "where taiKhoan.uid=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	
	
	@Override
	public List<User> getGVPBByCN(int chuyenNganh) {
		List<User> uList = new ArrayList<>();
		String query = "select * from [user] join taiKhoan\r\n"
				+ "on [user].uId = taiKhoan.uid\r\n"
				+ "where [user].uChuyenNganh=? and taiKhoan.idRole=2";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, chuyenNganh);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setuId(rs.getString(1));
				u.setFullName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setGioiTinh(rs.getString(6));
				u.setChuyenNganh(rs.getInt(7));
				u.setImage(rs.getString(8));
				uList.add(u);
			}
		} catch (Exception e) {
		}
		return uList;
	}
	
	@Override
	public List<User> getGVPBByID(int id) {
		List<User> uList = new ArrayList<>();
		String query = "select * from [user] join hoidong_info\r\n"
				+ "on [user].uId = hoidong_info.gv\r\n"
				+ "where hoidong_info.hd  = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setuId(rs.getString(1));
				u.setFullName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setGioiTinh(rs.getString(6));
				u.setChuyenNganh(rs.getInt(7));
				u.setImage(rs.getString(8));
				uList.add(u);
			}
		} catch (Exception e) {
		}
		return uList;
	}
	
	@Override
	public boolean checkUserInHD(int deTai, String uid) {
		String query = "select * from hoidong_info\r\n"
				+ "where hd=? and gv=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,deTai);
			ps.setString(2,uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
	public static void main(String[] args) {
		UserDAO a = new UserDAOImpl();
		System.out.print(a.checkUserInHD(1, "gv01"));
	}
	
	@Override
	public void insert(User user) {
		String query = "Insert into [user] values (?,?,?,?,?,?,?,null)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1,user.getuId());
			ps.setString(2, user.getFullName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getGioiTinh());
			ps.setInt(7, user.getChuyenNganh());
			ps.executeUpdate();
		} catch (Exception e) {
		}
		
	}
}