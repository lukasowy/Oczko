package main;

import java.util.Scanner;

public class Oczko {

	public static void main(String[] args) {
		Oczko o = new Oczko();
		o.start();
	}

	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Imiê: ");

		String imieGracza = sc.nextLine();

		Stol st = new Stol();

		Gracze gracz1 = new Gracze(imieGracza);
		Gracze gracz2 = new Gracze("CPU");

		gracz1.dajKarteGraczowi(st.gornaKarta());
		gracz2.dajKarteGraczowi(st.gornaKarta());

		gracz2.pokazkartyGracza();

		gracz1.dajKarteGraczowi(st.gornaKarta());
		gracz2.dajKarteGraczowi(st.gornaKarta());

		System.out.println("[Ukryta karta]\n");

		gracz1.pokazkartyGracza();

		System.out.println("Suma punktów: " + gracz1.getSumaPunktowKart() + "\n");

		boolean gracz1Stop = false;
		boolean gracz2Stop = false;

		String odp;
		while (!gracz1Stop || !gracz2Stop) {
			System.out.println("Dobierasz kartê czy pauzujesz? (D lub P)");
			odp = sc.nextLine();

			if (odp.compareToIgnoreCase("p") == 0) {
				gracz1Stop = gracz1.dajKarteGraczowi(st.gornaKarta());
				System.out.println("Suma punktów: " + gracz1.getSumaPunktowKart() + "\n");

				if (gracz1.getSumaPunktowKart() >= 21) {
					gracz1Stop = true;
				}
			} else {
				gracz1Stop = true;
			}

			if (!gracz2Stop) {
				if (gracz2.getSumaPunktowKart() < 19) {
					System.out.println("CPU dobiera karte\n");
					gracz2Stop = gracz2.dajKarteGraczowi(st.gornaKarta());

					if (gracz2.getSumaPunktowKart() >= 21) {
						gracz2Stop = true;
					}
				} else {
					System.out.println("CPU pauzuje\n");
					gracz2Stop = true;
				}
			}
		}

		gracz1.pokazkartyGracza();
		System.out.println("Suma punktów: " + gracz1.getSumaPunktowKart() + "\n");

		gracz2.pokazkartyGracza();
		System.out.println("Suma punktów: " + gracz2.getSumaPunktowKart() + "\n");

		if (gracz1.getSumaPunktowKart() > gracz2.getSumaPunktowKart() && gracz1.getSumaPunktowKart() <= 21
				|| gracz2.getSumaPunktowKart() > 21) {
			System.out.println(imieGracza + " wygrywa!");
		} else {
			System.out.println("CPU wygrywa!\n");
		}
		System.out.println("Jeszcze raz? (T lub N)");
		odp = sc.nextLine();
		if (odp.compareToIgnoreCase("N") == 0) {
			sc.close();
			System.exit(0);
		} else {
			start();
		}
	}
}
