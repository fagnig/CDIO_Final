package model;

public class Language {
	public static String yes() {
		return "Ja";
	}
	
	public static String no() {
		return "Nej";
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
