package menu;

import classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tools {
    private final Scanner sc = new Scanner(System.in);

    /**
     * Добавление нового животного
     */
    public void create() {
        try {
            System.out.print("Тип животного: ");
            String type = sc.nextLine();
            System.out.print("Имя животного: ");
            String nameAnimal = sc.nextLine();
            System.out.print("День рождения (yyyy-mm-dd): ");
            String birthdayAnimal = sc.nextLine();
            System.out.print("Сколько команд знает животное? ");
            int countCmd = Integer.parseInt(sc.next());

            List<String> cmdAnimal = new ArrayList<>();
            for (int i = 0; i < countCmd; i++) {
                System.out.printf("%d: ", i + 1);
                String tmp = sc.next();
                cmdAnimal.add(tmp.toUpperCase().charAt(0) + tmp.toLowerCase().substring(1));
            }

            if (type.equalsIgnoreCase("Cat")) {
                new Cat(nameAnimal, birthdayAnimal, cmdAnimal);
            } else if (type.equalsIgnoreCase("Dog")) {
                new Dog(nameAnimal, birthdayAnimal, cmdAnimal);
            } else if (type.equalsIgnoreCase("Hamster")) {
                new Hamster(nameAnimal, birthdayAnimal, cmdAnimal);
            } else if (type.equalsIgnoreCase("Horse")) {
                new Horse(nameAnimal, birthdayAnimal, cmdAnimal);
            } else if (type.equalsIgnoreCase("Camel")) {
                new Camel(nameAnimal, birthdayAnimal, cmdAnimal);
            } else if (type.equalsIgnoreCase("Donkey")) {
                new Donkey(nameAnimal, birthdayAnimal, cmdAnimal);
            } else {
                System.out.println("Неверный тип животного");
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорреткно введены данные. Повторите попытку: \n");
            create();
        }
    }

    /**
     * Вывод животных
     *
     * @param animals список всех животных
     */
    public void printAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    /**
     * Вывод список команд животного
     *
     * @param animals список всех животных
     * @return продолжить меню или повторить попытку ввода
     */
    public boolean printCommands(List<Animal> animals) {
        System.out.print("Введите имя животного: ");
        String name2 = sc.next();

        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name2)) {
                System.out.println(animal.printCommands());
                return true;
            }
        }
        System.out.print("Такого животного нет. Повторите попытку:\n");
        return false;
    }

    /**
     * Добавить новую команду животному
     *
     * @param animals список всех животных
     * @return продолжить меню или повторить попытку ввода
     */
    public boolean addCommandMenu(List<Animal> animals) {
        System.out.print("Введите имя животного: ");
        String name1 = sc.next();

        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name1)) {
                System.out.print("Команда: ");
                String cmd = sc.next();
                animal.addCommand(cmd);
                System.out.println(animal);
                return true;
            }
        }
        System.out.print("Такого животного нет. Повторите попытку:\n");
        return false;
    }
}
