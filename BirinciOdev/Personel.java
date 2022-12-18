package odev1;

public class Personel {
	private int depNo;
	public static int sayac=0;
	private int perID;
	private String perAd;
	private String perSoyad;
	private int perYas;
	
	public Personel() {
		this.perID = ++sayac;
	}
	
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	public int getPerID() {
		return perID;
	}

	public String getPerAd() {
		return perAd;
	}
	public void setPerAd(String perAd) {
		this.perAd = perAd;
	}
	public String getPerSoyad() {
		return perSoyad;
	}
	public void setPerSoyad(String perSoyad) {
		this.perSoyad = perSoyad;
	}
	public int getPerYas() {
		return perYas;
	}
	public void setPerYas(int perYas) {
		this.perYas = perYas;
	}
	
	
	
}
