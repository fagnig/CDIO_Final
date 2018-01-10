package game.model.fields.notownable;

import java.awt.Color;

public class RefugeField extends NeutralField {

	public RefugeField(String newName, Color primary, Color secondary) {
		super(newName, primary, secondary);
		// TODO Auto-generated constructor stub
		type = 7;
	}
	public int getType() {
		return type;
	}

}
