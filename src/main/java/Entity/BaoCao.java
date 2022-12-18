package Entity;

public class BaoCao {
	int id;
	String chude;
	String noidung;
	String fileName;
	
	public BaoCao() {
		super();
	}
	
	public BaoCao(int id,String chude,String noidung, String fileName ) {
		super();
		this.id = id;
		this.chude = chude;
		this.noidung = noidung;
		this.fileName = fileName;
	}
	
	public BaoCao(String fileName ) {
		super();
		
		this.fileName = fileName;
	}
	
	public String getChude() {
		return chude;
	}
	public void setChude(String chude) {
		this.chude = chude;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String Noidung) {
		Noidung = noidung;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
