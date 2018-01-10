package game.model.fields.notownable;

import java.awt.*;

public class PrisonField extends NotOwnable {

	    public PrisonField(String newName, Color primary, Color secondary){
	        super(newName, primary, secondary);
	        type = 8;
	        
	        description = "De ryger i fængsel, ryk frem til fængsel. De modtager ikke kr 4000 ved passering af start";
	        subText = "De fængsles";
	    }
}
