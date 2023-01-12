package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("zamaraevki@gmail.com", "Zamaraev Konstaantin");
        map.put("zamaraevki@yandex.ru", "Zamaraev Konstaantin");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
