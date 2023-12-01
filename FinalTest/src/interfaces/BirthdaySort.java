package interfaces;

import classes.Animal;

import java.util.Comparator;

public class BirthdaySort implements Comparator<Animal> {

    @Override
    public int compare(Animal first, Animal second) {
        return first.getBirthday().compareTo(second.getBirthday());
    }
}
