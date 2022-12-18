package DAO;

import Entity.BaoCao;

public interface BaoCaoDAO {
	BaoCao getBaoCao(int id);
	void insert(BaoCao bc);
	void update(BaoCao bc);
}
