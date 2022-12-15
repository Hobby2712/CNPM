package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectDB;
import DAO.TaiKhoanDAO;
import Entity.TaiKhoan;

public class TaiKhoanDAOImpl extends ConnectDB implements TaiKhoanDAO{
	
	@Override
	public TaiKhoan login(String user, String pass) {
		String query = "select * from taiKhoan\r\n"
				+ "where userName = ? and uPass = ?";
        try {
        	Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new TaiKhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
	}
	
	@Override
	public List<TaiKhoan> getAllTaiKhoan() {
		List<TaiKhoan> taiKhoanList = new ArrayList<>();
		String query = "select * from taiKhoan except (select * from taiKhoan where idRole = 1)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan();
				tk.setId(rs.getInt(1));
				tk.setUserName(rs.getString(2));;
				tk.setPass(rs.getString(3));
				tk.setUid(rs.getString(4));
				tk.setRole(rs.getInt(5));
				taiKhoanList.add(tk);
			}
		} catch (Exception e) {
		}
		return taiKhoanList;
	}
	
	@Override
	public void updateRole(int role, String username) {
		String query = "update taiKhoan\r\n"
				+ "set idRole = ?\r\n"
				+ "where userName = ?";
        try {
        	Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, role);
			ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }	
	}
	
	@Override
	public void deleteAccount(String username) {
		String query = "delete taiKhoan\r\n"
				+ "where userName = ?";
        try {
        	Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
