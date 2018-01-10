package fields;

import java.awt.*;

import model.Player;

public class IncomeTaxField extends TaxField {

    public IncomeTaxField(String newName, Color primary, Color secondary){
        super(newName, primary, secondary);
        type = 2;
    }


    public int getType() {
    	return type;
    }
    public String getDescription() {
    	return "Betal indkomstskat: 10% eller kr 4000"+description;
    }
}
