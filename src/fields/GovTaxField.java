package fields;

import java.awt.*;

import model.Player;

public class GovTaxField extends TaxField {

    public GovTaxField(String newName, Color primary, Color secondary){
        super(newName, primary, secondary);
        type = 3;
    }

    public void landOnField(Player landingPlayer){

        //to do later
        //landingPlayer.add(-1000);
    }
    public int getType() {
    	return type;
    }


}
