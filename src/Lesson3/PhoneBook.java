package Lesson3;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> book = new TreeMap<>();

    public void add(String surname, String number) {
        List<String> numbers;
        if (book.containsKey(surname)) {
            numbers = book.get(surname);
        } else {
            numbers = new ArrayList<>();
        }
        numbers.add(number);
        book.put(surname, numbers);
    }

    public List<String> get(String surname) {
        return book.get(surname);
    }


}
