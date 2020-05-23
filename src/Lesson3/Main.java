package Lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        List<String> arrwords = new ArrayList<>(Arrays.asList("Яблоко", "Яблоко", "Яблоко", "Яблоко", "Яблоко",
                "Персик", "Груша", "Слива", "Апельсин", "Клубника", "Грейпфрут", "Персик",
                "Банан", "Апельсин", "Апельсин", "Алыча", "Виноград", "Ананас"));
        System.out.println(arrwords);

        Map<String, Integer> mapWords = new TreeMap<>();
        for (String s : arrwords) {
            mapWords.put(s, mapWords.getOrDefault(s, 0) + 1);
        }
        System.out.println(mapWords);



        //Задание 2
        PhoneBook book = new PhoneBook();
        book.add("Pupkin", "89651235664");
        book.add("Lozhkin", "89654458123");
        book.add("Pupkin", "89451122354");
        book.add("Kurlikin", "89451248996");
        book.add("Joraev", "89456879123");
        book.add("Angorov", "89451235478");
        book.add("Pupkin", "89815462777");


        System.out.println(book.get("Pupkin"));

    }


}
