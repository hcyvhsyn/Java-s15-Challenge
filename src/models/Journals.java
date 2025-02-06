package models;

public class Journals extends Book {
    private String economy;


    public Journals(String author, String name, double price, String edition, String dateOfPurchase, String economy,  String category) {
        super(author, name, price, edition, dateOfPurchase, category); //  `Book`'tan gelen özellikler
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
