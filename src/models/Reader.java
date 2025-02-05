package models;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person{
    private Set<Book> borrowedBooks; //  Kullanıcının ödünç aldığı kitaplar

    public Reader(String name) {
        super(name);
        this.borrowedBooks = new HashSet<>(); //  Kitap listesi boş başlar
    }

    public void borrowBook(Book book) {
        if (book.isStatus()) {
            borrowedBooks.add(book);
            book.setStatus(false); // Kitap artık ödünç alınmış oldu
            System.out.println("📖 " + name + " kitabı ödünç aldı: " + book.getName());
        } else {
            System.out.println("❌ Kitap zaten ödünç alınmış: " + book.getName());
        }
    }

    //  Kitap iade etme metodu
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setStatus(true); // Kitap tekrar kütüphaneye döndü
            System.out.println("📕 " + name + " kitabı iade etti: " + book.getName());
        } else {
            System.out.println("❌ Bu kitap zaten sende değil: " + book.getName());
        }
    }

    //  Kullanıcının ödünç aldığı kitapları listeleme
    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("📌 " + name + " henüz hiç kitap ödünç almadı.");
            return;
        }
        System.out.println("📚 " + name + " tarafından ödünç alınan kitaplar:");
        for (Book book : borrowedBooks) {
            book.display();
        }
    }

    //  Soyut metodu override ediyoruz
    @Override
    public void whoYouAre() {
        System.out.println("Ben bir okuyucuyum: " + name);
    }
}
