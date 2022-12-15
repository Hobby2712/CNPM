package DAO;

import java.util.List;

import Entity.TaiKhoan;

public interface TaiKhoanDAO {

	TaiKhoan login(String user, String pass);

	List<TaiKhoan> getAllTaiKhoan();

	void deleteAccount(String username);

	void updateRole(int role, String username);

}
