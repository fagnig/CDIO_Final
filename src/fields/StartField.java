package fields;

import java.awt.Color;

import model.Player;

public class StartField extends NeutralField {

	public StartField(String newName, Color primary, Color secondary) {
		super(newName, primary, secondary);

		type = 0;
	}

	@Override
	public void landOnField(Player landingPlayer) {
		// TODO Auto-generated method stub
		
	}
    public int getType() {
    	return type;
    }

}
