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

}
