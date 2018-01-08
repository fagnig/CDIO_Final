package model;

public class Language {
	public static String yes() {
		return "Ja";
	}
	
	public static String no() {
		return "Nej";
	}
	public static String numberOfPlayers() {
		return "Hvor mange spillere er i? (2 - 6)";
	}
	public static String okay() {
		return "Okay";
	}
	public static String invalidPlayers() {
		return "Ugyldigt antal spillere, prøv igen";
	}
	public static String player() {
		return "Spiller";
	}
	public static String realName() {
		return "Indtast et rigtigt navn";
	}
	public static String name() {
		return "hedder hvad?";
	}
	public static String pickColor() {
		return "Vælg en farve";
	}
	public static String red() {
		return "Rød";
	}
	public static String blue() {
		return "Blå";
	}
	public static String gray() {
		return "Grå";
	}
	public static String yellow() {
		return "Gul";
	}
	public static String cyan() {
		return "Cyan";
	}
	public static String pink() {
		return "Pink";
	}
	public static String getFormattedDescription(int[] dat){
		String tempStr = "Leje: " + Integer.toString(dat[0]) +
				"\n 1 Hus: " + Integer.toString(dat[1]) +
				"\n 2 Huse: " + Integer.toString(dat[2]) +
				"\n 3 Huse: " + Integer.toString(dat[3]) +
				"\n 4 Huse: " + Integer.toString(dat[4]) +
				"\n Hotel: " + Integer.toString(dat[5]);
		return tempStr;
	}
}
