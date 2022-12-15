package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.ConnectDB;
import DAO.UserDAO;
import Entity.TaoDangKy;
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
	public static void main(String[] args) {
		UserDAO u = new UserDAOImpl();
		u.editInfo("1", "2", "3", "20110627");
		System.out.print(u.getInfo("sinhvien"));
	}
	
	@Override
	public void editInfo(String email, String address, String phone, String uid) {
		String query = "update [user]\r\n"
				+ "set uEmail = ?,\r\n"
				+ "uAddress = ?,\r\n"
				+ "uPhone = ?\r\n"
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
	
	

}