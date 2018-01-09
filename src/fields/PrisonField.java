package fields;

import java.awt.*;

import model.Player;

public class PrisonField extends Field{

	    public PrisonField(String newName, Color primary, Color secondary){
	        super(newName, primary, secondary);
	        type = 8;
	    }

	    public int getType() {
	    	return type;
	    }

		@Override
		public void landOnField(Player landingPlayer) {
			// TODO Auto-generated method stub
			
		}
		public String getSubText() {
			return "De fængsles"+subText;
		}
}
