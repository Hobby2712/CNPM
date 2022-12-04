package DAO;


import Entity.TaoDangKy;

public interface TaoDangKyDAO {

	void insertDKSV(TaoDangKy dk);
	
	void insertDKGV(TaoDangKy dk);

	boolean checkDKGV();

	boolean checkDKSV();

	void updateDKGV(TaoDangKy dk);

	void updateDKSV(TaoDangKy dk);
	
}
