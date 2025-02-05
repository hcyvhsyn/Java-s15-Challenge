package models;

public class Journals extends Book {
    private String economy;

    //  Constructor (Kurucu Metot)
    public Journals(String author, String name, double price, String edition, String dateOfPurchase, String economy) {
        super(author, name, price, edition, dateOfPurchase); //  `Book`'tan gelen özellikler
        this.economy = economy;
    }

    public String getEconomy() {
        return economy;
    }

    @Override
    public void display() {
        super.display(); //  `Book` sınıfındaki bilgileri göster
        System.out.println("Ekonomi Alan: " + economy);
    }
}
