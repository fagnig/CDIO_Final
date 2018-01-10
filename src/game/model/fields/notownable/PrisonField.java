package game.model.fields.notownable;

import game.model.Language;

import java.awt.*;

public class PrisonField extends NotOwnable {

	    public PrisonField(String newName, Color primary, Color secondary){
	        super(newName, primary, secondary);
	        type = 8;
	        
	        description = Language.jailed();
	        subText = Language.jailSub();
	    }
}
