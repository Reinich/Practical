package classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal implements Comparable<Animal> {
    protected String name;
    protected String birthday;
    protected List<String> commands;
    protected static List<Animal> animals = new ArrayList<>();
    private static int count;

    {
        count++;
    }

    public void addCommand(String cmd) {
        this.commands.add(cmd);
    }

    protected Animal(String name, String birthday, List<String> commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
        animals.add(this);
    }

    /**
     * Рассчет возраста
     *
     * @param birthday дата рождения
     * @return
     */
    public String calculateAge(String birthday) {
        String[] dateString = birthday.split("-");
        LocalDate currentDate = LocalDate.now();
        int[] dateInt = new int[3];

        for (int i = 0; i < 3; i++) {
            dateInt[i] = Integer.parseInt(dateString[i]);
        }

        LocalDate birthdayDate = LocalDate.of(dateInt[0], dateInt[1], dateInt[2]);

        return String.format("%d", Period.between(birthdayDate, currentDate).getYears());
    }

    // region Getters and Setters
    public static int getCount() {
        return count;
    }

    public static List<Animal> getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<String> getCommands() {
        return commands;
    }

    public String printCommands() {
        return this.commands.toString().replace("[", "").replace("]", "");
    }

    // endregion

    @Override
    public String toString() {
        return String.format("%s %s, %s, %s y.o., commands: %s\n",
                getClass().getSimpleName(), getName(), getBirthday(), calculateAge(getBirthday()), printCommands());
    }
}
