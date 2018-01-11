package game.model.fields.notownable;

import java.awt.Color;

public class ChanceField extends NotOwnableField {

	public ChanceField(String newName, Color primary, Color secondary) {
		super(newName, primary, secondary);
		// TODO Auto-generated constructor stub
		type = 1;
		subText = "prøv lykken";
		description = subText;
	}

}
