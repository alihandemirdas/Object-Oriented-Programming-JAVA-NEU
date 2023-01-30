//Alihan Demirdaş 20010011054
package odev2;

public class Ders {
	
	private int dersId;
	private String dersAd;
	public static int syc=1000;
	
	public Ders(String dersAd) {
		this.dersAd = dersAd;
		this.dersId = syc;
		syc+=10;
	}

	public int getDersId() {
		return dersId;
	}

	public void setDersId(int dersId) {
		this.dersId = dersId;
	}

	public String getDersAd() {
		return dersAd;
	}

	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}
	
}
