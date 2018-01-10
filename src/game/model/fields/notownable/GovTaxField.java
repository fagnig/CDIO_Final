package game.model.fields.notownable;

import java.awt.*;

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
