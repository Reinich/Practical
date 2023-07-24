package util;

import classes.Toy;

import java.io.*;
import java.util.Queue;

public class TXTFileWriter {
    public void writeToTXT(Queue<Toy> toysForPrize) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter("toys.txt"))) {
            for (int i = 0; i < 10; i++) {
                Toy toy = toysForPrize.poll();
                writer.printf("%s %s %d0%%\n", toy != null ? toy.getType() : null,
                        toy != null ? toy.getName() : null,
                        toy != null ? toy.getDrop() : 0);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
