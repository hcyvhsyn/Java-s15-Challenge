package models;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person{
    private Set<Book> borrowedBooks;

    public Reader(String name) {
        super(name);
        this.borrowedBooks = new HashSet<>();
    }


    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setStatus(true);
            System.out.println("Bu kitap zaten sende değil: " + book.getName());
        } else {
            System.out.println(name + " kitabı iade etti: " + book.getName());
        }
    }


    @Override
    public void whoYouAre() {
        System.out.println("Ben bir okuyucuyum: " + name);
    }
}
