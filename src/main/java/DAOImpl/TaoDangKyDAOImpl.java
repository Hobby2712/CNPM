package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.ConnectDB;
import DAO.TaoDangKyDAO;
import Entity.TaoDangKy;

public class TaoDangKyDAOImpl extends ConnectDB implements TaoDangKyDAO {

	@Override
	public void insertDKSV(TaoDangKy dk) {
		String query = "Insert into dotDangKy values (?,?,1)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setDate(1, dk.getNgayBD());
			ps.setDate(2, dk.getNgayKT());
			
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	@Override
	public void updateDKSV(TaoDangKy dk) {
		String query = "update dotDangKy\r\n"
				+ "set ngayBD = ?,\r\n"
				+ "ngayKT = ?\r\n"
				+ "where isSV=1";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setDate(1, dk.getNgayBD());
			ps.setDate(2, dk.getNgayKT());
			
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	@Override
	public void insertDKGV(TaoDangKy dk) {
		String query = "Insert into dotDangKy values (?,?,0)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setDate(1, dk.getNgayBD());
			ps.setDate(2, dk.getNgayKT());
			
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	@Override
	public void updateDKGV(TaoDangKy dk) {
		String query = "update dotDangKy\r\n"
				+ "set ngayBD = ?,\r\n"
				+ "ngayKT = ?\r\n"
				+ "where isSV=0";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setDate(1, dk.getNgayBD());
			ps.setDate(2, dk.getNgayKT());
			
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	@Override
	public boolean checkDKSV() {
		String query = "select * from dotDangKy\r\n"
				+ "where isSV=1";
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
	public boolean checkDKGV() {
		String query = "select * from dotDangKy\r\n"
				+ "where  isSV=0";
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
	
	public static void main(String[] args) {
		TaoDangKyDAO dao = new TaoDangKyDAOImpl();
		System.out.print(dao.checkDKSV());
	}
	
}
