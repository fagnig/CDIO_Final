package game.model.fields;

import java.awt.*;

public abstract class Field {

    protected String name, subText, description;
    protected Color[] color = new Color[2];

    public Field (String newName, Color primary, Color secondary){
        name = newName;
        color[0] = primary;
        color[1] = secondary;
        description = "";
        subText="";
    }

    public String getName() {
        return name;
    }

    public String getSubText() {
        return subText;
    }

    public String getDescription() {
        return description;
    }

    public Color[] getColor() {
        return color;
    }

}
