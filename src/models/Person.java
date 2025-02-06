package models;

public abstract class Person {
    protected String name; // Kişinin adı

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void whoYouAre();
}
