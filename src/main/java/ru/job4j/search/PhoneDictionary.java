package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combName = s -> s.getName().contains(key);
        Predicate<Person> combNumber = s -> s.getPhone().contains(key);
        Predicate<Person> combSurname = s -> s.getSurname().contains(key);
        Predicate<Person> combSAddress = s -> s.getAddress().contains(key);
        Predicate<Person> combine = combName.or(combNumber.or(combSurname.or(combSAddress)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}