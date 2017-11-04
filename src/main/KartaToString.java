package main;

public class KartaToString {
	public static String numToString(int pNumer) {
		String numerKarty = null;

		switch (pNumer) {
		case 2:
			numerKarty = "2";
			break;
		case 3:
			numerKarty = "3";
			break;
		case 4:
			numerKarty = "4";
			break;
		case 5:
			numerKarty = "5";
			break;
		case 6:
			numerKarty = "6";
			break;
		case 7:
			numerKarty = "7";
			break;
		case 8:
			numerKarty = "8";
			break;
		case 9:
			numerKarty = "9";
			break;
		case 10:
			numerKarty = "10";
			break;
		case 11:
			numerKarty = "Walet";
			break;
		case 12:
			numerKarty = "Dama";
			break;
		case 13:
			numerKarty = "Król";
			break;
		case 1:
			numerKarty = "AS";
			break;
		}
		return numerKarty;
	}
}
