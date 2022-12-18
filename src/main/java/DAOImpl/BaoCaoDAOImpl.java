package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Connection.ConnectDB;
import DAO.BaoCaoDAO;
import Entity.BaoCao;


public class BaoCaoDAOImpl extends ConnectDB implements BaoCaoDAO {

	@Override
	public void insert(BaoCao bc) {
		String query = "Insert into fileBaoCao values (?,?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1,bc.getChude());
			ps.setString(2, bc.getNoidung());
			ps.setString(3, bc.getFileName());
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void update(BaoCao bc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaoCao getBaoCao(int id) {
		String query = "select fileName from fileBaoCao where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new BaoCao(rs.getString(1));
			}
		} catch (Exception e) {
		}
		return null;
	}

	
}
