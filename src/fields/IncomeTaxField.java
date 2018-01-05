package fields;

import java.awt.*;

import model.Player;

public class IncomeTaxField extends TaxField {

    public IncomeTaxField(String newName, Color primary, Color secondary){
        super(newName, primary, secondary);
        type = 2;
    }

    public void landOnField(Player landingPlayer){
     //to do

    }
    public int getType() {
    	return type;
    }
}
