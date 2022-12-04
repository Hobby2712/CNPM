package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
