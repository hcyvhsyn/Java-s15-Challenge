package models;

import java.util.*;

public class Library {
    private List<Book> books;  // 📚 Kütüphanedeki kitaplar
    private Set<Reader> readers; // 📖 Kütüphane üyeleri
    private Scanner scanner;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new HashSet<>();
        this.scanner = new Scanner(System.in);
    }

    //  Yeni kitap ekleme metodu
    public void addBook() {
        System.out.print("Kitap Başlığı: ");
        String title = scanner.nextLine();
        System.out.print("Yazar: ");
        String author = scanner.nextLine();
        System.out.print("Fiyat: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Boş satırı temizle
        System.out.print("Baskı: ");
        String edition = scanner.nextLine();
        System.out.print("Satın Alma Tarihi: ");
        String dateOfPurchase = scanner.nextLine();

        Book book = new Book(author, title, price, edition, dateOfPurchase);
        books.add(book);
        System.out.println("✅ Kitap başarıyla eklendi: " + title);
    }


    //  Yeni okuyucu kaydetme metodu
    public void registerReader() {
        System.out.print("Okuyucu Adı: ");
        String name = scanner.nextLine();
        Reader reader = new Reader(name);
        if (readers.add(reader)) {
            System.out.println("✅ " + name + " kütüphaneye kayıt oldu.");
        } else {
            System.out.println("❌ Bu okuyucu zaten kayıtlı!");
        }
    }


    //  Kitap ödünç verme metodu
    public void lendBook() {
        System.out.print("Okuyucu Adı: ");
        String readerName = scanner.nextLine();
        Reader reader = findReaderByName(readerName);
        if (reader == null) {
            System.out.println("❌ Kullanıcı bulunamadı!");
            return;
        }

        System.out.print("Kitap Adı: ");
        String bookTitle = scanner.nextLine();
        Book book = findBookByTitle(bookTitle);
        if (book == null || !book.isStatus()) {
            System.out.println("❌ Kitap mevcut değil!");
            return;
        }

        reader.borrowBook(book);
    }


    //  Kitap iade etme metodu
    public void returnBook() {
        System.out.print("Okuyucu Adı: ");
        String readerName = scanner.nextLine();
        Reader reader = findReaderByName(readerName);
        if (reader == null) {
            System.out.println("❌ Kullanıcı bulunamadı!");
            return;
        }

        System.out.print("Kitap Adı: ");
        String bookTitle = scanner.nextLine();
        Book book = findBookByTitle(bookTitle);
        if (book == null) {
            System.out.println("❌ Kitap bulunamadı!");
            return;
        }

        reader.returnBook(book);
    }


    //  Kütüphanedeki kitapları listeleme
    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("📌 Kütüphanede kitap bulunmuyor.");
            return;
        }
        System.out.println("📚 Kütüphanedeki Kitaplar:");
        for (Book book : books) {
            book.display();
            System.out.println("----------------------");
        }
    }


    //  Yardımcı Metotlar (Okuyucu ve Kitap Bulma)
    private Reader findReaderByName(String name) {
        for (Reader reader : readers) {
            if (reader.getName().equalsIgnoreCase(name)) {
                return reader;
            }
        }
        return null;
    }

    private Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    //  Direkt olarak kitap ekleyen metot (Sadece Librarian çağırabilir)
    public void addBookDirectly(Book book) {
        books.add(book);
    }

    //  Direkt olarak okuyucu ekleyen metot (Sadece Librarian çağırabilir)
    public void registerReaderDirectly(Reader reader) {
        readers.add(reader);
    }

    //  Direkt kitap ödünç alma işlemi (Sadece Librarian çağırabilir)
    public boolean lendBookDirectly(Reader reader, Book book) {
        if (book.isStatus()) {
            reader.borrowBook(book);
            return true;
        }
        return false;
    }

    //  Direkt kitap iade alma işlemi (Sadece Librarian çağırabilir)
    public boolean returnBookDirectly(Reader reader, Book book) {
        if (reader != null && book != null) {
            reader.returnBook(book);
            return true;
        }
        return false;
    }

    //  Kitap Arama (ID, İsim, Yazar)
    public void searchBook() {
        System.out.print("Arama Türü Seçin (1: ID, 2: İsim, 3: Yazar): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Boş satırı temizle

        if (choice == 1) {
            System.out.print("Kitap ID: ");
            String id = scanner.nextLine();
            books.stream().filter(book -> book.getBookID().equals(id)).forEach(Book::display);
        } else if (choice == 2) {
            System.out.print("Kitap İsmi: ");
            String name = scanner.nextLine();
            books.stream().filter(book -> book.getName().equalsIgnoreCase(name)).forEach(Book::display);
        } else if (choice == 3) {
            System.out.print("Yazar İsmi: ");
            String author = scanner.nextLine();
            books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).forEach(Book::display);
        }
    }

    //  Kitap Silme Metodu
    public void deleteBook() {
        System.out.print("Silinecek Kitabın Adını Girin: ");
        String name = scanner.nextLine();
        books.removeIf(book -> book.getName().equalsIgnoreCase(name));
        System.out.println("✅ Kitap silindi!");
    }

    //  Kitap Güncelleme Metodu
    public void updateBook() {
        System.out.print("Güncellenecek Kitabın Adını Girin: ");
        String name = scanner.nextLine();
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(name)) {
                System.out.print("Yeni Fiyat: ");
                double newPrice = scanner.nextDouble();
                scanner.nextLine();
                book.setPrice(newPrice);
                System.out.println("✅ Kitap güncellendi!");
                return;
            }
        }
        System.out.println("❌ Kitap bulunamadı!");
    }

    //  Kategoriye Göre Kitapları Listeleme
    public void listBooksByCategory(String category) {
        System.out.println("\n📂 Kategoriye Göre Kitaplar: " + category);
        boolean found = false;
        for (Book book : books) {
            if (book instanceof Journals && category.equalsIgnoreCase("Journals")) {
                book.display();
                found = true;
            } else if (book instanceof StudyBooks && category.equalsIgnoreCase("StudyBooks")) {
                book.display();
                found = true;
            } else if (book instanceof Magazines && category.equalsIgnoreCase("Magazines")) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Bu kategoride kitap bulunamadı.");
        }
    }

    //  Yazara Göre Kitapları Listeleme
    public void listBooksByAuthor(String author) {
        System.out.println("\n✍️ Yazar: " + author + " Tarafından Yazılan Kitaplar");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Bu yazara ait kitap bulunamadı.");
        }
    }


}
