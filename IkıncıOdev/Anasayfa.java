//Alihan Demirdaş 20010011054
package odev2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Anasayfa {

	public static void main(String[] args) throws IOException {
		ArrayList<Ders> aldersler = new ArrayList<Ders>();
		ArrayList<Ders> mdersler = new ArrayList<Ders>();
		ArrayList<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
		ArrayList<Ders> dersler = new ArrayList<Ders>();
		Scanner scan = new Scanner(System.in);
		
		File ogrFile = new File("C:\\Users\\Alihan\\eclipse-workspace\\odev2\\src\\ogrenci.txt");
		if(!ogrFile.exists()) {
			System.out.println("Dosya bulunamadı.");
			return;
		}
		
		File dersFile = new File("C:\\Users\\Alihan\\eclipse-workspace\\odev2\\src\\ders.txt");
		if(!dersFile.exists()) {
			System.out.println("Dosya bulunamadı.");
			return;
		}
		
		BufferedReader brogr = new BufferedReader(new FileReader(ogrFile));
		BufferedReader brdrs = new BufferedReader(new FileReader(dersFile));
		
		String okudu;
		String[] dizi, dizi1;
		int kontrol =1;
		String isim1 = null;
		int id1=0, yas=0;
		
		while((okudu = brdrs.readLine()) != null) {
			dizi = okudu.split("%");
			id1 = Integer.parseInt(dizi[0]);
			isim1 = dizi[1];
			mdersler.add(new Ders(isim1));
		}
		brdrs.close();
		
		
		while((okudu = brogr.readLine()) != null) {

			String isim2;
			if(kontrol==1 && okudu.charAt(0) == '+') {
				okudu = okudu.substring(1);
				dizi = okudu.split("%");
				id1 = Integer.parseInt(dizi[0]);
				isim1 = dizi[1];
				yas = Integer.parseInt(dizi[2]);
				kontrol = 0;
			}
			else if(kontrol == 0 && okudu.charAt(0) == '*') {
				okudu = okudu.substring(1);
				dizi1 = okudu.split("%");
				isim2 = dizi1[1];
				
				for(Ders temp3: mdersler) {
					if(temp3.getDersAd().equals(isim2)) {
						dersler.add(temp3);
						aldersler.add(temp3);
					}
				}
			}
			else if(kontrol == 0 && okudu.charAt(0) == '+') {
				ogrenciler.add(new Ogrenci(id1,isim1,yas,dersler));
				dersler.clear();
				okudu = okudu.substring(1);
				dizi = okudu.split("%");
				id1 = Integer.parseInt(dizi[0]);
				isim1 = dizi[1];
				yas = Integer.parseInt(dizi[2]);
			}
		}
		brogr.close();
		
		/*for (Ogrenci temp: ogrenciler) {
			System.out.println("Ad: "+temp.getOgrAdSoyad());
			System.out.println("ID: "+temp.getOgrId());
			System.out.println("Yas: "+temp.getOgrYas());
			
			for (Ders temp1: temp.getAlinanDersler()) {
				System.out.println("Ders Ad: "+temp1.getDersAd());
				System.out.println("ID: "+temp1.getDersId());
			}
			System.out.println("\n");
		}
		
		System.out.println("\n\n");
		
		for (Ders temp: mdersler) {
			System.out.println("Ad: "+temp.getDersAd());
			System.out.println("ID: "+temp.getDersId()+"\n");
		}*/
		
		
		while(true) {
			System.out.println("Ana Menü"
					+ "\n1- Ders Ekle\n"
					+ "2- Ders Listele\n"
					+ "3- Ders Ara\n"
					+ "4- Ders Sil\n"
					+ "5- Öğrenci Ekle\n"
					+ "6- Öğrenci Ara\n"
					+ "7- Öğrenci Sil\n"
					+ "8- Öğrenci Listele\n"
					+ "9- Öğrencileri Ayrıntılı Listele\n"
					+ "10- Öğrencilerin Ödeyeceği Tutarı Hesapla\n"
					+ "11- Çıkış\n\n");
			
			System.out.println("Seçiminiz: ");
			int secim = scan.nextInt();
			
			if(secim==1) {
				System.out.println("\nDers ismi giriniz: ");
				scan.nextLine();
				String ad = scan.nextLine();
				
				mdersler.add(new Ders(ad));
				System.out.println("\nDers ekleme işlemi tamamlandı.");
			}
			
			else if(secim==2) {
				System.out.println("Ders Id     Ders Adı");
				for (Ders temp: mdersler) {
					System.out.println(temp.getDersId()+"       "+temp.getDersAd());
				}
			}
			
			else if(secim==3) {
				int kontroll = 1;
				System.out.println("Ders adı giriniz: ");
				scan.nextLine();
				String ad = scan.nextLine();
				for (Ders temp: mdersler) {
					if(temp.getDersAd().equals(ad)) {
						System.out.println("Ders Adı: "+temp.getDersAd());
						System.out.println("Ders ID: "+temp.getDersId());
						kontroll = 0;
					}
				}
				if(kontroll == 1) {
					System.out.println("Ders bulunamadı.");
				}
				
			}
			
			else if(secim==4) {
				int syc = 1, syc1=1;
				int index;
				System.out.println("Ders adı giriniz: ");
				String ad = scan.next();
				
				for (Ders temp: mdersler) {
					if(temp.getDersAd().equals(ad)) {
						index = mdersler.indexOf(temp);
						for (Ders temp2: aldersler) {
							if(temp2.getDersAd().equals(ad)) {
								System.out.println("Bu dersi alanlar var, silinemez");
								syc = 0;
								syc1 = 0;
								break;
							}
						}
						if(syc == 1) {
							mdersler.remove(index);
							System.out.println("Ders silindi.");
							break;
						}
					}
				}
				if(syc1==1){
					System.out.println("Böyle bir ders yok");
				}
			}
			
			else if(secim==5) {
				int id;
				while(true) {
					System.out.println("Öğrenci ID giriniz: ");
					id = scan.nextInt();
					int syc1=0;
					for(Ogrenci temp: ogrenciler) {
						if(temp.getOgrId() == id) {
							System.out.println("Bu id var yeniden dene.");
							syc1 = 1;
						}
					}
					if(syc1==0) {
						break;
					}
				}
				System.out.println("Öğrenci adı giriniz: ");
				scan.nextLine();
				String isim = scan.nextLine();
				System.out.println("Öğrenci yaşı giriniz: ");
				int yas1 = scan.nextInt();
				
				ArrayList<Ders> temp_ders = new ArrayList<Ders>();
				System.out.println("Kaç ders? ->");
				int secimm = scan.nextInt();
				
				String ismim;
				for(int i = 0; i<secimm;i++) {
					while(true) {
						System.out.println("Ders adı giriniz: ");
						ismim = scan.next();
						int syc1=0;
						for(Ders temp: mdersler) {
							if(temp.getDersAd().equals(ismim)) {
								syc1 = 1;
							}
						}
						if(syc1==0) {
							System.out.println("Böyle ders yok yeniden dene.");
						}
						if(syc1==1) {
							break;
						}
					}
					for(Ders temp3: mdersler) {
						if(temp3.getDersAd().equals(ismim)) {
							temp_ders.add(temp3);
							aldersler.add(temp3);
						}
					}
				}
				ogrenciler.add(new Ogrenci(id,isim,yas1,temp_ders));
				
				
			}
			
			else if(secim==6) {
				int kontroll = 1;
				System.out.println("Öğrenci adı giriniz: ");
				scan.nextLine();
				String ad = scan.nextLine();
				for (Ogrenci temp: ogrenciler) {
					if(temp.getOgrAdSoyad().equals(ad)) {
						System.out.println("Ad: "+temp.getOgrAdSoyad());
						System.out.println("ID: "+temp.getOgrId());
						System.out.println("Yas: "+temp.getOgrYas());
						
						for (Ders temp1: temp.getAlinanDersler()) {
							System.out.println("Ders Ad: "+temp1.getDersAd());
							System.out.println("ID: "+temp1.getDersId());
						}
						System.out.println("\n");
						kontroll = 0;
					}
				}
				if(kontroll == 1) {
					System.out.println("Öğrenci bulunamadı.");
				}
			}
			
			else if(secim==7) {
				int syc = 1;
				int index = 0;
				System.out.println("Öğrenci ID giriniz: ");
				int id = scan.nextInt();
				
				for (int i = 0; i < ogrenciler.size(); i++) {
		            if (ogrenciler.get(i).getOgrId() == id) {
		            	ogrenciler.remove(ogrenciler.get(i));
		            	syc=0;
		            }
		        }
				
				/*for (Ogrenci temp: ogrenciler) {
					if(temp.getOgrId() == id) {
						index = ogrenciler.indexOf(temp);
						System.out.println(index);
						ogrenciler.remove(index);
						syc=0;
					}
				}*/
				
				if(syc == 1){
					System.out.println("Böyle bir öğrenci yok");
				}
			}
			
			else if(secim==8) {
				System.out.println("Tüm Öğrenciler");
				for (Ogrenci temp: ogrenciler) {
					System.out.println(temp.getOgrId()+" "+temp.getOgrAdSoyad()+" "+temp.getOgrYas());
				}
			}
			
			else if(secim==9) {
				System.out.println("Tüm Öğrenciler ve Aldıkları Dersler");
				for (Ogrenci temp: ogrenciler) {
					System.out.println(temp.getOgrAdSoyad()+" "+temp.getOgrId()+" "+temp.getOgrYas());
					
					for (Ders temp1: temp.getAlinanDersler()) {
						System.out.println("     "+temp1.getDersId()+" "+temp1.getDersAd());
					}
				}
			}
			
			else if(secim==10) {
				System.out.println("Öğrenci ID giriniz: ");
				int id = scan.nextInt();
				int syc = 0;
				for (Ogrenci temp: ogrenciler) {
					if(temp.getOgrId() == id) {
						for (Ders temp1: temp.getAlinanDersler()) {
							syc++;
						}
						if(syc==1) {
							System.out.println("Tek ders için indirim yoktur.");
						}
						else if(syc==2) {
							System.out.println("780 TL, Kampanya 1, Öğrenci Adı: "+temp.getOgrAdSoyad());
						}else if(syc==3) {
							System.out.println("1140 TL, Kampanya 2, Öğrenci Adı: "+temp.getOgrAdSoyad());
						}else if(syc>3) {
							int toplam = 0;
							for(int i=0; i<syc; i++) {
								toplam+=360;
							}
							System.out.println(toplam+" TL, Kampanya 3, Öğrenci Adı: "+temp.getOgrAdSoyad());
						}
					}
				}
			}
			else if(secim==11) {
				
				BufferedWriter bwogr = new BufferedWriter(new FileWriter(ogrFile));
				BufferedWriter bwdrs = new BufferedWriter(new FileWriter(dersFile));
				
				for(Ders temp: mdersler)
				{
					bwdrs.write(temp.getDersId()+"%"+temp.getDersAd()+"\n");
				}
				bwdrs.flush();
				System.out.println("\nDers Dosya yeniden yazıldı. Program sonlandırıldı.");
				
				for(Ogrenci temp: ogrenciler)
				{
					bwogr.write("+"+temp.getOgrId()+"%"+temp.getOgrAdSoyad()+"%"+temp.getOgrYas()+"\n");
					for (Ders temp1: temp.getAlinanDersler()) {
						bwogr.write("*"+temp1.getDersId()+"%"+temp1.getDersAd()+"\n");
					}
				}
				bwogr.flush();
				System.out.println("\nÖğrenci Dosya yeniden yazıldı. Program sonlandırıldı.");
				
				return;
			}
			else
			{
				System.out.println("\nHatalı tuşlama yaptınız, yeniden deneyiniz.");
			}
			
			System.out.println("\nAna menüye yönlendiriliyorsunuz. Herhangi bir harfe ve ardından Enter tuşuna tıklayınız.");
		}
		
		
		
		
		
		
		

	}

}
