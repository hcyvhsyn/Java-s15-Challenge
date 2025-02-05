package models;

//  Soyut (abstract) sınıf
public abstract class Person {
    protected String name; // Kişinin adı

    //  Constructor (Kurucu Metot)
    public Person(String name) {
        this.name = name;
    }

    //  Getter metodu
    public String getName() {
        return name;
    }

    //  Soyut metot (alt sınıflar implemente edecek)
    public abstract void whoYouAre();
}
