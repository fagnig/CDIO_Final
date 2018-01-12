package game.model.fields.notownable;

import game.model.Language;

import java.awt.Color;

public class RefugeField extends NotOwnableField {

	public RefugeField(String newName, Color primary, Color secondary) {
		super(newName, primary, secondary);

		description = Language.parkingDesc();
		subText = Language.parking();
	}

}
