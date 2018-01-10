package model;

import fields.BuildableField;
import fields.OwnableField;

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
	public static String roll() {
		return "Rul med terningerne!";
	}
	public static String getFormattedDescription(int[] dat, int buildPrice){
		String tempStr = "Leje: " + Integer.toString(dat[0]) +
				" | 1 Hus: " + Integer.toString(dat[1]) +
				" | 2 Huse: " + Integer.toString(dat[2]) +
				" | 3 Huse: " + Integer.toString(dat[3]) +
				" | 4 Huse: " + Integer.toString(dat[4]) +
				" | Hotel: " + Integer.toString(dat[5]) +
				" | Pris på hus og hotel: " + Integer.toString(buildPrice);
		return tempStr;
	}
	public static String[] fieldNames(){
	    String [] names = new String[40];

        names[0] = "Start";
        names[1] = "Rødovrevej";
        names[2] = "Chance";
        names[3] = "Hvidovrevej";
        names[4] = "Indkomstskat";
        names[5] = "Redderiget Lindinger A/S";
        names[6] = "Roskildevej";
        names[7] = "Chance";
        names[8] = "Valby Langgade";
        names[9] = "Allégade";
        names[10] = "På besøg";
        names[11] = "Frederiksberg Allé";
        names[12] = "Tuborg";
        names[13] = "Bülowsvej";
        names[14] = "Gl. Kongevej";
        names[15] = "Mols - Linien";
        names[16] = "Bernstorffsvej";
        names[17] = "Chance";
        names[18] = "Hellerupvej";
        names[19] = "Strandvejen";
        names[20] = "Parkering";
        names[21] = "Trianglen";
        names[22] = "Chance";
        names[23] = "Østerbrogade";
        names[24] = "Grønningen";
        names[25] = "Gedser-Rostock";
        names[26] = "Bredgade";
        names[27] = "Kgs Nytorv";
        names[28] = "Carlsberg";
        names[29] = "Østergade";
        names[30] = "De fængsles";
        names[31] = "Amagertorv";
        names[32] = "Vimmelskaftet";
        names[33] = "Chance";
        names[34] = "Nygade";
        names[35] = "Rødby-Puttgarden";
        names[36] = "Chance";
        names[37] = "Frederiksberggade";
        names[38] = "Statsskat";
        names[39] = "Rådhuspladsen";
	    return names;
    }
    public static String wantToBuy(OwnableField field){
	    return "Vil du købe " + field.getName() + " for " + field.getPriceString() + ".";
    }
}
