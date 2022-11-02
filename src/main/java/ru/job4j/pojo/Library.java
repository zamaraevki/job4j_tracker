package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean cod", 213);
        Book book2 = new Book("The Da Vinci Code", 315);
        Book book3 = new Book("War and Peace", 756);
        Book book4 = new Book("The Great Gatsby", 459);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
        }
        System.out.println("swap 0 and 3");
        books[0] = book4;
        books[3] = book1;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
        }
        System.out.println("print only Clean cod");
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean cod")) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
            }
        }
    }
}
