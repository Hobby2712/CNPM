package DAO;

import java.util.List;

import Entity.User;

public interface UserDAO {

	User getInfo(String user);

	void editInfo(String email, String address, String phone, String uid);

	List<User> getSVQuanTam(int detai);

	List<User> getTVNhom(int detai);

	List<User> getAllTVNhom(int detai);

	boolean checkUserInNhom(String uid);

	int getCNByuid(String uid);

	List<User> getGVPBByCN(int chuyenNganh);

	List<User> getGVPBByID(int id);

	boolean checkUserInHD(int deTai, String uid);
	
	void insert(User user);

}
