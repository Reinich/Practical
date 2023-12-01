package classes;

import java.util.List;

public class Camel extends Animal{
    public Camel(String name, String birthday, List<String> commands) {
        super(name, birthday, commands);
    }
    @Override
    public int compareTo(Animal o) {
        return this.getName().compareTo(o.getName());
    }
}
