package models;

public class Magazines extends Book {

    private String publicationFrequency; // 📌 Yayın periyodu (Haftalık, Aylık vb.)


    public Magazines(String author, String name, double price, String edition, String dateOfPurchase, String publicationFrequency) {
        super(author, name, price, edition, dateOfPurchase); // 📌 `Book` sınıfından gelen özellikler
        this.publicationFrequency = publicationFrequency;
    }


    public String getPublicationFrequency() {
        return publicationFrequency;
    }

    //  Kitap bilgilerini ekrana yazdırma metodu (Override)
    @Override
    public void display() {
        super.display(); // 📌 `Book` sınıfındaki bilgileri göster
        System.out.println("Yayın Periyodu: " + publicationFrequency);
    }
}
