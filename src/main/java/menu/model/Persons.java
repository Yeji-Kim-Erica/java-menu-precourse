package menu.model;

import menu.error.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Persons {
    private final List<Person> persons;

    private Persons(List<Person> persons) {
        validate(persons);
        this.persons = persons;
    }

    public static Persons from(List<String> names) {
        List<Person> persons = new ArrayList<>();
        for (String name : names) {
            persons.add(new Person(name));
        }
        return new Persons(persons);
    };

    public List<Person> getNames() {
        return persons;
    }

    private void validate(List<Person> persons) {
        int size = persons.size();
        if (size < 2) {
            throw new IllegalArgumentException(ErrorMessage.PEOPLE_UNDER_MINIMUM.getMessage());
        }
        if (size > 5) {
            throw new IllegalArgumentException(ErrorMessage.PEOPLE_OVER_MAXIMUM.getMessage());
        }
    }
}
