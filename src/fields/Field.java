package fields;

import java.awt.*;

import model.Player;

public abstract class Field {

    protected String name, subText, description;
    protected Color[] color = new Color[2];
    protected int type;

    public Field (String newName, Color primary, Color secondary){
        name = newName;
        color[0] = primary;
        color[1] = secondary;
        description = "";
        subText="";
    }

    public abstract void landOnField(Player landingPlayer);
    

    public int getType() {
        return type;
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

    public String getPriceString(){
        return "";
    }

}
