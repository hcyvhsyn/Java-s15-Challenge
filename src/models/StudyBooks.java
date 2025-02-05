package models;

public class StudyBooks extends Book {
    private String subject;  // 📌 Ders adı (Matematik, Tarih vb.)
    private String difficultyLevel; // 📌 Zorluk seviyesi (Kolay, Orta, Zor)


    public StudyBooks(String author, String name, double price, String edition, String dateOfPurchase, String subject, String difficultyLevel) {
        super(author, name, price, edition, dateOfPurchase); // 📌 `Book` sınıfından gelen özellikler
        this.subject = subject;
        this.difficultyLevel = difficultyLevel;
    }

    //  Ders adı ve zorluk seviyesini almak için Getter metotları
    public String getSubject() {
        return subject;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    //  Kitap bilgilerini ekrana yazdırma metodu (Override)
    @Override
    public void display() {
        super.display(); // 📌 `Book` sınıfındaki bilgileri göster
        System.out.println("Ders: " + subject);
        System.out.println("Zorluk Seviyesi: " + difficultyLevel);
    }
}
