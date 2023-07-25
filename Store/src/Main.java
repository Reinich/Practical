import classes.impl.Constructor;
import classes.impl.Doll;
import classes.impl.Robot;
import classes.VendingMachine;
import util.Printer;
import util.TXTFileWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        VendingMachine vendingMachine = new VendingMachine();
        TXTFileWriter writer = new TXTFileWriter();
        Printer printer = new Printer();

        vendingMachine
                .addToy(new Doll("Элла", 6))
                .addToy(new Robot("Рики", 2))
                .addToy(new Doll("Эльза", 6))
                .addToy(new Robot("Тики", 4))
                .addToy(new Constructor("Машинка", 3))
                .addToy(new Robot("Танос", 1))
                .addToy(new Constructor("Дом", 2))
                .addToy(new Doll("Нэнси", 1));

        Constructor constructor1 = new Constructor("Самолет-К280", 6);
        Robot robot1 = new Robot("Терминатор", 1);
        Constructor constructor2 = new Constructor("Лего Тирекс", 8);

        robot1.setDrop(3);

        vendingMachine.addToy(constructor1);
        vendingMachine.addToy(constructor2);
        vendingMachine.addToy(robot1);

        printer.printAllToys(vendingMachine.getToys());
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.println();
            vendingMachine.rafflePrizes();
            System.out.println();
        }

        writer.writeToTXT(vendingMachine.getToysForPrize());
    }
}
