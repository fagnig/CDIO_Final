package game.model.fields.notownable;

import java.awt.*;

public class IncomeTaxField extends TaxField {

    public IncomeTaxField(String newName, Color primary, Color secondary){
        super(newName, primary, secondary);
        type = 2;
    }

}
