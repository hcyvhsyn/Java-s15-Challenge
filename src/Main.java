import models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📚 Kütüphane Yönetim Sistemine Hoş Geldiniz!");
            System.out.println("1️⃣ Kitap Ekle");
            System.out.println("2️⃣ Kitap Ara (ID, İsim, Yazar)");
            System.out.println("3️⃣ Kitap Güncelle");
            System.out.println("4️⃣ Kitap Sil");
            System.out.println("5️⃣ Kategoriye Göre Kitapları Listele");
            System.out.println("6️⃣ Yazara Göre Kitapları Listele");
            System.out.println("7️⃣ Kitap Ödünç Al");
            System.out.println("8️⃣ Kitap Geri Teslim Et");
            System.out.println("9️⃣ Kullanıcı Faturalarını Görüntüle");
            System.out.println("🔟 Çıkış");
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
                    System.out.print("Kullanıcı Adı: ");
                    break;
                case 10:
                    System.out.println("📌 Çıkış yapılıyor...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("❌ Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }
    }
}