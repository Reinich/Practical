package menu;

import classes.Animal;
import interfaces.BirthdaySort;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private int choice;
    Tools tools = new Tools();

    private int runMain() {
        String text = """
                Меню:
                1. Добавить нового животного
                2. Добавить команду животному
                3. Вывести список всех животных
                4. Вывести список животных по дате рождения
                5. Вывести список команд животного
                6. Счетчик животных
                7. Выход
                """;
        System.out.println(text);
        try {
            System.out.print("-> ");
            choice = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("Некорреткно введена команда.\nПовторите попытку: ");
            mainMenu();
        }
        return choice;
    }

    public void mainMenu() {
        choice = runMain();
        List<Animal> animals = Animal.getAnimals();

        switch (choice) {
            case 1 -> {
                tools.create();
                tools.printAnimals(animals);
                mainMenu();
            }
            case 2 -> {
                while (!tools.addCommandMenu(animals)) {
                    tools.addCommandMenu(animals);
                }
                mainMenu();
            }
            case 3 -> {
                tools.printAnimals(animals);
                mainMenu();
            }
            case 4 -> {
                animals.sort(new BirthdaySort());
                tools.printAnimals(animals);
                mainMenu();
            }
            case 5 -> {
                while (!tools.printCommands(animals)) {
                    tools.printCommands(animals);
                }
                mainMenu();
            }
            case 6 -> {
                System.out.printf("Всего животных в заповеднике: %d\n", Animal.getCount());
                mainMenu();
            }
            case 7 -> System.out.print("До свидания!\n");
        }
    }
}
