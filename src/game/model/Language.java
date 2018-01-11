package game.model;

import game.model.fields.ownable.OwnableField;

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
	public static String roll(Player player) {
		return "Det er "+player.getName()+"'s tur!";
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
	    String[] names = new String[40];

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
    public static String[] chanceStrings(){
        String[] strings = new String[23];

        strings[0] = "Modtag 3000 kr. af banken";
        strings[1] = "Modtag 500 kr. fra hver spiller";
        strings[2] = "Ryk til start";
        strings[3] = "Ryk 3 felter tilbage";
        strings[4] = "Modtag 1000 kr. af banken";
        strings[5] = "Modtag 200 kr. af banken";
        strings[6] = "Betal 1000 kr. af banken";
        strings[7] = "Ryk 3 felter frem";
        strings[8] = "Betal 3000 kr.";
        strings[9] = "Betal 300 kr.";
        strings[10] = "Betal 2000 kr.";
        strings[11] = "Modtag 200 kr. fra hver spiller";
        strings[12] = "Ryk i fængsel";
        strings[13] = "Modtag 500 kr. af banken";
        strings[14] = "Ryk til den nærmeste færge, modtag 4000 hvis start passeres";
        strings[15] = "Ryk til Mols-linjen, modtag 4000 hvis start passeres";
        strings[16] = "Ryk frem til Frederiksberg allé modtag 4000 hvis start passeres";
        strings[17] = "Ryk frem til Strandvejen, modtag 4000 hvis start passeres";
        strings[18] = "Ryk frem til Rådhuspladsen";
        strings[19] = "Ryk frem til Vimmelskaftet, modtag 4000 hvis start passeres";
        strings[20] = "Ryk frem til Grønningen, modtag 4000 hvis start passeres";
        strings[21] = "Betal 200 kr.";
        strings[22] = "Modtag fængselskort";

        return strings;
    }
    public static String error(){
	    return "Der er gået noget galt";
    }
    public static String payRent(){
	    return " betaler leje til ";
    }
    public static String taxType(){
    	return "Vil du betale 10% eller 4000kr";
    }
    public static String scaling() {
        return "10 Procent";
    }
    public static String flat() {
        return "4000 kr.";
    }
    public static String payTax(){
	    return "Du skal betale 4000kr til banken";
    }

    public static String jailDesc() {
        return "De sidder i fængsel. slå 2 ens, betal kr 1000 eller anvend dit løsladeskort hvis haves. Hvis der slås 2 ens rykker de det antal felter frem.";
    }

    public static String visit() {
	    return "På besøg";
    }

    public static String parking() {
	    return "Parkering";
    }

    public static String parkingDesc() {
	    return "GØR NOGET VED DINE DRØMME!";
    }

    public static String jailed() {
        return "De ryger i fængsel, ryk frem til fængsel. De modtager ikke kr 4000 ved passering af start";
    }

    public static String jailSub() {
	    return "De fængsles";
    }

    public static String bankrupt() {
	    return "De er desværre gået bankerot";
    }

    public static String currentlyJailed() {
	    return "De sidder i fængsel, slå to ens eller brug et kom-gratis-ud-af-fængsel kort";
    }

    public static String useJailCard() {
        return "Vil de bruge deres kom-gratis-ud-af-fængsel kort?";
    }

    public static String payBail() {
	    return "Vil de betale kautionen for at komme ud omgående?";
    }

    public static String rollForJail() {
	    return "Slå om at komme ud af fængsel";
    }

    public static String jailEscapeSuccess() {
        return "Du kom ud af fængsel";
    }

    public static String jailEscapeFail() {
	    return "Du kom ikke ud af fængslet i denne omgang";
    }

    public static String jailTooLong() {
	    return "De har siddet for længe i fængsel, de må betale kautionen";
    }

    public static String diceThrowFormat(int faceValue) {
        return "Du slog " + faceValue;
    }

    public static String fieldMortgaged() {
	    return "Feltet du er landet på er pantsat, så intet sker.";
    }

    public static String tooLucky() {
	    return "Du har slået dobbelt 3 gange i træk og ryger derfor i fængsel";
    }

    public static String chooseForMortgage(int left) {
	    return "Hvilken grund ønsker de at pantsætte? Der mangler: " + Math.abs(left) + " kr.";
    }

    public static String getCurrency() {
	    return "kr.";
    }

    public static String notEnoughMoney() {
	    return "Du har ikke nok penge";
    }

    public static String wantToBuild() {
	    return "Ønsker de at bygge huse/hoteller?";
    }

    public static String chooseForBuild() {
	    return "Hvilket felt ønskes opgraderet?";
    }

    public static String gameEnd(Player curPlayer) {
	    return "Spillet er slut! " + curPlayer.getName() + " vinder!";
    }
}
