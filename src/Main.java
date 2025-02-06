import models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Kütüphane Yönetim Sistemine Hoş Geldiniz!");
            System.out.println("1 Kitap Ekle");
            System.out.println("2 Kitap Ara (ID, İsim, Yazar)");
            System.out.println("3 Kitap Güncelle");
            System.out.println("4 Kitap Sil");
            System.out.println("5 Kategoriye Göre Kitapları Listele");
            System.out.println("6 Yazara Göre Kitapları Listele");
            System.out.println("7 Kitap Ödünç Al");
            System.out.println("8 Kitap Geri Teslim Et");
            System.out.println("9 Kullanıcı Ekle");
            System.out.print("Seçiminizi yapın: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // bos satirlari silmek icin

            switch (choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.searchBook();
                    break;
                case 3:
                    library.updateBook();
                    break;
                case 4:
                    library.deleteBook();
                    break;
                case 5:
                    System.out.print("Kategori İsmi: ");
                    String category = scanner.nextLine();
                    library.listBooksByCategory(category);
                    break;
                case 6:
                    System.out.print("Yazar İsmi: ");
                    String author = scanner.nextLine();
                    library.listBooksByAuthor(author);
                    break;
                case 7:
                    library.lendBook();
                    break;
                case 8:
                    library.returnBook();
                    break;
                case 9:
                    library.registerReader();
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }
    }
}