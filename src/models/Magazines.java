package models;

public class Magazines extends Book {

    private String publicationFrequency;


    public Magazines(String author, String name, double price, String edition, String dateOfPurchase, String publicationFrequency, String category) {
        super(author, name, price, edition, dateOfPurchase, category); // 📌 `Book` sınıfından gelen özellikler
        this.publicationFrequency = publicationFrequency;
    }


    public String getPublicationFrequency() {
        return publicationFrequency;
    }


    @Override
    public void display() {
        super.display();
        System.out.println("Yayın Periyodu: " + publicationFrequency);
    }
}
