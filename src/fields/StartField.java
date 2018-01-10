package fields;

import java.awt.Color;

import model.Player;
import java.awt.*;
public class StartField extends NeutralField {

	public StartField(String newName, Color primary, Color secondary) {
		super(newName, primary, secondary);

		type = 0;
	}

    public int getType() {
    	return type;
    }

}
