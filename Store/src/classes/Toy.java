package classes;

public abstract class Toy implements Comparable<Toy> {
    protected String name;

    protected final int id;
    protected int drop;
    protected static int counter;
    protected static int identifier;

    public abstract String getType();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    } // получить id конкретной игрушки

    public int getDrop() {
        return drop;
    } // получить шанс выпадения

    public static int getCounter() {
        return counter;
    } // количество игрушек в целом

    public void setDrop(int drop) {
        this.drop = drop;
    } // изменить шанс выпадения

    static {
        identifier = 10;
    } // начальный идентификатор

    {
        id = ++identifier;
        counter++;
    }

    public Toy(String name, int drop) {
        this.name = name;
        this.drop = drop;
    }

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(o.getDrop(), this.getDrop());
    }
}
