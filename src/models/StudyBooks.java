package models;

public class StudyBooks extends Book {
    private String subject;
    private String difficultyLevel;


    public StudyBooks(String author, String name, double price, String edition, String dateOfPurchase, String subject, String difficultyLevel, String category) {
        super(author, name, price, edition, dateOfPurchase,category);
        this.subject = subject;
        this.difficultyLevel = difficultyLevel;
    }



    public String getDifficultyLevel() {
        return difficultyLevel;
    }


    @Override
    public void display() {
        super.display();
        System.out.println("Ders: " + subject);
        System.out.println("Zorluk Seviyesi: " + difficultyLevel);
    }
}
