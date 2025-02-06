package models;

import java.util.HashMap;
import java.util.Map;

public class MemberRecord {
    private static int idCounter = 1; //  uye kayitlari icin
    private int memberID;
    private Reader reader;

    private Map<Book, String> borrowedBooks;

    private Map<Book, String> returnedBooks;

    //  Constructor (Kurucu Metot)
    public MemberRecord(Reader reader) {
        this.memberID = idCounter++; //  Her üye için benzersiz ID
        this.reader = reader;
        this.borrowedBooks = new HashMap<>();
        this.returnedBooks = new HashMap<>();
    }





}
