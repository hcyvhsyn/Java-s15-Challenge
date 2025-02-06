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

    //  yeni kitap ekleme
    public void addBook() {
        System.out.print("Kitap Ismi: ");
        String title = scanner.nextLine();
        System.out.print("Yazar: ");
        String author = scanner.nextLine();
        System.out.print("Fiyat: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Baskı: ");
        String edition = scanner.nextLine();
        System.out.print("Satın Alma Tarihi: ");
        String dateOfPurchase = scanner.nextLine();
        System.out.print("Kategori Seçin (Journals, StudyBooks, Magazines): ");
        String category = scanner.nextLine();

        Book book = new Book(author, title, price, edition, dateOfPurchase, category);
        books.add(book);
        System.out.println("Kitap başarıyla eklendi: " + title);
    }


    //  okuyucu ekleme
    public void registerReader() {
        System.out.print("Okuyucu Adı: ");
        String name = scanner.nextLine();
        Reader reader = new Reader(name);
        if (readers.add(reader)) {
            System.out.println(  name + " kütüphaneye kayıt oldu.");
        } else {
            System.out.println("Bu okuyucu zaten kayıtlı!");
        }
    }


    //  kitap odunc verme
    public void lendBook() {
        System.out.print("Okuyucu Adı: ");
        String readerName = scanner.nextLine();
        Reader reader = findReaderByName(readerName);

        // kullanici yoksa ekle
        if (reader == null) {
            System.out.println("Kullanıcı bulunamadı. Yeni bir kayıt oluşturuluyor");
            reader = new Reader(readerName);
            registerReaderDirectly(reader);
        }


        System.out.print("Kitap Adı: ");
        String bookTitle = scanner.nextLine();
        Book book = findBookByTitle(bookTitle);

        if (book == null) {
            System.out.println("Kitap bulunamadı!");
            return;
        }

        if (!book.isStatus()) {
            System.out.println("Bu kitap zaten başka biri tarafından ödünç alınmış!");
            return;
        }

        System.out.println(readerName + " kitabı ödünç aldı: " + bookTitle);
    }



    //  Kitap iade etme metodu
    public void returnBook() {
        System.out.print("Okuyucu Adı: ");
        String readerName = scanner.nextLine();
        Reader reader = findReaderByName(readerName);
        if (reader == null) {
            System.out.println("Kullanıcı bulunamadı!");
            return;
        }

        System.out.print("Kitap Adı: ");
        String bookTitle = scanner.nextLine();
        Book book = findBookByTitle(bookTitle);
        if (book == null) {
            System.out.println("Kitap bulunamadı!");
            return;
        }

        reader.returnBook(book);
    }

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


    //  Okuyucu eklemek icin
    public void registerReaderDirectly(Reader reader) {
        readers.add(reader);
    }


    //   arama methodu
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

    //  silme methodu
    public void deleteBook() {
        System.out.print("Silinecek Kitabın Adını Girin: ");
        String name = scanner.nextLine();
        books.removeIf(book -> book.getName().equalsIgnoreCase(name));
        System.out.println("Kitap silindi!");
    }

    //  guncellemek icin
    public void updateBook() {
        System.out.print("Güncellenecek Kitabın Adını Girin: ");
        String name = scanner.nextLine();
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(name)) {
                System.out.print("Yeni Fiyat: ");
                double newPrice = scanner.nextDouble();
                scanner.nextLine();
                book.setPrice(newPrice);
                System.out.println("Kitap güncellendi!");
                return;
            }
        }
        System.out.println("Kitap bulunamadı!");
    }

    //  kategori secimi
    public void listBooksByCategory(String category) {
        System.out.println("Kategoriye Göre Kitaplar: " + category);
        boolean found = false;
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase("Journals")) {
                book.display();
                found = true;
            } else if (book.getCategory().equalsIgnoreCase("StudyBooks")) {
                book.display();
                found = true;
            } else if (book.getCategory().equalsIgnoreCase("Magazines")) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Bu kategoride kitap bulunamadı.");
        }
    }

    //  yazara gore siralama
    public void listBooksByAuthor(String author) {
        System.out.println("Yazar: " + author + " Tarafından Yazılan Kitaplar");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Bu yazara ait kitap bulunamadı.");
        }
    }


}
