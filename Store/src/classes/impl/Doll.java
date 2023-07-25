package classes.impl;

import classes.Toy;

public class Doll extends Toy {

    public Doll(String name, int drop) {
        super(name, drop);
    }

    @Override
    public String getType() {
        return "Кукла";
    }


    @Override
    public String toString() {
        return String.format("№%d %s %s", getId(), getType(), getName());
    }

}
