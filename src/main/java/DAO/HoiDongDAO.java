package DAO;

import java.sql.Date;
import java.util.List;

import Entity.HoiDong;

public interface HoiDongDAO {

	List<HoiDong> getAllHD();

	void insertHD(int detai, int SL, Date ngayPB);

	void deleteHD(int id);

	List<HoiDong> getHDByCN(int chuyenNganh);

	HoiDong getHDByID(int id);

	void insertGVHD(int id, String uid);

	void deleteGVHD(int id, String uid);

	int soGVTrongHD(int id);

	int soGVYCHD(int id);

}
