package main;

public class Karty {
	private Kolory kolor;
	private int numerKarty;

	public Karty(Kolory pKolor, int pNumer) {
		this.kolor = pKolor;
		if (pNumer < 1 || pNumer > 13) {
			System.out.println("Z³y numer karty!");
			System.exit(1);
		} else {
			this.numerKarty = pNumer;
		}
	}

	public int getNumerKarty() {
		return numerKarty;
	}

	@Override
	public String toString() {

		String numerToString = KartaToString.numToString(numerKarty);

		return " [" + kolor + " " + numerToString + "]";
	}

}
