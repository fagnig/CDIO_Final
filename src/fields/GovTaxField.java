package fields;

import java.awt.*;

import model.Player;

public class GovTaxField extends TaxField {

    public GovTaxField(String newName, Color primary, Color secondary){
        super(newName, primary, secondary);
        type = 3;
    }

    public int getType() {
    	return type;
    }
    
    public String getDescription() {
    	return "Ekstraordinær statsskat: Betal kr. 2000"+description;
    }


}
