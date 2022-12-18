package odev1;

public class Proje {
	private int depNo;
	public static int sayac=0;
	private int projeID;
	private String projeAd;
	private int projeSure;
	private int projeMaliyet;
	
	public Proje() {
		this.projeID = ++sayac;
	}

	public int getDepNo() {
		return depNo;
	}

	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}

	public int getProjeID() {
		return projeID;
	}

	public String getProjeAd() {
		return projeAd;
	}

	public void setProjeAd(String projeAd) {
		this.projeAd = projeAd;
	}

	public int getProjeSure() {
		return projeSure;
	}

	public void setProjeSure(int projeSure) {
		this.projeSure = projeSure;
	}

	public int getProjeMaliyet() {
		return projeMaliyet;
	}

	public void setProjeMaliyet(int projeMaliyet) {
		this.projeMaliyet = projeMaliyet;
	}
	
	
	
}
