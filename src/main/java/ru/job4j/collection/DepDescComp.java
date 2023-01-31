package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Array = o1.split("/");
        String[] o2Array = o2.split("/");
        return o2Array[0].compareTo(o1Array[0]) != 0 ? o2.compareTo(o1) : o1.compareTo(o2);
    }
}
