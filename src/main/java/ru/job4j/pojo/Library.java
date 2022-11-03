package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Clean code", 213);
        books[1] = new Book("The Da Vinci Code", 315);
        books[2] = new Book("War and Peace", 756);
        books[3] = new Book("The Great Gatsby", 459);
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
        }
        System.out.println("swap 0 and 3");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
        }
        System.out.println("print only Clean code");
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
            }
        }
    }
}
