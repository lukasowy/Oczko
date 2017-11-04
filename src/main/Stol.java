package main;

import java.util.Random;

public class Stol {
	public Karty[] karty = null;
	int iloscKart = 52;

	public Stol() {
		karty = generujTalieKart();
		karty = tasowanieKart(karty);
	}

	public Karty[] generujTalieKart() {
		Karty[] tablicaKart = new Karty[iloscKart];
		int kartaIndex = 0;

		for (int x = 0; x < 4; x++) {
			for (int y = 1; y <= 13; y++) {
				tablicaKart[kartaIndex] = new Karty(Kolory.values()[x], y);
				kartaIndex++;
			}
		}

		return tablicaKart;
	}

	public Karty[] tasowanieKart(Karty[] pKarty) {
		Random rnd = new Random();

		Karty tempKarta = null;

		int tempIndeks;

		for (int x = 0; x < iloscKart; x++) {
			tempIndeks = rnd.nextInt(pKarty.length - 1 - 0) + 0;

			tempKarta = pKarty[x];
			pKarty[x] = pKarty[tempIndeks];
			pKarty[tempIndeks] = tempKarta;
		}
		return pKarty;
	}
	//wydaje dwie karty
	public Karty gornaKarta() {
		Karty topKarta = karty[0];
		
		for (int y = 1; y < iloscKart; y++) {
			karty[y-1] = karty[y];
			
		}
		karty[iloscKart - 1] = null;
		iloscKart--;
		
		return topKarta;
	}
	// pokaz wszystkie karty
	public void pokazWszystkieKarty(Karty[] pKarty) {
		for (int z = 0; z < iloscKart; z++) {
			System.out.printf("Karta " + (z + 1) + "%s\n", pKarty[z].toString());
		}

	}
}
