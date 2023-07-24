package classes.impl;

import classes.Toy;

public class Robot extends Toy {
    @Override
    public String getType() {
        return "Робот";
    }

    public Robot(String name, int drop) {
        super(name, drop);
    }

    @Override
    public String toString() {
        return String.format("№%d %s %s", getId(), getType(), getName());
    }
}
