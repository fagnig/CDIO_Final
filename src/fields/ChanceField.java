package fields;

import java.awt.Color;

import model.Player;

public class ChanceField extends NeutralField {

	public ChanceField(String newName, Color primary, Color secondary) {
		super(newName, primary, secondary);
		// TODO Auto-generated constructor stub
		type = 1;
		subText = "prøv lykken";
		description = subText;
	}

	@Override
	public void landOnField(Player landingPlayer) {
		// TODO Auto-generated method stub
		
	}
    public int getType() {
    	return type;
    }

}
