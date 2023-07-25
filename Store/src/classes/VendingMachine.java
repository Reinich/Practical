package classes;

import util.Printer;

import java.io.IOException;
import java.util.*;

public class VendingMachine {
    private final Random random = new Random();
    private final List<Toy> toys;

    public List<Toy> getToys() {
        return toys;
    }

    private final Queue<Toy> toysForPrize = new PriorityQueue<>();
    private final Printer printer = new Printer();

    public Queue<Toy> getToysForPrize() {
        return toysForPrize;
    }

    public VendingMachine() throws IOException {
        this.toys = new ArrayList<>(Toy.getCounter());
    }

    public VendingMachine addToy(Toy toy) {
        this.toys.add(toy);
        return this;
    }

    public void rafflePrizes() throws IOException {
        List<Integer> toysId = new ArrayList<>(toys.size());
        List<Integer> toysChanceDrop = new ArrayList<>(toys.size());
        List<Integer> toysForDrop = new ArrayList<>(toys.size());

        for (Toy toy : toys) {
            toysId.add(toy.getId());
            toysChanceDrop.add(toy.getDrop());
        } // добавляем в лист индекс и % выпадения

        for (int i = 0; i < toysId.size(); i++) {
            for (int j = 0; j < toysChanceDrop.get(i); j++) {
                toysForDrop.add(toysId.get(i));
            }
        } // комбинируем

        int droppedToy = toysForDrop.get(random.nextInt(toysForDrop.size())); // находим игрушку

        for (Toy toy : toys) {
            if (toy.getId() == droppedToy) {
                System.out.print("Выпала игрушка: ");
                printer.printToy(toy);
                this.toysForPrize.add(toy);
            }
        }

        removeToyFromIndexList(toysForDrop, droppedToy);

        removeToyFromList(toys, droppedToy);

    }

    private void removeToyFromIndexList(List<Integer> toysForDrop, int id) {
        toysForDrop.removeIf(toyId -> toyId == id);
    }

    private void removeToyFromList(List<Toy> toys, int id) {
        toys.removeIf(toy -> toy.getId() == id);
        printAllToys();
    }

    public void printAllToys() {
        for (Toy toy : toys) {
            System.out.printf("%s %s: id - %d\n",
                    toy.getType(), toy.getName(), toy.getId());
        }
    }

}
