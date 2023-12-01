package classes;

import java.util.List;

public class Cat extends Animal {
    public Cat(String name, String birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    @Override
    public int compareTo(Animal o) {
        return this.getName().compareTo(o.getName());
    }
}
