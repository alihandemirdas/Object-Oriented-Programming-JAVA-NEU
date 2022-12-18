package odev1;

import java.util.Scanner;

public class Anasayfa {
	
	public static void clearConsole() {
		for (int i = 0; i < 400; i++) {
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Kaç adet departman ekleyeceksiniz: ");
		int depSayi = scan.nextInt();
		Departman[] departman = new Departman[depSayi];
		
		for (int i = 0; i < depSayi; i++) {
			departman[i] = new Departman();
			System.out.println("\nDepartman No Giriniz: ");
			departman[i].setDepNo(scan.nextInt());
			
			System.out.println("\nDepartman Adı Giriniz: ");
			departman[i].setDepAd(scan.next());
		}
		
		System.out.println("\n\nDepartman no ve ad bilgileri alındı.\n");
		
		for (int i = 0; i < depSayi; i++) {
			System.out.println("\n"+departman[i].getDepNo()+" Nolu Departman İçin Personel Sayısı Giriniz: ");
			int sayi = scan.nextInt();
			departman[i].personeller = new Personel[sayi];
			
			for (int j = 0; j < sayi; j++) {
				departman[i].personeller[j] = new Personel();
				departman[i].personeller[j].setDepNo(departman[i].getDepNo());
				
				System.out.println("\nPersonel Adı Giriniz: ");
				departman[i].personeller[j].setPerAd(scan.next());
				
				System.out.println("\nPersonel Soyadı Giriniz: ");
				departman[i].personeller[j].setPerSoyad(scan.next());
				
				System.out.println("\nPersonel Yaşı Giriniz: ");
				departman[i].personeller[j].setPerYas(scan.nextInt());
			}
		}
		
		System.out.println("\n\nDepartmanlar için personel bilgileri alındı.\n");
		
		for (int i = 0; i < depSayi; i++) {
			System.out.println("\n"+departman[i].getDepNo()+" Nolu Departman İçin Proje Sayısı Giriniz: ");
			int sayi = scan.nextInt();
			departman[i].projeler = new Proje[sayi];
			
			for (int j = 0; j < sayi; j++) {
				departman[i].projeler[j] = new Proje();
				departman[i].projeler[j].setDepNo(departman[i].getDepNo());
				
				System.out.println("\nProje Adı Giriniz: ");
				departman[i].projeler[j].setProjeAd(scan.next());
				
				System.out.println("\nProje Süresi Giriniz (Ay): ");
				departman[i].projeler[j].setProjeSure(scan.nextInt());
				
				System.out.println("\nProje Maliyet Giriniz (Türk Lirası): ");
				departman[i].projeler[j].setProjeMaliyet(scan.nextInt());
			}
		}
		
		System.out.println("\n\nDepartmanlar için proje bilgileri alındı.");
		
		//Alttaki yorum satırındaki kod kendi kendime yazdığım test kodudur.
		
		/*for (int i = 0; i < depSayi; i++) {
			System.out.println("\nDepartman No: "+departman[i].getDepNo());
			System.out.println("Departman Adı: "+departman[i].getDepAd());
			
			for (int j = 0; j < departman[i].personeller.length; j++) {
				System.out.println("\nPersonel Departman No: "+departman[i].personeller[j].getDepNo());
				System.out.println("Personel ID: "+departman[i].personeller[j].getPerID());
				System.out.println("Personel Ad: "+departman[i].personeller[j].getPerAd());
				System.out.println("Personel Soyad: "+departman[i].personeller[j].getPerSoyad());
				System.out.println("Personel Yaş: "+departman[i].personeller[j].getPerYas());
			}
			
			for (int j = 0; j < departman[i].projeler.length; j++) {
				System.out.println("\nProje Departman No: "+departman[i].projeler[j].getDepNo());
				System.out.println("Proje Id: "+departman[i].projeler[j].getProjeID());
				System.out.println("Proje Ad: "+departman[i].projeler[j].getProjeAd());
				System.out.println("Proje Süre: "+departman[i].projeler[j].getProjeSure());
				System.out.println("Proje Maliyet: "+departman[i].projeler[j].getProjeMaliyet());
				
			}

		}*/
		
		
		while(true) {
			clearConsole();
			System.out.println("Ana Menü"
					+ "\n1- Tüm Departmanların Bilgilerini Listele\n"
					+ "2- Departman Adına Göre Arama Yap\n"
					+ "3- Personel Adına Göre Arama Yap\n"
					+ "4- Proje Adına Göre Arama Yap\n"
					+ "5- Yaş Bilgisine Göre Personelleri Bul\n"
					+ "6- Yaş Bilgisine Göre Personelleri Analiz Et\n"
					+ "7- Proje Süresine Göre Projeleri Bul\n"
					+ "8- Proje Maliyetine Göre Projeleri Bul\n"
					+ "9- Proje Maliyetine Göre Projeleri Analiz Et\n"
					+ "10- Çıkış\n\n");
			
			System.out.println("Seçiminiz: ");
			int secim = scan.nextInt();
			
			if(secim==1)
			{
				clearConsole();
				for (int i = 0; i < depSayi; i++) {
					System.out.println("\nDepartman No: "+departman[i].getDepNo()+" Departman Ad: "+departman[i].getDepAd());
					System.out.println("\nPersoneller:");
					
					for (int j = 0; j < departman[i].personeller.length; j++) {
						System.out.println("\n"+(j+1)+".Personel: "+departman[i].personeller[j].getPerID()+" "+departman[i].personeller[j].getPerAd()
								+" "+departman[i].personeller[j].getPerSoyad()+" "+departman[i].personeller[j].getPerYas());
					}
					System.out.println("\nProjeler:");
					for (int j = 0; j < departman[i].projeler.length; j++) {
						System.out.println("\n"+(j+1)+".Proje: "+departman[i].projeler[j].getProjeID()+" "+departman[i].projeler[j].getProjeAd()
								+" "+departman[i].projeler[j].getProjeSure()+" "+departman[i].projeler[j].getProjeMaliyet());					
					}
					
					System.out.println("\n");
				}
			}
			
			else if(secim==2)
			{
				clearConsole();
				System.out.println("Aranacak departman adı giriniz: ");
				String aranacak = scan.next();
				int kontrol = 1;
				
				for (int i = 0; i < depSayi; i++)
				{
					if (departman[i].getDepAd().equals(aranacak)) {
						System.out.println("\nDepartman No: "+departman[i].getDepNo()+" Departman Ad: "+departman[i].getDepAd());
						System.out.println("\nPersoneller:");
						
						for (int j = 0; j < departman[i].personeller.length; j++) {
							System.out.println("\n"+(j+1)+".Personel: "+departman[i].personeller[j].getPerID()+" "+departman[i].personeller[j].getPerAd()
									+" "+departman[i].personeller[j].getPerSoyad()+" "+departman[i].personeller[j].getPerYas());
						}
						System.out.println("\nProjeler:");
						for (int j = 0; j < departman[i].projeler.length; j++) {
							System.out.println("\n"+(j+1)+".Proje: "+departman[i].projeler[j].getProjeID()+" "+departman[i].projeler[j].getProjeAd()
									+" "+departman[i].projeler[j].getProjeSure()+" "+departman[i].projeler[j].getProjeMaliyet());					
						}
						kontrol = 0;
					}
				}
				
				if (kontrol == 1) {
					System.out.println("\nAradığınız departman bulunamadı.");
				}
				
			}
			
			else if(secim==3)
			{
				clearConsole();
				System.out.println("Aranacak personel adı giriniz: ");
				String aranacak = scan.next();
				int kontrol = 1;
				
				for (int i = 0; i < depSayi; i++)
				{
					for (int j = 0; j < departman[i].personeller.length; j++) {
						
						if (departman[i].personeller[j].getPerAd().equals(aranacak)) {
							System.out.println("\nDepartman No: "+departman[i].getDepNo()+" Departman Ad: "+departman[i].getDepAd());
							System.out.println("\n"+(j+1)+".Personel: "+departman[i].personeller[j].getPerID()+" "+departman[i].personeller[j].getPerAd()
									+" "+departman[i].personeller[j].getPerSoyad()+" "+departman[i].personeller[j].getPerYas());
							kontrol = 0;
						}						
					}
				}
				
				if (kontrol == 1) {
					System.out.println("\nAradığınız personel/personeller bulunamadı.");
				}
			}
			
			else if(secim==4)
			{
				
				clearConsole();
				System.out.println("Aranacak proje adı giriniz: ");
				String aranacak = scan.next();
				int kontrol = 1;
				
				for (int i = 0; i < depSayi; i++)
				{
					for (int j = 0; j < departman[i].projeler.length; j++) {
						
						if (departman[i].projeler[j].getProjeAd().equals(aranacak)) {
							System.out.println("\nDepartman No: "+departman[i].getDepNo()+" Departman Ad: "+departman[i].getDepAd());
							System.out.println("\n"+(j+1)+".Proje: "+departman[i].projeler[j].getProjeID()+" "+departman[i].projeler[j].getProjeAd()
									+" "+departman[i].projeler[j].getProjeSure()+" "+departman[i].projeler[j].getProjeMaliyet());
							kontrol = 0;
						}						
					}
				}
				
				if (kontrol == 1) {
					System.out.println("\nAradığınız proje/projeler bulunamadı.");
				}
				
			}
			
			else if(secim==5)
			{
				
				clearConsole();
				System.out.println("Aranacak personellerin yaşını giriniz: ");
				int aranacak = scan.nextInt();
				int kontrol = 1;
				
				for (int i = 0; i < depSayi; i++)
				{
					for (int j = 0; j < departman[i].personeller.length; j++) {
						
						if (aranacak == departman[i].personeller[j].getPerYas()) {
							System.out.println("\nDepartman No: "+departman[i].getDepNo()+" Departman Ad: "+departman[i].getDepAd());
							System.out.println("\n"+(j+1)+".Personel: "+departman[i].personeller[j].getPerID()+" "+departman[i].personeller[j].getPerAd()
									+" "+departman[i].personeller[j].getPerSoyad()+" "+departman[i].personeller[j].getPerYas());
							kontrol = 0;
						}						
					}
				}
				
				if (kontrol == 1) {
					System.out.println("\nAradığınız yaştaki personel/personeller bulunamadı.");
				}
				
			}
			
			else if(secim==6)
			{
				
				clearConsole();
				int bir=0,iki=0,uc=0,dort=0; //bir: 20-30, iki: 31-40, uc: 41-50, dort: >50
				int toplam = 0,sayac=0;
				
				for (int i = 0; i < depSayi; i++)
				{
					for (int j = 0; j < departman[i].personeller.length; j++) {
						
						toplam += departman[i].personeller[j].getPerYas();
						sayac++;
						
						if (departman[i].personeller[j].getPerYas() > 50) {
							dort++;
						}
						else if(departman[i].personeller[j].getPerYas() > 40){
							uc++;
						}
						else if(departman[i].personeller[j].getPerYas() > 30){
							iki++;
						}
						else if(departman[i].personeller[j].getPerYas() >= 20){
							bir++;
						}
					}
				}
				
				System.out.println("20-30 Yaş Aralığındaki Personel Sayısı: "+bir);
				System.out.println("\n31-40 Yaş Aralığındaki Personel Sayısı: "+iki);
				System.out.println("\n41-50 Yaş Aralığındaki Personel Sayısı: "+uc);
				System.out.println("\n>50 Personel Sayısı: "+dort);
				System.out.println("\n-----------------------------------------------------------");
				System.out.println("\nTüm Personellerin Yaş Ortalaması: "+(toplam/sayac));
				
			}
			
			else if(secim==7)
			{
				
				clearConsole();
				System.out.println("Aranacak süre giriniz: ");
				int aranacak = scan.nextInt();
				int kontrol = 1;
				
				for (int i = 0; i < depSayi; i++)
				{
					for (int j = 0; j < departman[i].projeler.length; j++) {
						
						if (aranacak == departman[i].projeler[j].getProjeSure()) {
							System.out.println("\nDepartman No: "+departman[i].getDepNo()+" Departman Ad: "+departman[i].getDepAd());
							System.out.println("\n"+(j+1)+".Proje: "+departman[i].projeler[j].getProjeID()+" "+departman[i].projeler[j].getProjeAd()
									+" "+departman[i].projeler[j].getProjeSure()+" "+departman[i].projeler[j].getProjeMaliyet());
							kontrol = 0;
						}						
					}
				}
				
				if (kontrol == 1) {
					System.out.println("\nAradığınız süreye sahip proje/projeler bulunamadı.");
				}
				
			}
			
			else if(secim==8)
			{
				
				clearConsole();
				System.out.println("Aranacak maliyet giriniz: ");
				int aranacak = scan.nextInt();
				int kontrol = 1;
				
				for (int i = 0; i < depSayi; i++)
				{
					for (int j = 0; j < departman[i].projeler.length; j++) {
						
						if (aranacak == departman[i].projeler[j].getProjeMaliyet()) {
							System.out.println("\nDepartman No: "+departman[i].getDepNo()+" Departman Ad: "+departman[i].getDepAd());
							System.out.println("\n"+(j+1)+".Proje: "+departman[i].projeler[j].getProjeID()+" "+departman[i].projeler[j].getProjeAd()
									+" "+departman[i].projeler[j].getProjeSure()+" "+departman[i].projeler[j].getProjeMaliyet());
							kontrol = 0;
						}						
					}
				}
				
				if (kontrol == 1) {
					System.out.println("\nAradığınız maliyete sahip proje/projeler bulunamadı.");
				}
				
			}
			
			else if(secim==9)
			{
				int buyuk = 0, kucuk=departman[0].projeler[0].getProjeMaliyet();
				int toplam=0, sayac=0;
				String ad1="a", ad2="b";
				
				for (int i = 0; i < depSayi; i++)
				{
					for (int j = 0; j < departman[i].projeler.length; j++) {
						
						toplam += departman[i].projeler[j].getProjeMaliyet();
						sayac++;
						
						if (departman[i].projeler[j].getProjeMaliyet() > buyuk) {
							buyuk = departman[i].projeler[j].getProjeMaliyet();
							ad1 = departman[i].projeler[j].getProjeAd();
						}
						
					}
				}
				
				for (int i = 0; i < depSayi; i++)
				{
					for (int j = 0; j < departman[i].projeler.length; j++) {
						
						if (departman[i].projeler[j].getProjeMaliyet() < kucuk) {
							kucuk = departman[i].projeler[j].getProjeMaliyet();
							ad2 = departman[i].projeler[j].getProjeAd();
						}
						
					}
				}
				
				System.out.println("En Yüksek Maliyetli Proje: "+ad1+" "+buyuk);
				System.out.println("\nEn Düşük Maliyetli Proje: "+ad2+" "+kucuk);
				System.out.println("\n-----------------------------------------------------------");
				System.out.println("\nTüm Projelerin Ortalama Maliyeti: "+(toplam/sayac));
						
			}
			
			else if(secim==10)
			{
				System.out.println("\nProgram sonlandırıldı.");
				scan.close();
				return;
			}
			
			else
			{
				System.out.println("\nHatalı tuşlama yaptınız, yeniden deneyiniz.");
			}
			
			System.out.println("\nAna menüye yönlendiriliyorsunuz. Herhangi bir harfe ve ardından Enter tuşuna tıklayınız.");
			scan.next();
			
		}
		
		
		
		
		
		
		
		
		
		

	}

}
