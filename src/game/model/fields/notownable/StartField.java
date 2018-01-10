package game.model.fields.notownable;

import java.awt.Color;

public class StartField extends NotOwnable {

	public StartField(String newName, Color primary, Color secondary) {
		super(newName, primary, secondary);

		type = 0;
	}

    public int getType() {
    	return type;
    }

}
