package Items;

import Enums.Taste;

public class Food extends Item {
    private Taste taste;
    private Veget veget;

    public Food (String name) {
        super(name);
        this.taste = Taste.TASTELESS;
    }

    public void setVeget (Veget veget) {
        this.veget = veget;
    }

    public void setTaste (Taste taste) {
        this.taste = taste;
    }

    public Veget getVeget() {
        return this.veget;
    }

    public String tasteToString() {
        switch(taste) {
            case SWEET: return "Сладкий";
            case SOUR: return "Кислый";
            case SALTY: return "Солёный";
            case BITTER: return "Горький";
        }
        return "Безвкусный";
    }
}