package fields;

import java.awt.Color;

import model.Player;

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
