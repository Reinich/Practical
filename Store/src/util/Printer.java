package util;

import classes.Toy;

import java.util.List;
import java.util.Queue;

public class Printer {
    public void printToy(Toy toy) {
        System.out.printf("%s %s: id - %d\n",
                toy.getType(), toy.getName(), toy.getId());
    }

    public void printAllToys(List<Toy> toys) {
        for (Toy toy : toys) {
            System.out.printf("%s %s: id - %d\n",
                    toy.getType(), toy.getName(), toy.getId());
        }
    }

    public void printAllToys(Queue<Toy> toys) {
        for (Toy toy : toys) {
            System.out.printf("%s %s: id - %d\n",
                    toy.getType(), toy.getName(), toy.getId());
        }
    }


}
