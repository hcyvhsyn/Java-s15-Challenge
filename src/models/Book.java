package models;

import java.util.UUID;

public class Book {
    private String bookID;
    private String author;
    private String name;
    private double price;
    private boolean status;
    private String edition;
    private String dateOfPurchase;


    public Book(String author, String name, double price, String edition, String dateOfPurchase) {
        this.bookID = UUID.randomUUID().toString();
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = true; // Yeni eklenen kitaplar mevcut
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getBookID() {
        return bookID;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public String getEdition() {
        return edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }


    public void display() {
        System.out.println("Kitap Bilgileri:");
        System.out.println("Book ID: " + bookID);
        System.out.println("Başlık: " + name);
        System.out.println("Yazar: " + author);
        System.out.println("Fiyat: $" + price);
        System.out.println("Baskı: " + edition);
        System.out.println("Satın Alma Tarihi: " + dateOfPurchase);
        System.out.println("Durum: " + (status ? "Mevcut" : "Ödünç Alınmış"));
    }
}
