package models;

import java.util.HashMap;
import java.util.Map;

public class MemberRecord {
    private static int idCounter = 1; //  Üye kayıtları için artan ID
    private int memberID;  //  Üye ID
    private Reader reader; //  Üye olan kişi

    //  Kullanıcının ödünç aldığı kitapları ve tarihleri saklayan Map
    private Map<Book, String> borrowedBooks;

    //  Kullanıcının iade ettiği kitapları ve tarihleri saklayan Map
    private Map<Book, String> returnedBooks;

    //  Constructor (Kurucu Metot)
    public MemberRecord(Reader reader) {
        this.memberID = idCounter++; //  Her üye için benzersiz ID
        this.reader = reader;
        this.borrowedBooks = new HashMap<>();
        this.returnedBooks = new HashMap<>();
    }

    //  Kitap ödünç alma kaydı
    public void borrowBook(Book book, String date) {
        if (!book.isStatus()) {
            System.out.println("❌ Kitap zaten ödünç alınmış: " + book.getName());
            return;
        }
        borrowedBooks.put(book, date);
        book.setStatus(false);
        System.out.println("📖 " + reader.getName() + " kitabı ödünç aldı: " + book.getName() + " Tarih: " + date);
    }

    //  Kitap iade etme kaydı
    public void returnBook(Book book, String date) {
        if (!borrowedBooks.containsKey(book)) {
            System.out.println("❌ Bu kitap kayıtlı bir ödünç kitap değil: " + book.getName());
            return;
        }
        borrowedBooks.remove(book);
        returnedBooks.put(book, date);
        book.setStatus(true);
        System.out.println("📕 " + reader.getName() + " kitabı iade etti: " + book.getName() + " Tarih: " + date);
    }

    //  Üyenin ödünç alma/iade geçmişini listeleme
    public void showHistory() {
        System.out.println("\n📚 " + reader.getName() + " - Üye ID: " + memberID + " Kitap Geçmişi:");

        if (borrowedBooks.isEmpty() && returnedBooks.isEmpty()) {
            System.out.println("📌 Henüz hiç işlem yapılmadı.");
            return;
        }

        System.out.println("📖 Ödünç Alınan Kitaplar:");
        for (Map.Entry<Book, String> entry : borrowedBooks.entrySet()) {
            System.out.println("- " + entry.getKey().getName() + " (Tarih: " + entry.getValue() + ")");
        }

        System.out.println("📕 İade Edilen Kitaplar:");
        for (Map.Entry<Book, String> entry : returnedBooks.entrySet()) {
            System.out.println("- " + entry.getKey().getName() + " (Tarih: " + entry.getValue() + ")");
        }
    }



}
