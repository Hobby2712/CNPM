package DAO;

import Entity.User;

public interface UserDAO {

	User getInfo(String user);

	void editInfo(String email, String address, String phone, String uid);

}
