//Alihan Demirdaş 20010011054
package odev2;

import java.util.ArrayList;

public class Ogrenci {
	private int ogrId;
	private String ogrAdSoyad;
	private int ogrYas;
	private ArrayList<Ders> alinanDersler;
	
	public Ogrenci(int ogrId, String ogrAdSoyad, int ogrYas, ArrayList<Ders> alinanDersler) {
		super();
		this.ogrId = ogrId;
		this.ogrAdSoyad = ogrAdSoyad;
		this.ogrYas = ogrYas;
		ArrayList<Ders> a = new ArrayList<Ders>();
		a = (ArrayList<Ders>)alinanDersler.clone();
		this.setAlinanDersler(a);
	}

	public ArrayList<Ders> getAlinanDersler() {
		return alinanDersler;
	}

	public void setAlinanDersler(ArrayList<Ders> alinanDersler) {
		this.alinanDersler = alinanDersler;
	}

	public int getOgrId() {
		return ogrId;
	}

	public void setOgrId(int ogrId) {
		this.ogrId = ogrId;
	}

	public String getOgrAdSoyad() {
		return ogrAdSoyad;
	}

	public void setOgrAdSoyad(String ogrAdSoyad) {
		this.ogrAdSoyad = ogrAdSoyad;
	}

	public int getOgrYas() {
		return ogrYas;
	}

	public void setOgrYas(int ogrYas) {
		this.ogrYas = ogrYas;
	}
	
	
	
	
	
	
	
}
