package DAO;

import java.util.List;

import Entity.DeTai;

public interface DeTaiDAO {

	List<DeTai> getAllDeTai();

	void insertDT(DeTai dt);

	DeTai getDTByID(String id);

	void insertNhom(int detai, String uid);

	boolean checkDotDKGV();

	boolean checkDotDKSV();

	int getIDdeTai(String user);

	void insertTV(int detai, String uid);

	void deleteTV(int detai, String uid);

	void tuChoiDeTai(int detai);

	void duyetDeTai(int detai);

	List<DeTai> getDuyetDeTai();

	DeTai getDeTaiByID(int detai);

	int soLuongSV(int detai);

	List<DeTai> getDeTaiHD(String maGV);

	void insertSVQT(int detai, String uid);

	void deleteSVQT(int detai, String uid);

	List<DeTai> getDeTai();

	int soDT();


}
