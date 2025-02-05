package models;

public class Librarian extends Person {

    //  Constructor (Kurucu Metot)
    public Librarian(String name) {
        super(name);
    }


    //  Kütüphaneye kitap ekleme metodu
    public void addBookToLibrary(Library library, Book book) {
        library.addBookDirectly(book);
        System.out.println("📘 " + name + " kütüphaneye kitap ekledi: " + book.getName());
    }

    //  Okuyucu kaydetme metodu
    public void registerReader(Library library, Reader reader) {
        library.registerReaderDirectly(reader);
        System.out.println("👤 " + name + " yeni bir okuyucuyu kayıt etti: " + reader.getName());
    }

    //  Kitap ödünç verme metodu
    public void lendBookToReader(Library library, Reader reader, Book book) {
        if (library.lendBookDirectly(reader, book)) {
            System.out.println("📖 " + name + " tarafından " + reader.getName() + " için kitap ödünç verildi: " + book.getName());
        } else {
            System.out.println("❌ Kitap ödünç verilemedi: " + book.getName());
        }
    }

    //  Kitap iade alma metodu
    public void returnBookFromReader(Library library, Reader reader, Book book) {
        if (library.returnBookDirectly(reader, book)) {
            System.out.println("📕 " + name + " tarafından " + reader.getName() + " kitabı iade aldı: " + book.getName());
        } else {
            System.out.println("❌ Kitap iade alınamadı: " + book.getName());
        }
    }


    @Override
    public void whoYouAre() {

    }

}
