package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Zamaraev Konstantin Igorevich");
        student.setGroup("TK-08-2");
        student.setReceiptDate(new Date());
        System.out.println(student.getFio() + student.getGroup() + student.getReceiptDate());
    }
}
