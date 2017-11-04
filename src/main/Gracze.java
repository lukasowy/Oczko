package main;

public class Gracze {

	public String imie;

	public Karty[] maxIloscKartwReku = new Karty[10];

	public int iloscKartwReku = 0;

	public int sumaPunktowKart = 0;

	public boolean czyKoniec = false;

	public Gracze(String pImie) {
		this.imie = pImie;

		for (int i = 0; i < 10; i++) {
			maxIloscKartwReku[i] = null;
		}
		iloscKartwReku = 0;

	}

	// wydanie kart graczowi
	public boolean dajKarteGraczowi(Karty pKarta) {
		int numerKarty = 0;

		if (iloscKartwReku == 10) {
			System.out.println("Gracz ma w reku 10 kart i nie moze dobrac kolejnej");
			System.exit(1);
		}

		maxIloscKartwReku[iloscKartwReku] = pKarta;
		iloscKartwReku++;

		numerKarty = pKarta.getNumerKarty();

		if (numerKarty == 1) {
			// mamy asa
			sumaPunktowKart += 11;
		} else if (numerKarty > 10) {
			// mamy karty od Waleta do Króla
			sumaPunktowKart += 10;
		} else {
			// mamy karte od 2 do 10
			sumaPunktowKart += numerKarty;
		}
		if (sumaPunktowKart == 21 || sumaPunktowKart > 21) {
			czyKoniec = true;
		}
		return czyKoniec;
	}

	// pokaz karty gracza
	public void pokazkartyGracza() {
		System.out.printf("%s ma karty: \n", imie);
		for (int i = 0; i < iloscKartwReku; i++) {
			System.out.printf("%s\n", maxIloscKartwReku[i].toString());
		}
	}
	
	//pokaz sume punktow
	public int getSumaPunktowKart() {
		return sumaPunktowKart;
	}
}
